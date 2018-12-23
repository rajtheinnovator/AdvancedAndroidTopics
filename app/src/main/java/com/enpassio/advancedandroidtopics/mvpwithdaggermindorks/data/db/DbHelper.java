package com.enpassio.advancedandroidtopics.mvpwithdaggermindorks.data.db;

import com.enpassio.advancedandroidtopics.mvpwithdaggermindorks.data.db.model.Option;
import com.enpassio.advancedandroidtopics.mvpwithdaggermindorks.data.db.model.Question;
import com.enpassio.advancedandroidtopics.mvpwithdaggermindorks.data.db.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Abhishek Raj on 12/23/2018.
 */

public interface DbHelper {

    Observable<Long> insertUser(final User user);

    Observable<List<User>> getAllUsers();

    Observable<List<Question>> getAllQuestions();

    Observable<Boolean> isQuestionEmpty();

    Observable<Boolean> isOptionEmpty();

    Observable<Boolean> saveQuestion(Question question);

    Observable<Boolean> saveOption(Option option);

    Observable<Boolean> saveQuestionList(List<Question> questionList);

    Observable<Boolean> saveOptionList(List<Option> optionList);
}
