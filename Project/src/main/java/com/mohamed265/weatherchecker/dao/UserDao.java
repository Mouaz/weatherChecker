package com.mohamed265.weatherchecker.dao;

import java.util.List;

import com.mohamed265.weatherchecker.entity.User;
import com.mohamed265.weatherchecker.exceptions.EntityMergeException;

public interface UserDao {

	public void save(User user) throws EntityMergeException;

	public void update(User user);

	public List<User> getAllUsers();

	public void delete(User user);

	public User getUserById(int id);

	public User loginByEmail(String email, String password);
	

	String selecUserByEmail(String email);

}
