package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class ReservationEarlyAccessException(
    val eventId: UUID,
    message: String = "Paid tickets open for Fancia Premium members first. Free users can reserve after the early-access window.",
    title: String = "Early Access",
    errorCode: String = "RESERVATION_EARLY_ACCESS",
) : DomainException(title, message, errorCode)
