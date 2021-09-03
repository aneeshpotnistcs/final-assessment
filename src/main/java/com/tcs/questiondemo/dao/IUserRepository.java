package com.tcs.questiondemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.tcs.questiondemo.entity.User;

public interface IUserRepository extends CrudRepository<User, Integer>{

}
