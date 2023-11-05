class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class LinkedList{
    private Node head;
    int length=0;

    public LinkedList(){
        this.head=null;
    }

    public void insertAtBeg(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        length++;
    }

    public void  insertAtEnd(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            Node p=head;
            while(p.next!=null){
                p=p.next;
            }
            p.next=newNode;
        }
        length++;
    }

    public void deleteAtBeg(){
        if(head==null){
            return;
        }
        else{
            head=head.next;
        }
        length--;
    }

    public void deleteAtEnd(){
        Node p=head,q=null;
        while (p.next!=null) {
            q=p;
            p=p.next;
        }
        q.next=null;
        length--;

    }

    public void insertAt(int data,int position){
        if(position<0 || position>length){
            return;
        }
        else if(position==0){
            insertAtBeg(data);
        }
        else{
            Node newNode=new Node(data);
            Node p=head;
            for(int i=1;i<position;i++){
                p=p.next;
            }
            newNode.next=p.next;
            p.next=newNode;
        }

    }

    public void deleteAt(int position){
        if(position<0 || position>length){
            return;
        }
        else if(position==0){
            deleteAtBeg();
        }
        else{
            Node p=head;
            for(int i=1;i<position;i++){
                p=p.next;
            }
            p.next=p.next.next;
        }
    }

    public void display(){
        Node p=head;
        while (p.next!=null) {
            System.out.print(p.data+"-->");
            p=p.next;
        }System.out.println(p.data);
    }

    

    public static void main(String [] args){
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBeg(1);
        linkedList.insertAtBeg(2);
        linkedList.insertAtBeg(3);

        System.out.println("Linked List:");
        linkedList.display();

        linkedList.deleteAtEnd();
        System.out.println("Linked List after prepending :");
        linkedList.display();

        linkedList.insertAt(1, 1);
        linkedList.display();

        linkedList.deleteAt(2);
        linkedList.display();

    }
}