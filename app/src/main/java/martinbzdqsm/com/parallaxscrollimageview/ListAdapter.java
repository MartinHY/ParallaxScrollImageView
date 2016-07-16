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
            , R.mipmap.test8
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


