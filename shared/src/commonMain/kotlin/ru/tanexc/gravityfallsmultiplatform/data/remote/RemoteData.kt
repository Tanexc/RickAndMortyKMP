package ru.tanexc.gravityfallsmultiplatform.data.remote

import ru.tanexc.gravityfallsmultiplatform.domain.model.Domain

interface RemoteData {
    fun asDomain(): Domain
}