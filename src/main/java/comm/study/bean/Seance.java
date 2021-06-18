/**
 * Copyright(c) 2018 asura
 */
package comm.study.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p></p>
 *
 *
 * @Description: Seance Bean
 * @ClassName Seance
 * @Author zhen.liu
 * @Date 2021/6/17 5:32 下午
 * @Version 1.0
 **/

@Getter
@Setter
@ToString
public class Seance {

    private String Id;

    private String name;

    private String Address;

    private Emp emp;

    private User user;
}
