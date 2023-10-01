package com.example.farmhelp1

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ThankyouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thankyou)
        val webview = findViewById<WebView>(R.id.sourceweb)
        webview.loadUrl("https://github.com/SomnathNikam")

        var omg = findViewById<ImageView>(R.id.imageView7)

        Glide.with(this)
            .asGif()
            .load(R.drawable.thankyougiphy)
            .into(omg)
    }
    fun goback(view: View){
        finish()
    }
}
