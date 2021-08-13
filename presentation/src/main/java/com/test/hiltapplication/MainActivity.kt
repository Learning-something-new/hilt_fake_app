package com.test.hiltapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.hiltapplication.search_books.SearchBooksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchBooksFragment())
            .commit()
    }
}