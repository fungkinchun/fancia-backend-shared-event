package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class EventTicketTierNotFoundException(
    val tierId: UUID? = null,
    message: String = "Event ticket tier not found",
    title: String = "Ticket Tier Not Found",
    errorCode: String = "EVENT_TICKET_TIER_NOT_FOUND",
) : DomainException(title, message, errorCode)
