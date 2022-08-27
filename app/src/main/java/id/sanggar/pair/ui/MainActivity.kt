package id.sanggar.pair.ui

import android.os.Bundle
import id.sanggar.pair.R
import id.sanggar.pair.base.BaseActivity
import id.sanggar.pair.ui.uimodel.DoaUiModel

class MainActivity : BaseActivity() {

    private val presenter: MainPresenterContract by lazy {
        module.provideMainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onGetDoa()
    }

    override fun initObserver() {
        presenter.getDoa.observe(this) {

        }
    }

}