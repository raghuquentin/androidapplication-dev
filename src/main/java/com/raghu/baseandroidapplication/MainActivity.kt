package com.raghu.baseandroidapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* var button = findViewById<Button>(R.id.playButton)
        button.setOnClickListener{
            mediaPlayer.start()
        }*/
        var playButton = findViewById<FloatingActionButton>(R.id.btPlay)
        var pauseButton = findViewById<FloatingActionButton>(R.id.btPause)
        var stopButton = findViewById<FloatingActionButton>(R.id.btStop)

        playButton.setOnClickListener{
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this,R.raw.malligaiye)
            }
            mediaPlayer?.start()
        }
        pauseButton.setOnClickListener{
            mediaPlayer?.pause()
        }
        stopButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
        }

    }
}