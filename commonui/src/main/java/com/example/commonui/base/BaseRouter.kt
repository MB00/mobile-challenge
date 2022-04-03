package com.example.commonui.base

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

open class BaseRouter {

    private var activity: WeakReference<AppCompatActivity>? = null

    fun setActivity(activity: AppCompatActivity) {
        this.activity = WeakReference(activity)
    }

    fun launchActivity(targetActivity: Class<*>, bundle: Bundle? = null) {
        activity?.get()?.apply {
            val intent = Intent(this, targetActivity)
            bundle?.let { intent.putExtras(it) }
            startActivity(intent)
        }
    }

    fun launchActivityForResult(targetActivity: Class<*>, bundle: Bundle? = null) {
        activity?.get()?.apply {
            val intent = Intent(this, targetActivity)
            bundle?.let { intent.putExtras(it) }
            startActivityForResult(intent, 0)
        }
    }

    fun openUrl(url: String) {
        var prefix = ""
        if (url.length < 8 || !url.contains("http")) {
            prefix = "https://"
        }
        activity?.get()?.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(prefix + url)))
    }

    fun finishActivity() = activity?.get()?.finish()

}