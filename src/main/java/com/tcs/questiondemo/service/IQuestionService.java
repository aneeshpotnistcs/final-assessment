package com.tcs.questiondemo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.tcs.questiondemo.entity.Question;

public interface IQuestionService {

	Iterable<Question> getAllQuestions();

	void save(@Valid Question question, Integer id);

	Optional<Question> getQuestion(Integer id);

	void updateUpvote(Question question, Integer id);

	void updateDownvote(Question question, Integer id);

	List<Question> getSpecificQuestions(Integer upvote);

}
