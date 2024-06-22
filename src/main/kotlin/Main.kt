package ru.netology

import kotlin.math.max

const val ERROR_TYPE_CARD = -1
const val ERROR_MONTH_LIMIT = -2
const val ERROR_DAY_LIMIT = -3


fun main() {
    val cardType = "Mastercard" // тип карты (Mastercard, Visa, Мир)
//    var transferAmountInMonth: Int = 0 // сумма осуществленных переводов в месяц
    val transfer = 15_000 //  осуществляемый перевод
    val maxLimit = 600_000 // максимальный лимит в месяц
    val transactionLimit = 150_000 // лимит одной операции
    moneyOrder(cardType, transfer, maxLimit, transactionLimit)

}

fun moneyOrder(cardType: String, transfer: Int, maxLimit: Int, transactionLimit: Int): Int {
    return when (cardType) {
        "Мир" -> mirLimit(transfer, maxLimit, transactionLimit)
        "Mastercard" -> mastercardLimitAndCommission(transfer, maxLimit, transactionLimit)
        "Visa" -> visaLimitCommission(transfer, maxLimit, transactionLimit)
        else ->
            ERROR_TYPE_CARD
    }

}

fun mirLimit(transfer: Int, maxLimit: Int, transactionLimit: Int): Int {
    var transferAmountInMonth: Int = 0
    val commission = 0
    return when {
        transferAmountInMonth + transfer > maxLimit -> {
            println("Операция отменена, превышен месячный лимит в размере $maxLimit на: " + (transferAmountInMonth + transfer - maxLimit))
            ERROR_MONTH_LIMIT
        }

        transfer > transactionLimit -> {
            println("Операция отменена, превышен суточный лимит на операцию в размере $transactionLimit на: " + (transfer - transactionLimit))
            ERROR_DAY_LIMIT
        }

        else -> {
            transferAmountInMonth += transfer
            println("Перевод в размере $transfer осуществлен.")
            commission
        }
    }
}

fun mastercardLimitAndCommission(transfer: Int, maxLimit: Int, transactionLimit: Int): Int {
    var transferAmountInMonth: Int = 0 // сумма осуществленных переводов в месяц
    var noCommissionLimitInMonth = 75_000 // сумма не облагаемая комиссией в месяц
    var commission: Int = 0
    return when {
        transferAmountInMonth + transfer > maxLimit -> {
            println("Операция отменена, превышен месячный лимит в размере $maxLimit на: " + (transferAmountInMonth + transfer - maxLimit))
            ERROR_MONTH_LIMIT
        }

        transfer > transactionLimit -> {
            println("Операция отменена, превышен суточный лимит на операцию в размере $transactionLimit на: " + (transfer - transactionLimit))
            ERROR_DAY_LIMIT
        }

        transferAmountInMonth + transfer <= maxLimit && transfer <= transactionLimit &&
                noCommissionLimitInMonth - transfer >= 0 -> {
            transferAmountInMonth += transfer
            noCommissionLimitInMonth -= transfer
            println("Перевод в размере $transfer осуществлен.")
            commission
        }

        else -> {
            transferAmountInMonth += transfer
            commission = ((transfer - noCommissionLimitInMonth) * 0.006 + 20).toInt()
            noCommissionLimitInMonth = 0
            println("Перевод в размере $transfer осуществлен.\n " +
                        "Комиссия за перевод составила: $commission.")
            commission
        }

    }
}

fun visaLimitCommission(transfer: Int, maxLimit: Int, transactionLimit: Int): Int {
    var transferAmountInMonth: Int = 0 // сумма осуществленных переводов в месяц
    val minCommission = 35 // минимальная комиссия за перевод
    val commission: Int = max(minCommission, (transfer * 0.0075).toInt())
    return when {
        transferAmountInMonth + transfer > maxLimit -> {
            println("Операция отменена, превышен месячный лимит в размере $maxLimit на: " + (transferAmountInMonth + transfer - maxLimit))
            ERROR_MONTH_LIMIT
        }

        transfer > transactionLimit -> {
            println("Операция отменена, превышен суточный лимит на операцию в размере $transactionLimit на: " + (transfer - transactionLimit))
            ERROR_DAY_LIMIT
        }

        else -> {
            transferAmountInMonth += transfer
            println(
                "Перевод в размере $transfer осуществлен.\n " +
                        "Комиссия за перевод составила: $commission.")
            commission
        }
    }
}