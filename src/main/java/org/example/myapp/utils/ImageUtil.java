package org.example.myapp.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Base64;

public class ImageUtil {

    //路径前缀
    private static final String preSource="./pic/";

    public static void WriteBase64ToFile(String fileName, String content) {
        String base64Image = content.replaceAll("^data:image/\\w+;base64,", "");
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        // 创建文件并写入字节数组
        File file = new File(preSource+fileName); // 注意：这里文件名和扩展名是硬编码的
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(imageBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
