// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    canIUseGetUserProfile: false,
    canIUseOpenData: wx.canIUse('open-data.type.userAvatarUrl') && wx.canIUse('open-data.type.userNickName') // 如需尝试获取用户信息可改为false
  },
  // 事件处理函数
  areaViewTap() {
    wx.navigateTo({
      url: '../list/list'
    })
  },
  itemViewTap() {
    wx.navigateTo({
      url: '../itemsop/itemsop'
    })
  },
  oderViewTap() {
    wx.navigateTo({
      url: '../oders/oders'
    })
  },
  buyViewTap() {
    wx.navigateTo({
      url: '../buy1/buy1'
    })
  },
  onLoad() {
    if (wx.getUserProfile) {
      this.setData({
        canIUseGetUserProfile: true
      })
    }
  },
  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
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
