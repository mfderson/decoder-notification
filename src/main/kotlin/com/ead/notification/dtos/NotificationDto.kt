package com.ead.notification.dtos

import com.ead.notification.enums.NotificationStatus
import org.jetbrains.annotations.NotNull

data class NotificationDto(
    @field:NotNull val status: NotificationStatus
)
