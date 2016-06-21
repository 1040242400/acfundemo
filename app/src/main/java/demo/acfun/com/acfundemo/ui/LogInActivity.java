package demo.acfun.com.acfundemo.ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import demo.acfun.com.acfundemo.BaseActivity;
import demo.acfun.com.acfundemo.R;

/**
 * Created by chen on 16/6/15.
 */
public class LogInActivity extends BaseActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        img = (ImageView) findViewById(R.id.img);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(LogInActivity.this.getResources(), BitmapFactory.decodeResource(getResources(), R.mipmap.bg_slide_menu_header)); //创建RoundedBitmapDrawable对象
        roundedBitmapDrawable.setCornerRadius(20); //设置圆角半径（根据实际需求）
        roundedBitmapDrawable.setAntiAlias(true); //设置反走样
        img.setImageDrawable(roundedBitmapDrawable);
    }

    public void initView() {
    }
}
