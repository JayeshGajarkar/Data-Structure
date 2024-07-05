public class Array {
  
    static void reverse(int numbers[]) {
        int first = 0, last = numbers.length - 1;
        int temp;
        while (first < last) {
            temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp; 
            first++;
            last--;
        }
    }

    static int search(int key, int numbers[]) {
        int first = 0, last = numbers.length - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (numbers[mid] == key) {
                return mid;
            } else if (key > numbers[mid]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return -1;
    }

    static void spiral(int arr[][]) {
        int sc = 0;
        int sr = 0;
        int ec = arr[0].length - 1;
        int er = arr.length - 1;

        while (sc <= ec && sr <= er) {
            for (int i = sc; i <= ec; i++) {
                System.out.print(arr[sr][i] + " ");
            }

            for (int i = sr + 1; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }

            for (int i = ec - 1; i >= sc; i--) {
                System.out.print(arr[er][i] + " ");
            }

            for (int i = er - 1; i > sr; i--) {
                System.out.print(arr[i][sc] + " ");
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
    }

    static void diagonal_sum(int arr[][]){
        int sum=0;
        /*for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==j){
                    sum+=arr[i][j];
                }else if(i+j==arr.length-1){
                    sum+=arr[i][j];
                }
            }
        }*/

        for(int i=0;i<arr.length;i++){
            sum+=arr[i][i];
            if(i!=arr.length-i-1){
                sum+=arr[i][arr.length-1-i];
            }
            
        }
        System.err.println(sum);
    }

    static boolean search(int numbers[][],int key){
        int row=0;
        int col=numbers[0].length-1;

        while(row<numbers.length && col>=0){ 
            if(key==numbers[row][col]){
                System.err.println("found at ("+ row +","+col+")");
                return true;
            }else if(key < numbers[row][col]){
                col--;
            }else{
                row++;
            }
        
            }
            System.out.println("Key not fouund !");
            return false;
    }
    

    public static void main(String args[]) {
        int numbers[][] = {{1, 2, 3, 4, 5},
                            {6, 7, 8, 9, 10},
                            {11,12,13,14,15},
                            {16,17,18,19,20},
                            {21,22,23,24,25}
                      };

        /*for (int i = 0; i < numbers.length; i++) {
            System.err.println(numbers[i]);
        }*/

        // reverse(numbers);

        // Print the reversed array
        /*for (int i = 0; i < numbers.length; i++) {
            System.err.print(" " + numbers[i]);
        }*/
        
        //System.err.println(numbers.length);
        
        //diagonal_sum(numbers);
        search(numbers,18);
    }   
}
