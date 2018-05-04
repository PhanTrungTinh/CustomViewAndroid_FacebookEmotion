package com.example.bryan.facebookemotion.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.bryan.facebookemotion.DimenCommon;
import com.example.bryan.facebookemotion.Util;

public class Emotion {


    //region SYSTEM EVENT

    public Emotion(Context mContext, int bitmap) {
        this.mContext = mContext;
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), bitmap);
        initPain();
    }

    //endregion

    //region UTILS
    private void initPain(){
        mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
        mPaint.setAntiAlias(true);
    }
    public void drawEmotion(Canvas canvas){
        RectF matrix = new RectF(left,top,right,bottom);
        canvas.drawBitmap(mBitmap,null,matrix,mPaint);
    }
    public void setMatrix(float left,float top, float right,float bottom){
       this.top=top;
       this.left=left;
       this.right=right;
       this.bottom=bottom;
    }
    public void setCurrentSize(int currentSize){
        currentSize=currentSize;
    }

    //endregion

    //region VARS
    private Context mContext;
    public Paint mPaint;
    private Bitmap mBitmap;
    public   float top;
    public   float left;
    public   float right;
    public   float bottom;
    public int currentSize;

    //endregion
}
