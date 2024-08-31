package ru.tanexc.rickandmortykmp.data.local.entity.main

import ru.tanexc.rickandmortykmp.domain.model.Domain

interface DataEntity {
    fun asDomain(): Domain
}