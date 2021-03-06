package demo.acfun.com.acfundemo.base;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.LayoutDirection;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okhttputils.OkHttpUtils;
import com.pnikosis.materialishprogress.ProgressWheel;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.utils.DensityUtil;
import demo.acfun.com.acfundemo.utils.LogUtils;
import demo.acfun.com.acfundemo.ui.MainActivity;

/**
 * Created by chen on 16/6/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private LinearLayout baseErrorView, baseErrorContentView;
    private ImageView baseErrorImg;
    private TextView baseErrorMsg;
    private Button baseErrorBut;

    public Dialog materialishProgress;

    public static String LogTga = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMaterialishProgress();
        LogTga = getClass().toString();

    }

    /**
     * 子类主动调用方法初始化 error view
     */
    public void initErrorView(View view, View.OnClickListener onClickListener) {
        baseErrorView = (LinearLayout) view.findViewById(R.id.base_error_view);
        baseErrorContentView = (LinearLayout) view.findViewById(R.id.base_error_content_view);
        baseErrorImg = (ImageView) view.findViewById(R.id.base_error_img);
        baseErrorMsg = (TextView) view.findViewById(R.id.base_error_msg);
        baseErrorBut = (Button) view.findViewById(R.id.base_error_but);
        LinearLayout.LayoutParams baseErrorConLayoutParams = new LinearLayout.LayoutParams(DensityUtil.getWindowsWidth(this), DensityUtil.getWindowsHeight(this));
        baseErrorContentView.setLayoutParams(baseErrorConLayoutParams);
        baseErrorContentView.setGravity(Gravity.CENTER);
        baseErrorBut.setOnClickListener(onClickListener);
    }

    /**
     * 子类主动调用 显示error view
     */
    public void showErrorView(int img, String msg, String butTitle) {
        baseErrorView.setVisibility(View.VISIBLE);
        baseErrorImg.setImageResource(img);
        baseErrorMsg.setText(msg);
        baseErrorBut.setText(butTitle);
    }

    /**
     * 子类主动调用 隐藏error view
     */
    public void hiddeErrorView() {
        this.baseErrorView.setVisibility(View.GONE);
    }

    /**
     * 父类主动初始化 进度条
     */
    private void initMaterialishProgress() {
        materialishProgress = new Dialog(this,
                R.style.Dialog_Fullscreen_NoTitle);
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.base_dialog, null);
        ProgressWheel progressWheel = (ProgressWheel) contentView.findViewById(R.id.progress_wheel);
        materialishProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        materialishProgress.setContentView(contentView);
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
