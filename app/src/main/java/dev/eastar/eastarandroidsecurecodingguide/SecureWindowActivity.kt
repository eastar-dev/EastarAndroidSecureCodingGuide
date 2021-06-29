package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.SecureWindowActivityBinding
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding

class SecureWindowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = SecureWindowActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.addFlagSecure.setOnClickListener {
            window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }

        bb.clearFlagSecure.setOnClickListener {
            window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
        }

        bb.exit.setOnClickListener { finish() }
    }
}