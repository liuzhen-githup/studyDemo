/**
 * Copyright(c) 2018 asura
 */
package comm.inter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p></p>
 *
 *
 * @Description: 多个图片合成
 * @ClassName ImageBeComposedOf
 * @Author zhen.liu
 * @Date 2021/8/23 2:29 下午
 * @Version 1.0
 **/
public class ImageBeComposedOf {
    private Graphics2D g = null;

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {

        try {
            int w = b.getWidth();
            int h = b.getHeight();

            g = d.createGraphics();
            g.drawImage(b, 300, -800, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return d;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {

        ImageBeComposedOf tt = new ImageBeComposedOf();

        BufferedImage d = tt.loadImageLocal("/Users/sence/Desktop/1.jpeg");
        BufferedImage b = tt.loadImageLocal("/Users/sence/Desktop/2.jpeg");

        tt.writeImageLocal("/Users/sence/Desktop/new.jpeg", tt.modifyImagetogeter(b, d));
        //将多张图片合在一起
        System.out.println("success");
    }
}
