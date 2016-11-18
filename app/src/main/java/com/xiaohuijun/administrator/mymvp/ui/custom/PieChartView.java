package com.xiaohuijun.administrator.mymvp.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * 作者：${xiaohuijun} on 2016/11/17 14:06
 * 邮箱：xiaohuijun1992@163.com
 */
public class PieChartView extends View{
    private ItemTypeListener itemTypeListener;
    private Paint paint;
    private Paint textPaint;
    private int mWidth,mHeight;
    private ArrayList<PieData> pieDatas;
    private int mStartAngle = 0;
    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public PieChartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private void initPaint(){
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        if(pieDatas == null || pieDatas.size()<=0)
            return;
        float currentStartAngle = mStartAngle;                    // 当前起始角度
        canvas.translate(mWidth / 2, mHeight / 2);                // 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);  // 饼状图半径
        RectF rect = new RectF(-r, -r, r, r);                     // 饼状图绘制区域

        for (PieData pie:pieDatas) {
            paint.setColor(pie.color());
            canvas.drawArc(rect, currentStartAngle, pie.angle(), true, paint);
            currentStartAngle += pie.angle();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return super.onTouchEvent(event);
    }

    // 设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();   // 刷新
    }

    public PieChartView setData(ArrayList<PieData> pieDatas){
        this.pieDatas = pieDatas;
        initData();
        invalidate();
        return this;
    }

    private void initData(){
        if(pieDatas == null || pieDatas.size()<=0)
            return;
        float count = 0;
        for (PieData pieData:pieDatas){
            count = count+pieData.value();
        }
        for(PieData pieData:pieDatas){
            float percent = pieData.value()/count;
             pieData.Bulider().percent(percent);
             pieData.Bulider().angle(percent*360);
        }
    }
    public PieChartView setItemTypeListener(ItemTypeListener itemTypeListener){
        this.itemTypeListener = itemTypeListener;
        return this;
    }
}
