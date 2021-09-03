package com.tcs.questiondemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.questiondemo.entity.Question;
import com.tcs.questiondemo.exception.QuestionNotFoundException;
import com.tcs.questiondemo.service.IQuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	IQuestionService questionService;

	@GetMapping
	public Iterable<Question> getQuestion() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/{id}")
	public Optional<Question> getQuestion(@PathVariable("id") Integer id){
		return questionService.getQuestion(id);
	}
	
	@ExceptionHandler(value = { QuestionNotFoundException.class})
	public ResponseEntity<Question> exception(RuntimeException runtimeException) {
		return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveQuestion(@Valid @RequestBody Question question) {
		questionService.save(question);
		logger.debug(question.getQuestion());
	}
	
	@PutMapping("/upvote/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void updateUpvotes(@PathVariable("id") Integer id, @RequestBody Question question) {
		questionService.updateUpvote(question, id);
	}
	
	@PutMapping("/downvote/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void updateDownvotes(@PathVariable("id") Integer id, @RequestBody Question question) {
		questionService.updateDownvote(question, id);
	}
	
	
	
}
