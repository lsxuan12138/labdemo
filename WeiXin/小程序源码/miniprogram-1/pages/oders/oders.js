// pages/oder/oder.js
Page({
    getClientId: function(e) {
        var value = e.detail.value; //获取输入的内容
        this.setData({
          clientId:value,
        })
        wx.setStorageSync('clientId', value);
    },
    /**
     * 页面的初始数据
     */
    data: {
   clienId:'',
   list:[]
    },
  
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
  
    },
  
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
             var that=this;
             wx.request({
               url: 'http://localhost:8081/demo/salenote/listsalenote',
               method:'GET',
               data:{},
               success:function(res){
                 var list=res.data.saleNoteList;
                 if(list==null){
                   var toastText='获取数据失败'+res.data.error;
                   wx.showToast({
                     title: 'toastText',
                     icon:'',
                     duration:2000
                   });
                 }else{
                   that.setData({
                     list:list
                   });
                 }
               }
             })
    },
  
    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {
  
    },
  
    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {
  
    },
  
    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {
  
    },
  
    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {
  
    },
   
     /**
   * 根据名称查询
   */
  findbyClientId: function (e){
    var that=this;
    wx.request({
      url: 'http://localhost:8081/demo/salenote/findByClientId',
      method:'GET',
      data:{ 
          clientId:this.data.clientId
        },
      success:function(res){
        var list=res.data.saleNoteList;
        if(list==null){
          var toastText='查询订单失败'+res.data.error;
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        }else if(list.length==0){
            var toastText='无此订单';
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        }else{
          var toastText='查询订单成功';
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
          that.setData({
            list:list
          });
        }
      }
    })
   }
  })