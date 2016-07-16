package martinbzdqsm.com.parallaxscrollimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import martinbzdqsm.com.parallaxscrollimageview_master.ParallaxListViewController;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private ParallaxListViewController parallaxListViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        viewInit();
    }

    private void viewInit() {

        listView = (ListView) findViewById(R.id.listView);
        listAdapter = new ListAdapter(Glide.with(this), getLayoutInflater());
        listView.setAdapter(listAdapter);
        parallaxListViewController = new ParallaxListViewController(R.id.img);
        listView.setOnScrollListener(parallaxListViewController);

    }
}
