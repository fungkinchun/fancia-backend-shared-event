package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.common.social.core.dto.LinkResponse
import com.fancia.backend.shared.event.core.enums.EventVisibility
import java.time.LocalDateTime
import java.util.*

data class EventResponse(
    val id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var interestGroups: Set<UUID>,
    var createdBy: UUID? = null,
    var createdAt: LocalDateTime? = null,
    var startTime: LocalDateTime? = null,
    var endTime: LocalDateTime? = null,
    var tags: Set<UUID> = emptySet(),
    var visibility: EventVisibility = EventVisibility.PUBLIC,
    var location: EventLocationDto? = null,
    var links: Set<LinkResponse> = emptySet(),
    var recurrence: EventRecurrenceDto? = null,
    var approvalRequired: Boolean = true,
)
