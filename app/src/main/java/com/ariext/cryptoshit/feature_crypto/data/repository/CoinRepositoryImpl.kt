package com.ariext.cryptoshit.feature_crypto.data.repository

import com.ariext.cryptoshit.feature_crypto.data.data_source.CoinPaprikaApi
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.CoinDetailDto
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.CoinDto
import com.ariext.cryptoshit.feature_crypto.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}