package java_IO_Case.FileInputOutputStream;

import org.junit.Test;

import java.io.*;

public class case3_WriteFile {
    @Test
    /*
    * 字节输出流
    * */
    public void writeFile() throws Exception {
        OutputStream os = new FileOutputStream("D:/手机视频/MV/ccc.txt");

        //os.write(65);
        //write(int b),数字的字节写入,65写入就是字符A

        String s = "爱我中华";
        byte[] b = s.getBytes();
        os.write(b);
        os.close();
    }

    @Test
    public void writeFile2() throws Exception {
        OutputStream os = new FileOutputStream("D:/手机视频/MV/eee.txt");

        for (int i = 100000; i > 0; i--) {
            String str = i+"\r\n";
            os.write(str.getBytes());
        }

        os.close();
    }
}
