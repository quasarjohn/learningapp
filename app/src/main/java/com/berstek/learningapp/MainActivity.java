package com.berstek.learningapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.berstek.learningapp.view.ViewpagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button goBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    goBtn = findViewById(R.id.goBtn);

    goBtn.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    Intent i = new Intent(this, ViewpagerActivity.class);
    startActivity(i);
  }
}
