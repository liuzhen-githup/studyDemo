/**
 * Copyright(c) 2018 asura
 */
package comm.study.qrCode;


import cn.hutool.extra.qrcode.QrCodeException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * <p></p>
 *
 *
 * @Description: 二维码生产
 * @ClassName GenerateQRCodeImage
 * @Author zhen.liu
 * @Date 2022/7/8 14:36
 * @Version 1.0
 **/
public class GenerateQRCodeImage {
    private static final String QR_CODE_IMAGE_PATH = "/Users/sence/Desktop/MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        //写二维码
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("this is chen xiao ying", 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }


}
