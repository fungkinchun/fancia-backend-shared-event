package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.Size
import java.util.UUID

data class CreateReservationRequest(
    var guests: Int = 0,
    @field:Size(max = 4000, message = "Reservation payload must be at most 4000 characters")
    var payload: String,
    var tierId: UUID? = null,
)
