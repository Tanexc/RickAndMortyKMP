package ru.tanexc.rickandmortykmp.data.local.entity.supportive

import androidx.room.Entity

@Entity(primaryKeys = ["charId", "locId"])
data class CharacterLocation(
    val charId: Long,
    val locId: Long
)