import java.util.*;
public class BST {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            root=new Node(data);
            return root;
        }

        if(data<root.data){
            root.left=insert(root.left, data);
        }else{
            root.right=insert(root.right, data);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.err.print(root.data+" ");
        inorder(root.right);
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        
        System.err.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Boolean search(Node root,int data){
        if(root==null){
            return false;
        }

        if(root.data==data){
            return true;
        }

        if(data<root.data){
            return search(root.left, data);
        }else{
            return search(root.right, data);
        }
    }

    public static Node createMirror(Node root){
        if(root==null){
            return null;
        }

        Node left=createMirror(root.left);
        Node right=createMirror(root.right);

        root.left=right;
        root.right=left; 

        return root;

    }



    public static Node Delete(Node root,int val){
        if(val<root.data){
            root.left=Delete(root.left, val);
        }else if(val>root.data){
            root.right=Delete(root.right, val);
        }
        else{
            //No child
            if(root.left==null && root.right==null){
                return null;
            }

            //one child
            if(root.right==null){
                return root.left;
            }else if(root.left==null){
                return root.right;
            }

            //two child
            Node IS=findInOrderSucess(root.right);
            root.data=IS.data;
            root.right=Delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInOrderSucess(Node root){
        while(root.left!=null){
            root=root.left;
        }

        return root;
    }
    
    public static void PrintInRange(Node root ,int k1,int k2){
        if(root==null){
            return;
        }

        if(root.data>=k1 && root.data<=k2){
            PrintInRange(root.left,k1,k2);
            System.err.print(root.data+" ");
            PrintInRange(root.right, k1, k2);
        }else if(root.data<k1){
            PrintInRange(root.right, k1, k2);
        }else if(root.data>k2){
            PrintInRange(root.left, k1, k2);
        }
    }

    public static void PrintPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.err.print(path.get(i)+"->");
        }
        System.err.println();
    }

    public static void PrintRootToPath(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }

        if(root.left==null && root.right==null){
            PrintPath(path);
            return;
        }
        path.add(root.data);
        PrintRootToPath(root.left, path);
        PrintRootToPath(root.right, path);
        path.remove(path.size()-1);

    }

    public static Boolean isValid(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        
        if(min!=null && root.data<=min.data){
            return false;
        }else if(max!=null && root.data>=max.data){
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static Node createBST(int[] arr,int st,int ed){
        if(st>ed){
            return null;
        }
        int mid=(st+ed)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, ed);
        return root;

    }
    public static void main(String args[]){
        //System.err.println("Hello world");
        int[] values={10,6,4,2,7,9,5,1,3,8};
        Node root=null;
        
        /*for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }*/
        
        /*inorder(root);
        System.err.println();
        System.err.println(search(root, 11));
        Delete(root, 6);
        inorder(root);
        System.err.println();
        PrintInRange(root, 2, 5);
        System.err.println();

        ArrayList<Integer> path=new ArrayList<>();
        PrintRootToPath(root,path);

        System.err.println(isValid(root, null, null));*/

        /*inorder(root);
        root=createMirror(root);
        System.err.println();
        inorder(root);*/
        int arr[]={3,5,6,8,10,11,12};
        root=createBST(arr, 0, arr.length-1);
        preorder(root);

    }
}
