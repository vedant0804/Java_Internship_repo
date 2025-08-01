package Model;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private int Id;
	private String Name;
	private List<Double> Marks ;
	
	public Student()
	{
		
	}
	
	public Student(int Id,String Name,List<Double> list )
	{
		this.Id=Id;
		this.Name=Name;
		this.Marks=list;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Double> getMarks() {
		return Marks;
	}

	public void setMarks(List<Double> marks) {
		Marks = marks;
	}

	@Override
	public String toString() {
		return "Student Id=" + Id + " \n" + "Name=" + Name + "\nMarks=" + Marks+"\n*****************************";
	}

	
}
