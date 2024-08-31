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
    
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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