// pages/changoder/changeoder.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        list:[],
        id:'undefined',
        storeId:'',
        clientId:'',
        price:'',
        addUrl:'http://localhost:8081/demo/salenote/addSaleNote',
        modifyUrl:'http://localhost:8081/demo/salenote/updateSaleNote'
    },
  
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
      var that=this;
      this.setData({
        id:options.id
      })
      
      if(options.id==undefined){
        return;
      }
      wx.request({
        url: 'http://localhost:8081/demo/salenote/findById',
        data:{id:options.id},
        method:'GET',
        success:function(res){
         var saleNote= res.data.saleNote;
         if(saleNote==undefined){
           var toastText='获取数据失败'+res.data.error;
           wx.showToast({
             title: toastText,
             icon:'',
             duration:2000
           })
         }else{
           that.setData({
             id:saleNote.id,
             storeId:saleNote.storeId,
             clientId:saleNote.clientId,
             price:saleNote.price,
             createTime:saleNote.createTime
           })
         }
        }
      })
      wx.request({
        url: 'http://localhost:8081/demo/salenoteitem/findBySaleNoteId',
        method:'GET',
        data:{saleNoteId:options.id},
        success:function(res){
          var list=res.data.saleNoteItemList;
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
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
  
    },
  
    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
       
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
    formSubmit:function(e){
      var that = this;
      var formData = e.detail.value;
      var url = that.data.addUrl;
      if(that.data.id != undefined){
        formData.id = that.data.id;
        url = that.data.modifyUrl;
      }
      console.log(formData);
      wx.request({
        url: url,
        data: JSON.stringify(formData),
        method:"POST",
        header: {'Content-Type':'application/json'},
        success: function(res){
          var result = res.data.success;
          var toastText = "操作成功！";
          if(result != 1){
            toastText = "操作失败"+res.data.error;
          }
          wx.showToast({
            title: toastText,
            icon:'',
            duration:2000
          });
          if(that.data.id==undefined){
             wx.redirectTo({
             url: '../buy1/buy1',
         })
          }else{
            wx.redirectTo({
              url: '../buy1/buy1',
            })
          }
  
        }
  
      })
  
    },
    addSaleNoteItem:function(){
        wx.navigateTo({
          url: '../changeoderitem/changeoderitem'
        })
      },
    deleteSaleNoteItem:function(e){
        var that=this;
        wx.showModal({
          title:'提示',
          content:'确定要删除吗['+e.target.dataset.id+']?',
          success:function(sm){
            if(sm.confirm){
              wx.request({
                url: 'http://localhost:8081/demo/salenoteitem/deleteSaleNoteItem',
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