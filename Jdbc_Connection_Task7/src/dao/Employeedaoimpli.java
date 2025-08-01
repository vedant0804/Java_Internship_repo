package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.Employee;

public class Employeedaoimpli implements Employeedao {

	private static Connection con;
	private static Properties prop;
	private static FileInputStream fis;
	private static String url;
	private static String password;
	private static String user;
	static {
		prop = new Properties();
		if (con == null) {
			try {
				fis = new FileInputStream("dbconfig.txt");
				prop.load(fis);
				url = prop.getProperty("db.url");
				password = prop.getProperty("db.password");
				user = prop.getProperty("db.user");
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				if (con != null) {
					System.out.println("connection successful");
				}

			} catch (Exception e) {
				System.out.println("some error occured");
				e.printStackTrace();
			}
		}

	}

	@Override
	public void addEmployee(Employee emp) {

		 try {
	
			String query = "INSERT INTO emp (id,name,dept) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
		    st.setInt(1, emp.getEmpId());
		    st.setString(2,emp.getEmpName());
		    st.setString(3, emp.getEmpDept());
		    int rows = st.executeUpdate();
		    if(rows>0)
		    {
		    	System.out.println("data entered successfully");
		    }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}
	
	public Employee getById(int id)
	{
		Employee emp = new Employee();
		try {
		String query = "Select * from emp where id=?";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,id);
		ResultSet rs = st.executeQuery();
	
		
			if(rs.next())
			{
				
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDept(rs.getString(3));
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void updateEmployee(int id) {
		
		Employee emp=getById(id);
		try {
			String query = "Update emp set name = ? , dept=? where id=?";
			
		}
		catch(SQLException s) {
			
		}
	}

}
