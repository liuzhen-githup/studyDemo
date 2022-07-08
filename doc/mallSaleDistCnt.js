function main(param){

    //检查参数
    if(!param.channel || !param.tag_time){
        throw "Param Error";
    }

    //从ES中查找数据,该查找条件可以从Kibana中组装后复制过来
    var query=	{
        "bool": {
            "must": [
                {
                    "term": {
                        "tag": {
                            "value": param.channel
                        }
                    }
                },{
                    "term": {
                        "tag_time.keyword": {
                            "value": param.tag_time
                        }
                    }
                }
            ]
        }
    };

    var rs = es.search(
        "uni_mall_sales_related_dist", //索引名
        "", //include eg. "column1,column2,column3"
        "", //exclude eg. "column1,column2.xx,column3"
        JSON.stringify(query), //查询条件，注意，这里需要转化成字符串
        "", //排序字段
        "", //排序方法
        null,  //开启位置
        null //返回条数
    );

    return {
        rs:rs
    };

}