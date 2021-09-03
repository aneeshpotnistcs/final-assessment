package com.tcs.questiondemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.tcs.questiondemo.entity.Question;

public interface IQuestionRepository extends CrudRepository<Question, Integer>{

}
