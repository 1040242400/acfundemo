package demo.acfun.com.acfundemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import demo.acfun.com.acfundemo.utils.DensityUtil;
import demo.acfun.com.acfundemo.utils.StringUtils;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.model.TuiJianEntity;

/**
 * Created by chen on 16/6/20.
 */
public class MainTuiJianRecyclerXiangJiaoBangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.Data.Contents> tuijianDataContents;
    private Integer[] bananaRankingIntegers = {R.mipmap.ic_banana_ranking_1, R.mipmap.ic_banana_ranking_2, R.mipmap.ic_banana_ranking_3};


    private OnRecyclerViewItemClickListener listener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int spPosition);
    }


    public MainTuiJianRecyclerXiangJiaoBangAdapter(Context context, List<TuiJianEntity.Data.Contents> entitys, OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.tuijianDataContents = entitys;
        this.listener = listener;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return tuijianDataContents.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.main_recycler_xiangjiaobang_item_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });
        TuiJianEntity.Data.Contents itemEntity = tuijianDataContents.get(position);
        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.title.setText(itemEntity.getTitle());
        FrameLayout.LayoutParams imgP = new FrameLayout.LayoutParams((int) (DensityUtil.getWindowsWidth(context) / 2.6), (int) ((DensityUtil.getWindowsWidth(context) / 2.6) * 0.5625));
        viewHolder.imageView.setLayoutParams(imgP);

        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(itemEntity.getImage()))
                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                        .build();

        viewHolder.imageView.setController(draweeController);

        viewHolder.upName.setText("UP主：" + itemEntity.getOwner().getName());
        viewHolder.bananaCout.setText(itemEntity.getVisit().getGoldBanana() + "");

        viewHolder.views.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getViews(), null));
        viewHolder.stows.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getStows(), null));
        if (tuijianDataContents.size() == bananaRankingIntegers.length) {
            viewHolder.bananaRanking.setImageResource(bananaRankingIntegers[position]);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView imageView;
        public TextView title, views, stows, upName, bananaCout;
        public ImageView bananaRanking;

        public ViewHolder(View contextView) {
            super(contextView);
            imageView = (SimpleDraweeView) contextView.findViewById(R.id.image_view);
            bananaRanking = (ImageView) contextView.findViewById(R.id.banana_ranking);
            title = (TextView) contextView.findViewById(R.id.title_view);
            views = (TextView) contextView.findViewById(R.id.views_view);
            stows = (TextView) contextView.findViewById(R.id.stows_view);
            upName = (TextView) contextView.findViewById(R.id.up_name);
            bananaCout = (TextView) contextView.findViewById(R.id.banana_count);
        }
    }


}
