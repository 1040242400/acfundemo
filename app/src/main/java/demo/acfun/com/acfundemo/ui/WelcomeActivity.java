package demo.acfun.com.acfundemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.entity.WelComeEntity;
import demo.acfun.com.acfundemo.utils.BitmapUtils;
import demo.acfun.com.acfundemo.utils.SPUtils;

/**
 * Created by chen on 16/6/22.
 */
public class WelcomeActivity extends Activity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        imageView = (ImageView) findViewById(R.id.image_view);

        WelComeEntity welComeEntity = (WelComeEntity) SPUtils.readObject(WelcomeActivity.this, SPUtils.WELCOME_ENTITY);
        if (welComeEntity != null) {
            imageView.setImageBitmap(BitmapUtils.base64ToBitmap(welComeEntity.getData().getBase64pic()));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMain = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        }, 2000);
    }
}
