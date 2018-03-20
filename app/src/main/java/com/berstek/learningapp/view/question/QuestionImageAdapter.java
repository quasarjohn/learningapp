package com.berstek.learningapp.view.question;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.utils.ImageLoader;

import java.util.List;

public class QuestionImageAdapter extends RecyclerView.Adapter<QuestionImageAdapter.Listholder> {

  private List<String> data;
  private LayoutInflater inflater;
  private Context context;

  public QuestionImageAdapter(List<String> data, Context context) {
    this.data = data;
    inflater = LayoutInflater.from(context);
    this.context = context;
  }

  @Override
  public Listholder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Listholder(inflater.inflate(R.layout.viewholder_question_img, parent, false));
  }

  @Override
  public void onBindViewHolder(Listholder holder, int position) {
    String imgUrl = data.get(position);

    ImageLoader.loadImage(imgUrl, holder.img, context);

  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  class Listholder extends RecyclerView.ViewHolder {

    private ImageView img;

    public Listholder(View itemView) {
      super(itemView);

      img = itemView.findViewById(R.id.img);
    }
  }
}
