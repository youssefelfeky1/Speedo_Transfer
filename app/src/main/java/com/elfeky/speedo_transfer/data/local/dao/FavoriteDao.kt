package com.elfeky.speedo_transfer.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.elfeky.speedo_transfer.data.model.Recipient
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Upsert
    suspend fun upsertRecipient(r: Recipient)

    @Delete
    suspend fun deleteRecipient(r: Recipient)

    @Query("SELECT * FROM recipient")
    fun getAllRecipients(): Flow<List<Recipient>>
}