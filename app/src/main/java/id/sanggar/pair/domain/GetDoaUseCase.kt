package id.sanggar.pair.domain

import id.sanggar.pair.base.UseCase
import id.sanggar.pair.data.repository.DoaRepository
import id.sanggar.pair.ui.uimodel.DoaUiModel

class GetDoaUseCase constructor(
    private val repository: DoaRepository
) : UseCase<Unit, Result<List<DoaUiModel>>>() {

    override suspend fun execute(param: Unit): Result<List<DoaUiModel>> {
        return repository().map {
            it.map { doa ->
                DoaUiModel(
                    name = doa.name,
                    doa = doa.latin,
                    translation = doa.translation,
                )
            }
        }
    }

}