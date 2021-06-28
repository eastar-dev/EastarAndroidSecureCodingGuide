package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding

class TextViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = TextviewActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)
        bb.setTextButton.setOnClickListener {

        }
        bb.removeTextButton.setOnClickListener {

        }
    }
}