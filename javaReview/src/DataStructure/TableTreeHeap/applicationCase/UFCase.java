package DataStructure.TableTreeHeap.applicationCase;
import DataStructure.TableTreeHeap.UF_Tree_Weighted;

import java.io.*;

/*
* 使用并查集解决的案例:畅通工程
* 在当前文件夹中有trffic_project.txt文件,文件内容中20表示共有20个地点,7表示已经修好的道路数量
* 其余以" "(空格)分开的一组数据表示两个地点之间具有道路
* 需要解决:至少还需修建多少条道路才能将所有地点接通
* */
public class UFCase {
    public static void main(String[] args) throws Exception {
        Reader reader = new FileReader
                ("D:\\JAVA2020\\IDEA2017_Projects\\javaReview\\src\\DataStructure\\TableTreeHeap" +
                        "\\applicationCase\\trffic_project.txt");
        //处理流
        BufferedReader br = new BufferedReader(reader);

        UF_Tree_Weighted uf = new UF_Tree_Weighted(20);
        int now = 0;//当前已修道路数量
        int N = 0;//参与互通工程的城市数量
        String str;
        while ((str = br.readLine())!= null){
            //readLine方法,BufferedReader将Reader进行了包装处理,可以支持一行一行地读取字符
            //System.out.println("读到的一行: "+str+"-");
            if (str.contains("地点数量:")) {
                String s = str.split(":")[1];
                N = Integer.parseInt(s);
                System.out.println("互通工程城市数量:"+N);
                uf = new UF_Tree_Weighted(N);
            }
            if (str.contains("已修道路:")) {
                now = Integer.parseInt(str.split(":")[1]);
                System.out.println("已修道路:"+now);
            }
            if (str.contains(" ")){
                Integer i1 = Integer.parseInt(str.split(" ")[0]);
                Integer i2 = Integer.parseInt(str.split(" ")[1]);
                uf.union(i1,i2);
            }
        }
        br.close();//要记住关闭流
        //要让所有的地点都互通,则需要所有地点在并查集中处于同一个组
        System.out.println("至少还要修建"+(uf.count()-1)+"条道路!");
    }
}
