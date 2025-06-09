const menu = {
    list() {
        return [{
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
    }
}
export default menu;