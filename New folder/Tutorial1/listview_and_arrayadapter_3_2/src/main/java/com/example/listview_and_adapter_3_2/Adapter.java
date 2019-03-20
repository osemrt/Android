package com.example.listview_and_adapter_3_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter extends ArrayAdapter {


    private final Context context;
    private final int resource;
    private final int[] images;
    private final String[] titles;
    private final String[] descriptions;

    public Adapter(Context context, int resource, int[] images, String[] titles, String[] descriptions) {
        super(context, resource, R.id.user_title, titles);
        this.context = context;
        this.resource = resource;
        this.images = images;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.getImageView().setImageResource(images[position]);
        viewHolder.getTextView1().setText(titles[position]);
        viewHolder.getTextView2().setText(descriptions[position]);

        return view;
    }
}
