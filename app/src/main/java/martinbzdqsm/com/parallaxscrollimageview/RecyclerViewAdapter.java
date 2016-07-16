package martinbzdqsm.com.parallaxscrollimageview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import martinbzdqsm.com.parallaxscrollimageview_master.ParallaxImageView;

/**
 * Created by Martin on 2016/7/11 0011.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private RequestManager manager;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(RequestManager manager, LayoutInflater mInflater) {
        this.manager = manager;
        this.mInflater = mInflater;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        viewHolder = new MyViewHolder(
                mInflater.inflate(R.layout.list_item, parent, false));
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return ids.length;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        manager.load(ids[position]).into(holder.parallaxImageView);
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {

        ParallaxImageView parallaxImageView;

        public MyViewHolder(View view) {
            super(view);
            parallaxImageView = (ParallaxImageView) view.findViewById(R.id.img);
        }
    }

    private int[] ids = new int[]{
            R.mipmap.test1, R.mipmap.test2, R.mipmap.test3
            , R.mipmap.test4
            , R.mipmap.test5
            , R.mipmap.test6
            , R.mipmap.test7
            , R.mipmap.test8
            , R.mipmap.test1, R.mipmap.test2, R.mipmap.test3
            , R.mipmap.test4
            , R.mipmap.test5
            , R.mipmap.test6
            , R.mipmap.test7
            , R.mipmap.test8, R.mipmap.test6
            , R.mipmap.test7
            , R.mipmap.test8
            , R.mipmap.test1, R.mipmap.test2, R.mipmap.test3
            , R.mipmap.test4, R.mipmap.test6
            , R.mipmap.test7
            , R.mipmap.test8
            , R.mipmap.test1, R.mipmap.test2, R.mipmap.test3
            , R.mipmap.test4, R.mipmap.test6
            , R.mipmap.test7
            , R.mipmap.test8
            , R.mipmap.test1, R.mipmap.test2, R.mipmap.test3
            , R.mipmap.test4
    };


}


