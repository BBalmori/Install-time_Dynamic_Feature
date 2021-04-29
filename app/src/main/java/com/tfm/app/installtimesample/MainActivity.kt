package com.tfm.app.installtimesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val manager: SplitInstallManager by lazy { SplitInstallManagerFactory.create(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        updateDynamicFeatureButtonState()

        button_app_open.setOnClickListener {
            val intent = Intent()
            intent.setClassName(BuildConfig.APPLICATION_ID, "com.tfm.app.dynamicfeature.installtime.InstallTimeActivity")
            startActivity(intent)
        }
    }

    private fun updateDynamicFeatureButtonState() {
        button_app_open.isEnabled = manager.installedModules.contains(DYNAMIC_MODULE_NAME)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val DYNAMIC_MODULE_NAME = "dynamicfeature_installtime"
    }
}