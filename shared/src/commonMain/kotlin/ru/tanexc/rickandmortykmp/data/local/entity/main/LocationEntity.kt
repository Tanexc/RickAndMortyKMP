package ru.tanexc.rickandmortykmp.data.local.entity.main

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.tanexc.rickandmortykmp.domain.model.Location

@Entity
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    val locId: Long,
    val name: String,
    val url: String
): DataEntity {
    override fun asDomain() = Location(
        name, url
    )

    companion object {
        fun default() = LocationEntity(0, "", "")
    }

}