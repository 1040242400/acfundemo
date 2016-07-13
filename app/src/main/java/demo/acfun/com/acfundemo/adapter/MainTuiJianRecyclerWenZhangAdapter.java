package demo.acfun.com.acfundemo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public class MainTuiJianRecyclerWenZhangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<TuiJianEntity.Data.Contents> tuijianDataContents;
    private Integer[] bananaRankingIntegers = {R.mipmap.ic_banana_ranking_1, R.mipmap.ic_banana_ranking_2, R.mipmap.ic_banana_ranking_3};


    private OnRecyclerViewItemClickListener listener;

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int spPosition);
    }


    public MainTuiJianRecyclerWenZhangAdapter(Context context, List<TuiJianEntity.Data.Contents> entitys, OnRecyclerViewItemClickListener listener) {
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
        return new ViewHolder(mLayoutInflater.inflate(R.layout.main_recycler_wenzhang_item_item, parent, false));
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
        viewHolder.fromView.setText("/来自哪里");
        viewHolder.titleView.setText(itemEntity.getTitle());
        viewHolder.commentsView.setText(itemEntity.getVisit().getComments() + "");
        viewHolder.upName.setText("UP主：" + itemEntity.getOwner().getName());
        viewHolder.viewsView.setText(StringUtils.toWanNumberString(itemEntity.getVisit().getViews(), null));
        if (position == tuijianDataContents.size() - 1) {
            viewHolder.lineView.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.lineView.setVisibility(View.VISIBLE);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fromView, commentsView, titleView, upName, viewsView;
        private View lineView;

        public ViewHolder(View contextView) {
            super(contextView);
            titleView = (TextView) contextView.findViewById(R.id.title_view);
            fromView = (TextView) contextView.findViewById(R.id.from_view);
            commentsView = (TextView) contextView.findViewById(R.id.comments_view);
            upName = (TextView) contextView.findViewById(R.id.up_name);
            viewsView = (TextView) contextView.findViewById(R.id.views_view);
            lineView = (View) contextView.findViewById(R.id.line_view);
        }
    }


}
