/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.patten;

import org.apache.commons.lang3.StringUtils;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName pwdDemo
 * @Author zhen.liu
 * @Date 2022/3/28 10:22 上午
 * @Version 1.0
 **/
public class pwdDemo {


    public static void main(String[] args) {
        String str = "Lzu6312425#^";
        boolean b = checkPassword(str);
        System.out.println(b);

    }

    /**
     * 常用用户密码字符验证
     * @param pwd
     * @return
     */
    public static boolean checkPassword(String pwd){
        if(StringUtils.isEmpty(pwd)){
            System.out.println("密码不能为空...");
            return false;
        }
        if(pwd.length() < 6){
            System.out.println("密码不能小于 6位...");
            return false;
        }
        boolean hasNumber = false;
        boolean hasSmallLetter = false;
        boolean hasBigLetter = false;
        boolean hasSpecialChar = false;
        char[] passwd = pwd.toCharArray();
        for (char c:passwd) {
            if(c >= '0' && c <= '9'){
                hasNumber = true;
                continue;
            }
            if( c >= 'A' && c <= 'Z'){
                hasBigLetter = true;
                continue;
            }
            if( c >= 'a' && c <= 'z'){
                hasSmallLetter = true;
                continue;
            }
            if("~@#S%*_-+=:.?".indexOf(c) > 0){
                hasSpecialChar = true;
                continue;
            }
            System.out.println("存在不能识别的特殊字符:{ "+c+" }");
            return false;
        }
        if(!hasNumber){
            System.out.println("密码中不包含数字");
            return false;
        }
        if(!hasSmallLetter){
            System.out.println("密码中不包含小写字符");
            return false;
        }
        if(!hasBigLetter){
            System.out.println("密码中不包含大写字符");
            return false;
        }
        if(!hasSpecialChar){
            System.out.println("密码中不包含特殊字符");
            return false;
        }
        // 如果四种组合条件均满足，则符合密码设置规则
        return hasNumber && hasSmallLetter && hasBigLetter && hasSpecialChar;
    }
}
