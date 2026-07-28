package com.fancia.backend.shared.event.core.dto

import com.fancia.backend.shared.common.social.core.dto.LinkItem
import com.fancia.backend.shared.common.tag.core.dto.TagItemRequest
import com.fancia.backend.shared.event.core.enums.EventVisibility
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime
import java.util.*

data class CreateEventRequest(
    @field:NotBlank(message = "Event name is required")
    @field:Size(max = 255, message = "Event name must be at most 255 characters")
    val name: String,
    @field:NotBlank(message = "Event description is required")
    @field:Size(max = 4000, message = "Event description must be at most 4000 characters")
    val description: String,
    @field:NotNull(message = "Event start time is required")
    val startTime: LocalDateTime,
    @field:NotNull(message = "Event end time is required")
    val endTime: LocalDateTime,
    val interestGroups: Set<UUID> = emptySet(),
    val tags: Set<@Valid TagItemRequest> = emptySet(),
    val visibility: EventVisibility? = EventVisibility.PUBLIC,
    @field:Valid
    val location: EventLocationDto? = null,
    @field:Valid
    val links: List<LinkItem> = emptyList(),
    @field:Valid
    val recurrence: EventRecurrenceDto? = null,
    val approvalRequired: Boolean? = true,
)
