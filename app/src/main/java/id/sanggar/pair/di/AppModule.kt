package id.sanggar.pair.di

import android.content.Context
import id.sanggar.pair.data.remote.DoaApi
import id.sanggar.pair.data.repository.DoaRepository
import id.sanggar.pair.data.repository.impl.DoaRepositoryImpl
import id.sanggar.pair.di.network.util.ErrorMessage
import id.sanggar.pair.domain.GetDoaUseCase
import id.sanggar.pair.ui.MainPresenter
import id.sanggar.pair.ui.MainPresenterContract
import id.sanggar.pair.util.AndroidCoroutineDispatchers
import id.sanggar.pair.util.CoroutineDispatchers

class AppModule constructor(
    private val context: Context
) {
    private fun provideCoroutineDispatchers(): CoroutineDispatchers {
        return AndroidCoroutineDispatchers
    }

    private fun provideDoaApi(): DoaApi {
        val network = NetworkModule(
            errorMessage = ErrorMessage(context)
        )

        val retrofit = network.provideRetrofit()
        return retrofit.create(DoaApi::class.java)
    }

    private fun provideDoaRepository(): DoaRepository {
        return DoaRepositoryImpl(provideDoaApi())
    }

    private fun provideGetDoaUseCase(): GetDoaUseCase {
        return GetDoaUseCase(provideDoaRepository())
    }

    fun provideMainPresenter(): MainPresenterContract {
        return MainPresenter(
            provideGetDoaUseCase(),
            provideCoroutineDispatchers()
        )
    }
}