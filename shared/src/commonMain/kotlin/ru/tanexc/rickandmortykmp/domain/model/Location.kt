package ru.tanexc.rickandmortykmp.domain.model

import kotlinx.serialization.Serializable
import ru.tanexc.rickandmortykmp.data.local.entity.main.LocationEntity

@Serializable
data class Location(
    val name: String,
    val url: String
): Domain {
    override fun asDataEntity(): LocationEntity = LocationEntity(
        0, name, url
    )
}
