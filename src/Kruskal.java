import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    int vertex1;
    int vertex2;
    int weight;
    public Edge(int vertex1,int vertex2,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge o1) {
        return this.weight- o1.weight;
    }
}
public class Kruskal {
    public static Edge[] kruskal(Edge[] edges,int v){
        Arrays.sort(edges);
        Edge[] mst = new Edge[v-1];
        int count = 0;
        int[] parent = new int[v];
        for(int i=0;i<v;i++)
            parent[i]=i;
        int i=0;
        while(count != v-1){
            Edge temp = edges[i++];
            int parentv1 = findParent(temp.vertex1,parent);
            int parentv2 = findParent(temp.vertex2,parent);
            if(parentv1!=parentv2){
                mst[count++]= temp;
                parent[parentv1]=parentv2;
            }
        }
        return mst;
    }
    public static int findParent(int v,int[] parent){
        if(v == parent[v])
            return v;
        return findParent(parent[v],parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        System.out.println("Enter number of edges:");
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0;i<e;i++){
            edges[i]=new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Edge[] mst = kruskal(edges,v);
        int total_cost =0;
        for (Edge edge : mst) {
            total_cost += edge.weight;
            if (edge.vertex1 > edge.vertex2)
                System.out.println(edge.vertex2 + " connected to " + edge.vertex1 + " with weight " + edge.weight);
            else
                System.out.println(edge.vertex1 + " connected to " + edge.vertex2 + " with weight " + edge.weight);
        }
        System.out.println("Total cost = "+ total_cost);
    }
}
/*Enter number of vertices:
8
Enter number of edges:
12
0 1 2
0 2 3
1 3 4
1 2 5
2 4 6
3 4 1
3 5 8
5 6 3
4 6 9
4 7 11
7 6 13
2 7 9
3 connected to 4 with weight 1
0 connected to 1 with weight 2
0 connected to 2 with weight 3
5 connected to 6 with weight 3
1 connected to 3 with weight 4
3 connected to 5 with weight 8
2 connected to 7 with weight 9
Total cost = 30
*/
