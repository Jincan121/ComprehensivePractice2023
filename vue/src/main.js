import Vue from 'vue'
import './plugins/axios'
import App from './app.vue'
import router from './router'
import store from './store'
import 'vant/lib/index.css'
import 'vant/lib/index.less';
import { Form } from 'vant';

import { NavBar } from 'vant';
import { Tabbar, TabbarItem } from 'vant';
import { Col, Row } from 'vant';
import { Icon } from 'vant';
import { List } from 'vant';
import { Cell, CellGroup } from 'vant';
import { Tab, Tabs } from 'vant';

import { Grid, GridItem } from 'vant';
import { Sticky } from 'vant';
import { Sidebar, SidebarItem } from 'vant';
import { IndexBar, IndexAnchor } from 'vant';
import { Tag } from 'vant';
import Vuex from 'vuex'
import { Image as VanImage } from 'vant';
import { Popup } from 'vant';
import { Search } from 'vant';
import { Divider } from 'vant';

Vue.use(Divider);

Vue.use(Search);
Vue.use(Popup);
Vue.use(VanImage);
Vue.use(Vuex);
Vue.use(Tag);
Vue.use(IndexBar);
Vue.use(IndexAnchor);
Vue.use(Sidebar);
Vue.use(SidebarItem);
Vue.use(Sticky);
Vue.use(Grid);
Vue.use(GridItem);

Vue.use(Tab);
Vue.use(Tabs);
Vue.use(Cell);
Vue.use(CellGroup);
Vue.use(List);
Vue.use(Icon);
Vue.use(Col);
Vue.use(Row);
Vue.use(Tabbar);
Vue.use(TabbarItem);
Vue.use(NavBar);
Vue.use(Form);
import { Toast } from 'vant';

Vue.use(Toast);
import { Swipe, SwipeItem } from 'vant';

Vue.use(Swipe);
Vue.use(SwipeItem);
import { PasswordInput } from 'vant';
import { Dialog } from 'vant';
import { Pagination } from 'vant';
import { RadioGroup, Radio } from 'vant';

Vue.use(Radio);
Vue.use(RadioGroup);
Vue.use(Pagination);
// 全局注册
Vue.use(Dialog);
Vue.use(PasswordInput);

import { Field } from 'vant';
import { Button } from 'vant';

import VueTouch from 'vue-touch'
Vue.use(VueTouch, {name: 'v-touch'})

import axios from 'axios'
// 挂载axios 到Vue的原型prototype的$http
Vue.prototype.$http = axios
// 设置请求的根路径
axios.defaults.baseURL = "http://175.178.213.250:8090"
axios.interceptors.request.use(config => {
  console.log(config);
  // 请求头挂载信息
  config.headers.Authorization = window.sessionStorage.getItem("flag");
  // 在最后必须return config
  return config;
})

Vue.use(Button);
Vue.use(Field);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
