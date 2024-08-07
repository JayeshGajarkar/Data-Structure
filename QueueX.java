import java.util.*;

public class QueueX{
    
    public static class QueueA{
        static int arr[];
        static int size;
        static int rear;

        QueueA(int n){
            arr=new int[n];
            size=n;
            rear= -1;
        }

        public  boolean isEmpty(){
            return rear==-1;
        }

        public  void add(int data){
            if(rear==size-1){
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear]=data;
            
        }

        public  int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            
            int front=arr[0];

            for(int i=0;i<size-1;i++){
                arr[i]=arr[i+1];
            }
            rear--;

            return front;
        }

        public int peek(){
            return arr[0];
        }

    }


    public static class QueueB{
        static int arr[];
        static int front;
        static int size;
        static int rear;

        QueueB(int n){
            arr=new int[n];
            size=n;
            front= -1;
            rear= -1;
        }

        public boolean isEmpty(){
            return rear==-1 && front==-1 ;
        }

        public boolean isFull(){
            return (rear+1) % size==front;
        }

        public  void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }

            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
            
        }

        public  int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            
            int result=arr[front];
            if(rear==front){
                front=rear=-1;
            }else{
                front=(front+1)%size;
            }
            return result;
        }

        public int peek(){
            return arr[front];
        }

    }

    public static void printNonRepeating(String str){
        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();

    }

    public static void interLeave(Queue<Integer> q){
        Queue<Integer> f=new LinkedList<>();
        int size =q.size();
        
        for(int i=0;i<size/2;i++){
            f.add(q.remove());
        }

        while(!f.isEmpty()){
            q.add(f.remove());
            q.add(q.remove());
        }

    }
    
    public static void main(String [] args){
    
    //System.err.println("Hello world");

    Queue<Integer> q=new LinkedList<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    q.add(5);
    q.add(6);
    q.add(7);
    q.add(8);

    interLeave(q);

    while(!q.isEmpty()){
        System.out.print(q.peek()+" ");
        q.remove();
    }
    System.out.println();
    

    String str="aabccxb";
    printNonRepeating(str);


    }
}