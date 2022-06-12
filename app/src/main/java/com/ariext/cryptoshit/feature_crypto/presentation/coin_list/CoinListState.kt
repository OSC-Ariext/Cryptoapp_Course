package com.ariext.cryptoshit.feature_crypto.presentation.coin_list

import com.ariext.cryptoshit.feature_crypto.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
