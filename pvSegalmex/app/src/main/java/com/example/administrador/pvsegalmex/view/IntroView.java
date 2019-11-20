package com.example.administrador.pvsegalmex.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.BuildConfig;
import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.SliderAdapter;

public class IntroView extends AppCompatActivity {


    private ViewPager viewPager;
    LinearLayout linearLayout;
    private boolean finish = false;
    private TextView[] mDots;
    private Button btnBack, btnNext;
    private int currentPage;

    SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_view);

        linearLayout = findViewById(R.id.linearBottom);
        viewPager = findViewById(R.id.introViewPager);
        btnBack = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(viewListener);

        btnNext.setOnClickListener(v -> viewPager.setCurrentItem(currentPage + 1));
        btnBack.setOnClickListener(v -> viewPager.setCurrentItem(currentPage - 1));

    }

    public static int getFirstTimeRun(Context contexto) {
        SharedPreferences sp = contexto.getSharedPreferences("MYAPP", 0);
        int result, currentVersionCode = BuildConfig.VERSION_CODE;
        int lastVersionCode = sp.getInt("FIRSTTIMERUN", -1);
        if (lastVersionCode == -1) result = 0;
        else
            result = (lastVersionCode == currentVersionCode) ? 1 : 2;
        sp.edit().putInt("FIRSTTIMERUN", currentVersionCode).apply();
        return result;
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            // mDots[i].setGravity(Gravity.CENTER);
            mDots[i].setTextColor(getResources().getColor(R.color.white));

            linearLayout.addView(mDots[i]);


        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.blueicons));
        }


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            currentPage = i;
            if (i == 0) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(false);
                btnBack.setVisibility(View.INVISIBLE);
                btnNext.setText(getString(R.string.btnNext));
                btnBack.setText("");
                finish = false;


            } else if (i == mDots.length - 1) {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText(getString(R.string.btnStart));
                btnBack.setText(getString(R.string.btnBack));
                finish = true;
                btnNext.setOnClickListener(v -> {
                    if (finish)
                        finish();
                    else
                        viewPager.setCurrentItem(currentPage + 1);
                });


            } else {
                btnNext.setEnabled(true);
                btnBack.setEnabled(true);
                btnBack.setVisibility(View.VISIBLE);

                btnNext.setText(getString(R.string.btnNext));
                btnBack.setText(getString(R.string.btnBack));
                finish = false;

            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
