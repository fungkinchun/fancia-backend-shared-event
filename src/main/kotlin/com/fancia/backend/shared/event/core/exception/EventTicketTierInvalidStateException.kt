package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class EventTicketTierInvalidStateException(
    message: String,
    val tierId: UUID? = null,
    title: String = "Ticket Tier Invalid State",
    errorCode: String = "EVENT_TICKET_TIER_INVALID_STATE",
) : DomainException(title, message, errorCode)
