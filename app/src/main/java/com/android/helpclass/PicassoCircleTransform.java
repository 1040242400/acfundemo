package com.android.helpclass;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;

import demo.acfun.com.acfundemo.R;

/**
 * Created by chen on 16/6/21.
 */
public class PicassoCircleTransform implements Transformation {

    @Override
    public Bitmap transform(Bitmap source) {
        int zoom = (int) (source.getWidth() * 0.1);

        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap target = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(target);
        canvas.drawRoundRect(new RectF(0, 0, target.getWidth(), target.getHeight()), zoom, zoom, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        source.recycle();
        return target;
    }

    @Override
    public String key() {
        return "square()";
    }
}
