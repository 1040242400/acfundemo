package demo.acfun.com.acfundemo.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import demo.acfun.com.acfundemo.utils.LogUtils;

/**
 * view 间距
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

        //已经 赋值过的 做标记  否则会叠加辅助
        if (view.getTag() != null) {
            return;
        }
        int position = parent.getChildPosition(view);
        int left = 0, right = 0, bottom = 0, top = 0;

//        //判断 当前 view 是 左边 右边 中间
        if ((position + 1) % rowNum == 1) {
            LogUtils.d("左边＝＝＝＝");
            right = sPace / 2;

        } else if ((position + 1) % rowNum == 0) {
            LogUtils.d("右边＝＝＝＝");
            left = sPace / 2;
        } else {
            LogUtils.d("中间＝＝＝＝");
            left = sPace / 2;
            right = sPace / 2;
        }

        //判断 是否为最后一行
        int lastLineCount = count % rowNum;
        if (position + 1 <= (count - lastLineCount)) {
            bottom = sPace / 2;
        }
        top = sPace / 2;

        //已经 赋值过的 做标记  否则会叠加辅助
        view.setTag(true);
        outRect.set(left, top, right, bottom);

        LogUtils.d(position + "item 间距 == left：" + outRect.left + "===right:" + outRect.right);
    }
}
