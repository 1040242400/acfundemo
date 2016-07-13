package demo.acfun.com.acfundemo.adapter;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import demo.acfun.com.acfundemo.utils.DensityUtil;
import demo.acfun.com.acfundemo.widget.ImageLoaderUtils;
import demo.acfun.com.acfundemo.utils.LogUtils;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.model.TuiJianEntity;
import demo.acfun.com.acfundemo.widget.ItemDecoration;

/**
 * Created by chen on 16/6/16.
 */
public class MainTuiJianRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.Data> tuijianData;
    private OnRecyclerViewItemClickListener listener;

    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int position);

        void onItemItemClick(int position, int subPosition);
    }

    public List<TuiJianEntity.Data> getTuijianData() {
        return tuijianData;
    }

    public void setTuijianData(List<TuiJianEntity.Data> tuijianData) {
        this.tuijianData = tuijianData;
    }

    public MainTuiJianRecyclerAdapter(Context context, List<TuiJianEntity.Data> entitys, OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.tuijianData = entitys;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    /**
     * 决定元素的布局使用哪种类型
     */
    @Override
    public int getItemViewType(int position) {
        return tuijianData.get(position).getType().getId();
    }

    /**
     * 渲染具体的ViewHolder
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = null;
        switch (viewType) {
            case TuiJianEntity.LunBoTuPian:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_lunbo_item, parent, false);
                return new LunBoViewHolder(contentView);
            case TuiJianEntity.ShiPing:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_shipin_item, parent, false);
                return new ShiPinViewHolder(contentView);
            case TuiJianEntity.Hengfu:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_hengfu_item, parent, false);
                return new HengFuViewHolder(contentView);
            case TuiJianEntity.XiangJiaoBang:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_xiangjiaobang_item, parent, false);
                return new XiangJiaoBangViewHolder(contentView);
            case TuiJianEntity.FanJu:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_fanju_item, parent, false);
                return new FanJuViewHolder(contentView);
            case TuiJianEntity.WenZhang:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_wenzhang_item, parent, false);
                return new WenZhangViewHolder(contentView);
            default:
                return null;
        }
    }

    /**
     * 绑定ViewHolder的数据。
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
        TuiJianEntity.Data itemEntity = tuijianData.get(position);

        if (holder instanceof LunBoViewHolder) {
            LunBoViewHolder lunBoViewHolder = (LunBoViewHolder) holder;

            HashMap<String, String> url_maps = new HashMap<String, String>();
            for (int i = 0; i < itemEntity.getContents().size(); i++) {
                url_maps.put(itemEntity.getContents().get(i).getTitle() + i, itemEntity.getContents().get(i).getImage());
            }
            lunBoViewHolder.sliderLayout.removeAllSliders();
            for (String name : url_maps.keySet()) {
                DefaultSliderView defaultSliderView = new DefaultSliderView(context);
                // initialize a SliderLayout
                defaultSliderView
                        .image(url_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                        .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                            @Override
                            public void onSliderClick(BaseSliderView slider) {
                                Toast.makeText(context, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
                            }
                        });
                //add your extra information
                defaultSliderView.bundle(new Bundle());
                defaultSliderView.getBundle()
                        .putString("extra", name);
                lunBoViewHolder.sliderLayout.addSlider(defaultSliderView);
            }

            FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) (DensityUtil.getWindowsWidth(context) * 0.39));
            lunBoViewHolder.sliderLayout.setLayoutParams(p);

        } else if (holder instanceof ShiPinViewHolder) {
            ShiPinViewHolder shiPinViewHolder = (ShiPinViewHolder) holder;
            ImageLoader.getInstance().displayImage(itemEntity.getImage(), shiPinViewHolder.titleIcon, ImageLoaderUtils.getOptionsDefault());
            shiPinViewHolder.title.setText(itemEntity.getName());
            shiPinViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            shiPinViewHolder.recyclerView.addItemDecoration(new ItemDecoration(DensityUtil.dp2px(context, 10), 2, itemEntity.getContents().size()));
            shiPinViewHolder.recyclerView.setAdapter(new MainTuiJianRecyclerShiPingAdapter(context, itemEntity.getContents()
                    , new MainTuiJianRecyclerShiPingAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int subPosition) {
                    listener.onItemItemClick(position, subPosition);
                }
            }));

            if (itemEntity.getShowMore() == 0) {
                shiPinViewHolder.line_view.setVisibility(View.GONE);
                shiPinViewHolder.more_view.setVisibility(View.GONE);
            } else {
                shiPinViewHolder.line_view.setVisibility(View.VISIBLE);
                shiPinViewHolder.more_view.setVisibility(View.VISIBLE);
                shiPinViewHolder.more.setText(itemEntity.getMenus().get(0).getName());
            }

            if (position == tuijianData.size() - 1) {
                shiPinViewHolder.line_view.setVisibility(View.GONE);
            }

        } else if (holder instanceof HengFuViewHolder) {
            HengFuViewHolder hengFuViewHolder = (HengFuViewHolder) holder;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.getWindowsWidth(context) - (DensityUtil.dp2px(context, 16) * 2), (int) ((DensityUtil.getWindowsWidth(context) - (DensityUtil.dp2px(context, 16) * 2)) * 0.2971));
            params.setMargins(DensityUtil.dp2px(context, 16), 0, DensityUtil.dp2px(context, 16), 0);
//            hengFuViewHolder.image.setLayoutParams(params);
            ImageLoader.getInstance().displayImage(itemEntity.getContents().get(0).getImage(), hengFuViewHolder.image, ImageLoaderUtils.getOptionsDefault());
            if (position == tuijianData.size() - 1) {
                hengFuViewHolder.line_view.setVisibility(View.GONE);
            }
        } else if (holder instanceof XiangJiaoBangViewHolder) {
            XiangJiaoBangViewHolder xiangJiaoBangViewHolder = (XiangJiaoBangViewHolder) holder;
            ImageLoader.getInstance().displayImage(itemEntity.getImage(), xiangJiaoBangViewHolder.titleIcon, ImageLoaderUtils.getOptionsDefault());
            xiangJiaoBangViewHolder.title.setText(itemEntity.getName());
            xiangJiaoBangViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            xiangJiaoBangViewHolder.recyclerView.setAdapter(new MainTuiJianRecyclerXiangJiaoBangAdapter(context, itemEntity.getContents()
                    , new MainTuiJianRecyclerXiangJiaoBangAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int subPosition) {
                    listener.onItemItemClick(position, subPosition);
                }
            }));

            if (itemEntity.getShowMore() == 0) {
                xiangJiaoBangViewHolder.line_view.setVisibility(View.GONE);
                xiangJiaoBangViewHolder.more_view.setVisibility(View.GONE);
            } else {
                xiangJiaoBangViewHolder.line_view.setVisibility(View.VISIBLE);
                xiangJiaoBangViewHolder.more_view.setVisibility(View.VISIBLE);
                xiangJiaoBangViewHolder.more.setText(itemEntity.getMenus().get(0).getName());
            }
            if (position == tuijianData.size() - 1) {
                xiangJiaoBangViewHolder.line_view.setVisibility(View.GONE);
            }
        } else if (holder instanceof FanJuViewHolder) {
            FanJuViewHolder fanJuViewHolder = (FanJuViewHolder) holder;
            ImageLoader.getInstance().displayImage(itemEntity.getImage(), fanJuViewHolder.titleIcon, ImageLoaderUtils.getOptionsDefault());
            fanJuViewHolder.title.setText(itemEntity.getName());
            fanJuViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
            fanJuViewHolder.recyclerView.addItemDecoration(new ItemDecoration(DensityUtil.dp2px(context, 10), 3, itemEntity.getContents().size()));
            fanJuViewHolder.recyclerView.setAdapter(new MainTuiJianRecyclerFanJuAdapter(context, itemEntity.getContents()
                    , new MainTuiJianRecyclerFanJuAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int subPosition) {
                    listener.onItemItemClick(position, subPosition);
                }
            }));

            if (itemEntity.getShowMore() == 0) {
                fanJuViewHolder.line_view.setVisibility(View.GONE);
                fanJuViewHolder.more_view.setVisibility(View.GONE);
            } else {
                fanJuViewHolder.line_view.setVisibility(View.VISIBLE);
                fanJuViewHolder.more_view.setVisibility(View.VISIBLE);
                fanJuViewHolder.more.setText(itemEntity.getMenus().get(0).getName());
            }
            if (position == tuijianData.size() - 1) {
                fanJuViewHolder.line_view.setVisibility(View.GONE);
            }
        } else if (holder instanceof WenZhangViewHolder) {
            WenZhangViewHolder wenZhangViewHolder = (WenZhangViewHolder) holder;
            ImageLoader.getInstance().displayImage(itemEntity.getImage(), wenZhangViewHolder.titleIcon, ImageLoaderUtils.getOptionsDefault());
            wenZhangViewHolder.title.setText(itemEntity.getName());
            wenZhangViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            wenZhangViewHolder.recyclerView.setAdapter(new MainTuiJianRecyclerWenZhangAdapter(context, itemEntity.getContents()
                    , new MainTuiJianRecyclerWenZhangAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(int subPosition) {
                    listener.onItemItemClick(position, subPosition);
                }
            }));

            if (itemEntity.getShowMore() == 0) {
                wenZhangViewHolder.line_view.setVisibility(View.GONE);
                wenZhangViewHolder.more_view.setVisibility(View.GONE);
            } else {
                wenZhangViewHolder.line_view.setVisibility(View.VISIBLE);
                wenZhangViewHolder.more_view.setVisibility(View.VISIBLE);
                wenZhangViewHolder.more.setText(itemEntity.getMenus().get(0).getName());
            }
            if (position == tuijianData.size() - 1) {
                wenZhangViewHolder.line_view.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return tuijianData.size();
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class LunBoViewHolder extends RecyclerView.ViewHolder {

        public SliderLayout sliderLayout;
        public PagerIndicator pagerIndicator;

        public LunBoViewHolder(View contentView) {
            super(contentView);
            sliderLayout = (SliderLayout) contentView.findViewById(R.id.slider_view);
            pagerIndicator = (PagerIndicator) contentView.findViewById(R.id.custom_indicator_view);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            sliderLayout.setCustomIndicator(pagerIndicator);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(4000);
        }
    }

    /***
     * 视频视图
     */
    public class ShiPinViewHolder extends RecyclerView.ViewHolder {
        public ImageView titleIcon;
        public LinearLayout more_view;
        public TextView title, sub_title, more;
        public RecyclerView recyclerView;
        public View line_view;

        public ShiPinViewHolder(View contentView) {
            super(contentView);
            titleIcon = (ImageView) contentView.findViewById(R.id.title_icon_view);
            title = (TextView) contentView.findViewById(R.id.title_view);
            more_view = (LinearLayout) contentView.findViewById(R.id.more_view);
            more = (TextView) contentView.findViewById(R.id.more);
            recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
            line_view = (View) contentView.findViewById(R.id.line_view);
        }
    }

    /***
     * 横幅视图
     */
    public class HengFuViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        public View line_view;

        public HengFuViewHolder(View contentView) {
            super(contentView);
            image = (ImageView) contentView.findViewById(R.id.image_view);
            line_view = (View) contentView.findViewById(R.id.line_view);
        }
    }

    /***
     * 香蕉榜视图
     */
    public class XiangJiaoBangViewHolder extends RecyclerView.ViewHolder {
        public ImageView titleIcon;
        public LinearLayout more_view;
        public TextView title, more;
        public RecyclerView recyclerView;
        public View line_view;

        public XiangJiaoBangViewHolder(View contentView) {
            super(contentView);
            titleIcon = (ImageView) contentView.findViewById(R.id.title_icon_view);
            title = (TextView) contentView.findViewById(R.id.title_view);
            more_view = (LinearLayout) contentView.findViewById(R.id.more_view);
            more = (TextView) contentView.findViewById(R.id.more);
            recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
            line_view = (View) contentView.findViewById(R.id.line_view);
        }
    }

    /***
     * 番剧视图
     */
    public class FanJuViewHolder extends RecyclerView.ViewHolder {
        public ImageView titleIcon;
        public LinearLayout more_view;
        public TextView title, more;
        public RecyclerView recyclerView;
        public View line_view;

        public FanJuViewHolder(View contentView) {
            super(contentView);
            titleIcon = (ImageView) contentView.findViewById(R.id.title_icon_view);
            title = (TextView) contentView.findViewById(R.id.title_view);
            more_view = (LinearLayout) contentView.findViewById(R.id.more_view);
            more = (TextView) contentView.findViewById(R.id.more);
            recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
            line_view = (View) contentView.findViewById(R.id.line_view);
        }
    }

    /***
     * 文章视图
     */
    public class WenZhangViewHolder extends RecyclerView.ViewHolder {
        public ImageView titleIcon;
        public LinearLayout more_view;
        public TextView title, more;
        public RecyclerView recyclerView;
        public View line_view;

        public WenZhangViewHolder(View contentView) {
            super(contentView);
            titleIcon = (ImageView) contentView.findViewById(R.id.title_icon_view);
            title = (TextView) contentView.findViewById(R.id.title_view);
            more_view = (LinearLayout) contentView.findViewById(R.id.more_view);
            more = (TextView) contentView.findViewById(R.id.more);
            recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
            line_view = (View) contentView.findViewById(R.id.line_view);
        }
    }
}
