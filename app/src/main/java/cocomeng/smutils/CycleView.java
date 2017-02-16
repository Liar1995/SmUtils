package cocomeng.smutils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sunmeng on 2/16/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

public class CycleView  extends View {
    Paint mPaint = new Paint();
    public CycleView(Context context) {
        this(context, null);
    }

    public CycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100,100,50,mPaint);
    }
}