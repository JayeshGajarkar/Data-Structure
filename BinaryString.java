import java.util.*;

public class BinaryString {
    int []A;
    public BinaryString(int n){
        A=new int[n];
    }
    public void binaryString(int n){
        if(n<=0){
            System.out.println(Arrays.toString(A));
        }
        else{A[n-1]=0;
        binaryString(n-1);
        A[n-1]=1;
        binaryString(n-1);
        }
        
    }
    
    public static void main(String []args) throws java.lang.Exception{
        int n =4;
        BinaryString obj=new BinaryString(n);
        obj.binaryString(n);
    }
}


