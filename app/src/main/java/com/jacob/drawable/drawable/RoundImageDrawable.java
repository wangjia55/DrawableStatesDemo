package com.jacob.drawable.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by jacob-wj on 2015/4/11.
 */
public class RoundImageDrawable extends Drawable {
    private Bitmap mBitmap;
    private Paint mPaint;
    private RectF mRectF;

    public RoundImageDrawable(Bitmap bitmap){
        this.mBitmap = bitmap;
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setShader(bitmapShader);

        mRectF = new RectF();

    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mRectF.set(left,top,right,bottom);

    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRectF, 30, 30, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
