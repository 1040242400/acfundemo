package demo.acfun.com.acfundemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import demo.acfun.com.acfundemo.utils.LogUtils;

/**
 * Created by chen on 16/6/15.
 */
public abstract class BaseFragmentActivity extends FragmentActivity {

    public static String LogTga = "BaseFragmentActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogTga = getClass().toString();
    }


    public void log(int logType, String tagStr, Object objects) {
        LogUtils.TAG = LogTga;
        LogUtils.log(logType, tagStr, objects);
    }
}
