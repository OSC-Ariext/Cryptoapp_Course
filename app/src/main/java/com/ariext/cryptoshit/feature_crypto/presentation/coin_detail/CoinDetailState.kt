package com.ariext.cryptoshit.feature_crypto.presentation.coin_detail

import com.ariext.cryptoshit.feature_crypto.domain.model.Coin
import com.ariext.cryptoshit.feature_crypto.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
