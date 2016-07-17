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
	
## 2.HOW TO USE##

Add ParallaxImageView into your layout :
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

