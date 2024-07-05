import java.util.Scanner;

class Factorial{
	public long factorial(int n){
		if(n<=1)return 1;
		else{
			return n*factorial(n-1);
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Factorial obj=new Factorial();
		/*System.out.print("Enter the number to calculate the Factorial:\n");
		int n=sc.nextInt();*/
		//System.out.printf("Factorial of number is %d!=%d",n,obj.factorial(n));
		for(int counter=0;counter<10;counter++){
			System.out.printf(" %d!=%d\n",counter,obj.factorial(counter));
		}
	}
}