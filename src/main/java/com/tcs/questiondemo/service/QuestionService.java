package com.tcs.questiondemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.questiondemo.dao.IQuestionRepository;
import com.tcs.questiondemo.entity.Question;
import com.tcs.questiondemo.exception.QuestionNotFoundException;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	IQuestionRepository questionRepository;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(@Valid Question question) {
		questionRepository.save(question);
	}

	@Override
	public Iterable<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	
	@Override
	public List<Question> getSpecificQuestions(Integer upvote) {
		
		Iterable<Question> questionFromDB = questionRepository.findAll();
		List<Question> ques = new ArrayList<Question>();
		for (Question question2 : questionFromDB) {
			if(question2.getUpvote()>= upvote)
				ques.add(question2);
		}
		return ques;

	}

	@Override
	public Optional<Question> getQuestion(Integer id) {
		Optional<Question> question = questionRepository.findById(id);
		if (!question.isPresent())
			throw new QuestionNotFoundException("Question does not exist");
		return question;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateUpvote(Question question, Integer id) {
		Optional<Question> questionFromDB = questionRepository.findById(id);
		if (questionFromDB.isPresent() && question.getUpvote()!= 0) {
			questionFromDB.get().setUpvote(question.getUpvote());
			questionRepository.save(questionFromDB.get());
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateDownvote(Question question, Integer id) {
		Optional<Question> questionFromDB = questionRepository.findById(id);
		if (questionFromDB.isPresent() && question.getDownvote()!= 0) {
			questionFromDB.get().setDownvote(question.getDownvote());
			questionRepository.save(questionFromDB.get());
		}
	}

	

}
