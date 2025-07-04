package Graph.Disjoint;

public class Disjoint_set_Union_Find {
   static int find(int par[], int x) {
        if (par[x] ==x) {
            return x;
        }
        return find(par, par[x]);
    }

    static void unionSet(int par[], int x, int z) {
       int xx=find(par,x);
       int zz=find(par,z);
       if(xx !=zz){
           par[xx]=zz;
       }
    }
}
