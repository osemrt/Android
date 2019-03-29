package com.example.listview_and_baseadapter_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder {
    private final ImageView imageView;
    private final TextView userTitle;
    private final TextView userDescription;

    public ViewHolder(View view) {
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
        this.userTitle = (TextView) view.findViewById(R.id.user_title);
        this.userDescription = (TextView) view.findViewById(R.id.user_description);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getUserTitle() {
        return userTitle;
    }

    public TextView getUserDescription() {
        return userDescription;
    }
}
