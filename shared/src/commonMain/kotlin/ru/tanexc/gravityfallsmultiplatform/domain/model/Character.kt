package ru.tanexc.gravityfallsmultiplatform.domain.model

import ru.tanexc.gravityfallsmultiplatform.data.local.CharacterEntity
import ru.tanexc.gravityfallsmultiplatform.data.remote.dto.CharacterDto

data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val quote: String,
    val episode: String

) : Domain {
    override fun asLocalData(): CharacterEntity =
        CharacterEntity(
            id, name, image, quote, episode
        )

    override fun asRemoteData(): CharacterDto =
        CharacterDto(
            id, name, image, quote, episode
        )
}
