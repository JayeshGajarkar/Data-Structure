import java.util.*;
public class Classroom {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int sq;

        Point(int x, int y ,int sq){
            this.x=x;
            this.y=y;
            this.sq=sq;
        }

        @Override
        public int compareTo(Point p2){
            return this.sq-p2.sq;
        }
         
    }

    static class Row implements Comparable<Row>{
        int idx;
        int c;

        Row(int idx,int c){
            this.idx=idx;
            this.c=c;
        }

        @Override
        public int compareTo(Row r){
            if(this.c==r.c){
                return this.idx-r.idx;
            }else{
                return this.c- r.c;
            }
        }
    }

    static class Heap{
        ArrayList<Integer> l=new ArrayList<>();

        public void add(int data){
            //add at lst index
            l.add(data);
            int x=l.size()-1; //child
            int p=(x-1)/2; //parent

            //swap child and parent
            while (l.get(x)<l.get(p)) {
                int temp=l.get(x);
                l.set(x, l.get(p));
                l.set(p,temp);

                x=p;
                p=(x-1)/2;
            }

        }

        private void heapify(int i){
            int f=2*i+1;
            int s=2*i+2;
            int m=i;

            if(f<l.size() && l.get(f)<l.get(m)){
                m=f;
            }

            if(s<l.size() && l.get(s)<l.get(m)){
                m=s;
            }

            if(m!=i){
                int temp=l.get(i); 
                l.set(i,l.get(m));
                l.set(m,temp);

                heapify(m);
            }
        }

        public void remove(){
            int temp=l.get(0);
            l.set(0,l.get(l.size()-1));
            l.set(l.size()-1,temp);

            l.remove(l.size()-1);

            heapify(0);
        }

        public int peek(){
            return l.get(0);
        }

        public boolean isEmpty(){
            return l.size()==0;
        }
    }




    public static void main(String[] args){
        //System.out.println("Hello world !");

        /*int[][] arr={{3,3},{5,-1},{-2,-4}};
        PriorityQueue<Point> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            int sq=arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1];
            pq.add(new Point(arr[i][0], arr[i][1], sq));
        }

        int k=2;

        for(int i=0;i<k;i++){
            Point p=pq.remove();
            System.out.println("("+p.x+","+p.y+")");
        }

        int[] val={2,3,3,4,6};
        PriorityQueue<Integer> p=new PriorityQueue<>();
        int cost=0;

        for(int i=0;i<val.length;i++){
            p.add(val[i]);
        }

        while(p.size()>1){
            int m1=p.remove();
            int m2=p.remove();
            cost+=m1+m2;
            p.add(m1+m2);
        }

        System.err.println(cost);
        PriorityQueue<Row> army=new PriorityQueue<>();
        int soldier[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        
        for(int i=0;i<soldier.length;i++){
            int c=0;
            for(int j=0;j<soldier[0].length;j++){
                c+=soldier[i][j]==1? 1:0;
            }
            army.add(new Row(i, c));
        }

        for(int i=0;i<k;i++){
            System.err.println("R"+army.remove().idx);
        }*/

        Heap h=new Heap();
        h.add(4);
        h.add(3);
        h.add(2);
        h.add(1);

        while(!h.isEmpty()){
            System.err.print(h.peek()+" ");
            h.remove();
        }
    }
}
