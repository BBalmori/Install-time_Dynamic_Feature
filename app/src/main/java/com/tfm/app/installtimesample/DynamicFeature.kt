package com.tfm.app.installtimesample

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class DynamicFeature : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}