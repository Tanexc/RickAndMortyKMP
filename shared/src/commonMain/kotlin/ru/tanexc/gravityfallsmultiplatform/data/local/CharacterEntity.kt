package ru.tanexc.gravityfallsmultiplatform.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val quote: String,
    val episode: String
) : LocalData {
    override fun asDomain(): Character = Character(
        id, name, image, quote, episode
    )

}