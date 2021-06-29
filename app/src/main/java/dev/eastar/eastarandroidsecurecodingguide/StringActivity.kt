package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding

class StringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = TextviewActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.setTextButton1.setOnClickListener {
            val someString = "someString"
            val anotherString = anotherFunc(someString)

            bb.someString.text = someString
            bb.anotherString.text = anotherString
        }

        bb.exit.setOnClickListener { finish() }
    }

    fun anotherFunc(someString: String): String {
        val someString = "anotherText"
        return someString
    }
}