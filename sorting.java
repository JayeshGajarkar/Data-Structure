/**
 * sorting
 **/
import java.util.*;
public class sorting {

    public static void Bubblesort(int arr[]){
        for(int i=1;i<=arr.length;i++){
            for (int j=0;j<arr.length-i;j++){
                int temp;
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    
    public static void Selection(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp;
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void Insertion(int arr[]){
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
       //System.out.println("Hello world");

       int arr[]={4,7,8,2,4,9};
       //Bubblesort(arr);
       //Selection(arr);
       Insertion(arr);
       
       for(int i=0;i<arr.length;i++){
        System.err.print(arr[i]+" ");
       }
    }
}