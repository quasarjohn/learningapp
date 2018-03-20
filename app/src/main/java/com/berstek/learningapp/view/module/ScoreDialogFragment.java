package com.berstek.learningapp.view.module;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.customClasses.CustomDialogFragment;
import com.berstek.learningapp.view.ViewpagerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreDialogFragment extends CustomDialogFragment
    implements View.OnClickListener {

  private View view;

  private int correct, incorrect, total;

  private TextView scoreTxt;

  private Button doneBtn;

  public ScoreDialogFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    correct = getArguments().getInt("correct");
    incorrect = getArguments().getInt("incorrect");
    total = getArguments().getInt("total");


    view = inflater.inflate(R.layout.fragment_score_dialog, container, false);
    scoreTxt = view.findViewById(R.id.scoreTxt);

    scoreTxt.setText(correct + " / " + total);
    doneBtn = view.findViewById(R.id.dontBtn);

    doneBtn.setOnClickListener(this);

    return view;
  }

  @Override
  public void onClick(View view) {

    Intent intent = new Intent(getActivity(), ViewpagerActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
  }
}
