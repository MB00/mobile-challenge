package com.example.logic.model

data class Transaction(
    val id: String,
    val amount: Int,
    val purchaseTime: String,
    val card: Card,
    val merchant: Merchant,
    val integration: Integration,
)