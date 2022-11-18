// pages/storesop/storeop.js
Page({
    getStoreId: function(e) {
        var value = e.detail.value; //获取输入的内容
        this.setData({
          storeId:value,//改变page--data中username的值
        })
        wx.setStorageSync('storeId', value);//将获取到的username值存入本地缓存空间
    },
    inputId:function(e){
        var value = e.detail.value; //获取输入的内容
        this.setData({
          id:value,//改变page--data中username的值
        })
        wx.setStorageSync('id', value);//将获取到的username值存入本地缓存空间
    },
    inputNum:function(e){
        var value = e.detail.value; //获取输入的内容
        this.setData({
          num:value,//改变page--data中username的值
        })
        wx.setStorageSync('num', value);//将获取到的username值存入本地缓存空间
    },
    /**
     * 页面的初始数据
     */
    data: {
  id:'',
  num:'',
  list:[],
  storeId:'',
  hiddenmodalput1: true,
  hiddenmodalput2: true
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
          url: 'http://localhost:8081/demo/storeitem/liststoreitem',
          method:'GET',
          data:{},
          success:function(res){
            var list=res.data.storeItemList;
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
  findbystoreid: function (e){
    var that=this;
    wx.request({
      url: 'http://localhost:8081/demo/storeitem/findByStoreId',
      method:'GET',
      data:{ 
          storeId:this.data.storeId
        },
      success:function(res){
        var list=res.data.storeItemList;
        if(list==null){
          var toastText='查询库存失败'+res.data.error;
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
        }else{
          var toastText='查询库存完毕';
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
  modalinput1: function () {
    this.setData({
        //注意到模态框的取消按钮也是绑定的这个函数，
        //所以这里直接取反hiddenmodalput，也是没有毛病
      hiddenmodalput1: !this.data.hiddenmodalput1
    })
  },
  modalinput2: function () {
    this.setData({
        //注意到模态框的取消按钮也是绑定的这个函数，
        //所以这里直接取反hiddenmodalput，也是没有毛病
      hiddenmodalput2: !this.data.hiddenmodalput2
    })
  },
  add:function(e){
    var that=this;
    wx.request({
        header: {'content-type': 'application/x-www-form-urlencoded'},
        url: 'http://localhost:8081/demo/storeitem/add',
        data:{ 
            id:that.data.id,
            num:that.data.num
          },
        method:'GET',
        success:function(res){
          var result=res.data.success;
          var toastText="入库成功";
          if(result!=1){
            toastText="入库失败";
          }
          wx.showToast({
            title:toastText,
            icon:'',
            duration:2000
          })
          that.setData({
            //注意到模态框的取消按钮也是绑定的这个函数，
            //所以这里直接取反hiddenmodalput，也是没有毛病
          hiddenmodalput2: !that.data.hiddenmodalput2
        })          
        }
  })
  wx.navigateTo({
    url: '../storeop/storeop',
  })

},
sub:function(e){
    var that=this;
    wx.request({
        header: {'content-type': 'application/x-www-form-urlencoded'},
        url: 'http://localhost:8081/demo/storeitem/sub',
        data:{ 
            id:that.data.id,
            num:that.data.num
          },
        method:'GET',
        success:function(res){
          var result=res.data.success;
          var toastText="出库成功";
          if(result!=1){
            toastText="出库失败";
          }
          wx.showToast({
            title:toastText,
            icon:'',
            duration:2000
          })
          that.setData({
            //注意到模态框的取消按钮也是绑定的这个函数，
            //所以这里直接取反hiddenmodalput，也是没有毛病
          hiddenmodalput1: !that.data.hiddenmodalput1
        })          
        }
  })
  wx.navigateTo({
    url: '../storeop/storeop',
  })

}
})
