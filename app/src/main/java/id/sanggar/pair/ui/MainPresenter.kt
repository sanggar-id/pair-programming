package id.sanggar.pair.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.sanggar.pair.base.Presenter
import id.sanggar.pair.domain.GetDoaUseCase
import id.sanggar.pair.ui.uimodel.DoaUiModel
import id.sanggar.pair.util.CoroutineDispatchers
import kotlinx.coroutines.launch

interface MainPresenterContract {
    fun onGetDoa()

    val getDoa: LiveData<DoaState>
}

class MainPresenter constructor(
    private val getDoaUseCase: GetDoaUseCase,
    dispatchers: CoroutineDispatchers,
) : Presenter(dispatchers), MainPresenterContract {

    private val _getDoa = MutableLiveData<DoaState>()
    override val getDoa: LiveData<DoaState> get() = _getDoa

    override fun onGetDoa() {
        launch {
            getDoaUseCase(Unit).onSuccess {
                _getDoa.value = DoaState.Success(it)
            }.onFailure {
                _getDoa.value = DoaState.Error(it.localizedMessage.orEmpty())
            }
        }
    }

}

sealed class DoaState {
    data class Success(val data: List<DoaUiModel>): DoaState()
    data class Error(val message: String): DoaState()
}