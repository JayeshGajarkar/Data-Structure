public class Sum {
    public static void main(String[]args){
        int result=sum(10);
        System.out.println(result);
    }
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        else{
            return n+sum(n-1);
        }
    }
}
