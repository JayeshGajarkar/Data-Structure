import java.util.LinkedList;
import java.util.Queue;

public class BinaryTrees{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    
    static class BianryTree{
        static int idx=-1;
        public  Node BuildTree(int[] nodes){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode =new Node(nodes[idx]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.err.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.err.print(root.data+" ");
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.err.print(root.data+" ");
        inorder(root.right);
    }

    public static void levelorder(Node root){
        if(root==null){
            return;
        }

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node data=q.remove();
            if(data.left!=null){
                q.add(data.left);
            }
            if(data.right!=null){
                q.add(data.right);
            }

            System.err.print(data.data+" ");
        }
        System.err.println();
    }

    public static int hight(Node root){
        if(root==null){
            return 0;
        }

        int lh=hight(root.left);
        int rh=hight(root.right);
        return Math.max(rh,lh)+1;
    }

    static class Info{
        int d;
        int h;

        Info(int d,int h){
            this.h=h;
            this.d=d;
        }
    }

    public static Info diameter(Node root){
        if(root==null){
            return new Info(0, 0);
        }

        /*int ld=diameter(root.left);
        int lh=hight(root.left);
        int rd=diameter(root.right);
        int rh=hight(root.right);

        int sd=rh+lh+1;

        return Math.max(sd,Math.max(ld,rd))
        */

        Info li=diameter(root.left);
        Info ri=diameter(root.right);

        int d=Math.max(Math.max(li.d,ri.d),li.h+ri.h+1);
        int h=Math.max(ri.h,li.h);

        return new Info(d, h);

    }

    public static int count(Node root){
        if(root==null){
            return 0;
        }

        int lt=count(root.left);
        int rt=count(root.right);
        return lt+rt+1;
    }

    public static boolean isIdentical(Node root ,Node sub){
        if(root==null && sub==null){
            return true;
        }else if(root==null|| sub==null){
            return false;
        }

        if(root.data!=sub.data){
            return false;
        }

        if(!isIdentical(root.left, sub.left)){
            return false;
        }

        if(!isIdentical(root.right, sub.right)){
            return false;
        }

        return true;

    }

    public static boolean isSubTree(Node root,Node sub){
        if(root==null){
            return false;
        }

        if(root.data==sub.data){
            if(isIdentical(root,sub)){
                return true;
            }
        }
        
        return isSubTree(root.left,sub)|| isSubTree(root.right,sub);
    }


    public static void main(String[] args){
        //System.out.println("Hello world");
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BianryTree tree=new BianryTree();
        Node root=tree.BuildTree(nodes);
        System.err.println(root.data);

        /*preorder(root);
        System.err.println();
        postorder(root);
        System.err.println();
        inorder(root);
        System.err.println();
        levelorder(root);*/

        System.err.println(hight(root));
        System.err.println(count(root));
        System.err.println(diameter(root));


        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        Node sub1 = new Node(2);
        sub1.left = new Node(4);
        sub1.right = new Node(5);
        System.out.println(isSubTree(root1, sub1));  // Expected: true

        // Test case 2: Subtree is not a part of the tree
        Node sub2 = new Node(2);
        sub2.left = new Node(4);
        sub2.right = new Node(6);
        System.out.println(isSubTree(root1, sub2));  // Expected: false


    }
}
