package Main;

import java.util.Scanner;

import Service.File_handling;

public class Main_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       File_handling fh = new File_handling();
        int choice;
        Scanner sc = new Scanner (System.in);
        do {
        	System.out.println("1.Create Notes\n2.Write into Notes\n3.Read from notes\n4.Exit\n\"***************************************\"");
        	choice=sc.nextInt();
        	sc.nextLine();
        	switch(choice)
        	{
        	case 1:
        		System.out.println("Enter file name");
        		String name=sc.next();
        		fh.Create_file(name+".txt");
        		break;
        	case 2:
        		System.out.println("Enter the file name to write into");
        		String fw=sc.next();
        		fh.Write_to_file(fw+".txt");
        		break;
        	case 3:
        		System.out.println("Enter the file name to read from");
        		String fr=sc.next();
        		fh.Read_from_file(fr+".txt");
        		System.out.println("\n***************************************");
        		break;
        	case 4:
        		System.out.println("ExitedApp");
        		break;
        		default:
        			break;
        	}
        }while(choice!=4);
        sc.close();
	}

}
