package ce.yildiz.edu.tr.recyclerview.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Random;

import ce.yildiz.edu.tr.recyclerview.R;
import ce.yildiz.edu.tr.recyclerview.adapters.MonsterAdapter;
import ce.yildiz.edu.tr.recyclerview.models.Monster;
import ce.yildiz.edu.tr.recyclerview.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MonsterAdapter monsterAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

    }

    private void setUp() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        initViewModel();
        initRecyclerView();
        initFloatingActionBar();

    }


    private void initViewModel() {
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();

        mainActivityViewModel.getMonsters().observe(this, new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsterList) {
                monsterAdapter.notifyDataSetChanged();
            }
        });

        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    showProgressBar();
                } else {
                    hideProgressBar();
                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getMonsters().getValue().size() - 1);
                }
            }
        });

    }


    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        monsterAdapter = new MonsterAdapter(this, mainActivityViewModel.getMonsters().getValue());
        recyclerView.setAdapter(monsterAdapter);
    }


    private void initFloatingActionBar() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.addNewValue(
//                        new Monster(
//                                "New Monster",
//                                "New Monster Description",
//                                "https://images.vexels.com/media/users/3/157788/isolated/preview/939c4e78a3a86769f6183946a2183847-monster-doodle-by-vexels.png"
//                        )
                        mainActivityViewModel.getMonsters().getValue().get(new Random().nextInt(12))

                );
            }
        });
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

}
