public class bit{

    public static void even_odd(int num){
        int bitmask=1;
        if((num & bitmask)==1){
            System.err.println("Odd");;
        }else{
            System.err.println("Even");
        }
    }

    public static int get_bit(int num,int i){
        int bitmask=1<<i;
        if((num & bitmask)==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int set_bit(int num,int i){
        int bitmask=1<<i;
        return (num |bitmask);
    }

    public static int clear_bit(int num , int i){
        int bitmask= ~(1<<i);
        return (num & bitmask);
    }

    public static int update_bit(int num,int i,int nb){
        
        /*if(i==0){
           clear_bit(num, i);
        }else{
            set_bit(num, i);
        }*/

        int n=clear_bit(num, i);
        int bitmask=nb<<i;
        return n | bitmask;

    }

    public static int clear_lbits(int num,int i){
        int bitmask=-1<<i;
        return num & bitmask;
    }

    public static int clear_rbits(int num,int i,int j){
        int a=-1<<(j+1);
        int b=(1<<i)-1;

        int bitmask=a|b;
        return num & bitmask;
    }

    public static boolean is_power2(int n){
        return (n &(n-1))==0;
    }


    public static int count_bits(int n){
        int count=0;
        while(n>0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static long fast_exp(int a,int n){
        long ans=1;

        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }



    public static void main(String []args){
        
        //System.err.println("Hello");

        //even_odd(3);
        //even_odd(6);
        
        /*String b =Integer.toBinaryString(1<<2);
        System.err.println(b);*/

        //System.err.println(clear_lbits(15,2));
        
        /*String b =Integer.toBinaryString(10);
        System.err.println(b);*/

        //System.err.println(clear_rbits(10,2,4));
        
        //System.err.println(is_power2(6));

        System.err.println(fast_exp(10,10));
    }
}