package com.ead.notification.dtos

import java.util.UUID

data class NotificationCommandDto(
    val title: String = "",
    val message: String = "",
    val userId: UUID = UUID.randomUUID()
)
