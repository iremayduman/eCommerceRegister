package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{
	List<User>users=new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" eklendi.");
		users.add(user);
	}

	@Override
	public void delete(User user) {
		
		for(User user1:users) {
			if(user1.getId()==user.getId()) {
				User delete1=user1;
				users.remove(delete1);
			}
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User getById(int id) {
		for(User user1:users) {
			if(user1.getId()==id) {
				return user1;
			}
		
	}
		return null;
}
}
