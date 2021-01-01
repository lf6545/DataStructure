package java_IO_Case.FileInputOutputStream;

import org.junit.Test;

import java.io.*;

public class case2_ReadFile {
    @Test
    /*
     * 字节输入流
     * */
    public void readFile() throws Exception {
        InputStream is = new FileInputStream("D:/手机视频/MV/aaa.txt");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer))!= -1){
            String s = new String(buffer, 0, len);
            System.out.println("读到的内容"+s);
        }
        is.close();//要记住关闭流
    }

    @Test
    /*
     * 字符输入流
     * */
    public void readFile2() throws Exception {
        Reader reader = new FileReader("D:/手机视频/MV/aaa.txt");

        char[] buffer = new char[50];//字符流使用字符数组作为每次读取的载具
        int len;
        while ((len = reader.read(buffer))!= -1){
            String s = new String(buffer, 0, len);
            System.out.println("读到的内容: "+s);
        }
        reader.close();//要记住关闭流
    }

    @Test
    /*
     * 字符输入流的处理流BufferedReader
     * */
    public void readFile3() throws Exception {
        Reader reader = new FileReader("D:/手机视频/MV/aaa.txt");

        BufferedReader br = new BufferedReader(reader);

        String str;
        while ((str = br.readLine())!= null){
            //readLine方法,BufferedReader将Reader进行了包装处理,可以支持一行一行地读取字符
            System.out.println("读到的一行: "+str);
        }
        br.close();//要记住关闭流
    }
}
