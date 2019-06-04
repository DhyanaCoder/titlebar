package com.example.thinkpad.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomViewOne extends View {
    private  int lastX,lastY;
    private Scroller mScroller;
    public CustomViewOne(Context context) {
        super(context);

    }

    public CustomViewOne(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomViewOne(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }
    @Override
    public void computeScroll(){
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int delta=destX-scrollX;
        mScroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x=(int) event.getX();
        int y=(int) event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX=x-lastX;
                int offsetY=y-lastY;
                /**layout 方法
                 * layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);**/
                /**offsetLeftAndRight() offsetTopAndBottom()方法
                 offsetLeftAndRight(offsetX);
                 offsetTopAndBottom(offsetY);*/
                /**LayoutParams方法() 改变布局参数
                LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin=getLeft()+offsetX;
                layoutParams.topMargin=getTop()+offsetY;
                setLayoutParams(layoutParams);**/
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
             case MotionEvent.ACTION_UP:

        }
        return true;
    }
}
