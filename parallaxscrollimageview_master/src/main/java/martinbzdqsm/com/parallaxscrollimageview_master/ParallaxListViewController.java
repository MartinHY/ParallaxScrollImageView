package martinbzdqsm.com.parallaxscrollimageview_master;

import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by Martin on 2016/5/21.
 */
public class ParallaxListViewController implements ListView.OnScrollListener {
    private int parallaxImageViewId;

    public ParallaxListViewController(int parallaxImageViewId) {
        this.parallaxImageViewId = parallaxImageViewId;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (visibleItemCount > 0) {
            for (int i = 0, count = visibleItemCount; i < count; ++i) {
                ParallaxImageView currentImageView = (ParallaxImageView) view.getChildAt(i)
                        .findViewById(parallaxImageViewId);
                if (currentImageView != null) {
                    currentImageView.doWork();
                }
            }
        }

    }
}