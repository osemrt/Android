package com.example.listview_and_adapter_3_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private final ImageView imageView;
    private final TextView textView1;
    private final TextView textView2;

    public ViewHolder(View view) {
        this.imageView = (ImageView) view.findViewById(R.id.user_imageView);
        this.textView1 = (TextView) view.findViewById(R.id.user_title);
        this.textView2 = (TextView) view.findViewById(R.id.user_description);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView1() {
        return textView1;
    }

    public TextView getTextView2() {
        return textView2;
    }
}
