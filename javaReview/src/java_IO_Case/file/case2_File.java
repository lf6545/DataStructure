package java_IO_Case.file;

import com.sun.javafx.image.BytePixelSetter;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;

/*
* 遍历所有目录及文件
*
* */
public class case2_File {

    public static void main(String[] args) throws Exception{
        File java2020 = new File("D:/DTLFolder/");
        //System.out.println(java2020.toString());
        find(java2020);
    }
    public static void find(File file){
        if (file.isDirectory()){
            System.out.println("[文件夹]"+file.getName());

            for (String s : file.list()) {
                File afile = new File(file.toString()+"/"+s);
                find(afile);
            }
        }else {
            System.out.println("[文件]"+file.getName());//getName获取文件或者目录的名称
        }
    }
}
