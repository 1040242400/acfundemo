package demo.acfun.com.acfundemo.adapter;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import demo.acfun.com.acfundemo.utils.LogUtils;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.entity.TuiJianEntity;

/**
 * Created by chen on 16/6/16.
 */
public class MainTuiJianRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity> entitys;
    private OnRecyclerViewItemClickListener listener;

    private boolean loadImg = true;

    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int position);

        void onItemItemClick(int position, int subPosition);
    }

    public MainTuiJianRecyclerAdapter(Context context, List<TuiJianEntity> entitys, OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.entitys = entitys;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    /**
     * 决定元素的布局使用哪种类型
     */
    @Override
    public int getItemViewType(int position) {
        return entitys.get(position).getType().getId();
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
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_shipin_item, parent, false);
                return new XiangJiaoBangViewHolder(contentView);
            case TuiJianEntity.FanJu:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_shipin_item, parent, false);
                return new FanJuViewHolder(contentView);
            case TuiJianEntity.WenZhang:
                contentView = mLayoutInflater.inflate(R.layout.main_recycler_shipin_item, parent, false);
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
        TuiJianEntity itemEntity = entitys.get(position);

        if (holder instanceof LunBoViewHolder) {
            LunBoViewHolder lunBoViewHolder = (LunBoViewHolder) holder;

            if (loadImg) {
                HashMap<String, String> url_maps = new HashMap<String, String>();
                for (int i = 0; i < itemEntity.getContents().size(); i++) {
                    url_maps.put(itemEntity.getContents().get(i).getTitle() + i, itemEntity.getContents().get(i).getImage());
                }

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
                loadImg = false;
            }

            FrameLayout.LayoutParams p = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) (DensityUtil.getWindowsWidth(context) * 0.39));
            lunBoViewHolder.sliderLayout.setLayoutParams(p);

        } else if (holder instanceof ShiPinViewHolder) {
            ShiPinViewHolder shiPinViewHolder = (ShiPinViewHolder) holder;
            Picasso.with(context).load(itemEntity.getImage()).into(shiPinViewHolder.titleIcon);
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

            if (itemEntity.getMenuBean() == null) {
                shiPinViewHolder.more.setVisibility(View.GONE);
            } else {
                shiPinViewHolder.more.setVisibility(View.VISIBLE);
                shiPinViewHolder.more.setText(itemEntity.getMenuBean().getName());
            }

            if (position < getItemCount() - 1) {
                if (entitys.get(position + 1).getType().getId() == TuiJianEntity.Hengfu) {
                    shiPinViewHolder.mar_view.setVisibility(View.GONE);
                } else {
                    shiPinViewHolder.mar_view.setVisibility(View.VISIBLE);
                }
            }

        } else if (holder instanceof HengFuViewHolder) {
            HengFuViewHolder hengFuViewHolder = (HengFuViewHolder) holder;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) ((DensityUtil.getWindowsWidth(context) - (DensityUtil.dp2px(context, 16) * 2)) * 0.2971));
//            hengFuViewHolder.image.setLayoutParams(params);
            Picasso.with(context).load(itemEntity.getContents().get(0).getImage()).into(hengFuViewHolder.image);
        } else if (holder instanceof XiangJiaoBangViewHolder) {
            XiangJiaoBangViewHolder xiangJiaoBangViewHolder = (XiangJiaoBangViewHolder) holder;
        } else if (holder instanceof FanJuViewHolder) {
            FanJuViewHolder fanJuViewHolder = (FanJuViewHolder) holder;
        } else if (holder instanceof WenZhangViewHolder) {
            WenZhangViewHolder wenZhangViewHolder = (WenZhangViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return entitys.size();
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
        public TextView title, more;
        public RecyclerView recyclerView;
        public View mar_view;

        public ShiPinViewHolder(View contentView) {
            super(contentView);
            titleIcon = (ImageView) contentView.findViewById(R.id.title_icon_view);
            title = (TextView) contentView.findViewById(R.id.title_view);
            more = (TextView) contentView.findViewById(R.id.more_view);
            recyclerView = (RecyclerView) contentView.findViewById(R.id.recycler_view);
            mar_view = (View) contentView.findViewById(R.id.mar_view);
        }
    }

    /***
     * 横幅视图
     */
    public class HengFuViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        public View mar_view;

        public HengFuViewHolder(View contentView) {
            super(contentView);
            image = (ImageView) contentView.findViewById(R.id.image_view);
            mar_view = (View) contentView.findViewById(R.id.mar_view);
        }
    }

    /***
     * 香蕉榜视图
     */
    public class XiangJiaoBangViewHolder extends RecyclerView.ViewHolder {

        public XiangJiaoBangViewHolder(View view) {
            super(view);
        }
    }

    /***
     * 番剧视图
     */
    public class FanJuViewHolder extends RecyclerView.ViewHolder {

        public FanJuViewHolder(View view) {
            super(view);
        }
    }

    /***
     * 文章视图
     */
    public class WenZhangViewHolder extends RecyclerView.ViewHolder {

        public WenZhangViewHolder(View view) {
            super(view);
        }
    }

    /**
     * 视频间距
     */
    public class ItemDecoration extends RecyclerView.ItemDecoration {
        private int sPace;
        private int rowNum;
        private int count;

        public ItemDecoration(int sPace, int rowNum, int count) {
            this.sPace = sPace;
            this.rowNum = rowNum;
            this.count = count;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            int left = 0, right = 0, bottom = 0, top = 0;

            int position = parent.getChildPosition(view);
            if ((position + 1) % 2 == 0) {
                left = sPace / 2;
            } else {
                right = sPace / 2;
            }

            int lastLineCount = count % rowNum;
            if (position + 1 <= (count - lastLineCount)) {
                bottom = sPace / 2;
            }

            if (view.getTag() == null) {
                view.setTag(true);
                outRect.set(left, top, right, bottom);
            }

            LogUtils.d(position + "item 间距 == left：" + outRect.left + "===right:" + outRect.right + "===bottom:" + outRect.bottom);
        }
    }
}
