// pages/buy/buy.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
list:[]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {
        var that=this;
        wx.request({
          url: 'http://localhost:8081/demo/salenote/refundList',
          method:'GET',
          data:{},
          success:function(res){
            var list=res.data.refundList;
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
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    },
   to1(){
    wx.navigateTo({
        url: '../buy1/buy1'
      })
   },
   to2(){
    wx.navigateTo({
        url: '../buy2/buy2'
      })
   },
   to3(){
    wx.navigateTo({
        url: '../buy3/buy3'
      })
   },
   to4(){
    wx.navigateTo({
        url: '../buy4/buy4'
      })
   }
   
})