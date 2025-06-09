import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'


    import lishibeijing from '@/views/modules/lishibeijing/list'
    import shipinfenlei from '@/views/modules/shipinfenlei/list'
    import zhizuoshipin from '@/views/modules/zhizuoshipin/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discusszhizuoshipin from '@/views/modules/discusszhizuoshipin/list'
    import config from '@/views/modules/config/list'
    import storeup from '@/views/modules/storeup/list'

    import quweigushi from '@/views/modules/quweigushi/list'
    import quweishipin from '@/views/modules/quweishipin/list'
    import discussquweishipin from '@/views/modules/discussquweishipin/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/lishibeijing',
        name: '历史背景',
        component: lishibeijing
      }
          ,{
	path: '/shipinfenlei',
        name: '视频分类',
        component: shipinfenlei
      }
          ,{
	path: '/zhizuoshipin',
        name: '制作视频',
        component: zhizuoshipin
      }
          ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
          ,{
	path: '/discusszhizuoshipin',
        name: '制作视频评论',
        component: discusszhizuoshipin
      }

        ,{
            path: '/quweigushi',
            name: '趣味故事',
            component: quweigushi
        }
        ,{
            path: '/quweishipin',
            name: '趣味视频',
            component: quweishipin
        }
        ,{
            path: '/discussquweishipin',
            name: '趣味视频评论',
            component: discussquweishipin
        }

          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
        ,{
            path: '/storeup',
            name: '收藏管理',
            component: storeup
        }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
