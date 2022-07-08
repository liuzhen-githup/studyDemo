/**
 * Copyright(c) 2018 asura
 */
package comm.inter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * <p></p>
 *
 *
 * @Description:
 * @ClassName ImageDemo2
 * @Author zhen.liu
 * @Date 2021/8/24 9:28 上午
 * @Version 1.0
 **/
public class ImageDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("人物照片路径");
        File  file2 = new File("二维码路径");
        //人物照片
        Image src1 = javax.imageio.ImageIO.read(file);
        //二维码图片
        Image src2 = javax.imageio.ImageIO.read(file2);

        //获取人物照片宽高
        int width = src1.getWidth(null);
        int height = src1.getHeight(null);

        //创建一个画布，设置宽高（这里人物照片宽高就是画布宽高）
        BufferedImage thumbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = thumbImage.createGraphics();


        //绘制人脸图片
        g.drawImage(src1.getScaledInstance(width,height, Image.SCALE_SMOOTH), 0, 0, null);


        //绘制二维码图片（这里二维码的宽高就由人物照片决定好了，我这里二维码宽高都是照片的宽度四分之一，然后二维码位于照片右下角）
//        g.drawImage(src3.getScaledInstance(width/4,
//                width/4, Image.SCALE_SMOOTH), width/4*3, height-wwid/4, null);


        //获取项目的根路径
        String path = "/";
        path = path +"image";
        //使用uuid为图片生成一个名字
        String name = UUID.randomUUID().toString();
        name = name+".jpg";
        path = path +File.separator+name;

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));
        String formatName = path.substring(path.lastIndexOf(".") + 1);
        ImageIO.write(thumbImage, /*"GIF"*/ formatName /* format desired */ , new File(path) /* target */ );

        //关闭输出流
        out.close();
    }
}
