package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.EdittextActivityBinding
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = EdittextActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.setTextButton.setOnClickListener {
            val charSampleData: CharArray = charArrayOf('e', 'a', 's', 't', 'a', 'r', 'd', 'e', 'v', '1')
            bb.editText.setText(charSampleData, 0, 10)
        }

        bb.getTextButton.setOnClickListener {
            bb.editText.editableText
            bb.editText.text
        }


        bb.exit.setOnClickListener { finish() }
    }
}