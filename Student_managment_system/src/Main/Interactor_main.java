package Main;

import java.util.List;
import java.util.Scanner;
import Model.Student;
import Service.Student_service;
import Service.Student_service_impli;

public class Interactor_main {

	public static void main(String[] args) {
		int choice=0;
		char input='Y';
		Scanner sc = new Scanner(System.in);
		
      Student_service ss = new Student_service_impli();
      System.out.println("WELCOME TO STUDENT MANAGMENT SYSTEM\n***************************************");
      do {
    	  System.out.println("1.Add Student\n2.View Students\n3.Update Student Details\n4.Delete Student Record\n5.Exit\n***************************************");
    	  choice=sc.nextInt();
    	  switch(choice) {
    	  case 1: 
    		  boolean val= ss.Add_student();
    		  if(val)
    		  {
    			  System.out.println("Student added successfully");
    		  }
    		  else
    			  System.out.println("Failed to add student record already exists !!!");
    		    break;
    	  case 2:
    		  List<Student>all=ss.Get_students();
    		  for(Student stu : all)
    		  {
    			  System.out.println(stu);
    		  }
    		  break;
    	  case 3:
    		  System.out.println("Enter the student id to update details");
    		  int up_no=sc.nextInt();
    		  Student up_stu=ss.update_student(up_no);
    		  System.out.println(up_stu);
    		  break;
    	  case 4:
    		  System.out.println("Enter the student id to delete details");
    		  int del_no=sc.nextInt();
    		  if(ss.Delete_student(del_no))
    		  {
    			  System.out.println("Student detail deleted successfully");
    		  }
    		  else
    			  System.out.println("failed to delete student details");
    		  break;
    	  case 5 :
    		  System.out.println("Thankyou student portal exited successfully !!!!!!!!!!!!!");
    		  break;
    		default:
    			break;
    	  }
    	  if(choice!=5)
    	  {
    	  System.out.println("If you want to perform more opertaions press : Y\nTo exit press : N \n*****************************" );
    	  input=sc.next().charAt(0);
    	  System.out.println("Thankyou student portal exited successfully !!!!!!!!!!!!!");
    	  }
    	  else {
    	  sc.close();
    	  break;
    	  }
      }while(input!='N');
	}

}
