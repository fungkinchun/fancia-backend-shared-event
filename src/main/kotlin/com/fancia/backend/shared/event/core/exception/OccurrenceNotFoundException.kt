package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class OccurrenceNotFoundException(
    val eventId: UUID,
    val occurrenceId: UUID,
    title: String = "Occurrence Not Found",
    message: String = "Occurrence $occurrenceId not found for event $eventId",
    errorCode: String = "OCCURRENCE_NOT_FOUND",
) : DomainException(title, message, errorCode)
