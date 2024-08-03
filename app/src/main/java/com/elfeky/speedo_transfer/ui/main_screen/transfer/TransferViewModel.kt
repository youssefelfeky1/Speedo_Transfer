package com.elfeky.speedo_transfer.ui.main_screen.transfer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.elfeky.speedo_transfer.data.model.Recipient
import com.elfeky.speedo_transfer.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TransferViewModel(app: Application) : AndroidViewModel(app) {

    private val favoriteRepo = FavoriteRepository(app)

    fun upsertRecipient(r: Recipient) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepo.upsertRecipient(r)
        }
    }

    fun seletAllRecipients(): Flow<List<Recipient>> = favoriteRepo.selectAllRecipient()
}