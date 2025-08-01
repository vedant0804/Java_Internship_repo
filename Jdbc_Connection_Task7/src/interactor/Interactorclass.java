package interactor;

import dao.Employeedaoimpli;
import model.Employee;

public class Interactorclass {
 public static void main(String[] args) {
	Employeedaoimpli emp = new Employeedaoimpli();
	emp.addEmployee(new Employee(2,"sakshi","IT"));
}
}
