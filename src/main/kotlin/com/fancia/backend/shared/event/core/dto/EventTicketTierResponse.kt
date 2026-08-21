package com.fancia.backend.shared.event.core.dto

import java.time.LocalDateTime
import java.util.UUID

data class EventTicketTierResponse(
    val id: UUID?,
    val eventId: UUID,
    val name: String,
    val priceMinor: Long,
    val currency: String,
    val capacityPerOccurrence: Int?,
    val sortOrder: Int,
    val createdBy: UUID?,
    val createdAt: LocalDateTime?,
)
