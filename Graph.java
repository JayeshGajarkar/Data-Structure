import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    static class Edge {
        int source;
        int destination;
        int weight;
        
        Edge(int s, int d, int w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        /*// 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        
        graph[6].add(new Edge(6, 5, 1));*/

        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));



    }


    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q=new LinkedList<>();
        boolean[] v=new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int curr=q.remove();
            if(!v[curr]){
                System.err.print(curr+"-->");
                v[curr]=true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.destination);
                }
            }
        }
        System.err.println();
    }

    public static void dfs(ArrayList<Edge>[] graph,boolean[] v,int curr){
        System.err.print(curr+" -->");
        v[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!v[e.destination]){
                dfs(graph, v, e.destination);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,boolean[] v,int s,int d){
        if(s==d){
            return true;
        }

        v[s]=true;

        for(int i=0;i<graph[s].size();i++){
            Edge e=graph[s].get(i);
            if(!v[e.destination] && hasPath(graph, v, e.destination, d)){
                return true;
            }

        }

        return false;


    }

    public static void helper(ArrayList<Edge>[] graph,int[] indeg){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indeg[e.destination]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph){
        int indeg[]=new int[graph.length];
        helper(graph, indeg);
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            System.err.print(curr+" ");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                indeg[e.destination]--;
                if(indeg[e.destination]==0){
                    q.add(e.destination);
                }   
            }
        }
        System.err.println();


    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        
        
        /*int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // 2 - vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 1, 1));

       
        for(int i=0;i<graph[2].size();i++){
            Edge e=graph[2].get(i);
            System.err.println("2 --> "+ e.destination);
        }
        */

        /*int v=7;
        ArrayList<Edge>[] graph=new ArrayList[v];
        createGraph(graph);
        bfs(graph);
        boolean[] vis=new boolean[v];
        dfs(graph,vis,0);
        System.err.println();
        System.err.println(hasPath(graph, new boolean[v], 0, 6));*/

        int v=6;

        ArrayList<Edge>[] graph=new ArrayList[v];
        createGraph(graph);
        topSort(graph);

    }
}
