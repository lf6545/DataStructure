package DataStructure.TableTreeHeap;
/*
* 并查集:树型数据结构
* */
public class UF {
    private int[] eleAndGroup;//记录节点元素及该元素所在的分组标识
    private int count;//记录并查集中数据的分组个数

    public UF(int N){
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

    //获取元素p所在分组的标识符
    public int find(int p){
        if (p<0||p>eleAndGroup.length){
            return -1;
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

        int pGroup = find(p);
        int qGroup = find(q);
        System.out.println(p+" 和 "+q+" 合并到 "+qGroup+" 组中");
        //合并组
        //将并查集中的由p组标识符标记的数据改为q组标识符,即p组数据合并到了q组
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup){
                eleAndGroup[i] = qGroup;
            }
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
}
