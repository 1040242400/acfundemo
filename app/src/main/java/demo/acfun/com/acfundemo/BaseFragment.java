package demo.acfun.com.acfundemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.helputils.LogUtils;

/**
 * Created by chen on 16/6/15.
 */
public abstract class BaseFragment extends Fragment {
    public static String LogTga = "BaseFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogTga = getClass().toString();
        return getContentView(inflater, container, savedInstanceState);
    }

    //获取布局文件ID
    protected abstract View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    public void log(int logType, String tagStr, Object objects) {
        LogUtils.TAG = LogTga;
        LogUtils.log(logType, tagStr, objects);
    }
}
