package com.fancia.backend.shared.event.core.entity

import com.fancia.backend.shared.common.core.entity.AbstractEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "event_time_slots")
class EventTimeSlot : AbstractEntity() {
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    var event: Event? = null

    @Column(name = "start_time", nullable = false)
    var startTime: LocalDateTime = LocalDateTime.MIN

    @Column(name = "end_time", nullable = false)
    var endTime: LocalDateTime = LocalDateTime.MIN

    @Column(name = "sort_order", nullable = false)
    var sortOrder: Int = 0
}
