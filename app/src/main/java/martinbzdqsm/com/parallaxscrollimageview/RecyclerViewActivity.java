package martinbzdqsm.com.parallaxscrollimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;

import martinbzdqsm.com.parallaxscrollimageview_master.ParallaxRecyclerViewController;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ParallaxRecyclerViewController mParallaxRecyclerViewController;
    private RadioGroup radioGroup;
    private RecyclerViewAdapter recyclerViewAdapter;
    private StaggerGridRecyclerViewAdapter staggerGridRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

//        mParallaxRecyclerViewController=new ParallaxRecyclerViewController()
        viewInit();
    }

    private void viewInit() {

        radioGroup = (RadioGroup) findViewById(R.id.mradiogroup);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(Glide.with(this), getLayoutInflater());
        staggerGridRecyclerViewAdapter = new StaggerGridRecyclerViewAdapter(Glide.with(this), getLayoutInflater());
        mRecyclerView.setAdapter(recyclerViewAdapter);
        setLinear();
    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {
                case R.id.rd_linear:
                    setLinear();
                    break;
                case R.id.rd_staggered_grid:
                    setStaggeredGrid();
                    break;
                case R.id.rd_grid:
                    setGrid();
                    break;

            }

        }
    };

    private void setStaggeredGrid() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mParallaxRecyclerViewController = new ParallaxRecyclerViewController(staggeredGridLayoutManager, R.id.img);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
        mRecyclerView.setAdapter(staggerGridRecyclerViewAdapter);
    }

    private void setGrid() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mParallaxRecyclerViewController = new ParallaxRecyclerViewController(gridLayoutManager, R.id.img);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    private void setLinear() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mParallaxRecyclerViewController = new ParallaxRecyclerViewController(linearLayoutManager, R.id.img);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

}
