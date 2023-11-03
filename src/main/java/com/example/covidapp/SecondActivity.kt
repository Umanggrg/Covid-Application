package com.example.covidapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)



        item.setOnClickListener {
            val intent = Intent(this, affected::class.java)
            // start your next activity
            startActivity(intent)
        }
        btn.setOnClickListener {
            val intent = Intent(this, prev::class.java)
            // start your next activity
            startActivity(intent)
        }
        note.setOnClickListener {
            val intent = Intent(this, notes::class.java)
            // start your next activity
             startActivity(intent)
        }
        rgstr.setOnClickListener {
            val intent = Intent(this, Worldnews::class.java)
            // start your next activity
            startActivity(intent)

        }

    }
    fun goTrackCountries(view: View?) {
        startActivity(Intent(applicationContext, AffectedCountries::class.java))
    }
}