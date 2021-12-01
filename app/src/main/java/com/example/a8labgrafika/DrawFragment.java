package com.example.a8labgrafika;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class DrawFragment extends Fragment {
    private static final String ARG_PARAM1 = "number";
    String mParam1;

    public DrawFragment() {
        // Required empty public constructor
    }

    public static DrawFragment newInstance(String param1) {
        DrawFragment fragment = new DrawFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) mParam1 = getArguments().getString(ARG_PARAM1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedview = inflater.inflate(R.layout.fragment_draw, container, false);
        RelativeLayout relativeLayout = inflatedview.findViewById(R.id.draw_container);
        relativeLayout.addView(new Polygon(getActivity(), 500, 600, Float.parseFloat(getArguments().getString(ARG_PARAM1))));

        return inflatedview;
    }

    private static class Polygon extends View{
        private float x;
        private float y;
        private float sides;
        public Polygon(Context context) {
            super(context);
        }

        public Polygon(Context context, float x, float y, float sides) {
            super(context);
            this.x = x;
            this.y = y;
            this.sides = sides;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float a = ((float) Math.PI *2) / sides;
            canvas.save();
            canvas.translate(x, y);
            canvas.rotate((float) 0);
            Path path = new Path();
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.colorAccent));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            path.moveTo((float) 200, 0);
            for(int i = 1; i < sides; i++) path.lineTo((float) 200 * (float) Math.cos(a * i), (float) 200 * (float) Math.sin(a * i));
            path.close();
            canvas.drawPath(path, paint);
            Log.i("Paint", "painted " + sides);
            canvas.restore();
        }
    }
}