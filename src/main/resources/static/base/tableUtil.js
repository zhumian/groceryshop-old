var tableUtil = function () {

    /** datatable 默认配置  **/
    var defaultSetting = {
        paging: true,
        searching: false,
        serverSide: false,
        ordering: false,
        scrollX: true,
        scrollY: false,
        pageLength: 15,
        pagingType: 'full_numbers',
        lengthMenu: [5, 10, 15, 20, 50, 100],
        language: {
            "sProcessing": "处理中...",
            "sLengthMenu": "显示 _MENU_ 项结果",
            "sZeroRecords": "没有匹配结果",
            "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
            "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
            "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
            "sInfoPostFix": "",
            "sSearch": "搜索:",
            "sUrl": "",
            "sEmptyTable": "表中数据为空",
            "sLoadingRecords": "载入中...",
            "sInfoThousands": ",",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上页",
                "sNext": "下页",
                "sLast": "末页"
            },
            "oAria": {
                "sSortAscending": ": 以升序排列此列",
                "sSortDescending": ": 以降序排列此列"
            }
        },
        fnRowCallback: null, //行事件
    };

    return {

        /**
         * 初始化datables
         * @param $obj        table dom对象
         * @param url        请求地址
         * @param columns    字段配置
         * @param setting    datatable 设置
         * @param params    请求参数 预留
         */
        load: function ($obj, url, params, columns, setting) {
            var nowSetting = $.extend({}, defaultSetting);
            nowSetting.columns = columns;

            if (url) { // 自己传数据源
                nowSetting.serverSide = true;
                nowSetting.ajax = {
                    type: 'post',
                    url: url,
                    data : params,
                };

            }
            setting = $.extend({}, nowSetting, setting);

            var table = $obj.DataTable(setting);

            return table;
        },

    }

}();