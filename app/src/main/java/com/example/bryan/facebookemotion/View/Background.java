package com.example.bryan.facebookemotion.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.bryan.facebookemotion.DimenCommon;
import com.example.bryan.facebookemotion.Util;

public class Background {

    //region GET/SET
    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }
    //endregion

    //region CONSTRUCTOR
    public Background(Context mContext) {
        this.mContext = mContext;
        initPain();
        matrix();
    }
    //endregion

    //region UTILS
    public void initPain() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);

    }

    public void drawBackgound(Canvas canvas) {
        float radius =  Util.dpToPx(50) / 2;
        RectF board = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(board, radius, radius, mPaint);
    }

    public void matrix() {
        bottom = (float) DimenCommon.HEIGHT_VIEW_REACTION / 2;
        top = bottom - ((DimenCommon.DIVIDE * 2) + DimenCommon.NORMAL_SIZE);
        left = DimenCommon.DIVIDE * 2;
        right = (float) (DimenCommon.DIVIDE * 7) + (DimenCommon.NORMAL_SIZE * 6)+left;
    }

    //endregion


    //region VARS
    private Context mContext;
    public Paint mPaint;
    private float top;
    private float bottom;
    private float left=10;
    private float right;


    //endregion

}
