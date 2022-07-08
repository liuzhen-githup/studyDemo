function main(param){

    if(!param.tag_time || !param.type){
        throw ("Param empty")
    }

    //从ES中查找数据,该查找条件可以从Kibana中组装后复制过来
    var query=	{
        "bool": {
            "must": [
                {
                    "term": {
                        "tag_time": {
                            "value": param.tag_time
                        }
                    }
                },{
                    "term": {
                        "type.keyword": {
                            "value": param.type
                        }
                    }
                }
            ]
        }
    };


}