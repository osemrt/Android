package com.example.listview_and_adapter_3_1;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter {


    private final Context context;
    private final int resource;
    private final String[] titles;
    private final String[] descriptions;
    private final int[] images;

    public Adapter(@NonNull Context context, int resource, String[] titles, String[] descriptions, int[] images) {
        super(context, resource, R.id.user_title, titles);

        this.context = context;
        this.resource = resource;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(resource, parent, false);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.user_imageView);
        TextView textView1 = (TextView) view.findViewById(R.id.user_title);
        TextView textView2 = (TextView) view.findViewById(R.id.user_description);

        imageView.setImageResource(images[position]);
        textView1.setText(titles[position]);
        textView2.setText(descriptions[position]);

        return view;
    }
}
