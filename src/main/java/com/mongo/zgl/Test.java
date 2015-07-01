package com.mongo.zgl;

import java.util.Date;
import java.util.UUID;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	private static UserRepository userRepository;
	static {
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		userRepository = context.getBean(UserRepository.class);
	}
      

	@org.junit.Test
	public void test() {
		userRepository.test();
	}

	@org.junit.Test
	public void createCollection() {
		userRepository.createCollection();
	}

	@org.junit.Test
	public void addUser() {
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setName("jack");
		user.setBirthday(new Date());
		userRepository.insert(user);
	}
	@org.junit.Test
	public void findUser(){
		userRepository.findList(1, 10);
	}
	
	@org.junit.Test
	public void deleteUser() {
		userRepository.deleteByName("jack");
	}
}