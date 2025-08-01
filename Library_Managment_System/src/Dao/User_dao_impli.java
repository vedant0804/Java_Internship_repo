package Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.User;

public class User_dao_impli implements User_dao {

	private static List<User> users;

	static {
		users=new ArrayList<>();
		users.add(new User(1, "vishesh",null));
		users.add(new User(2, "Daniel",null));
	}

	@Override
	public boolean Add_user(User user) {
		for (User user1 : users) {
			if (user1.getPid() == user.getPid()) {
				return false;
			}
		}
		users.add(user);
		return true;
	}

	@Override
	public boolean Remove_user(int id) {
		for (User user1 : users) {
			if (user1.getPid() == id) {
				users.remove(user1);
				return true;
			}
		}

		return false;
	}

	@Override
	public User Find_byid(int id) {
		for (User use : users) {
			if (use.getPid() == id) {
				return use;
			}
		}
		return null;
	}

	@Override
	public List<User> All_user() {
		if(users==null)
		{
		return null;
		}
		else
		return users;
	}

}
