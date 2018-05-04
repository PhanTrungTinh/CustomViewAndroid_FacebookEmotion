package com.example.bryan.facebookemotion.View;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.example.bryan.facebookemotion.DimenCommon;
import com.example.bryan.facebookemotion.EaseOutBack;
import com.example.bryan.facebookemotion.R;
import com.example.bryan.facebookemotion.Util;

public class EmotionView extends View {

    //region GET/SET


    //endregion

    //region SYSTEM EVENT
    public EmotionView(Context context) {
        super(context);
        init();
    }

    public EmotionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmotionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mCanvas = canvas;
        mBackground.drawBackgound(canvas);
        for (Emotion emotion : mEmotion) {
            emotion.drawEmotion(canvas);
        }

    }
    //endregion

    //region EVENT

    //endregion

    //region UTILS
    private void init() {
        mBackground = new Background(getContext());
        setLayerType(LAYER_TYPE_SOFTWARE, mBackground.mPaint);
        mEmotion[0] = new Emotion(getContext(), R.drawable.like);
        mEmotion[1] = new Emotion(getContext(), R.drawable.love);
        mEmotion[2] = new Emotion(getContext(), R.drawable.haha);
        mEmotion[3] = new Emotion(getContext(), R.drawable.wow);
        mEmotion[4] = new Emotion(getContext(), R.drawable.cry);
        mEmotion[5] = new Emotion(getContext(), R.drawable.angry);
        emotionSetMatrix(this.currentSize);
    }

    private void emotionSetMatrix(int currentSize) {
        mELeft = mBackground.getLeft() + DimenCommon.DIVIDE;
        mETop = mBackground.getTop() + DimenCommon.DIVIDE;
        mEBottom = mBackground.getBottom() - DimenCommon.DIVIDE;
        mERight = mELeft + currentSize;
        for (Emotion emotion : mEmotion) {
            emotion.setMatrix(mELeft, mETop, mERight, mEBottom);
            mELeft = mERight + DimenCommon.DIVIDE;
            mERight = mELeft + currentSize;
        }
    }

    //endregion

    //region Animation

    //endregion
    //region VARS
    public final long DURATION_EACH_ITEM_BEGIN = 3500;
    public final long TIME_ACTION = 500;
    private EaseOutBack easeOutBack;
    private Background mBackground;
    private Emotion[] mEmotion = new Emotion[6];
    private float mELeft;
    private float mERight;
    private float mEBottom;
    private float mETop;
    private int currentSize = DimenCommon.NORMAL_SIZE;
    private Canvas mCanvas;

    //endregion
}
