package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import android.util.Base64
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.EdittextActivityBinding

class EditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = EdittextActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.setTextButton.setOnClickListener {
            val charSampleData: CharArray = charArrayOf('e', 'a', 's', 't', 'a', 'r', 'd', 'e', 'v', '1')
            bb.editText.setText(charSampleData, 0, 10)
        }

        bb.addTextButton.setOnClickListener {
            bb.editText.text.replace(8,9,"a")
        }

        bb.getTextButton.setOnClickListener {
            val length = bb.editText.text.length
            val chars = CharArray(length)
            bb.editText.text.getChars(0, length, chars, 0)
            bb.editText.text.replace(0, length, "e")
            bb.editText.text.clear()

            val bytes = toByte(chars)
            chars.clear()
            val editTextSec = Base64.encodeToString(bytes, Base64.NO_WRAP or Base64.NO_PADDING)
            bytes.clear()
            bb.getTextButtonDesc.text = editTextSec
        }

        bb.exit.setOnClickListener { finish() }
    }
}