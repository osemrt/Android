package com.example.gridview_and_baseadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ViewHolder {
    private final ImageView imageView;
    private final TextView textView;

    public ViewHolder(View view) {
        this.imageView = (ImageView) view.findViewById(R.id.imageView);
        this.textView = (TextView) view.findViewById(R.id.textView);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }
}
