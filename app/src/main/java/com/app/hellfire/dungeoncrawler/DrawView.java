package com.app.hellfire.dungeoncrawler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin.rogers on 7/24/2015.
 */
public class DrawView extends View implements View.OnTouchListener{

    Paint paint = new Paint();
    List<Point> points = new ArrayList<Point>();

    public DrawView(Context context)
    {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        paint.setColor(Color.WHITE);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        for (Point point: points)
        {
            canvas.drawCircle(point.x, point.y, 5, paint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Point point = new Point();
        point.set((int)event.getX(),(int)event.getY());
        points.add(point);
        return false;
    }
}
