package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.ReservationStatus
import java.time.LocalDateTime
import java.util.*

data class ReservationResponse(
    var eventId: UUID? = null,
    var occurrenceId: UUID? = null,
    var userId: UUID? = null,
    var status: ReservationStatus? = null,
    var guests: Int? = null,
    var payload: String? = null,
    var tierId: UUID? = null,
    var priceMinor: Long? = null,
    var currency: String? = null,
    var checkedInAt: LocalDateTime? = null,
    var checkInToken: String? = null,
)
