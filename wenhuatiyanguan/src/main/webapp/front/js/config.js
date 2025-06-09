
var projectName = '鲸落文化线上体验馆';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
},
{
	name: '我的收藏',
	url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '制作视频',
	url: './pages/zhizuoshipin/list.html'
},
{
	name: '趣味视频',
	url: './pages/quweishipin/list.html'
},
{
	name: '历史背景',
	url: './pages/lishibeijing/list.html'
},
{
	name: '趣味故事',
	url: './pages/quweigushi/list.html'
},
]

var adminurl =  "http://localhost:8080/wenhuatiyanguan/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{
    "backMenu": [{
        "child": [{
            "buttons": ["查看", "修改", "删除"],
            "menu": "用户",
            "menuJump": "列表",
            "tableName": "yonghu"
        }],
        "menu": "用户管理"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "视频分类",
            "menuJump": "列表",
            "tableName": "shipinfenlei"
        }],
        "menu": "视频分类管理"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
            "menu": "制作视频",
            "menuJump": "列表",
            "tableName": "zhizuoshipin"
        }],
        "menu": "制作视频管理"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
            "menu": "趣味视频",
            "menuJump": "列表",
            "tableName": "quweishipin"
        }],
        "menu": "趣味视频管理"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "轮播图管理",
            "tableName": "config"
        }, {
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "历史背景",
            "tableName": "lishibeijing"
        }, {
            "buttons": ["新增", "查看", "修改", "删除"],
            "menu": "趣味故事",
            "tableName": "quweigushi"
        }, {
            "buttons": ["查看", "修改", "删除"],
            "menu": "收藏管理",
            "tableName": "storeup"
        }],
        "menu": "系统管理"
    }],
    "frontMenu": [{
        "child": [{
            "buttons": ["查看"],
            "menu": "制作视频列表",
            "menuJump": "列表",
            "tableName": "zhizuoshipin"
        }],
        "menu": "制作视频"
    }],
    "hasBackLogin": "是",
    "hasBackRegister": "否",
    "hasFrontLogin": "否",
    "hasFrontRegister": "否",
    "roleName": "管理员",
    "tableName": "users"
}, {
    "backMenu": [{
        "child": [{
            "buttons": ["查看", "删除"],
            "menu": "收藏信息",
            "tableName": "storeup"
        }],
        "menu": "收藏管理"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改"],
            "menu": "趣味故事",
            "tableName": "quweigushi"
        }],
        "menu": "趣味故事"
    }, {
        "child": [{
            "buttons": ["新增", "查看", "修改", "查看评论"],
            "menu": "趣味视频",
            "menuJump": "列表",
            "tableName": "quweishipin"
        }],
        "menu": "趣味视频管理"
    }],
    "frontMenu": [{
        "child": [{
            "buttons": ["查看"],
            "menu": "制作视频列表",
            "menuJump": "列表",
            "tableName": "zhizuoshipin"
        }],
        "menu": "制作视频"
    }],
    "hasBackLogin": "否",
    "hasBackRegister": "否",
    "hasFrontLogin": "是",
    "hasFrontRegister": "是",
    "roleName": "用户",
    "tableName": "yonghu"
}]

var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
