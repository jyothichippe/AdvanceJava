package org.jsp.SpringbootThird.dao;

import java.util.List;

import java.util.Optional;

import org.jsp.SpringbootThird.dto.User;
import org.jsp.SpringbootThird.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
 private UserRepository repository;
	
	public User saveUser(User user) {
		User savedUser = repository.save(user);
		return savedUser;
	}
	
	public Optional<User> getUserById(int id){
		Optional<User> user = repository.findById(id);
		return user;
	}
	
	public User login(String email) {
		User user = repository.login(email);
		return user;
	}
	
	public void deleteUser(int id)
	{
		repository.deleteById(id);
	}
	public User updateUser(User user)
	{
		return repository.save(user);
	}
	public List<User> getAllUsers(User user){
		return repository.findAll();
	}

	public boolean exists(int id) {
		return repository.existsById(id);
	}
}
