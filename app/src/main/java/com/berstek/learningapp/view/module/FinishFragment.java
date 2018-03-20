package com.berstek.learningapp.view.module;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.berstek.learningapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishFragment extends Fragment implements View.OnClickListener {

  private View view;

  private Button viewScoreBtn;

  public FinishFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_finish, container, false);

    viewScoreBtn = view.findViewById(R.id.viewScoreBtn);
    viewScoreBtn.setOnClickListener(this);

    return view;
  }

  @Override
  public void onClick(View view) {
    if (finishFragmentCallback != null)
      finishFragmentCallback.onViewScoreClicked();
  }

  private FinishFragmentCallback finishFragmentCallback;

  public interface FinishFragmentCallback {
    void onViewScoreClicked();
  }

  public void setFinishFragmentCallback(FinishFragmentCallback finishFragmentCallback) {
    this.finishFragmentCallback = finishFragmentCallback;
  }
}
