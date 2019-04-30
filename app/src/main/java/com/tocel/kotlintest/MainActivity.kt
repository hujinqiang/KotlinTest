package com.tocel.kotlintest

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() ,Handler.Callback{
    val content:MutableList<String> = mutableListOf()
    override fun handleMessage(msg: Message?): Boolean {
        if(content.size == 10){
            content.clear()
        }
        content.add(msg?.obj.toString())
        tv_msg.setText(content.joinToString("\n",limit = 1,truncated = ""))
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun play() {
        val job = GlobalScope.launch {
            audioStream = AudioStreamTest()
            audioStream.setOnPlayFinishListener {
                runOnUiThread {  play.isEnabled = true }
            }
            audioStream.start(this@MainActivity,resources.assets.open("test.wav"))
        }
    }

    fun play(view:View){
        play()
        play = view as Button
        play.isEnabled = false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    lateinit var play:Button

    lateinit var audioStream:AudioStreamTest
    override fun onDestroy() {
        super.onDestroy()
        audioStream?.destroy()
    }

}
