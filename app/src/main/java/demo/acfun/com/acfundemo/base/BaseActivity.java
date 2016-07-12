package demo.acfun.com.acfundemo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.lzy.okhttputils.OkHttpUtils;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.utils.LogUtils;
import demo.acfun.com.acfundemo.ui.MainActivity;

/**
 * Created by chen on 16/6/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static String LogTga = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogTga = getClass().toString();

    }

    // 左边 进入
    public void toLeftStartActivity(Intent intent) {
        super.startActivity(intent);
        //参数一 是当前即将进入屏幕的view 的动画，参数二是当前view 的动画
        overridePendingTransition(R.anim.push_a, R.anim.push_b);
    }

    //右边 消失
    public void toRightFinish() {
        super.finish();
        overridePendingTransition(R.anim.pop_a, R.anim.pop_b);
    }

    //日志输出
    public void log(int logType, String tagStr, Object objects) {
        LogUtils.TAG = LogTga;
        LogUtils.log(logType, tagStr, objects);
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if (this.getClass() == MainActivity.class) {
                if ((System.currentTimeMillis() - exitTime) > 2000) {
                    Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                } else {
                    finish();
                }
            } else {
                toRightFinish();
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //根据 Tag 取消请求
        OkHttpUtils.getInstance().cancelTag(this);
    }

}
