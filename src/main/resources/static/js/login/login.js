var index = new Vue({
    el : "#login",
    data : {
        account : null,
        password : null
    },
    methods : {
        login : function () {
            var url = base + "/login";
            var params = {
                account : this.account,
                password : this.password
            };
            this.$http.post(url, params, {emulateJSON : true}).then(function (value) {
                var response = value.data
                if(response.success){
                    window.location.href =  base + "/home";
                }else{
                    layerUtil.fail(response.msg)
                }
            });

        },
        register : function () {

        }
    },

})