package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.event.core.enums.EventRole
import java.util.*

data class EventParticipantResponse(
    var userId: UUID? = null,
    var role: EventRole? = null,
)