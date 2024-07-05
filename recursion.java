public class recursion {

    public static  void printDes(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printDes(n-1);
    }

    public static void printInc(int n){
        if(n==1){
            System.out.print(n +" ");
            return;
        }
        printInc(n-1);   
        System.out.print(n + " ");
    }

    public static int fac(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n* fac(n-1);
    }

    public static int sum(int n){
        if(n==1 || n==0){
            return n;
        }
        return n+sum(n-1);
    }

    public static int fib_n(int n){
        if(n==1 || n==0){
            return n;
        }
        
        return fib_n(n-1)+fib_n(n-2);
    }

    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int  last_oc(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }
        int isFound=last_oc(arr,key,i+1);
        
        if(isFound==-1 && arr[i]==key){
            return i;
        }

        return isFound;
    }

    public static int power(int x,int n){
        if(n==0){
            return 1;
        }

        return x*power(x,n-1);
    }

    public static int o_power(int x,int n){
        if(n==0){
            return 1;
        }
        int hp=o_power(x, n/2);
        int ans=hp*hp; 
        
        if(n%2!=0){
            ans=x*ans;
        }

        return ans;
    }

    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }

        return tilling(n-1)+tilling(n-2);
    }


    public static void removeduplicate(int i ,StringBuilder nst ,String str,boolean map[]){
        if(i==str.length()){
            System.out.println(nst);
            return;
        }
        char chr=str.charAt(i);
        if(map[chr -'a']==true){
            removeduplicate(i+1, nst, str, map);
        }else{
            map[chr -'a']=true;
            removeduplicate(i+1, nst.append(chr), str, map);
        }

    }

    public static void  printBinString(int n,int l,String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        printBinString(n-1,0,str+"0");
        if(l==0){
            printBinString(n-1,1,str+"1");
        }
    }

    public static void main(String args[]){
        //printDes(10);
        //printInc(10);
        //System.out.println(fib_n(10));

        int arr[]={8,7,3,4,5,2,1,5,8,9};
        //System.err.println(last_oc(arr,5,0));
        //System.out.println(tilling(3));;

        String str="apnnacollege";
        removeduplicate(0, new StringBuilder(""), str, new boolean[26]);
        printBinString(3,0,"");
    }
}