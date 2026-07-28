package com.fancia.backend.shared.event.core.exception

import com.fancia.backend.shared.common.core.exception.DomainException

class GroupEventRequiresInterestGroupsException(
    title: String = "Group Event Requires Interest Groups",
    message: String = "Group visibility events must be linked to at least one interest group",
    errorCode: String = "GROUP_EVENT_REQUIRES_INTEREST_GROUPS",
) : DomainException(title, message, errorCode)
