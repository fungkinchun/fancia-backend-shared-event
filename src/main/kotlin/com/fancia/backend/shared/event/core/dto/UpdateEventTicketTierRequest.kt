package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.Size

data class UpdateEventTicketTierRequest(
    @field:Size(max = 255)
    val name: String? = null,
    @field:Min(0)
    val priceMinor: Long? = null,
    @field:Size(max = 8)
    val currency: String? = null,
    @field:Min(1)
    val capacityPerOccurrence: Int? = null,
    val clearCapacity: Boolean = false,
    @field:Min(0)
    val checkInBeforeMinutes: Int? = null,
    @field:Min(0)
    val checkInAfterMinutes: Int? = null,
    val sortOrder: Int? = null,
)
