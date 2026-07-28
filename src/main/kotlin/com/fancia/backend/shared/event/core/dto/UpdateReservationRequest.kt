package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.ReservationStatus
import jakarta.validation.constraints.Size

data class UpdateReservationRequest(
    var guests: Int = 0,
    @field:Size(max = 4000, message = "Reservation payload must be at most 4000 characters")
    var payload: String,
    var status: ReservationStatus
)