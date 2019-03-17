package com.example.listview_and_baseadapter_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {


    private final Context context;
    private final ArrayList<Person> personArrayList;
    private final String[] titles;
    private final String[] descriptions;
    private final int[] images;


    public Adapter(Context context) {
        this.context = context;
        personArrayList = new ArrayList<>();

        this.titles = context.getResources().getStringArray(R.array.titles);
        this.descriptions = context.getResources().getStringArray(R.array.descriptions);
        this.images = Image.getImages();

        for (int i = 0; i < 160; i++) {
            personArrayList.add(new Person(images[i], titles[i], descriptions[i]));
        }


    }

    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        //if you code them separately, how do you decide the returned value? [images?, titles?, descriptions?]
        return personArrayList.get(position);
    }

    //the function below is related to the database, we will see it!
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(context.getResources().getLayout(R.layout.single_row), parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.getImageView().setImageResource(personArrayList.get(position).getImage());
        viewHolder.getUserTitle().setText(personArrayList.get(position).getTitle());
        viewHolder.getUserDescription().setText(personArrayList.get(position).getDescription());


        return convertView;
    }
}
