package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateEventTicketTierRequest(
    @field:NotBlank
    @field:Size(max = 255)
    val name: String,
    @field:Min(0)
    val priceMinor: Long = 0,
    @field:Size(max = 8)
    val currency: String = "gbp",
    @field:Min(1)
    val capacityPerOccurrence: Int? = null,
    val sortOrder: Int = 0,
)
