package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.*

class EventNotFoundException : DomainException {
    val eventId: UUID?
    val ref: String

    constructor(
        eventId: UUID,
        title: String = "Event not found",
        message: String = "Event not found with id: $eventId",
        errorCode: String = "EVENT_NOT_FOUND",
    ) : super(title, message, errorCode) {
        this.eventId = eventId
        this.ref = eventId.toString()
    }

    constructor(
        ref: String,
        title: String = "Event not found",
        message: String = "Event not found with id or slug: $ref",
        errorCode: String = "EVENT_NOT_FOUND",
    ) : super(title, message, errorCode) {
        this.eventId = null
        this.ref = ref
    }
}