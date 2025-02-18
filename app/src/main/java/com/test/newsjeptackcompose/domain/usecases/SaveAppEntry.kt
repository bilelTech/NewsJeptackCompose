package com.test.newsjeptackcompose.domain.usecases

import com.test.newsjeptackcompose.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }

}