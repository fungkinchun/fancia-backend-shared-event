package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class CheckInTokenInvalidException(
    title: String = "Invalid check-in token",
    message: String = "No accepted reservation matches this check-in token",
    errorCode: String = "CHECK_IN_TOKEN_INVALID",
) : DomainException(title, message, errorCode)

class CheckInOutsideWindowException(
    title: String = "Check-in not open",
    message: String = "Check-in is only allowed within this ticket's occurrence window",
    errorCode: String = "CHECK_IN_OUTSIDE_WINDOW",
) : DomainException(title, message, errorCode)

class CheckInAccessDeniedException(
    title: String = "Check-in access denied",
    message: String = "Only the event host or cohost can check guests in",
    errorCode: String = "CHECK_IN_ACCESS_DENIED",
) : DomainException(title, message, errorCode)
