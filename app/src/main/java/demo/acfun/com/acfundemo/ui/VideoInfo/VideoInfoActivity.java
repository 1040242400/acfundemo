package demo.acfun.com.acfundemo.ui.VideoInfo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.adapter.MainViewPagerAdapter;
import demo.acfun.com.acfundemo.base.BaseActivity;
import demo.acfun.com.acfundemo.utils.DensityUtil;

/**
 * Created by chen on 16/7/14.
 */
public class VideoInfoActivity extends BaseActivity {
    private AppBarLayout appBar;
    private CollapsingToolbarLayout toolbarLayout;
    private Toolbar toolBar;
    private LinearLayout barPlayView;
    private ImageView videoView;
    private String[] tabList = new String[]{"视频信息", "相关推荐"};
    private List<Fragment> viewList;
    private SmartTabLayout tabLayout;
    private ViewPager viewPager;
//    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = LayoutInflater.from(this).inflate(R.layout.videoinfo_activity, null);
        setContentView(contentView);
        initErrorView(contentView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialishProgress.show();
                loadData();
            }
        });

        materialishProgress.show();
        initView();
        initTabLayoutViewPager();
        loadData();

    }

    private void initTabLayoutViewPager() {
        tabLayout = (SmartTabLayout) findViewById(R.id.tab_layout);
        viewList = new ArrayList<>();
        viewList.add(new VideoInfoPingJiaFragment());
        viewList.add(new VideoInfoPingJiaFragment());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), tabList, viewList);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(tabList.length);
        tabLayout.setViewPager(viewPager);
    }

    private void initView() {
        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        barPlayView = (LinearLayout) findViewById(R.id.bar_play_view);
        videoView = (ImageView) findViewById(R.id.video_view);
        RelativeLayout.LayoutParams videoParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (DensityUtil.getWindowsWidth(this) * (9.0 / 16.0)));
        videoView.setLayoutParams(videoParams);

        appBar = (AppBarLayout) findViewById(R.id.app_bar);
        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    toolBar.setBackgroundColor(getResources().getColor(R.color.clearColor));
                    barPlayView.setVisibility(View.GONE);
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    toolBar.setBackgroundColor(getResources().getColor(R.color.black));
                    barPlayView.setVisibility(View.VISIBLE);
                } else {
                    double p = 255.0 / (videoView.getHeight() - barPlayView.getHeight());
                    toolBar.setBackgroundColor(Color.argb(255 - (int) (verticalOffset * p), 0, 0, 0));
                    barPlayView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void loadData() {
        materialishProgress.hide();
        showData();
    }

    private void showData() {

    }
}
