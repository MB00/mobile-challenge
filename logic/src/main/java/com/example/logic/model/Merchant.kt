package com.example.logic.model

data class Merchant(
    val id: String,
    val name: String,
    val merchantCategory: MerchantCategory,
    val website: String
)