package com.elfeky.speedo_transfer.ui.main_screen.more.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.elfeky.speedo_transfer.data.model.Recipient
import com.elfeky.speedo_transfer.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavouriteViewModel(app: Application) : AndroidViewModel(app) {

    private val favoriteRepo = FavoriteRepository(app)

    fun upsertRecipientEdit(r: Recipient) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepo.upsertRecipient(r)
        }
    }

    fun deleteRecipient(r: Recipient) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepo.deleteRecipient(r)
        }
    }


    fun selectAllRecipients(): Flow<List<Recipient>> = favoriteRepo.selectAllRecipient()
}