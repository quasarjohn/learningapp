package com.berstek.learningapp.view.module;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.customClasses.SmartTextView;
import com.berstek.learningapp.model.Intro;
import com.berstek.learningapp.utils.ImageLoader;
import com.berstek.learningapp.view.ViewpagerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends Fragment {

  private View view;

  private TextView titleTxt;
  private TextView headerTxt, subeaderTxt;
  private ImageView img;

  private Intro intro;

  public IntroFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_intro, container, false);

    intro = (Intro) getArguments().getSerializable("intro");

    titleTxt = view.findViewById(R.id.titleTxt);
    headerTxt = view.findViewById(R.id.headerTxt);
    subeaderTxt = view.findViewById(R.id.subheaderTxt);
    img = view.findViewById(R.id.img);

    titleTxt.setText(intro.getTitle());
    headerTxt.setText(intro.getHeader());

    if (intro.getSubheader() != null) {
      subeaderTxt.setText(Html.fromHtml(intro.getSubheader()));
    }

    ImageLoader.loadImage(intro.getImgUrl(), img, getContext());

    return view;
  }

}
