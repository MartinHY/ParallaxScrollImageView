package martinbzdqsm.com.parallaxscrollimageview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btList, btRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewInit();
    }

    private void viewInit() {
        findViewById(R.id.bt_list).setOnClickListener(onClickListener);
        findViewById(R.id.bt_recycler).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.bt_list:
                    intent.setClass(MainActivity.this,ListViewActivity.class);
                    break;
                case R.id.bt_recycler:
                    intent.setClass(MainActivity.this,RecyclerViewActivity.class);
                    break;
            }
            MainActivity.this.startActivity(intent);
        }
    };

}
