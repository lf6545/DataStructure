package java_IO_Case.FileInputOutputStream;

import org.junit.Test;


import java.io.*;

public class case1_FileStream {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            File file = new File("D:\\手机视频\\MV\\lf.txt");
            long length = file.length();
            System.out.println(length);
            is = new FileInputStream("D:\\手机视频\\MV\\lf.txt");
            os = new FileOutputStream("D:\\手机视频\\MV\\lf4.txt");

            byte[] buffer = new byte[102400];

            //is.read(),从这个输入流中读取一个字节的数据,直到没有数据输入,返回-1
            //is.read(byte b[]){return readBytes(b, 0, b.length)}根据字节数组大小来读取字节数,返回读取字节的个数
            int len;
            while ((len = is.read(buffer)) != -1){//读一下,读取字节内容存到buffer字节数组中,字节数组进入到内存
                double v = (((double) length - (double) is.available()) / length) * 100;
                String vString = String.format("%.1f", v);
                System.out.println("已完成"+vString+"%");
                //System.out.println(is.available());//is流里还有多少字节可以读到内存中去
                os.write(buffer,0, len);//把读到的写一下,从内存中的buffer数组里将自己数据写入磁盘
                //从buffer里取出来存到磁盘,0开始,len长度个数,因为is读进来就是这么多

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null){//如果输入流不为空,关闭
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){//如果输出流不为空,关闭
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
