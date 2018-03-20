package com.berstek.learningapp.view.module;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.model.Title;
import com.berstek.learningapp.utils.ImageLoader;
import com.berstek.learningapp.view.ViewpagerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ModuleCoverFragment extends Fragment {

  private View view;

  private Title title;
  private TextView titleTxt, subtitleTxt;
  private TextView moduleNumberTxt, moduleHeaderTxt;
  private ImageView moduleImg;

  public ModuleCoverFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_module_cover, container, false);

    title = (Title) getArguments().getSerializable("title");

    titleTxt = view.findViewById(R.id.titleTxt);
    subtitleTxt = view.findViewById(R.id.subtitleTxt);
    moduleImg = view.findViewById(R.id.moduleImg);

    moduleNumberTxt = view.findViewById(R.id.moduleNumberTxt);
    moduleHeaderTxt = view.findViewById(R.id.moduleHeaderTxt);

    titleTxt.setText(title.getTitle());
    subtitleTxt.setText(title.getSubtitle());
//    moduleNumberTxt.setText(title.getModuleNumber());
//    moduleHeaderTxt.setText(title.getModuleHeader());

    ImageLoader.loadImage(title.getImgUrl(), moduleImg, getContext());
    return view;
  }

}
