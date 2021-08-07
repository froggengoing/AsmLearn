package com.froggengo.asm.uitl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author froggengo@qq.com
 * @date 2021/7/30 18:53.
 */
public class ClassOutputUtil {

    public static void byte2File(String outPath, byte[] bytes) {
        try {
            outPath = System.getProperty("user.dir") + "/" + outPath;
            final File file = new File(outPath);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.mkdirs();
            }
            final ByteArrayInputStream byteInStream = new ByteArrayInputStream(bytes);
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            int read = 0;
            final byte[] buf = new byte[1024];
            while ((read = byteInStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            byteInStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
