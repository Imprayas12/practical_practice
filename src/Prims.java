import java.util.*;

class Node implements Comparator<Node>
{
    private int vertex;
    private int weight;

    Node(int _v, int _w) { vertex = _v; weight = _w; }

    Node() {}

    int getV() { return vertex; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
public class Prims {
    public static void prims_algo(ArrayList<ArrayList<Node>> graph, int n){
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            key[i]= Integer.MAX_VALUE;
            parent[i]=-1;
            visited[i]=false;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(n,new Node());
        key[0]= 0;
        pq.add(new Node(0,key[0]));
        while(!pq.isEmpty()){
            int u = pq.poll().getV();
            visited[u]= true;
            for(Node it: graph.get(u)){
                if(!visited[it.getV()] && it.getWeight() < key[it.getV()]){
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(),key[it.getV()]));
                }
            }
        }
        for (int i = 1; i < n; i++) {
        if(parent[i]>i){
            System.out.println(i+" connected to "+parent[i]+" with weight "+key[i]);
        }
        else
            System.out.println(parent[i]+" connected to "+i+" with weight "+key[i]);
        }
    }
    public static void main(String[] args) {
       int n = 5;
       ArrayList<ArrayList<Node>> graph = new ArrayList<>();
       for(int i=0;i<n;i++){
           graph.add(new ArrayList<>());
       }
        graph.get(0).add(new Node(1,2));
        graph.get(0).add(new Node(2,4));
        graph.get(1).add(new Node(3,5));
        graph.get(1).add(new Node(2,6));
        graph.get(2).add(new Node(4,3));
        graph.get(3).add(new Node(4,1));
        prims_algo(graph,n);
    }
}