package martinbzdqsm.com.parallaxscrollimageview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.RequestManager;

import martinbzdqsm.com.parallaxscrollimageview_master.ParallaxImageView;

/**
 * Created by Martin on 2016/7/11 0011.
 */
public class ListAdapter extends BaseAdapter {

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
            , R.drawable.test8
    };

    private RequestManager manager;
    private LayoutInflater mInflater;

    public ListAdapter(RequestManager manager, LayoutInflater mInflater) {
        this.manager = manager;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return ids.length;
    }

    @Override
    public Object getItem(int position) {
        return ids[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder h = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            h = new Holder();
            h.img = (ParallaxImageView) convertView.findViewById(R.id.img);
            convertView.setTag(h);
        } else {
            h = (Holder) convertView.getTag();
        }
        manager.load(ids[position]).into(h.img);
        return convertView;
    }

    static class Holder {
        private ParallaxImageView img;
    }

}


