package com.example.media_player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {

    private Button button;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        //mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(this, R.raw.music_file);
        mediaPlayer.setOnCompletionListener(this);

        Toast.makeText(this, Integer.toString(mediaPlayer.getDuration() / 1000), Toast.LENGTH_LONG).show();

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
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
        if (mediaPlayer.isPlaying())
            pauseMusic();
        else
            playMusic();

    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            button.setText("Play");
        }

    }

    public void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            button.setText("Pause");
        }
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this, "The end of the music", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
            super.onDestroy();
    }




}
