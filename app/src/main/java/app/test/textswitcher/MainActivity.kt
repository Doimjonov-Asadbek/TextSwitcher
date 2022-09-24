package app.test.textswitcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextSwitcher
import android.widget.TextView
import android.widget.ViewSwitcher
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    val strings = arrayOf("First text", "Second text", "Third text")
    var currentText = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textSwitcher = findViewById<TextSwitcher>(R.id.textSwitcher)
        val changeText = findViewById<AppCompatButton>(R.id.change_text)
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        textSwitcher.setFactory {
            val switcherTextView = TextView(this@MainActivity)
            switcherTextView.textSize = 24f
            switcherTextView.gravity = Gravity.CENTER

            switcherTextView
        }

        textSwitcher.inAnimation = inAnimation
        textSwitcher.outAnimation = outAnimation

        textSwitcher.setText(strings[currentText])

        changeText.setOnClickListener {
            if (currentText != 2)
                currentText++
            else
                currentText = 0

            textSwitcher.setText(strings[currentText])
        }


    }
}