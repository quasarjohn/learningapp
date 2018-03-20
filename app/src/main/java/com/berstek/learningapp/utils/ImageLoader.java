package com.berstek.learningapp.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

  public static void loadImage(String url, ImageView img, Context context) {
    Glide.with(context).load(url).skipMemoryCache(true).into(img);
  }
}
