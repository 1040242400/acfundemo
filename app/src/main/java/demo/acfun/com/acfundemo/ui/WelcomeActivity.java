package demo.acfun.com.acfundemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import demo.acfun.com.acfundemo.Manage.UserManage;
import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.base.BaseActivity;
import demo.acfun.com.acfundemo.model.BaseEntity;
import demo.acfun.com.acfundemo.model.WelComeEntity;
import demo.acfun.com.acfundemo.network.AppHttp;
import demo.acfun.com.acfundemo.utils.BitmapUtils;
import demo.acfun.com.acfundemo.utils.SPUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chen on 16/6/22.
 */
public class WelcomeActivity extends BaseActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        imageView = (ImageView) findViewById(R.id.image_view);

        WelComeEntity welComeEntity = (WelComeEntity) SPUtils.readObject(WelcomeActivity.this, UserManage.WELCOME_ENTITY);
        if (welComeEntity != null) {
            imageView.setImageBitmap(BitmapUtils.base64ToBitmap(welComeEntity.getData().getBase64pic()));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imageView.setVisibility(View.VISIBLE);
            }
        }, 500);

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
