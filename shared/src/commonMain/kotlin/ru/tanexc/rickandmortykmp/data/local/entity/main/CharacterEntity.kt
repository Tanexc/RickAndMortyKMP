package ru.tanexc.rickandmortykmp.data.local.entity.main

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.tanexc.rickandmortykmp.domain.model.Character

@Entity
data class CharacterEntity(
    @PrimaryKey
    val charId: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val episode: String,
    val url: String,
    val created: String
) : DataEntity {
    override fun asDomain(): Character = Character(
        charId,
        name,
        status,
        species,
        type,
        gender,
        LocationEntity.default().asDomain(),
        LocationEntity.default().asDomain(),
        image,
        episode.split("( )"),
        url,
        created
    )

}