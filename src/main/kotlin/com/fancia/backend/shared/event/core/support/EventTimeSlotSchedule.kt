package com.fancia.backend.shared.event.core.support

import com.fancia.backend.shared.event.core.dto.EventTimeSlotRequest
import com.fancia.backend.shared.event.core.entity.Event
import com.fancia.backend.shared.event.core.exception.InvalidEventScheduleException
import java.time.LocalDateTime
import java.util.UUID

object EventTimeSlotSchedule {
    data class Window(
        val startTime: LocalDateTime,
        val endTime: LocalDateTime,
        val id: UUID? = null,
        val sortOrder: Int = 0,
    )

    fun resolve(
        startTime: LocalDateTime?,
        endTime: LocalDateTime?,
        timeSlots: List<EventTimeSlotRequest>?,
    ): List<Window> {
        val fromList = timeSlots.orEmpty().mapIndexed { index, slot ->
            Window(
                startTime = slot.startTime,
                endTime = slot.endTime,
                id = slot.id,
                sortOrder = slot.sortOrder ?: index,
            )
        }
        val windows = if (fromList.isNotEmpty()) {
            fromList
        } else if (startTime != null && endTime != null) {
            listOf(Window(startTime = startTime, endTime = endTime))
        } else {
            emptyList()
        }
        if (windows.isEmpty()) {
            throw InvalidEventScheduleException(
                message = "Provide at least one time slot",
            )
        }
        windows.forEach { validate(it.startTime, it.endTime) }
        val starts = windows.map { it.startTime }
        if (starts.size != starts.toSet().size) {
            throw InvalidEventScheduleException(
                message = "Time slots cannot share the same start time",
            )
        }
        return windows
            .sortedWith(compareBy({ it.sortOrder }, { it.startTime }))
            .mapIndexed { index, window -> window.copy(sortOrder = index) }
    }

    fun validate(startTime: LocalDateTime, endTime: LocalDateTime) {
        if (!endTime.isAfter(startTime)) {
            throw InvalidEventScheduleException()
        }
    }

    fun anchors(event: Event): List<Window> {
        val slots = event.timeSlots.sortedBy { it.sortOrder }
        if (slots.isNotEmpty()) {
            return slots.map {
                Window(
                    startTime = it.startTime,
                    endTime = it.endTime,
                    id = it.id,
                    sortOrder = it.sortOrder,
                )
            }
        }
        val start = event.startTime ?: return emptyList()
        val end = event.endTime ?: return emptyList()
        return listOf(Window(startTime = start, endTime = end))
    }
}
