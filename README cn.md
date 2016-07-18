# ParallaxScrollImageView
用在listView 和 recylerView中的Imageview 视觉滚动差特效

![image](https://github.com/MartinBZDQSM/ParallaxScrollImageView/blob/master/app/src/main/res/raw/pre.gif)


## 1.添加库 ##
Step 1. 在你工程的根build.gradle下面添加对仓库的描述:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. 添加描述

	dependencies {
	        compile 'com.github.MartinBZDQSM:ParallaxScrollImageView:v1.0'
	}
   tips: If you already used the appcompat-v7 and recyclerview-v7 try this：

		compile 'com.android.support:appcompat-v7:' + SUPPORT_VERSION
    		compile 'com.android.support:recyclerview-v7:' + SUPPORT_VERSION
    		compile('com.github.MartinBZDQSM:ParallaxScrollImageView:v1.0')
    		{
		exclude group: 'com.android.support', module: 'appcompat-v7'
        	exclude group: 'com.android.support', module: 'recyclerview-v7'
		}

	
## 2.如何用?##

### (1)在布局文件中添加ParallaxImageView 并添加相关参数:###
```java
 <martinbzdqsm.com.parallaxscrollimageview_master.ParallaxImageView
        xmlns:parallax="http://schemas.android.com/apk/res-auto"
        android:id="@+id/img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        parallax:img_ratio="0.6"   
        parallax:orientation="bottom_top"
        parallax:paralax_ratio="0.2" />
```

parallax:img_ratio ：图片预览时所呈现的高与实际宽度的比值

parallax:paralax_ratio：图片预览时偏移距离与实际宽度的比值

所以 img_ratio+paralax_ratio= height(实际高度)/width(实际宽度)

parallax:orientation ：      TOP_BOTTOM,BOTTOM_TOP

### (2)添加滑动监控器:###
		#### Listview ：     ####

			parallaxListViewController = new ParallaxListViewController(R.id.img);
        		listView.setOnScrollListener(parallaxListViewController);
		
		#### Recylerview:(GridLayoutManager,StaggeredGridLayoutManager,LinearLayoutManager) ####
		
		         GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        		 mParallaxRecyclerViewController = new ParallaxRecyclerViewController(gridLayoutManager, R.id.img);
        		 mRecyclerView.setLayoutManager(gridLayoutManager);
        		 mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
        		 mRecyclerView.setAdapter(recyclerViewAdapter);
        		 
    Tips: StaggeredGridLayoutManager 瀑布流与其他的用法稍微有点不同,如果有需要可以看下demo如何写的	 
        		
	
