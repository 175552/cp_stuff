import java.util.*;
public class dsu {
    int n;
    HashMap<Integer, Integer> parent;
    HashMap<Integer, Integer> size;
    public dsu(int nn){
        n = nn;
        parent = new HashMap<>();
        size = new HashMap<>();
    }
    public int find(int u) {
        if(u == parent.get(u)) {
            return u;
        }
        return parent.put(u, find(parent.get(u)));
    }
    public boolean union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) {
            if(size.get(v) > size.get(u)) {
                int temp = v;
                v = u;
                u = temp;
            }
            parent.put(v, u);
            size.put(u, size.get(u) + size.get(v));
            return false;
        }
        return true;
    }
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int nodes = input.nextInt();
        int edges = input.nextInt();
        dsu temp = new dsu(nodes);
        boolean found = false;
        for(int i = 0; i < edges; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            if(!temp.parent.containsKey(from)) {
                temp.parent.put(from, from);
                temp.size.put(from, 1);
            }
            if(!temp.parent.containsKey(to)) {
                temp.parent.put(to, to);
                temp.size.put(to, 1);
            }
            if(temp.union(from, to)) {
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("Found");
        } else System.out.println("Not Found");
    }
}
