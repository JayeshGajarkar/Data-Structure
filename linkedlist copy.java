public class linkedlist{

    public static class Node{

        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head=null;
    public static Node  tail=null;
    public static int size=0;

    public static void add_first(int data){
        Node nn = new Node(data);
        size++;

        if(head==null){
            head=tail=nn;
            return;
        }
        nn.next=head;
        head=nn;
    }

    public static void add_last(int data){
        Node nn=new Node(data);
        size++;

        if(tail==null){
            head=tail=nn;
            return;
        }
        tail.next=nn;
        tail=nn;
       

    }

    public static void  print(){
        Node temp=head;

        while(temp!=null){
            System.out.print(" "+temp.data +" "+ "-->");
            temp=temp.next;
        }
        System.out.println(" null");
        return ;

    }

    public static void delete_index(int n){
        Node temp=head; 
        size--;

        if(n==0){
            head=head.next;
            return;
        }
        for(int i=0;i<n-1;i++){
            temp=temp.next;
        }
        if(temp.next==tail){
            temp.next=null;
            return;
        }
        temp.next=temp.next.next;
    }

    public static void delete_data(int data){
        Node temp=head;
        Node prev=null;
        size--;

        if(head.data==data){
            head=head.next;
            return;
        }
        
        while(temp!=null){
            if(temp.data==data){
                prev.next=temp.next;
                return ;
            }
            prev=temp;
            temp=temp.next;
        }
    }

    public static void insert(int data,int n){
        Node temp=head; 
        

        if(n==0){
            add_first(data);
            return;
        }

        size++;
        
        for(int i=0;i<n-1;i++){
            temp=temp.next;
        }

        Node nn=new Node(data);


        nn.next=temp.next;
        temp.next=nn;
    }

    public static void main(String args[]){

        linkedlist ll=new linkedlist();
        System.err.println(ll.size);

        ll.add_first(3);
        ll.add_first(2);
        ll.add_first(1);
        ll.add_last(4);
        ll.add_last(5);
        ll.print();
        ll.delete_index(0);
        /*ll.delete_data(3);
        ll.delete_data(5);*/
        ll.print();
        ll.insert(1, 0);
        ll.print();
        ll.insert(6, 5);
        ll.print();
        System.err.println(ll.size);




    }
    
    
}