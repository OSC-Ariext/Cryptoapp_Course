package com.ariext.cryptoshit.feature_crypto.domain.repository

import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.CoinDetailDto
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}