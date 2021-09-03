package com.tcs.questiondemo.service;

import java.util.Optional;

import javax.validation.Valid;

import com.tcs.questiondemo.entity.Question;

public interface IQuestionService {

	Iterable<Question> getAllQuestions();

	void save(@Valid Question question);

	Optional<Question> getQuestion(Integer id);

	void updateUpvote(Question question, Integer id);

	void updateDownvote(Question question, Integer id);

}
