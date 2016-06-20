package demo.acfun.com.acfundemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chen on 16/6/7.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] tabList;
    private List<Fragment> viewList;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public MainViewPagerAdapter(FragmentManager fm, String[] tabList, List<Fragment> viewList) {
        super(fm);
        this.tabList = tabList;
        this.viewList = viewList;
    }

    @Override
    public Fragment getItem(int position) {
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return tabList.length;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList[position];
    }

}
