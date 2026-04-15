package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.ReservationStatus
import java.util.*

data class ReservationResponse(
    var eventId: UUID? = null,
    var userId: UUID? = null,
    var status: ReservationStatus? = null
)
