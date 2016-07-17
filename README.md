# ParallaxScrollImageView
image parallax with listView or recylerView

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
    		compile('com.github.MartinBZDQSM:ParallaxScrollImageView:v1.0') {
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

must set id like ：R.id.img

parallax:img_ratio ：it's preview image contrast with width 

parallax:paralax_ratio：it's parallax constrast with width

so img_ratio+paralax_ratio= height/width

parallax:orientation ：      TOP_BOTTOM,BOTTOM_TOP

### (2)Add ScrollListener :###
		Listview：     
		
			parallaxListViewController = new ParallaxListViewController(R.id.img);
        		listView.setOnScrollListener(parallaxListViewController);
	
		Recylerview:

		       StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        	       mParallaxRecyclerViewController = new ParallaxRecyclerViewController(staggeredGridLayoutManager, R.id.img);
        	       mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
	 	       mRecyclerView.addOnScrollListener(mParallaxRecyclerViewController);
	
