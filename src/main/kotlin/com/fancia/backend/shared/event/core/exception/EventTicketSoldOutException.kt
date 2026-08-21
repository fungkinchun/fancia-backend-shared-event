package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class EventTicketSoldOutException(
    val tierId: UUID? = null,
    message: String = "This ticket tier is sold out for the occurrence",
    title: String = "Ticket Sold Out",
    errorCode: String = "EVENT_TICKET_SOLD_OUT",
) : DomainException(title, message, errorCode)
