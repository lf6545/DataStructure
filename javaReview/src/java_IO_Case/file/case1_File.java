package java_IO_Case.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class case1_File {
    public static void main(String[] args) throws Exception {
        File file = new File("D://2020/");
        //System.out.println(file.createNewFile());//文件不存在时创建
//        System.out.println("可以治行吗?"+file.canExecute());
//        System.out.println("可以读取吗?"+file.canRead());
//        System.out.println("可以写入吗?"+file.canWrite());
//        System.out.println(file.exists());
//      System.out.println(file.getParent());//父路径,不包括文件名
//      File parentFile = file.getParentFile();//父路径作为对象拿出来
//      System.out.println(file.getTotalSpace()/1024/1024/1024);//获取对象所在磁盘总容量,(字节
//      System.out.println(file.getUsableSpace()/1024/1024/1024);
//      System.out.println("是文件夹吗?"+file.isDirectory());
//      System.out.println(new Date(file.lastModified()));//return long时间戳

//      System.out.println(file.length());//字节
        /*for (String s : file.list()) {
            //获取文件对象了路径下的所有文件和目录的字符串数组
            System.out.println(s);
        }*/
//        file.mkdir()//不能创建不存在的父目录
//        file.mkdirs()//可以连带创建父目录
    }
}
