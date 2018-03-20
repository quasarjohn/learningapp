package com.berstek.learningapp.view.question;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.model.Answer;

import java.util.List;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ListHolder> {

  private List<Answer> data;
  private Context context;
  private LayoutInflater inflater;

  private Answer answer;

  private AnswerClickCallback answerClickCallback;

  public AnswerAdapter(List<Answer> data, Context context) {
    this.data = data;
    this.context = context;
    inflater = LayoutInflater.from(context);
  }

  @Override
  public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ListHolder(inflater.inflate(R.layout.viewholder_answer, parent, false));
  }

  @Override
  public void onBindViewHolder(final ListHolder holder, final int position) {
    final Answer answer = data.get(position);
    this.answer = answer;
    holder.answerTxt.setText(answer.getAnswer());

    if (answer.isSelected()) {
      if (answer.isCorrect()) {
        holder.view.setBackgroundColor(context.getResources().getColor(R.color.greenText));
      } else {
        holder.view.setBackgroundColor(context.getResources().getColor(R.color.redText));
      }
    }

  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView answerTxt;
    private View view;

    public ListHolder(View itemView) {
      super(itemView);

      answerTxt = itemView.findViewById(R.id.answerTxt);
      view = itemView;
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if (!answer.isSelected()) {
        answerClickCallback.onAnswerClicked(getAdapterPosition());
      }
    }
  }

  public interface AnswerClickCallback {
    void onAnswerClicked(int pos);
  }

  public void setAnswerClickCallback(AnswerClickCallback answerClickCallback) {
    this.answerClickCallback = answerClickCallback;
  }
}
