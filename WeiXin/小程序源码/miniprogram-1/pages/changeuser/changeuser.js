// pages/changeitem/changeitem.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        id:'undefined',
        name:'',
        account:'',
        password:'',
        roleId:'',
        addUrl:'http://localhost:8081/demo/user/addUser',
        modifyUrl:'http://localhost:8081/demo/user/updateUser'
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
        url: 'http://localhost:8081/demo/user/findbyid',
        data:{id:options.id},
        method:'GET',
        success:function(res){
         var user= res.data.user;
         if(user==undefined){
           var toastText='获取数据失败'+res.data.error;
           wx.showToast({
             title: toastText,
             icon:'',
             duration:2000
           })
         }else{
           that.setData({
             id:user.id,
             name:user.name,
             account:user.account,
             password:user.password,
             roleId:user.roleId
           })
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
             url: '../userop/userop',
         })
          }else{
            wx.redirectTo({
              url: '../userop/userop',
            })
          }
  
        }
  
      })
  
    }
  })