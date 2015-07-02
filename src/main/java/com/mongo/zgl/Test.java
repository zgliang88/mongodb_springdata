package com.mongo.zgl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author zhangguangliang
 * @email zgliang88@163.com
 * @date 2015年7月1日 下午12:02:49
 */
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
	public void batchInsert(){
		List<User> users=new ArrayList<User>();
		for(int i=0;i<1000;i++){
			User user = new User();
			user.setId(UUID.randomUUID().toString());
			user.setName("jack"+i);
			user.setBirthday(new Date());
			users.add(user);
		}
		userRepository.batchInsert(users);
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