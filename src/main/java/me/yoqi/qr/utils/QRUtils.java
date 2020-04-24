package me.yoqi.qr.utils;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * 二维码识别工具类
 */
public class QRUtils {

    /** 二维码识别
     * @param image 截图
     * @return
     */
    public String readQR(BufferedImage image) {
        Result result;
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        HashMap<DecodeHintType, String> map = new HashMap<>();
        map.put(DecodeHintType.CHARACTER_SET, "utf-8");
        try {
            result = multiFormatReader.decode(binaryBitmap, map);
            System.out.println("解析结果:" + result.toString());
            System.out.println("内容：" + result.getText());
            return result.getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
