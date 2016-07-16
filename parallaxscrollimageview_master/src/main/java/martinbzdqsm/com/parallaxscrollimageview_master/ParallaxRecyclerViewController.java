package martinbzdqsm.com.parallaxscrollimageview_master;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Created by Martin on 2016/5/21.
 */
public class ParallaxRecyclerViewController extends RecyclerView.OnScrollListener {
    private RecyclerView.LayoutManager layoutManager;
    private int parallaxImageViewId;

    public ParallaxRecyclerViewController(RecyclerView.LayoutManager layoutManager, int parallaxImageViewId) {
        this.layoutManager = layoutManager;
        this.parallaxImageViewId = parallaxImageViewId;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int firstVisibleItem = 0, visibleItemCount = 0;
        if (GridLayoutManager.class.isInstance(layoutManager)) {
            firstVisibleItem = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
            visibleItemCount = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition() - firstVisibleItem + 1;
        } else if (StaggeredGridLayoutManager.class.isInstance(layoutManager)) {//这里还有一些问题
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] firstVisibleItems = (staggeredGridLayoutManager).findFirstVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]);
            int[] lastVisibleItems = (staggeredGridLayoutManager).findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]);
            visibleItemCount = getMaxPosition(lastVisibleItems) - getMinPosition(firstVisibleItems);
        } else if (LinearLayoutManager.class.isInstance(layoutManager)) {
            firstVisibleItem = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            visibleItemCount = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() - firstVisibleItem + 1;
        }
        for (int i = 0, count = visibleItemCount; i < count; ++i) {
            try {
                ParallaxImageView currentImageView = (ParallaxImageView) recyclerView.getChildAt(i)
                        .findViewById(parallaxImageViewId);
                currentImageView.doWork();
            } catch (NullPointerException e) {

            }
//            ParallaxImageView currentImageView = (ParallaxImageView) recyclerView.getChildAt(i)
//                    .findViewById(parallaxImageViewId);
//            if (currentImageView != null) {
//                currentImageView.doWork();
//            }
        }
    }

    private int getMaxPosition(int[] arr) {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    private int getMinPosition(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minVal)
                minVal = arr[i];
        }
        return minVal;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }
}
