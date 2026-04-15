package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.ReservationStatus

data class UpdateReservationRequest(
    var guests: Int = 0,
    var payload: String,
    var status: ReservationStatus
)