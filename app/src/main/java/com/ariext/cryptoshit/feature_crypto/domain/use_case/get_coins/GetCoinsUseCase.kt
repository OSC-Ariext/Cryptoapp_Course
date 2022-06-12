package com.ariext.cryptoshit.feature_crypto.domain.use_case.get_coins

import com.ariext.cryptoshit.core.Resource
import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.toCoin
import com.ariext.cryptoshit.feature_crypto.domain.model.Coin
import com.ariext.cryptoshit.feature_crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}