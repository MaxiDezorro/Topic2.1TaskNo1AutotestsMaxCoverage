import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.netology.mastercardLimitAndCommission

class MainKtTest {

    @Test
    fun mirDayLimit() {
        val transfer = 170_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.mirLimit(transfer, maxLimit, transactionLimit)

    assertEquals(-3,result)
    }
    @Test
    fun mirMonthLimit() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.mirLimit(transfer, maxLimit, transactionLimit)

        assertEquals(-2,result)
    }

    @Test
    fun mirCommissionZero() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.mirLimit(transfer, maxLimit, transactionLimit)

        assertEquals(0,result)
    }

    @Test
    fun moneyOrderErrorCard() {
        val cardType = "Maestro" // тип карты (Mastercard, Visa, Мир)
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(100, result)
    }

    @Test
    fun moneyOrderMirCommissionZero() {
        val cardType = "Мир" // тип карты (Mastercard, Visa, Мир)
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(0, result)
    }

    @Test
    fun moneyOrderMirErrorMonthLimit() {
        val cardType = "Мир" // тип карты (Mastercard, Visa, Мир)
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-2, result)
    }

    @Test
    fun moneyOrderMirErrorDayLimit() {
        val cardType = "Мир" // тип карты (Mastercard, Visa, Мир)
        val transfer = 200_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-3, result)
    }

    @Test
    fun visaLimitDay() {
        val transfer = 200_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.visaLimitCommission(transfer, maxLimit, transactionLimit)

        assertEquals(-3, result)

    }

    @Test
    fun visaLimitMonth() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.visaLimitCommission(transfer, maxLimit, transactionLimit)

        assertEquals(-2, result)

    }
    @Test
    fun visaCommission() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.visaLimitCommission(transfer, maxLimit, transactionLimit)

        assertEquals(750, result)

    }

    @Test
    fun mastercardLimitMonth() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val  result = mastercardLimitAndCommission(transfer, maxLimit, transactionLimit)

        assertEquals(-2, result)
    }

    @Test
    fun mastercardLimitDay() {
        val transfer = 200_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val  result = mastercardLimitAndCommission(transfer, maxLimit, transactionLimit)

        assertEquals(-3, result)
    }

    @Test
    fun mastercardNoCommission() {
        val transfer = 10_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val  result = mastercardLimitAndCommission(transfer, maxLimit, transactionLimit)

        assertEquals(0, result)
    }

    @Test
    fun mastercardCommission() {
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val  result = mastercardLimitAndCommission(transfer, maxLimit, transactionLimit)

        assertEquals(170, result)
    }

    @Test
    fun moneyOrderVisaErrorMonthLimit() {
        val cardType = "Visa" // тип карты (Mastercard, Visa, Мир)
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-2, result)
    }

    @Test
    fun moneyOrderVisaErrorDayLimit() {
        val cardType = "Visa" // тип карты (Mastercard, Visa, Мир)
        val transfer = 200_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-3, result)
    }

    @Test
    fun moneyOrderVisaMinimumCommission() {
        val cardType = "Visa" // тип карты (Mastercard, Visa, Мир)
        val transfer = 1_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(35, result)
    }

    @Test
    fun moneyOrderMastercardErrorMonthLimit() {
        val cardType = "Mastercard" // тип карты (Mastercard, Visa, Мир)
        val transfer = 100_000 //  осуществляемый перевод
        val maxLimit = 60_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-2, result)
    }

    @Test
    fun moneyOrderMastercardErrorDayLimit() {
        val cardType = "Mastercard" // тип карты (Mastercard, Visa, Мир)
        val transfer = 200_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(-3, result)
    }

    @Test
    fun moneyOrderMastercardCommissionZero() {
        val cardType = "Mastercard" // тип карты (Mastercard, Visa, Мир)
        val transfer = 70_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(0, result)
    }

    @Test
    fun moneyOrderMastercardCommission() {
        val cardType = "Mastercard" // тип карты (Mastercard, Visa, Мир)
        val transfer = 150_000 //  осуществляемый перевод
        val maxLimit = 600_000 // максимальный лимит в месяц
        val transactionLimit = 150_000 // лимит одной операции

        val result = ru.netology.moneyOrder(cardType, transfer, maxLimit, transactionLimit)

        assertEquals(470, result)
    }

}

