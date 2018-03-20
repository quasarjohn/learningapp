package com.berstek.learningapp.view.question;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.berstek.learningapp.R;
import com.berstek.learningapp.model.Answer;
import com.berstek.learningapp.model.Question;
import com.berstek.learningapp.view.ViewpagerActivity;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements AnswerAdapter.AnswerClickCallback {

  private View view;

  private RecyclerView questionsRecview, answersRecview;
  private QuestionImageAdapter adapter;

  private AnswerAdapter answerAdapter;

  private List<String> imagesList;
  private List<Answer> answersList;

  private Question question;

  private int selectedAnswer;


  public QuestionFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    question = (Question) getArguments().getSerializable("question");

    view = inflater.inflate(R.layout.fragment_question, container, false);
    questionsRecview = view.findViewById(R.id.questionsRecview);
    answersRecview = view.findViewById(R.id.answersRecview);

    FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
    layoutManager.setFlexDirection(FlexDirection.ROW);
    layoutManager.setJustifyContent(JustifyContent.CENTER);
    layoutManager.setFlexWrap(FlexWrap.WRAP);
    layoutManager.setAutoMeasureEnabled(true);

    FlexboxLayoutManager layoutManager1 = new FlexboxLayoutManager(getContext());
    layoutManager1.setFlexDirection(FlexDirection.ROW);
    layoutManager1.setJustifyContent(JustifyContent.CENTER);
    layoutManager1.setFlexWrap(FlexWrap.WRAP);
    layoutManager1.setAutoMeasureEnabled(true);

    questionsRecview.setLayoutManager(layoutManager);
    answersRecview.setLayoutManager(layoutManager1);

    init();

    return view;
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  private void init() {

    imagesList = new ArrayList<>();

    for (int i = 0; i < question.getCount(); i++) {
      imagesList.add(question.getImage());
    }

    adapter = new QuestionImageAdapter(imagesList, getContext());
    questionsRecview.setAdapter(adapter);

    answersList = generateChoices();

    answerAdapter = new AnswerAdapter(answersList, getContext());
    answerAdapter.setAnswerClickCallback(this);
    answersRecview.setAdapter(answerAdapter);
  }

  private ArrayList<Answer> generateChoices() {

    ArrayList<Answer> answersList = new ArrayList<>();

    HashMap<Integer, String> numbers = new HashMap<>();

    Answer answer = new Answer();
    answer.setCorrect(true);
    answer.setAnswer(question.getCount() + "");
    answersList.add(answer);

    while (true) {
      int num = ThreadLocalRandom.current().nextInt(1, 10);

      if (num != question.getCount()) {
        if (numbers.get(num) == null) {
          Answer a = new Answer();
          a.setAnswer(num + "");
          a.setCorrect(false);
          answersList.add(a);

          numbers.put(num, "");
        }
      }

      if (answersList.size() == 4) {
        Collections.shuffle(answersList);
        return answersList;
      }
    }
  }


  @Override
  public void onAnswerClicked(int pos) {
    Answer answer = answersList.get(pos);

    selectedAnswer = pos;
    answer.setSelected(true);
    answerAdapter.notifyItemChanged(pos);

    if (questionFragmentCallback != null) {
      if (answer.isCorrect())
        questionFragmentCallback.onAnswerCorrect();
      else
        questionFragmentCallback.onAnswerIncorrect();
    }
  }

  private QuestionFragmentCallback questionFragmentCallback;

  public interface QuestionFragmentCallback {
    void onAnswerCorrect();

    void onAnswerIncorrect();
  }

  public void setQuestionFragmentCallback(QuestionFragmentCallback questionFragmentCallback) {
    this.questionFragmentCallback = questionFragmentCallback;
  }
}
