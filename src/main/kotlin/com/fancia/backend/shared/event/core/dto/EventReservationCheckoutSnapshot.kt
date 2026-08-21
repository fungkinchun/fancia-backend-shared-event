package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.ReservationStatus
import java.util.UUID

data class EventReservationCheckoutSnapshot(
    val eventId: UUID,
    val occurrenceId: UUID,
    val userId: UUID,
    val hostUserId: UUID,
    val tierId: UUID,
    val tierName: String,
    val priceMinor: Long,
    val currency: String,
    val reservationStatus: ReservationStatus?,
)
