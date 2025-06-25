package Dao;

import java.util.List;

import Model.Student;

public interface Student_dao {

	public boolean Add_student(Student st);
	
	public List<Student>Get_students();
	
	public Student update_student(int id);
	
	public boolean Delete_student(int id);

}
