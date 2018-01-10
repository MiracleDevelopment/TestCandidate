package com.dev.ipati.testcandidate

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.dev.ipati.testcandidate.adapter.AdapterRecyclerMain
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity() {
    private val adapterList: AdapterRecyclerMain by lazy {
        AdapterRecyclerMain()
    }
    private val listPermission: List<String> = listOf(android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_FINE_LOCATION)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        showDropDown()
    }

    private fun showDropDown() {
        intent.extras?.let {
            val position: Int? = intent.extras.getInt("backMain")
            position?.let {
                val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this)
                alertDialog.setTitle(position.toString())
                alertDialog.setPositiveButton("OK", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        p0?.dismiss()
                    }
                })
                alertDialog.show()
            }
        }
    }

    private fun setUpRecyclerView() {
        recyclerViewListItem.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewListItem.itemAnimator = DefaultItemAnimator()
        recyclerViewListItem.adapter = adapterList
        adapterList.clickListener = { position ->
            when (position) {
                0 -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(listPermission.toTypedArray(), 1001)
                    }
                }
                1 -> {
                    val intentOne = Intent(this, DropDownActivity::class.java)
                    startActivity(intentOne)
                    finish()
                }
                2 -> {
                    val intentTwo = Intent(this, ExpandedActivity::class.java)
                    startActivity(intentTwo)
                }
                3 -> {
                    val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, 1002)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1002 -> {

            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1001 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
            }
        }
    }
}
