package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.Student_dao;
import Dao.Student_dao_impli;
import Model.Student;

public class Student_service_impli implements Student_service {
 
	private Student_dao sd;
	
	
	public Student_service_impli()
	{
		this.sd=new Student_dao_impli();
	}
 
	@Override
	public boolean Add_student() {
		Student stu = new Student();
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Student Details\n****************************");
		System.out.println("Enter Student ID");
		stu.setId(sc.nextInt());
		//sc.next();
		System.out.println("Enter student name");
		stu.setName(sc.next());
		System.out.println("Enter number of subjects for marks");
		int no = sc.nextInt();
		List<Double>marks= new ArrayList<>();
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter marks for "+ (i+1) +" subject : " );
			marks.add(sc.nextDouble());
		}
		stu.setMarks(marks);
		
		if(sd.Add_student(stu))
		{
		   
			return true;
		}
		else 
	
		return false;
	}

	@Override
	public List<Student> Get_students() {
		  List<Student> rs = sd.Get_students();
		return rs;
	}

	@Override
	public Student update_student(int id) {
		
	Student update =sd.update_student(id);
		
		if(update!=null)
		{
			return update;
		}
		return null ;
	}

	@Override
	public boolean Delete_student(int id) {
		if(sd.Delete_student(id))
		{
			return true;
		}
		return false;
	}

  
}
