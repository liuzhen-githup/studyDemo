package comm.inter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
public class ImageDemo{

    public static void main(String[] args){
        try {
            InputStream imagein1 = new FileInputStream("/Users/sence/Desktop/1.jpeg");
            InputStream imagein2 = new FileInputStream("/Users/sence/Desktop/2.jpeg");
            BufferedImage bg_image = new BufferedImage(192, 144, BufferedImage.TYPE_INT_BGR);
            BufferedImage image1 = ImageIO.read(imagein1);
            BufferedImage image2 = ImageIO.read(imagein2);
            Graphics g = bg_image.getGraphics();
            g.drawImage(image1, 0, 48, 48, 48,null);
            g.drawImage(image2, 48, 48, 48, 48,null);
            OutputStream outImage = new FileOutputStream("/Users/sence/Desktop/3.jpeg");
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
            enc.encode(bg_image);
            imagein1.close();
            imagein2.close();
            outImage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}