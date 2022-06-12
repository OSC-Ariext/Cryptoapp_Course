package com.ariext.cryptoshit.feature_crypto.domain.use_case.get_coin

import com.ariext.cryptoshit.core.Resource
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.toCoin
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.toCoinDetail
import com.ariext.cryptoshit.feature_crypto.domain.model.Coin
import com.ariext.cryptoshit.feature_crypto.domain.model.CoinDetail
import com.ariext.cryptoshit.feature_crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}