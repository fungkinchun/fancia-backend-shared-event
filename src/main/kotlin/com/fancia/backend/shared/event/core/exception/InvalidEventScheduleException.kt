package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class InvalidEventScheduleException(
    title: String = "Invalid event schedule",
    message: String = "End time must be after start time",
    errorCode: String = "INVALID_EVENT_SCHEDULE",
) : DomainException(title, message, errorCode)
