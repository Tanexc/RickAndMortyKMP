package ru.tanexc.gravityfallsmultiplatform.data.local

import ru.tanexc.gravityfallsmultiplatform.domain.model.Domain

interface LocalData {
    fun asDomain(): Domain
}