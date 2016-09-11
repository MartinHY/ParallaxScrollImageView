package martinbzdqsm.com.parallaxscrollimageview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;

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
            R.drawable.test1, R.drawable.test2, R.drawable.test3
            , R.drawable.test4
            , R.drawable.test5
            , R.drawable.test6
            , R.drawable.test7
            , R.drawable.test8
            , R.drawable.test1, R.drawable.test2, R.drawable.test3
            , R.drawable.test4
            , R.drawable.test5
            , R.drawable.test6
            , R.drawable.test7
            , R.drawable.test8, R.drawable.test6
            , R.drawable.test7
            , R.drawable.test8
            , R.drawable.test1, R.drawable.test2, R.drawable.test3
            , R.drawable.test4, R.drawable.test6
            , R.drawable.test7
            , R.drawable.test8
            , R.drawable.test1, R.drawable.test2, R.drawable.test3
            , R.drawable.test4, R.drawable.test6
            , R.drawable.test7
            , R.drawable.test8
            , R.drawable.test1, R.drawable.test2, R.drawable.test3
            , R.drawable.test4
    };


}


