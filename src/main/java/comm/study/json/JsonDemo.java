/**
 * Copyright(c) 2018 asura
 */
package comm.study.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/5/14 8:31 下午
 */
public class JsonDemo {

    public static void main(String[] args) throws JsonProcessingException {

        String orderId = "YFN-3a27d650b9e24dcfa347b50024b72a91-e60c6";
        int num = (int)(orderId.charAt(orderId.length() - 1)) % 10;

        System.out.println(num);
    }

    public static void toJson(){
    }
}
