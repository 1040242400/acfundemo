package demo.acfun.com.acfundemo.ui;

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

import demo.acfun.com.acfundemo.network.AppHttp;

import demo.acfun.com.acfundemo.base.BaseFragment;
import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.adapter.MainTuiJianRecyclerAdapter;
import demo.acfun.com.acfundemo.model.TuiJianEntity;
import demo.acfun.com.acfundemo.ui.VideoInfo.VideoInfoActivity;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chen on 16/6/7.
 */
public class MainTuiJianFragment extends BaseFragment {
    private SwipeRefreshLayout swipeLayout;
    private RecyclerView recyclerView;
    private MainTuiJianRecyclerAdapter recyclerAdapter;
    private TuiJianEntity tuiJianEntity;

    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.main_tuijian_fragment, null);
        initErrorView(contentView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddeErrorView();
                materialishProgress.show();
                laodData();
            }
        });


        initView(contentView);
        materialishProgress.show();
        laodData();
        return contentView;
    }

    private void initView(View contentView) {
        swipeLayout = (SwipeRefreshLayout) contentView.findViewById(R.id.swipe_layout);
        swipeLayout.setProgressBackgroundColor(R.color.white);
        swipeLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                laodData();
            }
        });

        recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    private void laodData() {
        AppHttp.getInstance().getRetrofitApi().getTuijian("0", "-1")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TuiJianEntity>() {
                    @Override
                    public void onCompleted() {
                        hiddeErrorView();
                        swipeLayout.setRefreshing(false);
                        materialishProgress.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeLayout.setRefreshing(false);
                        materialishProgress.dismiss();
                        if (tuiJianEntity == null) {
                            showErrorView(R.mipmap.ic_launcher, e.getMessage(), "点击刷新");
                        } else {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onNext(TuiJianEntity tuiJianEntity) {
                        MainTuiJianFragment.this.tuiJianEntity = tuiJianEntity;
                        showData();
                    }
                });

    }

    private void showData() {
        if (recyclerView.getAdapter() == null) {
            recyclerAdapter = new MainTuiJianRecyclerAdapter(MainTuiJianFragment.this.getActivity(), tuiJianEntity.getData(), new MainTuiJianRecyclerAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Snackbar.make(getView(), "item on click" + position, Snackbar.LENGTH_SHORT).show();
                }

                @Override
                public void onItemItemClick(int position, int subPosition) {
                    Intent toInfo = new Intent(getActivity(), VideoInfoActivity.class);
                    toLeftStartActivity(toInfo);
                }
            });
            recyclerView.setAdapter(recyclerAdapter);
        } else {
            recyclerAdapter.setTuijianData(tuiJianEntity.getData());
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