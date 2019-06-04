package com.example.thinkpad.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleBar extends RelativeLayout {
    private ImageButton imageButton_left;
    private ImageButton imageButton_right;
    private TextView textView_center;
    private RelativeLayout title_bar;
    private String titleName="TITLT";
    private int mColor=Color.BLUE;
    private int mTextColor=Color.WHITE;
    private int textSize=24;
    private Drawable mLeftDrawble=getResources().getDrawable(R.drawable.back);
    private Drawable mRightDrawble=getResources().getDrawable(R.drawable.more);
    private int mleftSize=0;
    private int mrightSize=0;
    public TitleBar(Context context) {
        super(context);


    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray=context.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        mColor=mTypedArray.getColor(R.styleable.TitleBar_backgroundColor,Color.BLUE);
        mTextColor=mTypedArray.getColor(R.styleable.TitleBar_title_bg,Color.WHITE);
        mLeftDrawble=mTypedArray.getDrawable(R.styleable.TitleBar_leftDrawble);
        mRightDrawble=mTypedArray.getDrawable(R.styleable.TitleBar_rightDrawble);
        titleName=mTypedArray.getString(R.styleable.TitleBar_title_text);
        textSize=mTypedArray.getInteger(R.styleable.TitleBar_textSize,25);
        mleftSize=mTypedArray.getInteger(R.styleable.TitleBar_leftSize,0);
        mrightSize=mTypedArray.getInteger(R.styleable.TitleBar_rightSize,0);
        initView(context);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setTitle(String text){
        textView_center.setText(text);
    }
    public void setLeftOnlickListener(OnClickListener onlickListener){
        imageButton_left.setOnClickListener(onlickListener);
    }
    public void setRightOnclickListener(OnClickListener onclickListener){
        imageButton_right.setOnClickListener(onclickListener);
    }
    public void initView(Context context){
        LayoutInflater.from(context).inflate(R.layout.title_bar,this,true);
        imageButton_left=(ImageButton)findViewById(R.id.left);
        imageButton_right=(ImageButton)findViewById(R.id.right);
        textView_center=(TextView)findViewById(R.id.title);
        title_bar=(RelativeLayout)findViewById(R.id.title_bar);
        if(mLeftDrawble!=null)
        imageButton_left.setBackground(mLeftDrawble);
        if(mRightDrawble!=null)
        imageButton_right.setBackground(mRightDrawble);
        title_bar.setBackgroundColor(mColor);
        textView_center.setText(titleName);
        textView_center.setTextColor(mTextColor);
        textView_center.setTextSize(textSize);
        ViewGroup.LayoutParams layoutParams = imageButton_left.getLayoutParams();
        if(mleftSize!=0) {
            layoutParams.height = mleftSize;
            layoutParams.width = mleftSize;
            imageButton_left.setLayoutParams(layoutParams);
        }
        if(mrightSize!=0) {
            layoutParams = imageButton_right.getLayoutParams();
            layoutParams.height = mrightSize;
            layoutParams.width = mrightSize;
            imageButton_right.setLayoutParams(layoutParams);
        }
    }
}
