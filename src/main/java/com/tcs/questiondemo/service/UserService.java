package com.tcs.questiondemo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.questiondemo.dao.IUserRepository;
import com.tcs.questiondemo.entity.User;
import com.tcs.questiondemo.exception.UserNotFoundException;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(@Valid User user) {
		userRepository.save(user);
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("User does not exist");
		return user;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(User user, Integer id) {
		Optional<User> userFromDB = userRepository.findById(id);
		if(userFromDB.isPresent()) 
		{
			userFromDB.get().setFirstName(user.getFirstName());
			userRepository.save(userFromDB.get());

		}
	}

}
