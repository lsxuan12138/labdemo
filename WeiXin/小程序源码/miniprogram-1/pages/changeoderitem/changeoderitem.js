// pages/changeoderitem/changeoderitem.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        id:'undefined',
        saleNoteId:'',
        productId:'',
        quantity:'',
        addUrl:'http://localhost:8081/demo/salenoteitem/addSaleNoteItem',
        modifyUrl:'http://localhost:8081/demo/salenoteitem/updateSaleNoteItem'
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {
        var that=this;
        this.setData({
          id:options.id
        })
        
        if(options.id==undefined){
          return;
        }
        wx.request({
          url: 'http://localhost:8081/demo/salenoteitem/findById',
          data:{id:options.id},
          method:'GET',
          success:function(res){
           var saleNoteItem= res.data.saleNoteItem;
           if(saleNoteItem==undefined){
             var toastText='获取数据失败'+res.data.error;
             wx.showToast({
               title: toastText,
               icon:'',
               duration:2000
             })
           }else{
             that.setData({
               id:saleNoteItem.id,
               saleNoteId:saleNoteItem.saleNoteId,
               productId:saleNoteItem.productId,
               quantity:saleNoteItem.quantity
             })
           }
          }
        })
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
    
      }
      
})