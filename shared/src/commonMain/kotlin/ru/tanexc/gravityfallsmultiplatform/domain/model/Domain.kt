package ru.tanexc.gravityfallsmultiplatform.domain.model

import ru.tanexc.gravityfallsmultiplatform.data.local.LocalData
import ru.tanexc.gravityfallsmultiplatform.data.remote.dto.RemoteData

interface Domain {
    fun asLocalData(): LocalData

    fun asRemoteData(): RemoteData
}