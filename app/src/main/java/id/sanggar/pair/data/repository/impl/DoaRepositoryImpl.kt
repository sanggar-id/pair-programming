package id.sanggar.pair.data.repository.impl

import id.sanggar.pair.data.entity.Doa
import id.sanggar.pair.data.remote.DoaApi
import id.sanggar.pair.data.repository.DoaRepository

class DoaRepositoryImpl constructor(
    private val api: DoaApi
) : DoaRepository {
    override suspend fun invoke(): Result<List<Doa>> {
        return api.doa().map {
            it.data
        }
    }
}