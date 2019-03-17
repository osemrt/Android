package com.example.listview_and_adapter_3;

import android.content.Context;
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


    public Adapter(Context context, int resource, String[] titles, String[] descriptions, int[] images) {
        //Why could it not completed when I put only two parameters to super? I have already set titles in the getView method.
        super(context, resource, R.id.title_textView, titles);

        this.resource = resource;
        this.context = context;

        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.template_row, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textView1 = (TextView) view.findViewById(R.id.title_textView);
        TextView textView2 = (TextView) view.findViewById(R.id.description_textView);

        imageView.setImageResource(images[position]);
        textView1.setText(titles[position]);
        textView2.setText(descriptions[position]);


        return view;
    }
}
