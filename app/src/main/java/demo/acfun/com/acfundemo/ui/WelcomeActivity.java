package demo.acfun.com.acfundemo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import demo.acfun.com.acfundemo.R;

/**
 * Created by chen on 16/6/22.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMain = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        }, 1000);
    }
}
