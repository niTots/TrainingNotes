package com.example.darkfox.trainingnotes.arch.mocked

import android.app.Activity
import com.example.darkfox.trainingnotes.arch.domain.splash.ISplashInteractor
import com.example.darkfox.trainingnotes.arch.repository.local.LocalRepository
import com.example.darkfox.trainingnotes.dto.Account
import com.example.darkfox.trainingnotes.dto.ReadWriteStoragePermission
import com.example.darkfox.trainingnotes.utils.permission.PermissionHelper
import kotlinx.coroutines.delay

class MockedSplashInteractor(private val localRepository: LocalRepository<Account>,
                             private val permissionLocalRepository: LocalRepository<ReadWriteStoragePermission>,
                             private val permissionHelper: PermissionHelper) : ISplashMockedInteractor {

    override suspend fun loadUser(success: (Account) -> Unit, error: (Exception) -> Unit) {
        delay(2000)
        localRepository.restore(success, error)
    }

    override fun savePermissions(permission: ReadWriteStoragePermission) {
        permissionLocalRepository.save(permission)
    }

    override fun attemptRequestPermissions(activity: Activity, success: () -> Unit) {
        permissionHelper
                .addOnPermissionGrantedListener { write, read ->
                    permissionLocalRepository.save(ReadWriteStoragePermission(write, read))
                }
                .attemptRequestPermissions(activity)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        permissionHelper.onRequestPermissionsResult(requestCode, grantResults)
    }
}