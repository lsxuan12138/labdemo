// pages/userop/userop.js
Page({
    getName: function(e) {
        var value = e.detail.value; //获取输入的内容
        this.setData({
          name:value,//改变page--data中username的值
        })
        wx.setStorageSync('name', value);//将获取到的username值存入本地缓存空间
    },
    /**
     * 页面的初始数据
     */
    data: {
  list:[],
  name:''
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
    onShow: function () {
        var that=this;
        wx.request({
          url: 'http://localhost:8081/demo/client/listclient',
          method:'GET',
          data:{},
          success:function(res){
            var list=res.data.clientList;
            if(list==null){
              var toastText='获取数据失败'+res.data.error;
              wx.showToast({
                title: toastText,
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

     /**
   * 根据名称查询
   */
  findbyname: function (e){
    var that=this;
    wx.request({
      url: 'http://localhost:8081/demo/client/findbyname',
      method:'GET',
      data:{ 
          name:this.data.name
        },
      success:function(res){
        var list=res.data.clientList;
        if(list==null){
          var toastText='查询客户失败'+res.data.error;
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        }else{
          var toastText='查询客户完毕';
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
   },
   addClient:function(){
    wx.navigateTo({
      url: '../changeclient/changeclient'
    })
  },
  deleteClient:function(e){
    var that=this;
    console.log(e.currentTarget)
    console.log(e.Target)
    e.target === e.currentTarget
    wx.showModal({
      title:'提示',
      content:'确定要删除吗['+e.target.dataset.name+']?',
      success:function(sm){
        if(sm.confirm){
          wx.request({
            url: 'http://localhost:8081/demo/client/deleteClient',
            data:{id:e.target.dataset.id},
            method:'GET',
            success:function(res){
              var result=res.data.success;
              var toastText="删除成功";
              if(result!=1){
                toastText="删除失败";
              }else{
                that.data.list.splice(e.target.dataset.index,1)
                that.setData({
                  list: that.data.list
                });
              }
              wx.showToast({
                title:toastText,
                icon:'',
                duration:2000
              })
             
            }
            
          })
        }
      }
     
    });

  }
})