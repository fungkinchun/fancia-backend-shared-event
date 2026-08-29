package com.fancia.backend.shared.event.core.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.util.UUID

data class CheckInRequest(
    @field:NotBlank
    @field:Size(max = 64)
    val token: String,
)

data class ManualCheckInRequest(
    @field:jakarta.validation.constraints.NotNull
    val userId: UUID,
)

data class CheckInSyncRequest(
    val tokens: List<String> = emptyList(),
)

data class CheckInResultResponse(
    val tokenAccepted: Boolean,
    val alreadyCheckedIn: Boolean,
    val checkedInAt: LocalDateTime?,
    val userId: UUID?,
    val tierName: String?,
    val guestCount: Int?,
    val errorCode: String? = null,
    val message: String? = null,
)

data class CheckInRosterEntry(
    val tokenHash: String,
    val userId: UUID,
    val tierName: String?,
    val guestCount: Int,
    val checkedInAt: LocalDateTime?,
)

data class CheckInRosterResponse(
    val occurrenceId: UUID,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val entries: List<CheckInRosterEntry>,
)

data class CheckInSyncResponse(
    val results: List<CheckInResultResponse>,
)
