package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    private final String TAG = "OSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view 2, view 3, and view 4 use the layout params of the frame layout!!!!!!!!!

        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.layout, null);
        View view2 = layoutInflater.inflate(R.layout.layout,(FrameLayout)findViewById(R.id.frameLayout), true);
        View view3 = layoutInflater.inflate(R.layout.layout,(FrameLayout)findViewById(R.id.frameLayout));
        View view4 = layoutInflater.inflate(R.layout.layout,(FrameLayout)findViewById(R.id.frameLayout), false);

        Log.e(TAG, Integer.toString(R.id.frameLayout));
        Log.e(TAG, Integer.toString(R.id.linearLayout1));
        Log.e(TAG, Integer.toString(R.id.linearLayout2));
        Log.e(TAG, Integer.toString(R.id.textView));
        Log.e(TAG, "----------------");
        Log.e(TAG, Integer.toString(view1.getId()));
        Log.e(TAG, Integer.toString(view2.getId()));
        Log.e(TAG, Integer.toString(view3.getId()));
        Log.e(TAG, Integer.toString(view4.getId()));

        /*

        2019-03-16 20:05:59.199 32599-32599/? E/OSE: 2131165245
        2019-03-16 20:05:59.199 32599-32599/? E/OSE: 2131165261
        2019-03-16 20:05:59.199 32599-32599/? E/OSE: 2131165262
        2019-03-16 20:05:59.199 32599-32599/? E/OSE: 2131165322
        2019-03-16 20:05:59.199 32599-32599/? E/OSE: ----------------
        2019-03-16 20:05:59.200 32599-32599/? E/OSE: 2131165262
        2019-03-16 20:05:59.200 32599-32599/? E/OSE: 2131165245
        2019-03-16 20:05:59.200 32599-32599/? E/OSE: 2131165245
        2019-03-16 20:05:59.200 32599-32599/? E/OSE: 2131165262

         */

    }


}
