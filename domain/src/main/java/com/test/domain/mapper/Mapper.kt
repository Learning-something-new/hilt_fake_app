package com.test.domain.mapper

interface Mapper<F, T> {

    fun convert(obj: F): T

}