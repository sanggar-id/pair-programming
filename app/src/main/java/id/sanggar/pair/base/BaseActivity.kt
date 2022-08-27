package id.sanggar.pair.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.sanggar.pair.App
import id.sanggar.pair.di.AppModule

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var module: AppModule

    abstract fun initObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        module = (application as App).module
        initObserver()
    }

}