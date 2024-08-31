package ru.tanexc.rickandmortykmp.domain.model

import kotlinx.serialization.Serializable
import ru.tanexc.rickandmortykmp.data.local.entity.main.CharacterEntity

@Serializable
data class Character(
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : Domain {
    override fun asDataEntity(): CharacterEntity =
        CharacterEntity(
            id,
            name,
            status,
            species,
            type,
            gender,
            image,
            episode.joinToString("( )"),
            url,
            created
        )

}
