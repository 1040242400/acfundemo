package demo.acfun.com.acfundemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.helputils.DensityUtil;
import com.android.helputils.LogUtils;
import com.lzy.okhttputils.OkHttpUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import demo.acfun.com.acfundemo.R;
import demo.acfun.com.acfundemo.entity.TuiJianEntity;

/**
 * Created by chen on 16/6/20.
 */
public class MainTuiJianRecyclerShiPingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.ContentsBean> entitys;

    private OnRecyclerViewItemClickListener listener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int spPosition);
    }


    public MainTuiJianRecyclerShiPingAdapter(Context context, List<TuiJianEntity.ContentsBean> entitys, OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.entitys = entitys;
        this.listener = listener;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return entitys.size();
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
        TuiJianEntity.ContentsBean entity = entitys.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.title.setText(entity.getTitle());

        LinearLayout.LayoutParams imgP = new LinearLayout.LayoutParams((int) ((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10)) / 2), (int) (((DensityUtil.getWindowsWidth(context) - DensityUtil.dp2px(context, 16 + 16 + 10)) / 2) * 0.5625));
        viewHolder.imageView.setLayoutParams(imgP);
        Picasso.with(context).load(entity.getImage()).into(viewHolder.imageView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;

        public ViewHolder(View contextView) {
            super(contextView);
            imageView = (ImageView) contextView.findViewById(R.id.image_view);
            title = (TextView) contextView.findViewById(R.id.title);
        }
    }


}
