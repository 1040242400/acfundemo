package demo.acfun.com.acfundemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public class MainTuiJianRecyclerShiPingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.Data.Contents> tuijianDataContents;

    private OnRecyclerViewItemClickListener listener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int spPosition);
    }


    public MainTuiJianRecyclerShiPingAdapter(Context context, List<TuiJianEntity.Data.Contents> entitys, OnRecyclerViewItemClickListener listener) {
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
        return new ViewHolder(mLayoutInflater.inflate(R.layout.main_recycler_shipin_item_item, parent, false));
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
        //recycler 边距 16dp item 边距 10dp 去除后布局显示不会越界
        FrameLayout.LayoutParams imgP = new FrameLayout.LayoutParams((int) ((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10)) / 2), (int) (((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10)) / 2) * 0.5625));
        viewHolder.imageView.setLayoutParams(imgP);

        DraweeController draweeController =
                Fresco.newDraweeControllerBuilder()
                        .setUri(Uri.parse(itemEntity.getImage()))
                        .setAutoPlayAnimations(true) // 设置加载图片完成后是否直接进行播放
                        .build();

        viewHolder.imageView.setController(draweeController);
//        ImageLoader.getInstance().displayImage(itemEntity.getImage(), viewHolder.imageView, ImageLoaderUtils.getOptionsRounde(context));

//        viewHolder.views.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getViews(), null));
//        viewHolder.stows.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getStows(), null));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView imageView;
        public TextView title, views, stows;

        public ViewHolder(View contextView) {
            super(contextView);
            imageView = (SimpleDraweeView) contextView.findViewById(R.id.image_view);
            title = (TextView) contextView.findViewById(R.id.title_view);
            views = (TextView) contextView.findViewById(R.id.views_view);
            stows = (TextView) contextView.findViewById(R.id.stows_view);
        }
    }


}
