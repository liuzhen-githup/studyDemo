/**
 * Copyright(c) 2018 asura
 */
package comm.yfn.utils;

import sun.net.util.IPAddressUtil;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName IpCheckDemo
 * @Author zhen.liu
 * @Date 2022/5/28 10:17
 * @Version 1.0
 **/
public class IpCheckDemo {


    public static void main(String[] args) {
        System.out.println("192.168.56.1: " + CNIPRecognizer.isCNIP("192.168.56.1"));

        System.out.println(internalIp("192.168.56.1"));
    }


    public static boolean internalIp(String ip) {
        byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
        return internalIp(addr);
    }

    public static boolean internalIp(byte[] addr) {

        final byte b0 = addr[0];

        final byte b1 = addr[1];

//10.x.x.x/8

        final byte SECTION_1 = 0x0A;

//172.16.x.x/12

        final byte SECTION_2 = (byte) 0xAC;

        final byte SECTION_3 = (byte) 0x10;

        final byte SECTION_4 = (byte) 0x1F;

//192.168.x.x/16

        final byte SECTION_5 = (byte) 0xC0;

        final byte SECTION_6 = (byte) 0xA8;

        switch (b0) {

            case SECTION_1:

                return true;

            case SECTION_2:

                if (b1 >= SECTION_3 && b1 <= SECTION_4) {

                    return true;

                }

            case SECTION_5:

                switch (b1) {

                    case SECTION_6:

                        return true;

                }

            default:

                return false;

        }

    }


}
