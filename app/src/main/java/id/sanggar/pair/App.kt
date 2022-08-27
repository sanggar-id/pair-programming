package id.sanggar.pair

import android.app.Application
import id.sanggar.pair.di.AppModule

class App : Application() {

    val module by lazy(LazyThreadSafetyMode.NONE) {
        AppModule(this)
    }

}