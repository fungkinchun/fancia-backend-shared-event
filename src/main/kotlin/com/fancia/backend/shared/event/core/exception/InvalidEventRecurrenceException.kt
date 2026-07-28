package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

open class InvalidEventRecurrenceException(
    title: String = "Invalid event recurrence",
    message: String = "Invalid event recurrence",
    errorCode: String = "INVALID_EVENT_RECURRENCE",
) : DomainException(title, message, errorCode)

class WeeklyRecurrenceRequiresDaysOfWeekException :
    InvalidEventRecurrenceException(
        title = "Invalid weekly recurrence",
        message = "Weekly recurrence requires at least one day of week",
        errorCode = "WEEKLY_RECURRENCE_REQUIRES_DAYS_OF_WEEK",
    )

class RecurrenceDaysOfWeekNotSupportedException :
    InvalidEventRecurrenceException(
        title = "Invalid event recurrence",
        message = "daysOfWeek is only supported for weekly recurrence",
        errorCode = "RECURRENCE_DAYS_OF_WEEK_NOT_SUPPORTED",
    )
