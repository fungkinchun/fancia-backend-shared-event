package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.OccurrenceStatus
import java.time.LocalDateTime
import java.util.UUID

data class EventOccurrenceResponse(
    val id: UUID,
    val eventId: UUID,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val status: OccurrenceStatus,
    val timeSlotId: UUID? = null,
)
