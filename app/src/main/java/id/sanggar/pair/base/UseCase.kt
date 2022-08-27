package id.sanggar.pair.base

abstract class UseCase<P : Any, T> {

    abstract suspend fun execute(param: P): T

    suspend operator fun invoke(param: P): T {
        return execute(param)
    }

}