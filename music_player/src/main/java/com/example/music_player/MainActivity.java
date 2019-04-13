package com.example.music_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private MediaPlayer mediaPlayer;
    private ImageView imageView;
    private TextView textView;
    private SeekBar seekBar;
    private TextView leftTime;
    private TextView rightTime;
    private Button prevButton;
    private Button playButton;
    private Button nextButton;

    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        setSeekBar();
    }

    public void setUpUI() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music_file);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        leftTime = (TextView) findViewById(R.id.leftTime);
        rightTime = (TextView) findViewById(R.id.rightTime);
        prevButton = (Button) findViewById(R.id.prevButton);
        playButton = (Button) findViewById(R.id.playButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        leftTime.setText(simpleDateFormat.format(new Date(mediaPlayer.getCurrentPosition())));
        rightTime.setText(simpleDateFormat.format(new Date((mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));

    }

    private void setSeekBar() {
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mediaPlayer.seekTo(progress);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                leftTime.setText(simpleDateFormat.format(new Date((mediaPlayer.getCurrentPosition()))));
                rightTime.setText(simpleDateFormat.format(new Date((mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()))));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.prevButton:
                backMusic();
                break;

            case R.id.playButton:
                if (mediaPlayer.isPlaying())
                    pauseMusic();
                else
                    startMusic();
                break;

            case R.id.nextButton:
                nextMusic();
                break;
        }

    }

    private void nextMusic() {
        if (mediaPlayer != null & mediaPlayer.isPlaying())
            mediaPlayer.seekTo(0);
    }

    private void backMusic() {
        if (mediaPlayer != null & mediaPlayer.isPlaying())
            mediaPlayer.seekTo(mediaPlayer.getDuration());
    }

    public void startMusic() {
        if (mediaPlayer != null) {
            playButton.setBackgroundResource(android.R.drawable.ic_media_pause);
            mediaPlayer.start();

            thread = new Thread(this);
            thread.start();

        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            playButton.setBackgroundResource(android.R.drawable.ic_media_play);
            mediaPlayer.pause();
        }
    }

    @Override
    public void run() {

        while (mediaPlayer != null && mediaPlayer.isPlaying()) {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
        }


    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        thread.interrupt();
        thread = null;

        super.onDestroy();
    }
}
