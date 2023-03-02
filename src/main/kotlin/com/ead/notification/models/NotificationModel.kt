package com.ead.notification.models

import com.ead.notification.enums.NotificationStatus
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "NOTIFICATIONS")
@JsonIgnoreProperties(ignoreUnknown = true)
data class NotificationModel(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val userId: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val title: String = "",

    @Column(nullable = false)
    val message: String = "",

    @Column(nullable = false)
    val creationDate: LocalDateTime = LocalDateTime.now(ZoneId.of("UTC")),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var status: NotificationStatus = NotificationStatus.CREATED

): Serializable