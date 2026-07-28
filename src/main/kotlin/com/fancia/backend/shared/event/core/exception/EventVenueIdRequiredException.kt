package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class EventVenueIdRequiredException(
    title: String = "Venue id required",
    message: String = "Venue id is required when event location kind is VENUE",
    errorCode: String = "EVENT_VENUE_ID_REQUIRED"
) : DomainException(title, message, errorCode)
