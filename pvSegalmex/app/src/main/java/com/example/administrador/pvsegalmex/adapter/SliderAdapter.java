package com.example.administrador.pvsegalmex.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrador.pvsegalmex.R;

//Muestra en secciones intro de la aplicacion
public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_images =
            {
                    R.drawable.barcodescanm,
                    R.drawable.printer,
                    R.drawable.store
            };

    public String[] slide_headings =
            {
                    "Escánea",
                    "Imprime",
                    "Adaptable"
            };
    public String[] slide_text =
            {
                    "Agrega productos y  obtén información completa" + '\n' + "mediante el escáner",
                    "Brinda tickets impresos",
                    "Personaliza tu Punto Cytruss"
            };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideImageView = view.findViewById(R.id.imagenIntro);
        TextView slideHeading = view.findViewById(R.id.tvHeading);
        TextView slideText = view.findViewById(R.id.tvText);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideText.setText(slide_text[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}