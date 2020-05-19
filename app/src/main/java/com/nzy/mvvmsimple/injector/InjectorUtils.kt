package com.nzy.mvvmsimple.injector

import com.nzy.mvvmsimple.user.UserRepository
import com.nzy.mvvmsimple.user.UserViewModelFactory

/**
 *  得到各种各样的Repository工具类
 */
object InjectorUtils {
    fun provideUserViewModelFactory(): UserViewModelFactory {
        val repository = getUserRepository()
        return UserViewModelFactory(repository)
    }

    private fun getUserRepository(): UserRepository {
        return UserRepository.getInstance()
    }


}