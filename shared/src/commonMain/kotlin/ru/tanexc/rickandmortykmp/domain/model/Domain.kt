package ru.tanexc.rickandmortykmp.domain.model

import ru.tanexc.rickandmortykmp.data.local.entity.main.DataEntity

interface Domain {
    fun asDataEntity(): DataEntity
}