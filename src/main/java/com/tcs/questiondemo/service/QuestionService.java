package com.tcs.questiondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.questiondemo.dao.IQuestionRepository;
import com.tcs.questiondemo.entity.Question;

public class QuestionService implements IQuestionService{
	
	@Autowired
	IQuestionRepository questionRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Iterable<Question> getAllQuestions() {
		return null;
	}

}
