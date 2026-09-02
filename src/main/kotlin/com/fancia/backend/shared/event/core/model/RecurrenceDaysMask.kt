package com.fancia.backend.shared.event.core.model

import java.time.DayOfWeek

@JvmInline
value class RecurrenceDaysMask(val bits: Int) {
    init {
        require(bits in 0..127) { "Recurrence days mask must fit in 7 bits" }
    }

    fun isEmpty(): Boolean = bits == 0

    fun isNotEmpty(): Boolean = bits != 0

    fun contains(day: DayOfWeek): Boolean = bits and day.toMaskBit() != 0

    fun toDayOfWeekSet(): Set<DayOfWeek> = DayOfWeek.entries.filterTo(linkedSetOf()) { contains(it) }

    fun toSmsString(): String = SMS_ORDER.joinToString("") { day ->
        if (contains(day)) "1" else "0"
    }

    companion object {
        const val SUNDAY = 1 shl 6
        const val MONDAY = 1 shl 5
        const val TUESDAY = 1 shl 4
        const val WEDNESDAY = 1 shl 3
        const val THURSDAY = 1 shl 2
        const val FRIDAY = 1 shl 1
        const val SATURDAY = 1 shl 0

        val NONE: RecurrenceDaysMask = RecurrenceDaysMask(0)

        private val SMS_ORDER = listOf(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
        )

        fun fromDayOfWeekSet(days: Set<DayOfWeek>): RecurrenceDaysMask {
            if (days.isEmpty()) return NONE
            return RecurrenceDaysMask(days.fold(0) { acc, day -> acc or day.toMaskBit() })
        }

        fun fromSmsString(value: String): RecurrenceDaysMask {
            require(value.length == 7) { "Expected 7-character SMTWTFS mask" }
            var bits = 0
            value.forEachIndexed { index, char ->
                require(char == '0' || char == '1') { "Mask characters must be 0 or 1" }
                if (char == '1') {
                    bits = bits or (1 shl (6 - index))
                }
            }
            return RecurrenceDaysMask(bits)
        }
    }
}

private fun DayOfWeek.toMaskBit(): Int = when (this) {
    DayOfWeek.SUNDAY -> RecurrenceDaysMask.SUNDAY
    DayOfWeek.MONDAY -> RecurrenceDaysMask.MONDAY
    DayOfWeek.TUESDAY -> RecurrenceDaysMask.TUESDAY
    DayOfWeek.WEDNESDAY -> RecurrenceDaysMask.WEDNESDAY
    DayOfWeek.THURSDAY -> RecurrenceDaysMask.THURSDAY
    DayOfWeek.FRIDAY -> RecurrenceDaysMask.FRIDAY
    DayOfWeek.SATURDAY -> RecurrenceDaysMask.SATURDAY
}
