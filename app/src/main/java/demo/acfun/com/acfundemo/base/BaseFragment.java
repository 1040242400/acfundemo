package demo.acfun.com.acfundemo.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.pnikosis.materialishprogress.ProgressWheel;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.utils.LogUtils;

/**
 * Created by chen on 16/6/15.
 */
public abstract class BaseFragment extends Fragment {
    public Dialog materialishProgress;
    public static String LogTga = "BaseFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogTga = getClass().toString();
        initMaterialishProgress();
        return getContentView(inflater, container, savedInstanceState);
    }

    //获取布局文件ID
    protected abstract View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    public void log(int logType, String tagStr, Object objects) {
        LogUtils.TAG = LogTga;
        LogUtils.log(logType, tagStr, objects);
    }

    public void initMaterialishProgress() {
        materialishProgress = new Dialog(this.getActivity(),
                R.style.Dialog_Fullscreen_NoTitle);
        View contentView = LayoutInflater.from(this.getActivity()).inflate(
                R.layout.base_dialog, null);
        ProgressWheel progressWheel = (ProgressWheel) contentView.findViewById(R.id.progress_wheel);
        materialishProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        materialishProgress.setContentView(contentView);
    }
}
