package Service;

import java.util.List;

import Model.Student;

public interface Student_service {
	
	public boolean Add_student();
	
	public List<Student>Get_students();
	
	public Student update_student(int id);
	
	public boolean Delete_student(int id);

}
