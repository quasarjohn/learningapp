package com.berstek.learningapp.view.matching_question;


import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.model.MatchingImage;
import com.berstek.learningapp.model.MatchingLine;
import com.berstek.learningapp.model.MatchingQuestion;
import com.berstek.learningapp.utils.CustomAnimator;
import com.berstek.learningapp.utils.ImageLoader;
import com.berstek.learningapp.view.question.QuestionFragment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchingQuestionFragment extends Fragment implements View.OnClickListener {

  private View view;
  private FrameLayout root;
  private Button checkBtn;
  //this is the canvas on top of the frame layout where the lines are drawn
  private MyView myCanvas;
  //coordinates of the images and the choices respectively
  private int x, y = 100, x1, y1 = 100;
  private int imageSize = 150, offsetImg = 200, offsetTxt = 200, textSize = 35;
  //temp holder of the x and y coordinate of the line when user taps on a picture
  private int lineX, lineY;
  //blink animation
  private AnimatorSet animation;
  //stores the lines on the canvas so they do not disappear when canvas refreshed
  private HashMap<String, MatchingLine> matchingLines = new HashMap<>();
  //temp holder for the current selected matching image. allows the answer to be set
  private MatchingImage matchingImage;
  //temp holder for the selected image. allows the blink animation to be removed when another view is clicked
  private ImageView focusedImage;
  //the question object that contains all the items. I need reference to this so I can access the items globally
  private MatchingQuestion question;
  //reference to all images. allows me to remove the animator by
  // iterating all the images when the root view is clicked
  private ArrayList<ImageView> imageViews = new ArrayList<>();
  private ArrayList<TextView> textViews = new ArrayList<>();

  private DisplayMetrics displayMetrics = new DisplayMetrics();

  public MatchingQuestionFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_matching_question, container, false);

    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

    imageSize = (int) (displayMetrics.heightPixels / 5.5);
    offsetImg = imageSize + 20;


    question = (MatchingQuestion) getArguments().getSerializable("question");


    checkBtn = view.findViewById(R.id.checkBtn);
    checkBtn.setOnClickListener(this);

    root = view.findViewById(R.id.root);
    root.setOnClickListener(this);
    myCanvas = new MyView(getContext());

    root.addView(myCanvas);


    //load images

    for (final MatchingImage image : question.getMatchingImages()) {
      final ImageView imageView = (ImageView) getLayoutInflater().inflate(R.layout.img, null);
      ImageLoader.loadImage(image.getImage(), imageView, getContext());
      FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
          (imageSize, imageSize);
      params.setMargins(x, y, 0, 0);
      imageView.setLayoutParams(params);
      root.addView(imageView);
      y += offsetImg;

      imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          for (ImageView i : imageViews) {
            if (i != imageView) {

              if (animation != null) {
                animation.removeAllListeners();
                animation.end();
                animation.cancel();
              }

              i.clearAnimation();
              i.setAlpha(1f);
            }
          }

          animation = CustomAnimator.animateAlpha(imageView);
          lineX = view.getLeft() + (imageSize / 2) + (imageSize / 4) + 10;
          lineY = view.getTop() + (imageSize / 2);

          matchingImage = image;
          focusedImage = imageView;
        }
      });

      imageViews.add(imageView);
    }

    int width = displayMetrics.widthPixels;

    x1 = width - imageSize;

    for (final String choice : question.getChoices()) {
      TextView textView = new TextView(getContext());
      textView.setText(choice);
      textView.setTextSize(50);
      FrameLayout.LayoutParams params = new FrameLayout.LayoutParams
          (imageSize, imageSize);
      params.setMargins(x1, y1, 0, 0);
      textView.setLayoutParams(params);
      root.addView(textView);
      y1 += offsetImg;
      textViews.add(textView);

      textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          MatchingLine matchingLine = new MatchingLine();
          matchingLine.setX(lineX);
          matchingLine.setY(lineY);
          matchingLine.setX1((int) view.getX() - textSize);
          matchingLine.setY1((int) view.getY() + textSize);
          matchingLine.setSourceImg(focusedImage);
          matchingLine.setColor(Color.BLACK);

          matchingLines.put(choice, matchingLine);
          matchingImage.setChosenAnswer(choice);

          String toRemove = "";
          for (String k : matchingLines.keySet()) {
            if (!k.equals(choice)) {
              if (matchingLines.get(k).getSourceImg() == focusedImage) {
                toRemove = k;
              }
            }
          }

          matchingLines.remove(toRemove);

          myCanvas.invalidate();
          focusedImage.clearAnimation();
          animation.removeAllListeners();
          animation.end();
          animation.cancel();

          focusedImage.setAlpha(1f);

        }
      });
    }
    return view;
  }

  @Override
  public void onClick(View view) {

    if (view.getId() == R.id.checkBtn) {
      checkAnswers();
    } else if (view.getId() == R.id.root) {

      for (ImageView i : imageViews) {
        if (i != focusedImage) {

          if (animation != null) {
            animation.removeAllListeners();
            animation.end();
            animation.cancel();
          }

          i.setAlpha(1f);
        }
      }
    }
  }

  class MyView extends View {

    private Paint paint;

    public MyView(Context context) {
      super(context);
      paint = new Paint();
      paint.setColor(Color.BLACK);
      paint.setStrokeWidth(8f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
      super.onDraw(canvas);

      for (String k : matchingLines.keySet()) {
        MatchingLine line = matchingLines.get(k);
        paint.setColor(line.getColor());
        canvas.drawLine(line.getX(), line.getY(), line.getX1(), line.getY1(), paint);

        canvas.save();

      }

    }


  }

  private void checkAnswers() {

    for (MatchingImage matchingImage : question.getMatchingImages()) {
      if (matchingImage.getAnswer().equals(matchingImage.getChosenAnswer())) {
        if (matchingImage.getAnswer() != null && matchingLines.get(matchingImage.getChosenAnswer()) != null)
          matchingLines.get(matchingImage.getChosenAnswer()).setColor(Color.parseColor("#1faa00"));
        if (questionFragmentCallback != null)
          questionFragmentCallback.onAnswerCorrect();
      } else {
        if (questionFragmentCallback != null)
          questionFragmentCallback.onAnswerIncorrect();
        if (matchingImage.getAnswer() != null && matchingLines.get(matchingImage.getChosenAnswer()) != null)
          matchingLines.get(matchingImage.getChosenAnswer()).setColor(Color.parseColor("#f44336"));
      }
    }

    for (ImageView img : imageViews) {
      img.setOnClickListener(null);
    }

    for (TextView textView : textViews) {
      textView.setOnClickListener(null);
    }

    myCanvas.invalidate();

    checkBtn.setVisibility(View.GONE);
  }


  private QuestionFragment.QuestionFragmentCallback questionFragmentCallback;

  public void setQuestionFragmentCallback(QuestionFragment.QuestionFragmentCallback questionFragmentCallback) {
    this.questionFragmentCallback = questionFragmentCallback;
  }
}
