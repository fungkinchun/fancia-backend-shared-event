package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.RecurrenceFrequency
import java.time.DayOfWeek
import java.time.LocalDateTime

data class EventRecurrenceDto(
    val frequency: RecurrenceFrequency,
    val daysOfWeek: Set<DayOfWeek> = emptySet(),
    val pausedUntil: LocalDateTime? = null,
)
