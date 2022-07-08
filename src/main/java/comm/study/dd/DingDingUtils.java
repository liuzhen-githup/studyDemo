/**
 * Copyright(c) 2018 asura
 */
package comm.study.dd;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiUserGetByMobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiUserGetByMobileResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName DingDingUtils
 * @Author zhen.liu
 * @Date 2021/10/8 9:09 上午
 * @Version 1.0
 **/
public class DingDingUtils {

    public static Long AGENT_ID = 893072185L;
    public static String APP_KEY = "dingypdbznqxviwf4fyr";
    public static String APP_SECRET = "2uA7Koki50tPfBskP2S_RiGELjx-ZfyMrzbNqextDUcZKKso7YBfDgOkgiOTMEWH";

    private static String DD_ACCESS_TOKEN_KEY = "DD_ACCESS_TOKEN_KEY";

    public static String MESSAGE_URL = "https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";


    /**
     * 获取accessToken
     * @return
     * @throws ApiException
     */
    public static String getAccessToken() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(APP_KEY);
        request.setAppsecret(APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = null;
        try {
            response = client.execute(request);
        } catch (ApiException e) {
            throw new RuntimeException(e.getErrMsg());
        }
        return response.getAccessToken();
    }

    public void sendNotification(String mobile,String alarmCode,String severityDesc) throws ApiException {
        String accessToken = getAccessToken();
        if(StringUtils.isBlank(mobile)){
            return;
        }
        //电话号码数组
        String[] split = mobile.split(",");
        for (String s : split) {
            DingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_by_mobile");
            OapiUserGetByMobileRequest req = new OapiUserGetByMobileRequest();
            req.setMobile(s);
            req.setHttpMethod("GET");
            OapiUserGetByMobileResponse rsp = client2.execute(req, accessToken);
            //获取到Urid就是在公司里要发送到那个人的id
            String urid = "0e41cf9999994a45ba9256dab284699d";
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");
            OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
            request.setUseridList(urid);
            request.setAgentId(AGENT_ID);
            request.setToAllUser(false);
            OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
            msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
            msg.getOa().setMessageUrl(MESSAGE_URL);
            msg.getOa().setPcMessageUrl("https://www.baidu.com");
            msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
            msg.getOa().getHead().setText("text");
            msg.getOa().getHead().setBgcolor("FFBBBBBB");
            msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
            msg.getOa().getBody().setContent("******");
            OapiMessageCorpconversationAsyncsendV2Request.Form formPark = new OapiMessageCorpconversationAsyncsendV2Request.Form();
            formPark.setKey(APP_KEY);
            OapiMessageCorpconversationAsyncsendV2Request.Form formAlarmCode = new OapiMessageCorpconversationAsyncsendV2Request.Form();
            formAlarmCode.setKey("************");
            formAlarmCode.setValue(alarmCode);
            OapiMessageCorpconversationAsyncsendV2Request.Form formSeverityDesc = new OapiMessageCorpconversationAsyncsendV2Request.Form();
            formSeverityDesc.setKey("************");
            formSeverityDesc.setValue(severityDesc);
            OapiMessageCorpconversationAsyncsendV2Request.Form formConner = new OapiMessageCorpconversationAsyncsendV2Request.Form();
            formConner.setKey("************");
            ArrayList<OapiMessageCorpconversationAsyncsendV2Request.Form> objects = new ArrayList<>();
            objects.add(formPark);
            objects.add(formSeverityDesc);
            objects.add(formAlarmCode);
            objects.add(formConner);
            msg.getOa().getBody().setForm(objects);
            msg.setMsgtype("oa");
            request.setMsg(msg);
            OapiMessageCorpconversationAsyncsendV2Response response = client.execute(request,accessToken);
            System.out.println(response.isSuccess());
            System.out.println(response.getTaskId());
        }
    }

    public static void main(String[] args) {
        DingDingUtils utils = new DingDingUtils();

    }

}
