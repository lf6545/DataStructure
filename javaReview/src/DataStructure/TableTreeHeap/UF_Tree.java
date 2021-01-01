package DataStructure.TableTreeHeap;
/*
* 并查集:树型数据结构
* 对UF进行优化,eleAndGroup[i]的值不在作为i元素的分组标识,而是i元素的父节点
* */
public class UF_Tree {
    private int[] eleAndGroup;//记录节点元素及该元素所在的分组标识
    private int count;//记录并查集中数据的分组个数

    public UF_Tree(int N){
        //初始化分组数量,默认N
        this.count = N;
        this.eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
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
        //让q的根节点的父节点为p的根节点就行了
        int qRoot = find(q);
        int pRoot = find(p);
        eleAndGroup[qRoot] = pRoot;
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
}
