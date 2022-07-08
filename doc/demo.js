
/**
 这是一个Demo程序，不要改它，大家参考
 POST https://erpapi.selleroa.com/v1/jsapi/main/test/test/demo {}  将会调用该 main方法，param为body里面的参数,
 该脚本支持符合ES5格式JS语法。
 */
function main(param){
    /**
     可调用的上下文数据及服务
     service:
     svc.xxxService.v2Create({"属性":"值"})  //创建对象
     svc.xxxService.v2Get("ID") //根据ID查找
     svc.xxxService.v2List()   //返回整个表的数据
     svc.xxxService.rollPage("companyId",{"模版属性":"模版值"},"排序字段","DESC|ASC",PageSize,Page); //分页查询
     svc.xxxService.deleteLogical("ID"); //逻辑删除
     svc.xxxService.findByExample("companyId",{"模版属性":"模版值"},size); //条件查询
     svc.xxService.updateSkipNull("companyId",{"":""},ver); //修改数据
     session:
     session.companyId   //公司ID
     session.userId   //用户ID
     session.userName   //用户名
     session.userMobile   //手机号
     session.userPosition   //职务
     session.deptId   //部门ID
     session.deptName   //部门名字
     session.deptCode   //部门编码
     ES:
     es.search("INDEX","QueryString",size);  查找
     es.search(
     "INDEX",   //索引名
     "includes", //包函字段
     "excludes", //过虑字段
     "QueryString", //条件，和在kibana上的一样
     "orderColumn", //排序字段
     "DESC|ASC",
     from,  //开始位置
     size  //大小
     );  查找

     */

    //检查参数
    if(!param.name||!param.mobile){
        throw "Param Error";
    }

    //1、创建
    var createParam={
        name:param.name,
        mobile:param.mobile,
        companyId:session.companyId
    };
    var id = svc.testAbcService.v2Create(createParam); // testAbcService 访问的是 testAbcDO 表,以此类推

    //2、查找数据
    var testAbcDO = svc.testAbcService.v2Get(id);

    //3、修改数据
    var newName="修改过后的名字"+new Date().getTime();
    var updateSuccess = svc.testAbcService.updateSkipNull(session.companyId,{id:testAbcDO.id,name:newName},testAbcDO.ver);

    //4、条件查找
    var testAbcDOList = svc.testAbcService.findByExample(session.companyId,{name:newName},2);

    /**
     总的来说，大部分的针对mysql的增，删查改功能，都可以利用该方法
     */

        //从ES中查找数据,该查找条件可以从Kibana中组装后复制过来
    var query=	{
            "match_all": {}
        };
    var rs = es.search(
        "yfn-spu1", //索引名
        "skus.productCode,productName", //include eg. "column1,column2,column3"
        "skus.specs,skus.skuName", //exclude eg. "column1,column2.xx,column3"
        JSON.stringify(query), //查询条件，注意，这里需要转化成字符串
        "orgPrice", //排序字段
        "DESC", //排序方法
        0,  //开启位置
        10 //返回条数
    );

    //返回数据
    return {
        testAbcDOList:testAbcDOList,
        updateSuccess:updateSuccess,
        id:testAbcDO.id,
        testAbcDO:testAbcDO,
        a:"xxxaaaaa",
        rs:rs
    };

}