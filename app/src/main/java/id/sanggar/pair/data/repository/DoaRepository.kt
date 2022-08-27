package id.sanggar.pair.data.repository

import id.sanggar.pair.data.entity.Doa

interface DoaRepository {
    suspend operator fun invoke(): Result<List<Doa>>
}