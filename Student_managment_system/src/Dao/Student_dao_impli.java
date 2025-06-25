package Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Model.Student;

public class Student_dao_impli implements Student_dao{
    static List<Student>records;
	 static {
		  records = new ArrayList<>();
		 records.add(new Student(1,"Rishi",Arrays.asList(21.0,23.0,54.0,34.0)));
		 records.add(new Student(2,"Naman",Arrays.asList(22.0,45.0,68.0,97.0)));
	 }
	@Override
	public boolean Add_student(Student st) {
        for (Student st1 : records)
        {
        	if(st1.getId()==st.getId())
        	{
        		return false;
        	}
        }
          records.add(st);
          return true;
	}

	@Override
	public List<Student> Get_students() {
		// TODO Auto-generated method stub
		return records;
	}

	@Override
	public Student update_student(int id) {
		
		Scanner sc =new Scanner(System.in);
		List<Double> marks = new ArrayList<>();
		for (Student stu : records)
		{
			if(stu.getId()==id)
			{
			   System.out.println("Enter Student name to update");
			   stu.setName(sc.next());
			   System.out.println("Enter the number of subjects");
			   int size=sc.nextInt();
			   for(int i=0;i<size;i++)
			   {
				   System.out.println("Enter marks for "+ i+1+" subject :");
				   marks.add(sc.nextDouble());
			   }
			   stu.setMarks(marks);
			  
				return stu;
			}
		}
	
		return null;
	}

	@Override
	public boolean Delete_student(int id) {
		for ( Student stu : records)
		{
			if(stu.getId()==id)
			{
				records.remove(stu);
				return true;
			}
		}
		return false;
	}

	
}
