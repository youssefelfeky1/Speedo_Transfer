package com.elfeky.speedo_transfer.repository

import android.content.Context
import com.elfeky.speedo_transfer.data.local.RoomDBHelper
import com.elfeky.speedo_transfer.data.model.Recipient
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(context: Context) {

    private val db = RoomDBHelper.getInstance(context)

    suspend fun upsertRecipient(r: Recipient) {
        db.dao.upsertRecipient(r)
    }

    suspend fun deleteRecipient(r: Recipient) {
        db.dao.deleteRecipient(r)
    }

    fun selectAllRecipient(): Flow<List<Recipient>> = db.dao.getAllRecipients()
}