package ce.yildiz.edu.tr.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private MainActivityViewModel mainActivityViewModel;
    private LiveData<String> myRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
    }

    private void setUp() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        myRandomNumber = mainActivityViewModel.getNumber();

        button.setOnClickListener(this);

        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
    }

    @Override
    public void onClick(View view) {
        mainActivityViewModel.createNumber();
    }
}
