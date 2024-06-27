package ru.tanexc.gravityfallsmultiplatform.data.remote

import ru.tanexc.gravityfallsmultiplatform.domain.model.Character

data class CharacterDto(
    val id: Int,
    val name: String,
    val image: String,
    val quote: String,
    val episode: String
): RemoteData {
    override fun asDomain(): Character = Character(
        id,
        name,
        image,
        quote,
        episode
    )
}