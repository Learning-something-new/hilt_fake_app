package com.test.domain.usecase

abstract class UseCase<in P, R> {

    operator fun invoke(parameters: P): R {
        return execute(parameters)
    }

    protected abstract fun execute(parameters: P): R
}