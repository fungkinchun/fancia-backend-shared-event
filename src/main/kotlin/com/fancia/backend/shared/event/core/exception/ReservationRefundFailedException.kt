package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class ReservationRefundFailedException(
    title: String = "Reservation refund failed",
    message: String = "Refund failed; reservation was not updated. Try again.",
    errorCode: String = "EVENT_RESERVATION_REFUND_FAILED",
) : DomainException(title, message, errorCode)
