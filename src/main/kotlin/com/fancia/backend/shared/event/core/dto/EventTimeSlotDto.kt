package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.NotNull
import java.time.LocalDateTime
import java.util.UUID

data class EventTimeSlotRequest(
    val id: UUID? = null,
    @field:NotNull(message = "Time slot start time is required")
    val startTime: LocalDateTime,
    @field:NotNull(message = "Time slot end time is required")
    val endTime: LocalDateTime,
    val sortOrder: Int? = null,
)

data class EventTimeSlotResponse(
    val id: UUID,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val sortOrder: Int,
)
