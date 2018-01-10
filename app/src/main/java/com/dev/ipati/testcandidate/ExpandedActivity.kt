package com.dev.ipati.testcandidate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_expanded.*
import android.view.animation.OvershootInterpolator


class ExpandedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expanded)
        expandableTextView.setAnimationDuration(750L)

        expandableTextView.setInterpolator(OvershootInterpolator())

        expandableTextView.expandInterpolator = OvershootInterpolator()
        expandableTextView.collapseInterpolator = OvershootInterpolator()

        button_toggle.setOnClickListener {
            expandableTextView.toggle()
            expandableTextView.expand()
        }
    }
}
