package com.example.bryan.facebookemotion;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.bryan.facebookemotion.View.EmotionView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbnLike = findViewById(R.id.button_like);
        mEmotionView = findViewById(R.id.emotion);
        animator = new ValueAnimator();

        mbnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmotionView.setVisibility(View.VISIBLE);
            }
        });


    }

    //region VARs
    private ValueAnimator animator;
    private EmotionView mEmotionView;
    private Button mbnLike;
    //endregion
}
