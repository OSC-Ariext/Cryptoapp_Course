package com.ariext.cryptoshit.feature_crypto.domain.model

import com.ariext.cryptoshit.feature_crypto.data.data_source.dto.Team

data class CoinDetail(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<Team>
)

