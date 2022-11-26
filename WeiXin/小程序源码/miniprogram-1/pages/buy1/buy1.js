// pages/buy/buy.js
Page({
    /**
     * 页面的初始数据
     */
    data: {
list:[],
clientId:''
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
          url: 'http://localhost:8081/demo/salenote/waitList',
          method:'GET',
          data:{},
          success:function(res){
            var list=res.data.waitList;
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
   },
   addProduct:function(){
    wx.navigateTo({
      url: '../changeitem/changeitem'
    })
  },
  addSaleNote:function(){
    wx.navigateTo({
      url: '../changeoder/changeoder'
    })},
  submit:function(e){
    var that=this;
    wx.showModal({
      title:'提示',
      content:'确定提交订单['+e.target.dataset.id+']吗?',
      success:function(sm){
        if(sm.confirm){
          wx.request({
            url: 'http://localhost:8081/demo/salenote/submitSaleNote',
            data:{id:e.target.dataset.id},
            method:'POST',
            success:function(res){
              var result=res.data.success;
              var toastText="提交成功";
              if(result!=1){
                toastText="提交失败";
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
  },
  delete:function(e){
    var that=this;
    wx.showModal({
      title:'提示',
      content:'确定删除订单['+e.target.dataset.id+']吗?',
      success:function(sm){
        if(sm.confirm){
          wx.request({
            url: 'http://localhost:8081/demo/salenote/deleteSaleNote',
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