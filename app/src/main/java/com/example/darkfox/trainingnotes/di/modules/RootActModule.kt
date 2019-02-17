package com.example.darkfox.trainingnotes.di.modules

import com.example.darkfox.trainingnotes.arch.domain.root.IRootInteractor
import com.example.darkfox.trainingnotes.arch.domain.root.RootInteractor
import com.example.darkfox.trainingnotes.arch.ui.root.navigation.RootRouter
import com.example.darkfox.trainingnotes.arch.ui.root.viewModel.IRootViewModel
import com.example.darkfox.trainingnotes.arch.ui.root.viewModel.RootViewModel
import com.example.darkfox.trainingnotes.utils.enums.KoinScopes
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object RootActModule {

    private val scopeName = KoinScopes.ROOT_ACT.scopeName

    val module = module {
        scope(scopeName){ RootRouter() }
        scope<IRootInteractor>(scopeName){ RootInteractor() }
        viewModel{ RootViewModel(get(),get()) }
    }

}