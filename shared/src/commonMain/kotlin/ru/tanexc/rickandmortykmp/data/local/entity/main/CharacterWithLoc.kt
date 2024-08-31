package ru.tanexc.rickandmortykmp.data.local.entity.main

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ru.tanexc.rickandmortykmp.data.local.entity.supportive.CharacterLocation
import ru.tanexc.rickandmortykmp.domain.model.Character


data class CharacterWithLoc(
    @Embedded
    val character: CharacterEntity,

    @Relation(
        parentColumn = "charId",
        entityColumn = "locId",
        associateBy = Junction(CharacterLocation::class)
    )
    val location: LocationEntity,

    @Relation(
        parentColumn = "charId",
        entityColumn = "locId",
        associateBy = Junction(CharacterLocation::class)
    )
    val origin: LocationEntity
): DataEntity {
    override fun asDomain(): Character = Character(
        character.charId,
        character.name,
        character.status,
        character.species,
        character.type,
        character.gender,
        origin.asDomain(),
        location.asDomain(),
        character.image,
        character.episode.split("( )"),
        character.url,
        character.created
    )
}