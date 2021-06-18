/**
 * Copyright(c) 2018 asura
 */
package comm.study.json;

import lombok.*;

import java.io.Serializable;

/**
 * <p></p>
 *
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/5/14 8:30 下午
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stud implements Serializable {

    private String name;

    private Integer age;

    private String mark;
}
