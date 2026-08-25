package com.fancia.backend.shared.event.core.entity

import com.fancia.backend.shared.event.core.enums.ReservationStatus
import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

@Embeddable
data class ReservationId(
    @Column(name = "occurrence_id")
    var occurrenceId: UUID? = null,
    @Column(name = "user_id")
    var userId: UUID? = null,
) : Serializable {
    override fun equals(other: Any?): Boolean =
        other is ReservationId && other.occurrenceId == occurrenceId && other.userId == userId

    override fun hashCode(): Int = Objects.hash(occurrenceId, userId)
}

@Entity
@Table(name = "reservations")
class Reservation(
    @EmbeddedId
    var id: ReservationId? = null,
) {
    @MapsId("occurrenceId")
    @ManyToOne
    @JoinColumn(name = "occurrence_id", insertable = false, updatable = false)
    var occurrence: EventOccurrence? = null
    var guests: Int = 0

    @Column(length = 4000)
    var payload: String = ""

    @Enumerated(EnumType.STRING)
    var status: ReservationStatus? = ReservationStatus.PENDING

    @Column(name = "tier_id")
    var tierId: UUID? = null

    @Column(name = "price_minor")
    var priceMinor: Long? = null

    @Column(length = 8)
    var currency: String? = null

    @Column(name = "stripe_checkout_session_id", length = 255)
    var stripeCheckoutSessionId: String? = null

    @Column(name = "paid_at")
    var paidAt: LocalDateTime? = null

    @Column(name = "check_in_token", length = 64)
    var checkInToken: String? = null

    @Column(name = "checked_in_at")
    var checkedInAt: LocalDateTime? = null

    @Column(name = "checked_in_by")
    var checkedInBy: UUID? = null
}
