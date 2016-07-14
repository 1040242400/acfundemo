package demo.acfun.com.acfundemo.ui.VideoInfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.adapter.MainTuiJianRecyclerAdapter;
import demo.acfun.com.acfundemo.adapter.VideoInfoAdapter;
import demo.acfun.com.acfundemo.base.BaseFragment;
import demo.acfun.com.acfundemo.model.TuiJianEntity;
import demo.acfun.com.acfundemo.network.AppHttp;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chen on 16/6/7.
 */
public class VideoInfoPingJiaFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private VideoInfoAdapter recyclerAdapter;

    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.main_pingjia_fragment, null);
        initErrorView(contentView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        initView(contentView);
        laodData();
        return contentView;
    }

    private void initView(View contentView) {
        recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    private void laodData() {
        showData();
    }

    private void showData() {
        if (recyclerView.getAdapter() == null) {
            recyclerAdapter = new VideoInfoAdapter(getActivity(), new VideoInfoAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int spPosition) {
                    showErrorView(R.mipmap.ic_launcher, "a", "v");
                }
            });
            recyclerView.setAdapter(recyclerAdapter);
        } else {
            recyclerAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        super.onStop();
    }

}