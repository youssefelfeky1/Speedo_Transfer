package com.elfeky.speedo_transfer.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elfeky.speedo_transfer.data.local.dao.FavoriteDao
import com.elfeky.speedo_transfer.data.model.Recipient

@Database(entities = [Recipient::class], version = 1, exportSchema = false)
abstract class RoomDBHelper : RoomDatabase() {

    abstract val dao: FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(c: Context): RoomDBHelper {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(c, RoomDBHelper::class.java, "MyDB")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}