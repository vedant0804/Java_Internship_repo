package Dao;

import java.util.List;

import Model.User;

public interface User_dao {

	public boolean Add_user(User user);

	public boolean Remove_user(int id);
	
	public User Find_byid(int id);
	
	public List<User>All_user();

}
