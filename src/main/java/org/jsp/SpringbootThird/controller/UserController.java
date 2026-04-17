package org.jsp.SpringbootThird.controller;

import java.util.List;



import org.jsp.SpringbootThird.dto.User;
import org.jsp.SpringbootThird.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/users")
@CrossOrigin(origins ="*")
@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
//		System.out.println(user);
		User savedUser = service.saveUser(user);
		return savedUser;
	}
	
	@GetMapping("/find/{id}")
	public User getUserById(@PathVariable int id) {
			return service.getUserById(id);
		//	System.out.println(id);
	}
	@GetMapping("/login")
	public boolean login(@RequestParam String email,@RequestParam String password) {
		return service.login(email, password);
		//		System.out.println(email);
//		System.out.println(password);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		String message = service.deleteUser(id);
		
		if(message.contains("successfully")) {
			return ResponseEntity.status(200).body(message);	
		}
		return ResponseEntity.status(404).body(message);
	}
//	public void deleteUser(@RequestBody User user, @PathVariable int id) {
//		String message = service.deleteUser(id);
//	}
	@PutMapping("/update/{id}")
	public User update(@RequestBody User user ,@PathVariable int id) {
		user.setId(id);
		return service.updateUser(user);
	}
	@GetMapping("/find_all")
	public List<User> getAllUsers(User user) {
		return service.getAllUsers(user);
	}
}


