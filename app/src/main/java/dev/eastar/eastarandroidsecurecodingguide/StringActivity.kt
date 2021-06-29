package dev.eastar.eastarandroidsecurecodingguide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.eastarandroidsecurecodingguide.databinding.StringActivityBinding
import dev.eastar.eastarandroidsecurecodingguide.databinding.TextviewActivityBinding

class StringActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bb = StringActivityBinding.inflate(layoutInflater)
        setContentView(bb.root)

        bb.stringTest.setOnClickListener {
            val someString = "someString"
            bb.someString.text = someString

            val anotherString = StringFuncClass.anotherString(someString)
            bb.anotherString.text = anotherString
            bb.someStringAfterAnotherString.text = someString
        }

        bb.exit.setOnClickListener { finish() }
    }
}