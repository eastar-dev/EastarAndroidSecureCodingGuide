package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding
import java.nio.ByteBuffer
import java.nio.CharBuffer
import java.nio.charset.Charset

class TextViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = TextviewActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.setTextButton1.setOnClickListener {
            val charSampleData: CharArray = charArrayOf('e', 'a', 's', 't', 'a', 'r', 'd', 'e', 'v', '1')
            bb.sampleTextView.setText(charSampleData, 0, 10)
        }

        bb.setTextButton2.setOnClickListener {
            val charSampleData = "eastardev2"
            bb.sampleTextView.text = charSampleData
        }

        bb.setTextButton3.setOnClickListener {
            val charSampleData = byteArrayOf('e'.code.toByte(), 'a'.code.toByte(), 's'.code.toByte(), 't'.code.toByte(), 'a'.code.toByte(), 'r'.code.toByte(), 'd'.code.toByte(), 'e'.code.toByte(), 'v'.code.toByte(), '3'.code.toByte())
            bb.sampleTextView.text = String(charSampleData)
        }

        bb.removeTextButton.setOnClickListener {
            bb.sampleTextView.text = ""
        }
    }
}