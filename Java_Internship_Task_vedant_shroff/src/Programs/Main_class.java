package Programs;

import java.util.Scanner;
public class Main_class {

	public static void main(String[] args) {
		int choice=0;
		char ch1='Y';
		Scanner sc = new Scanner(System.in);
		Calculator_class ss =new Calculator_class();
		System.out.println("Java Terminal based Calculator\n"
				+"*********************************\n"
				+ "Select the operation to perform\n"
				+"*********************************\n"
				);
		int a,b;
	   do
		{
		  
			System.out.println("1.Addition\n2.Substraction\n3.Multiplication\n4.Divide");
			choice=sc.nextInt();
		 	switch(choice)
		 	{
		 	case 1: 
		 		System.out.println("Enter two Numbers");
		 		a=sc.nextInt();
		 		b=sc.nextInt();
		 		System.out.println("The Addition of two number is :" +ss.add(a, b));
		 		break;
			case 2: 
		 		System.out.println("Enter two Numbers");
		 		a=sc.nextInt();
		 		b=sc.nextInt();
		 		System.out.println("Substraction of two number is :" +ss.substract(a, b));
		 		break;
			case 3: 
		 		System.out.println("Enter two Numbers");
		 		a=sc.nextInt();
		 		b=sc.nextInt();
		 		System.out.println("The Multiplication of two number is :" +ss.multiply(a, b));
		 		break;
			case 4: 
		 		System.out.println("Enter two Numbers");
		 		a=sc.nextInt();
		 		b=sc.nextInt();
		 		System.out.println("Dividation of two number is :" +ss.divide(a, b));
		 		break;
			
		 		default:
		 		{
		          System.out.println("Enter Valid choice");
		 		}
		 	}
		 	
		      System.out.println("do you want to continue\nY\nN");
		      ch1=sc.next().charAt(0);
		      if(ch1=='N')
		      {
		    	  System.out.println("Thankyou end of program");
		      }
		}
		 	while(ch1=='Y');
	}
}
		 	
