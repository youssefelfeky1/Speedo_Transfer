package com.elfeky.speedo_transfer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("recipient")
data class Recipient(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id: Int = 0,
    @ColumnInfo("recipient_name")
    val recipientName:String,
    @ColumnInfo("recipient_account")
    val recipientAccount:String,
)