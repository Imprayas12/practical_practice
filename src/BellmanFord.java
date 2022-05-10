import java.util.*;

public class BellmanFord {
    public void BellFord(int[][] graph, int n,int src){
        int[] dist = new int[n];
        for(int i=0;i<n;i++) dist[i]= Integer.MAX_VALUE;
        dist[src] = 0;
        for(int r=0;r<n;r++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i] + graph[i][j] < dist[j] && graph[i][j]!=0)
                        dist[j] = dist[i] + graph[i][j];
                }
            }
        }
        boolean flag = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i] + graph[i][j] < dist[j]){
                    System.out.println("NEGATIVE CYCLE DETECTED");
                    flag = true;
                    break;
                }
            }
        }
        if(!flag)
            for(int i=0;i<n;i++)
                System.out.println("Shortest Dist of "+ i + " from " + src +" = "+ dist[i]);
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] graph = new int[6][6];
        graph[3][2] = 6;
        graph[5][3] = 1;
        graph[0][1] = 5;
        graph[1][5] = -3;
        graph[1][2] = -2;
        graph[3][4] = -2;
        graph[2][4] = 3;
        BellmanFord obj = new BellmanFord();
        obj.BellFord(graph,n,0);
    }
}
