package com.berstek.learningapp.view;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.berstek.learningapp.R;
import com.berstek.learningapp.customClasses.GifView;
import com.berstek.learningapp.model.Intro;
import com.berstek.learningapp.model.MatchingQuestion;
import com.berstek.learningapp.model.Module;
import com.berstek.learningapp.model.Question;
import com.berstek.learningapp.model.Title;
import com.berstek.learningapp.test.DataInit;
import com.berstek.learningapp.utils.ImageLoader;
import com.berstek.learningapp.view.matching_question.MatchingQuestionFragment;
import com.berstek.learningapp.view.module.FinishFragment;
import com.berstek.learningapp.view.module.IntroFragment;
import com.berstek.learningapp.view.module.ModuleCoverFragment;
import com.berstek.learningapp.view.module.ScoreDialogFragment;
import com.berstek.learningapp.view.question.QuestionFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ViewpagerActivity extends AppCompatActivity
    implements QuestionFragment.QuestionFragmentCallback,
    FinishFragment.FinishFragmentCallback {

  private ImageView confettiImg;

  private TabLayout tab;
  private ViewPager viewPager;

  private ArrayList<Fragment> fragments;

  private View tabIndicator;


  private int correct = 0, incorrect = 0, totalItems = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_viewpager);
    confettiImg = findViewById(R.id.confettiImg);


    getSupportActionBar().hide();

    setTitle("Module 1");

    tabIndicator = getLayoutInflater().inflate(R.layout.tablayout_view, null);

    tab = findViewById(R.id.tab);
    viewPager = findViewById(R.id.viewpager);

    fragments = new ArrayList<>();

    initModule();

    viewPager.setAdapter(new ViewpagerAdapter(getSupportFragmentManager()));
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    tab.setupWithViewPager(viewPager);


    for (int i = 0; i < tab.getTabCount(); i++) {
      tab.getTabAt(i).setCustomView(getLayoutInflater().inflate(R.layout.tablayout_view_deselected, null));
    }

    tab.getTabAt(0).setCustomView(null);
    tab.getTabAt(0).setCustomView(tabIndicator);

    tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        tab.setCustomView(null);
        tab.setCustomView(tabIndicator);

        if (tab.getPosition() == fragments.size() - 1) {
          Glide.with(ViewpagerActivity.this).load(R.raw.gif_confetti).diskCacheStrategy(DiskCacheStrategy.NONE).into(confettiImg);
        }
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
        tab.setCustomView(null);
        tab.setCustomView(getLayoutInflater().inflate(R.layout.tablayout_view_deselected, null));
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });

    viewPager.setOffscreenPageLimit(fragments.size());

  }

  private void initModule() {
    Module module = new DataInit().getModule();
    Title title = module.getTitle();

    //init the module cover fragment
    ModuleCoverFragment moduleCoverFragment = new ModuleCoverFragment();
    Bundle titleBundle = new Bundle();
    titleBundle.putSerializable("title", title);
    moduleCoverFragment.setArguments(titleBundle
    );

    fragments.add(moduleCoverFragment);
    tab.addTab(tab.newTab());


    for (Object page : module.getPages()) {

      if (page instanceof Intro) {
        Intro intro = (Intro) page;

        IntroFragment introFragment = new IntroFragment();
        Bundle introBundle = new Bundle();
        introBundle.putSerializable("intro", intro);
        introFragment.setArguments(introBundle);
        fragments.add(introFragment);
        tab.addTab(tab.newTab());

      } else if (page instanceof Question) {
        Question question = (Question) page;

        QuestionFragment questionFragment = new QuestionFragment();
        if (!question.isSample()) {
          questionFragment.setQuestionFragmentCallback(this);
          totalItems++;
        }
        Bundle questionBundle = new Bundle();
        questionBundle.putSerializable("question", question);
        questionFragment.setArguments(questionBundle);
        fragments.add(questionFragment);
        tab.addTab(tab.newTab());
      } else if (page instanceof MatchingQuestion) {
        MatchingQuestionFragment matchingQuestionFragment = new MatchingQuestionFragment();
        matchingQuestionFragment.setQuestionFragmentCallback(this);
        MatchingQuestion question = (MatchingQuestion) page;
        Bundle bundle = new Bundle();
        bundle.putSerializable("question", question);
        matchingQuestionFragment.setArguments(bundle);
        fragments.add(matchingQuestionFragment);
        tab.addTab(tab.newTab());
        totalItems += question.getMatchingImages().size();
      }

    }

    FinishFragment finishFragment = new FinishFragment();
    finishFragment.setFinishFragmentCallback(new FinishFragment.FinishFragmentCallback() {
      @Override
      public void onViewScoreClicked() {
        ScoreDialogFragment scoreDialogFragment = new ScoreDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("correct", correct);
        bundle.putInt("incorrect", incorrect);
        bundle.putInt("total", totalItems);

        scoreDialogFragment.setArguments(bundle);

        scoreDialogFragment.show(getFragmentManager(), null);
      }
    });

    fragments.add(finishFragment);
    tab.addTab(tab.newTab());

  }

  @Override
  public void onAnswerCorrect() {
    correct++;
  }

  @Override
  public void onAnswerIncorrect() {
    incorrect++;
  }

  @Override
  public void onViewScoreClicked() {

  }

  private class ViewpagerAdapter extends FragmentStatePagerAdapter {

    public ViewpagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return fragments.get(position);
    }

    @Override
    public int getCount() {
      return fragments.size();
    }
  }

}
