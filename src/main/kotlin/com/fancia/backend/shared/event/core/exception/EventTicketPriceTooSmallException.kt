package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class EventTicketPriceTooSmallException(
    message: String,
    val tierId: UUID? = null,
    title: String = "Ticket Price Too Small",
    errorCode: String = "EVENT_TICKET_PRICE_TOO_SMALL",
) : DomainException(title, message, errorCode)
