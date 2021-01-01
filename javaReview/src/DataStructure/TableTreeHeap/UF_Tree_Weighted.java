package DataStructure.TableTreeHeap;

import DataStructure.ArrayAndList.QueueByList;

/*
* 并查集:树型数据结构
* 对UF_Tree进行优化,由于union()中并不判断p,q所在树的深度,
* 有可能导致合并的新树深度不断增加,从而使得find方法查找根节点的时间变长
* 优化 : 在union中分析p,q所在树的深度,让深度较小的树的根节点指向深度更大的树
* 但是我这也没有实现记录数的深度,只是用树的元素数量来表示树的大小
* */
public class UF_Tree_Weighted {
    private int[] eleAndGroup;//记录节点元素及该元素所在的分组标识
    private int count;//记录并查集中数据的分组个数
    private int[] sz;//记录每个根节点对应的树中的元素个数
    public UF_Tree_Weighted(int N){
        //初始化分组数量,默认N
        this.count = N;
        this.eleAndGroup = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
            sz[i] = 1;
        }
    }

    //获取并查集中数据的分组个数
    public int count(){
        return count;
    }

    //获取元素p所在分组的标识符(标识符即树的根节点)
    public int find(int p){
        if (p<0||p>eleAndGroup.length){
            return -1;
        }
        while (p!=eleAndGroup[p]){
            //当前元素的父节点不是该元素本身,继续查找根节点
            p = find(eleAndGroup[p]);
        }
        return eleAndGroup[p];
    }

    //判断并查集中元素p和元素q是否在同一组
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    //把p和q元素所在分组进行合并
    public void union(int p,int q){
        //判断p,q是否已经在同一分组
        if (connected(p,q)){
            return;
        }
        //不在同一组中,进行合并;
        //获取p,q元素所在组的根节点
        int qRoot = find(q);
        int pRoot = find(p);
        //判断两树的大小
        if (sz[pRoot]>=sz[qRoot]) {
            //p树大于等于q树
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] = sz[pRoot]+sz[qRoot];
            sz[qRoot] = 0;
        }else{
            eleAndGroup[pRoot] = qRoot;
            sz[qRoot] = sz[pRoot]+sz[qRoot];
            sz[pRoot] = 0;
        }

        //分组个数-1
        count--;
    }

    //打印数据分组的数组
    public void print(){
        System.out.println("-数据---组号-");
        for (int i = 0; i < eleAndGroup.length; i++) {
            System.out.println(" "+i+"     "+eleAndGroup[i]);
        }
    }

    //打印树的根节点及其树的元素个数
    public void printRoot(){
        System.out.println("-根元素---该树中元素个数-");
        for (int i = 0; i < sz.length; i++) {
            System.out.println(" "+i+"     "+sz[i]);
        }
    }

    //返回sz[]
    public int[] getSz(){
        return this.sz;
    }

    //返回元素个数

}
