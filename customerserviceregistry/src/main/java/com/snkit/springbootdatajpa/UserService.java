package com.snkit.springbootdatajpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

@Service(value = "userService")
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void addUser(User user) {

		UserEntity uEntity = new UserEntity();

		uEntity.setName(user.getName());
		uEntity.setDesg(user.getDesg());
		uEntity.setCompName(user.getCompName());
		
		
		AddressEntity add = new AddressEntity();
		
		add.setUserEntity(uEntity);
		
	//	add.setCity(user.getCity());
		//add.setState(user.getState());
		
		uEntity.getAddressEntity().add(add);
		userRepository.save(uEntity);

	}

	public List<User> getAllUser() {

		List<User> userList = new ArrayList<>();

		List<UserEntity> userEntity = userRepository.findAll();

		userEntity.forEach(user -> {
			User u = new User(user.getName(), user.getDesg());
			u.setCompName(user.getCompName());
			
			user.getAddressEntity().forEach(add -> {
				Address addVo = new Address();
				
				addVo.setCity(add.getCity());
				addVo.setState(add.getState());
				u.getAddList().add(addVo);
				
			});

			userList.add(u);
		});

		return userList;

	}

	public User getByUser(User user1) {

		UserEntity user = userRepository.findByName(user1.getName());
		
		
		User u = new User(user.getName(), user.getDesg());
		u.setCompName(user.getCompName());

		return u;
	}
	
	public User findUserAddByName(User user1) {

		UserEntity user = userRepository.getUserEntity(user1.getName());
		
		
		User u = new User(user.getName(), user.getDesg());
		u.setCompName(user.getCompName());
		
		user.getAddressEntity().forEach(add -> {
			Address addVo = new Address();
			
			addVo.setCity(add.getCity());
			addVo.setState(add.getState());
			u.getAddList().add(addVo);
			
		});

		return u;
	}
	public List<User> findByUserCity(UserReq userReq) {

		List<User> userList = new ArrayList<>();
		
		UserSpecification spec =new UserSpecification(userReq);

		
	
		
		List<UserEntity> userEntity = userRepository.findAll(spec);
		
		

		userEntity.forEach(user -> {
			User u = new User(user.getName(), user.getDesg());
			u.setCompName(user.getCompName());
			
			user.getAddressEntity().forEach(add -> {
				Address addVo = new Address();
				
				addVo.setCity(add.getCity());
				addVo.setState(add.getState());
				u.getAddList().add(addVo);
				
			});

			userList.add(u);
		});

		return userList;

	}
}
