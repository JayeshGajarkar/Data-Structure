public class BackTracking{
    public static void changeArr(int[] arr,int i, int value){
        if(i==arr.length){
            printArr(arr);
            return ;
        }

        arr[i]=value; 
        changeArr(arr,i+1,value+1);
        arr[i]=arr[i]-2;
    }

    public static void printArr(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.err.println(" ");
    } 

    public static void find_subsets(String s,String ans,int i){
        if(i==s.length()){
            System.out.println(ans);
            return;
        }
        find_subsets(s,ans+s.charAt(i),i+1);
        find_subsets(s,ans,i+1);
    }

    
    public static void find_permutation(StringBuilder ans, String str) {
        if (str.length() == 0) {
            System.out.println(ans.toString());
            return;
        }
    
        for (int i = 0; i < str.length(); i++) {
            ans.append(str.charAt(i));
            String newStr = str.substring(0, i) + str.substring(i + 1);
            find_permutation(ans, newStr);
            ans.deleteCharAt(ans.length() - 1);
        }
    
    }

    //------------------------------------------------------------------------------N Queens--------------------------------------------------
    
    public static boolean is_safe(char board[][],int row,int col){
        
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;j--,i--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;

    }
    
    
    public static void  Nqueens(char board[][],int row ){

        if(row==board.length){
            print_board(board);
            return;
        }

        for(int j=0;j<board.length;j++){
            if(is_safe(board, row, j)){
                board[row][j]='Q';
                Nqueens(board, row+1);
                board[row][j]='.';
            }
        }
    }
    
    
    public static void chess_board(int n){
        char board[][]= new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        Nqueens(board, 0);
    }

    public static void print_board(char board[][]){
        System.err.println("-----------Chess board ----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
        System.out.println();
        }
       // System.out.println("---------------------------------");
    }
    

    //--------------------------------------------------------------------------------------------------------------------------------------------------


    public static void main(String []args){
        //System.out.println("Hello world");
        /*int arr[]={0,0,0,0,0};
        changeArr(arr, 0, 1);
        printArr(arr);*/

        //find_subsets("abc","",0);

        //find_permutation(new StringBuilder(),"abc");

        chess_board(5);

    }
}