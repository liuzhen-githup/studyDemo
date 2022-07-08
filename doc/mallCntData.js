function main(param){

    //检查参数
    if(!param.type){
        throw "Param Error";
    }


    //从ES中查找数据,该查找条件可以从Kibana中组装后复制过来
    var query=	{
        "match_all": {}
    };

    var rs = es.search(
        "uni_mall_summary", //索引名
        "", //include eg. "column1,column2,column3"
        "time_stamp", //exclude eg. "column1,column2.xx,column3"
        JSON.stringify(query), //查询条件，注意，这里需要转化成字符串
        "time_stamp", //排序字段
        "DESC", //排序方法
        0,  //开启位置
        1 //返回条数
    );

    //返回数据
    return {
        rs:rs
    };
}