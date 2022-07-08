/**
 * Copyright(c) 2018 asura
 */
package comm.study.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName TestPics
 * @Author zhen.liu
 * @Date 2021/12/4 6:42 下午
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class TestPics {

    /**
     * SPU ID
     */
    private String productCode;

    /**
     * SPU 图片集合
     */
    private List<Images> pics;
    @Getter
    @Setter
    @ToString
    public static class Images{
        /**
         * 媒体链接
         */
        private String url;
        /**
         * width
         */
        private Integer width;
        /**
         * height
         */
        private Integer height;

        /**
         * 是否选中图片
         */
        private Boolean checked;
    }

}
