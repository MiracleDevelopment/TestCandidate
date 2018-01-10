package com.dev.ipati.testcandidate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.dev.ipati.testcandidate.adapter.AdapterDropDown
import kotlinx.android.synthetic.main.activity_drop_down.*

class DropDownActivity : AppCompatActivity() {
    private val adapterDropdown: AdapterDropDown by lazy {
        AdapterDropDown()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_down)

        recyclerViewDropdown.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewDropdown.itemAnimator = DefaultItemAnimator()
        recyclerViewDropdown.adapter = adapterDropdown
        adapterDropdown.onClickListener = { position: Int ->
            val intentMain = Intent(this, MainActivity::class.java)
            intentMain.putExtra("backMain", position + 1)
            startActivity(intentMain)
            finish()
        }
    }
}
