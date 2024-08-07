import java.util.*;

public class StackX {

    //Using Arraylist
    static class StackA {
        
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            if (list.size() == 0) {
                System.err.println("Stack is Empty");
                return -1;
            }
            int data = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return data;
        }

        public int peek() {
            if (list.size() == 0) {
                System.err.println("Stack is Empty");
                return -1;
            }
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    //Using LinkedList 
    static class StackB{
        
        static class Node{
            int data;
            Node next;

            Node(int data){
                this.data=data;
                this.next=null;
            }
        }

        static Node head=null;

        public  void  push(int data){
            Node nn=new Node(data);
            if(head==null){
                head=nn;
                return;
            }

            nn.next=head;
            head=nn;
        }

        public  int pop(){
            if(head==null){
                return -1;
            }
            int data=head.data;
            head=head.next;
            return data;
        }
        
        public  int peek(){
            if(head==null){
                return -1;
            }
            return head.data;
        }

        public  boolean isEmpty(){
            return head==null;
        }

    }

    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        StringBuilder st=new StringBuilder();

        for(int i=0;i<str.length();i++){
            st.append(s.pop());
        }

        return st.toString();
    }
    

    public static void pushAtBottom(StackB s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
    
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    
    public static void reverseStack(StackB s) {
        if (s.isEmpty()) {
            return;
        }
        
        int data = s.pop();
        reverseStack(s);
        pushAtBottom(s, data);
    }

    public static boolean removeDuplicate(String str){
        
        Stack<Character> s=new Stack<>();

        for(int i=0;i<str.length();i++){
            
            if(str.charAt(i)==')'){
                int c=0;
                while (s.peek()!= '(' ) {
                    s.pop();
                    c++;
                }

                if(c<1){
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(str.charAt(i));
            }
        }

        return false;

    }
    



    public static void main(String[] args) {
        StackB s = new StackB();
        s.push(3);
        s.push(2);
        s.push(1);

        pushAtBottom(s,4);

        /*while(!s.isEmpty()){
            System.err.println(s.peek());
            s.pop();
        }*/

        reverseStack(s);
        
        while(!s.isEmpty()){
            System.err.println(s.peek());
            s.pop();
        }

        String str="Jayesh";
        System.err.println(reverseString(str));

        String st1="((a+b))";
        System.err.println(removeDuplicate(st1));
        String st2="(a+b)";
        System.err.println(removeDuplicate(st2));
    
    }
}
