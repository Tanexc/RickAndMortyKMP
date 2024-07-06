package ru.tanexc.gravityfallsmultiplatform.data.remote.dto

import ru.tanexc.gravityfallsmultiplatform.domain.model.Domain

interface RemoteData {
    fun asDomain(): Domain
}