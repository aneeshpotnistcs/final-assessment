package com.tcs.questiondemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.questiondemo.entity.Question;
import com.tcs.questiondemo.service.IQuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	IQuestionService questionService;
	
	@GetMapping
	public Iterable<Question> getQuestion(){
		return questionService.getAllQuestions();
	}
}
