package com.javaexpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaexpress.model.User;
import com.javaexpress.service.UserServiceImpl;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class UserServiceApplication implements CommandLineRunner{
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		User user = new User();
//		user.setUserId(31);
//		user.setEmail("javaexpresschannelupdated@gmail.com");
//		user.setFirstName("JavaUpdated");
//		user.setLastName("ExpressUpdated");
//		user.setPhone("7801007910");
		
		
		//userServiceImpl.createUser(user);
		//userServiceImpl.updateUser(null, user);
	}
	
	

}
