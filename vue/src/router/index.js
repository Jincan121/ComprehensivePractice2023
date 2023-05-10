import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../login.vue'
import Sign from '../sign.vue'
import Main from '../main.vue'
import Push from '../components/push/push.vue'
import Search from '../components/search/search.vue'
import Ju from '../components/push/push_ju.vue'
import Shi from '../components/push/push_shi.vue'
import Write from '../components/write/write.vue'
import W_push from '../components/write/write_push.vue'
import W_no from '../components/write/write_noticed.vue'
import Tag from '../components/search/search_tag.vue'
import Poet from '../components/search/search_poet.vue'

import tag1 from '../components/tags_button/1.vue'
import tag2 from '../components/tags_button/2.vue'
import tag3 from '../components/tags_button/3.vue'
import tag4 from '../components/tags_button/4.vue'
import tag5 from '../components/tags_button/5.vue'
import tag6 from '../components/tags_button/6.vue'
import tag7 from '../components/tags_button/7.vue'
import tag8 from '../components/tags_button/8.vue'
import tag9 from '../components/tags_button/9.vue'
import tag10 from '../components/tags_button/10.vue'
import tag11 from '../components/tags_button/11.vue'
import TagList from '../components/tags_button/tagList.vue'

import pItem from '../components/poetryItem.vue'

import User from '../components//user/user.vue'
import UserWrite from '../components/user/userWrite.vue'
import UserCol from '../components/user/userCol.vue'
import UserNotice from '../components/user/userNotice.vue'

import Flower from '../components/game/flower.vue'
import Flower_feng from '../components/game/flower_feng.vue'
import Flower_hua from '../components/game/flower_hua.vue'
import Flower_xue from '../components/game/flower_xue.vue'
import Flower_yue from '../components/game/flower_yue.vue'

import Game3 from '../components/game/game_poet.vue'
import Li from '../components/game/li.vue'
import Du from '../components/game/du.vue'
import Su from '../components/game/su.vue'
import Yi from '../components/game/yi.vue'

import Pic from '../components/game/game_pic.vue'

import SearchPage from  '../components/search/searchPage.vue'
Vue.use(VueRouter)
const routes = [
  {
    path: '/login',
    component: Login
  },
  {
    path: '/sign',
    component: Sign
  },
  {

    path: "/",
    redirect: "/Login",

  },
  {path: '/searchPage',
  component: SearchPage},
  {path:'/poetry',component:pItem},
  {path:'/tagList',component:TagList},
  {path:'/userWrite',component:UserWrite},
  {path:'/userCol',component:UserCol},
  {path:'/userNotice',component:UserNotice},
  {path:'/gamePic',component:Pic},
  {path:'/flower',component:Flower,
  children:[
    {path:'/flower/feng',component:Flower_feng},
    {path:'/flower/hua',component:Flower_hua},
    {path:'/flower/xue',component:Flower_xue},
    {path:'/flower/yue',component:Flower_yue},
  ]},

  {path:'/game_p',component:Game3,
  children:[
    {path:'/game_p/li',component:Li},
    {path:'/game_p/du',component:Du},
    {path:'/game_p/su',component:Su},
    {path:'/game_p/yi',component:Yi},
  ]},
  
  {
    path: '/main',
    component: Main,
    children: [
      
      {path:'/main/user',component:User},
      {

        path: '/main/push',
        component: Push,
        children:
        [
          {
            path: '/main/push/ju',
            component: Ju
          },
          {
            path: '/main/push/shi',
            component: Shi
          }
        ]
      },
      {
        path: '/main/search',
        component: Search,
        children:
        [
          {
            path: '/main/search/tag',
            component: Tag,
            children:
            [
              {path: '/main/search/tag/1',component: tag1},
              {path: '/main/search/tag/2',component: tag2},
              {path: '/main/search/tag/3',component: tag3},
              {path: '/main/search/tag/4',component: tag4},
              {path: '/main/search/tag/5',component: tag5},
              {path: '/main/search/tag/6',component: tag6},
              {path: '/main/search/tag/7',component: tag7},
              {path: '/main/search/tag/8',component: tag8},
              {path: '/main/search/tag/9',component: tag9},
              {path: '/main/search/tag/10',component: tag10},
              {path: '/main/search/tag/11',component: tag11},
            ]   
          },
          {
            path: '/main/search/poet',
            component: Poet,
          },
        ]
      },
      {
        path: '/main/write',
        component: Write,
        children:
        [
          
          {
            path: '/main/write/push',
            component: W_push
          },
          {
            path: '/main/write/notice',
            component: W_no
          },
        ]
      },
    ]
  },


]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
