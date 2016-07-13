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

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.model.TuiJianEntity;
import demo.acfun.com.acfundemo.utils.DensityUtil;
import demo.acfun.com.acfundemo.utils.StringUtils;

/**
 * Created by chen on 16/6/20.
 */
public class MainTuiJianRecyclerFanJuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.Data.Contents> tuijianDataContents;
    private Integer[] bananaRankingIntegers = {R.mipmap.ic_banana_ranking_1, R.mipmap.ic_banana_ranking_2, R.mipmap.ic_banana_ranking_3};


    private OnRecyclerViewItemClickListener listener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int spPosition);
    }


    public MainTuiJianRecyclerFanJuAdapter(Context context, List<TuiJianEntity.Data.Contents> entitys, OnRecyclerViewItemClickListener listener) {
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
        return new ViewHolder(mLayoutInflater.inflate(R.layout.main_recycler_fanju_item_item, parent, false));
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
        viewHolder.subTitle.setText("更新至" + itemEntity.getLatestBangumiVideo().getTitle());
        //recycler 边距 16dp item 边距 10dp 去除后布局显示不会越界
        FrameLayout.LayoutParams imgP = new FrameLayout.LayoutParams((int) ((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10 + 10)) / 3), (int) (((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10 + 10)) / 3) * 1.333));
        viewHolder.imageView.setLayoutParams(imgP);

        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(itemEntity.getImage()))
                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                        .build();

        viewHolder.imageView.setController(draweeController);
        viewHolder.stows.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getStows(), null) + "人追");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView imageView;
        public TextView title, subTitle, stows;

        public ViewHolder(View contextView) {
            super(contextView);
            imageView = (SimpleDraweeView) contextView.findViewById(R.id.image_view);
            title = (TextView) contextView.findViewById(R.id.title_view);
            subTitle = (TextView) contextView.findViewById(R.id.sub_title_view);
            stows = (TextView) contextView.findViewById(R.id.stows_view);
        }
    }


}
