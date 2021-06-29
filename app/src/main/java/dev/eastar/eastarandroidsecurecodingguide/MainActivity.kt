package dev.eastar.eastarandroidsecurecodingguide

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.setTextSample.setOnClickListener { startActivity(Intent(this, TextViewActivity::class.java)) }
        bb.getTextSample.setOnClickListener { startActivity(Intent(this, EditTextActivity::class.java)) }
        bb.stringSample.setOnClickListener { startActivity(Intent(this, StringActivity::class.java)) }
        bb.secureWindowSample.setOnClickListener { startActivity(Intent(this, SecureWindowActivity::class.java)) }
    }
}