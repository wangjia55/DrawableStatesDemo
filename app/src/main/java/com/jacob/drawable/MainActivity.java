package com.jacob.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.jacob.drawable.drawable.CircleImageDrawable;
import com.jacob.drawable.drawable.RoundImageDrawable;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = (ImageView) findViewById(R.id.imageview1);
        Bitmap bitmap  = BitmapFactory.decodeResource(getResources(),R.drawable.ic_pic);
        RoundImageDrawable roundImageView = new RoundImageDrawable(bitmap);
        imageView1.setImageDrawable(roundImageView);

        ImageView imageView2 = (ImageView) findViewById(R.id.imageview2);
        Bitmap bitmap2  = BitmapFactory.decodeResource(getResources(),R.drawable.ic_pic);
        CircleImageDrawable circleImageDrawable = new CircleImageDrawable(bitmap2);
        imageView2.setImageDrawable(circleImageDrawable);
    }

}
