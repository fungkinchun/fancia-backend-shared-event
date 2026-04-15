package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.NotBlank
import java.util.*

data class CreateReservationRequest(
    var guests: Int = 0,
    var payload: String,
)