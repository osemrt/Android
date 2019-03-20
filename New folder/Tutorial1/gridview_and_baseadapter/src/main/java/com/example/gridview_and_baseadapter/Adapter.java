package com.example.gridview_and_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private final Context context;
    private final int[] imageIds;
    private final String[] countrieNames;
    private final ArrayList<Country> countries;

    public Adapter(Context context) {
        this.context = context;

        this.imageIds = Image.getImages();
        this.countrieNames = context.getResources().getStringArray(R.array.countries);
        this.countries = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            this.countries.add(new Country(imageIds[i], countrieNames[i]));
        }

    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.getImageView().setImageResource(countries.get(position).getImageId());
        viewHolder.getTextView().setText(countries.get(position).getCountryName());

        //important part!! to pass image id to another activity
        viewHolder.getImageView().setTag(countries.get(position));

        return convertView;
    }
}
