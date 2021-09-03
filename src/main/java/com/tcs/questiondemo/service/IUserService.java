package com.tcs.questiondemo.service;

import java.util.Optional;

import javax.validation.Valid;

import com.tcs.questiondemo.entity.User;

public interface IUserService {

	Iterable<User> getAllUsers();

	void save(@Valid User user);

	Optional<User> getUser(Integer id);

	void deleteUser(Integer id);

	void update(User user, Integer id);


}
