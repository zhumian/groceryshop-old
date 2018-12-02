var home = new Vue({
    el : "#home",
    data : {
        currentUser : currentUser,
        tab : null,
    },
    methods : {
        openTab : function (code) {
            this.tab = code
        }
    },
    mounted : function () {
        element.render();
    }

})