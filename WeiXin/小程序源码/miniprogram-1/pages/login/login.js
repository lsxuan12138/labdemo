// pages/login/login.js

Page({
    getAccount: function(e) {
        var value = e.detail.value; //获取输入的内容
        this.setData({
          account:value,//改变page--data中username的值
        })
        wx.setStorageSync('account', value);//将获取到的username值存入本地缓存空间
    },
      getPassword:function(e) {
        var value = e.detail.value;
        this.setData({
          password: value,
        })
        wx.setStorageSync('password', value);
    },
    doLogin: function(e) {
        var that = this;
        /*if(that.data.username.length ==0 || that.data.password.length ==0){//校验非空
          wx.showToast({  //弹框提示
            icon: 'none',
            title: '用户名或密码不能为空！',
            duration: 2000,
          })
        }else {*/
          wx.request({  //向后台发送请求
            url: 'http://localhost:8081/demo/user/findbyaccount',
            method: "GET",
            header: { 'content-type': 'application/json' },
            data: {
              account: this.data.account, //this.data.username 代表你data中username的值
              //password: this.data.password,
            },
            success: function (res) { //res为后台返回给前端的数据
              console.log("res.data"+res.data),
              //that.setData({
              //  userId: res.data.data,  //保存userId
              //  code: res.data.code,    
              //})
              console.log(res.data);
              console.log(res.data.user.password);
              console.log(that.data.password);
              
              if(res.data.user.password == that.data.password ){ //如果返回的code为200，代表用户名密码验证成功
                wx.showToast({
                  title: '登录成功',
                })
                //wx.setStorageSync('userId', res.data.data); //保存userId至本地，以便随时调用
                console.log(res.data.data);
                if(res.data.user.roleId==1){
                    wx.redirectTo({
                        url: '../index1/index1',  //跳转至首页
                      })
                }else if(res.data.user.roleId==2){
                    wx.redirectTo({
                        url: '../index1/index1',  //跳转至首页
                      })
                }else {
                    wx.redirectTo({
                        url: '../index/index',  //跳转至首页
                      })
                }
            }else{
                wx.showToast({
                  icon: 'none',
                  title: '用户名或密码错误',
                })
              }
     
            }
          })
        //}
      },
    /**
     * 页面的初始数据
     */
    data: {
        uaccount:'',
        password:'' 
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        /*var that = this;
        wx.request({
          url: 'https://192.168.10.163:8866/weixin/user/login',
          method: "get",
          header: { 'content-type': 'application/x-www-form-urlencoded' },
          data: {
            username: wx.getStorageSync('username'),
            password: wx.getStorageSync('password'),
          },
          success: function (res) {
            let code = res.data.code;
            let userId = res.data.data;
            console.log(code);
            console.log(userId);
            if(code == 200){
              // wx.showToast({
              //   title: '登录成功',
              // })
              wx.setStorageSync('userId', userId);
                wx.redirectTo({
                url: '../index/index',
              })
            }
          }
        })*/
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

    }
})