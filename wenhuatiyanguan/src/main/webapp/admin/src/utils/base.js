const base = {
    get() {
                return {
            url : "http://localhost:8080/wenhuatiyanguan/",
            name: "wenhuatiyanguan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/wenhuatiyanguan/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "鲸落文化线上体验馆"
        } 
    }
}
export default base
