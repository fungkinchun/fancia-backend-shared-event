package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException
import java.util.UUID

class EventHostPayoutNotReadyException(
    val eventId: UUID? = null,
    val hostUserId: UUID? = null,
    message: String = "Event host must finish Stripe payouts onboarding before selling paid tickets",
    title: String = "Host Payouts Not Ready",
    errorCode: String = "EVENT_HOST_PAYOUT_NOT_READY",
) : DomainException(title, message, errorCode)
