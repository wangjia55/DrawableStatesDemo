package com.jacob.drawable.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by jacob-wj on 2015/4/11.
 */
public class CircleImageDrawable extends Drawable {
    private Bitmap mBitmap;

    private Paint mPaint;

    public CircleImageDrawable(Bitmap bitmap){
        this.mBitmap = bitmap;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);

    }

    @Override
    public int getIntrinsicHeight() {
        return mBitmap.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return mBitmap.getWidth();
    }

    @Override
    public void draw(Canvas canvas) {
        int width = getIntrinsicWidth()/2;
        int height = getIntrinsicHeight()/2;
        int radius = Math.min(width,height);
        canvas.drawCircle(width,height,radius,mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha( alpha);
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
