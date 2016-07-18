# ParallaxScrollImageView   
[中文文档](README_cn.md "中文文档")
image parallax with listView or recylerView

![image](https://github.com/MartinBZDQSM/ParallaxScrollImageView/blob/master/app/src/main/res/raw/pre.gif)


## 1.ADD THE LIBRARY ##
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency

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

	
## 2.HOW TO USE##

### (1)Add ParallaxImageView into your layout :###
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

parallax:img_ratio ：it's preview image contrast with width 

parallax:paralax_ratio：it's parallax constrast with width

so img_ratio+paralax_ratio= height/width

parallax:orientation ：      TOP_BOTTOM,BOTTOM_TOP

### (2)Add ScrollListener :###
		Listview ：     

			parallaxListViewController = new ParallaxListViewController(R.id.img);
        		listView.setOnScrollListener(parallaxListViewController);
		
		Recylerview:(GridLayoutManager,StaggeredGridLayoutManager,LinearLayoutManager)
		
		         GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        		 mParallaxRecyclerViewController = new ParallaxRecyclerViewController(gridLayoutManager, R.id.img);
        		 mRecyclerView.setLayoutManager(gridLayoutManager);
        		 mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
        		 mRecyclerView.setAdapter(recyclerViewAdapter);
        		 
      if you want use StaggeredGridLayoutManager,you can see the sample.  		 
        		
	
