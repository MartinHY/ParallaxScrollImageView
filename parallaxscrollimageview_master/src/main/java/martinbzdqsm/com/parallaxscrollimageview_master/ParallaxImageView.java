package martinbzdqsm.com.parallaxscrollimageview_master;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by Martin on 2016/5/21.
 * Tag:2016/07/08 添加上下模式和偏移比例的设置
 */
public class ParallaxImageView extends ImageView {

    private static final String TAG = "ParallaxImageView";

    private int viewHeight, viewWidth, screenHeight, targetDis;

    private float img_ratio;//图片显示的比例

    private float parallax_ratio;//滑动总距离所占的比例

    private Orientation orientation = Orientation.BOTTOM_TOP;

    /**
     * 显示方向
     */
    public enum Orientation {
        TOP_BOTTOM,//自顶向下
        BOTTOM_TOP,//自下往上
    }

    public ParallaxImageView(Context context) {
        super(context, null);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.ParallaxImageView);
        img_ratio = mTypedArray.getFloat(R.styleable.ParallaxImageView_img_ratio, 0);
        parallax_ratio = mTypedArray.getFloat(R.styleable.ParallaxImageView_paralax_ratio, 0);
        int resouceId = mTypedArray.getInt(R.styleable.ParallaxImageView_orientation, 1);
        orientation = resouceId == 1 ? Orientation.BOTTOM_TOP : Orientation.TOP_BOTTOM;
        Log.i(TAG, "img_ratio:  " + img_ratio);
        Log.i(TAG, "parallax_ratio:  " + parallax_ratio);
        Log.i(TAG, "resouceId:  " + resouceId);
        mTypedArray.recycle();
        viewInit();

    }

    private void viewInit() {
        setScaleType(ScaleType.MATRIX);
        screenHeight = Utils.getScreenHeight(getContext());

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (img_ratio != 0) {
            setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
            int childWidthSize = getMeasuredWidth();
            int childHeightSize = getMeasuredHeight();
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
            //按比例修改宽高
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (childWidthSize * img_ratio * 1.0f), MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onDraw(Canvas paramCanvas) {
        if (getDrawable() == null || getDrawable().getMinimumWidth() == 0) {
            super.onDraw(paramCanvas);
            return;
        }
        super.onDraw(paramCanvas);
        if (getWidth() != 0) {
            viewWidth = getWidth();
            viewHeight = (int) (viewWidth * img_ratio);
            targetDis = (int) (viewWidth * parallax_ratio);
            Log.i(TAG, "targetDis  " + targetDis);
            Log.i(TAG, "tviewHeight  " + viewHeight);
            paramCanvas.save();
            int[] arrayOfInt = new int[2];
            ((ViewGroup) getParent()).getLocationOnScreen(arrayOfInt);
            int targetHeight = arrayOfInt[1] - Utils.getStatusBarHeight(getContext());
            if (targetHeight <= 0)
                targetHeight = 0;

            if (targetHeight >= screenHeight)
                targetHeight = screenHeight;

            while (true) {
                Matrix localMatrix = paramCanvas.getMatrix();
                if (getDrawable() != null) {
                    int reHeight = viewWidth * getDrawable().getMinimumHeight() / getDrawable().getMinimumWidth();

                    if (reHeight < viewHeight)
                        reHeight = viewHeight;

                    if (targetDis > (reHeight - viewHeight)) {//如果设置的滑动距离比实际滑动距离大，则进行缩放
                        float f = (viewHeight + targetDis) / reHeight;
                        Log.i(TAG, "targetDis > (n - viewHeight):  " + f);
                        localMatrix.postScale(f, f);
                        localMatrix.postTranslate(-viewWidth * (f - 1.0F) / 2.0F, getHeight() * (f - 1.0F) / 2.0F);
                    }
                }
                if (orientation == Orientation.BOTTOM_TOP) {
                    localMatrix.postTranslate(0.0F,
                            (-(targetDis / 2) - (((targetHeight - screenHeight / 2)) * targetDis) / screenHeight));
                } else {
                    localMatrix.postTranslate(0.0F,
                            (-(targetDis / 2) + (((targetHeight - screenHeight / 2)) * targetDis) / screenHeight));
                }

                paramCanvas.concat(localMatrix);
                super.onDraw(paramCanvas);
                paramCanvas.restore();
                if (targetHeight >= screenHeight - getHeight()) {
                    targetHeight = screenHeight - getHeight();
                }
                return;
            }
        }
    }

    @Override
    protected boolean setFrame(int frameLeft, int frameTop, int frameRight, int frameBottom) {
        if (getDrawable() == null) {
            return super.setFrame(frameLeft, frameTop, frameRight, frameBottom);
        }
        float frameWidth = frameRight - frameLeft;
        float originalImageWidth = (float) getDrawable().getIntrinsicWidth();
        float usedScaleFactor = frameWidth / originalImageWidth;
        Matrix matrix = getImageMatrix();
        matrix.setScale(usedScaleFactor, usedScaleFactor, 0, 0); // Replaces the
        float tanslateX = ((getDrawable().getIntrinsicWidth() * usedScaleFactor) - getWidth()) / 2;
        matrix.postTranslate(-tanslateX, 0);
        setImageMatrix(matrix);
        return super.setFrame(frameLeft, frameTop, frameRight, frameBottom);
    }

    /**
     * 这里设置比例的和必须等于高比，否则会有偏差
     *
     * @param img_ratio      设置图片比例
     * @param parallax_ratio 设置偏移总差
     */
    public void setParallax_Drawable(Drawable drawable, float img_ratio, float parallax_ratio) {
        this.img_ratio = img_ratio;
        this.parallax_ratio = parallax_ratio;
        setImageDrawable(drawable);
    }


    /**
     * 设置偏移方向，这里的方向指的是相对于向上滑动，图片偏移的方向
     *
     * @param orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        invalidate();
    }

    public void doWork() {
        invalidate();
    }
}
