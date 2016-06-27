package demo.acfun.com.acfundemo.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import demo.acfun.com.acfundemo.network.AppHttp;

import java.util.List;

import demo.acfun.com.acfundemo.base.BaseFragment;
import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.adapter.MainTuiJianRecyclerAdapter;
import demo.acfun.com.acfundemo.model.TuiJianEntity;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chen on 16/6/7.
 */
public class MainTuiJianFragment extends BaseFragment {
    private SwipeRefreshLayout swipeLayout;
    private RecyclerView recyclerView;
    private MainTuiJianRecyclerAdapter recyclerAdapter;
    private List<TuiJianEntity> entitys;

    protected View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.main_tuijian_fragment, null);

        initView(contentView);

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
        swipeLayout.setRefreshing(true);
        AppHttp.getMainTuijian(MainTuiJianFragment.this.getActivity(), new AppHttp.AppHttpCallBack() {
            @Override
            public void returnEntity(Object object, boolean isFromCache, Request request, Response response) {
                swipeLayout.setRefreshing(false);
                entitys = (List<TuiJianEntity>) object;
                showData();
            }
        });

    }

    private void showData() {
        if (recyclerView.getAdapter() == null) {
            recyclerAdapter = new MainTuiJianRecyclerAdapter(MainTuiJianFragment.this.getActivity(), entitys, new MainTuiJianRecyclerAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Snackbar.make(getView(), "item on click" + position, Snackbar.LENGTH_SHORT).show();
                }

                @Override
                public void onItemItemClick(int position, int subPosition) {
                    Snackbar.make(getView(), "item item on click" + position + "," + subPosition, Snackbar.LENGTH_SHORT).show();
                }
            });
            recyclerView.setAdapter(recyclerAdapter);
        } else {
            recyclerView.getAdapter().notifyDataSetChanged();
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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    swipeLayout.setRefreshing(false);
                    break;

                default:
                    break;

            }
            super.handleMessage(msg);
        }
    };

}