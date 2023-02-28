package com.ead.notification.controllers

import com.ead.notification.dtos.NotificationDto
import com.ead.notification.models.NotificationModel
import com.ead.notification.services.NotificationService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
class UserNotificationController(
    val notificationService: NotificationService
) {
    @GetMapping("/users/{userId}/notifications")
    fun getAllNotificationsByUser(
        @PathVariable userId: UUID,
        @PageableDefault(
            page = 0,
            size = 10,
            sort = ["id"],
            direction = Sort.Direction.ASC
        ) pageable: Pageable): ResponseEntity<Page<NotificationModel>> {
         return ResponseEntity.status(HttpStatus.OK).body(notificationService.findAllNotificationsByUser(userId, pageable))
    }

    @PutMapping("/users/{userId}/notifications/{notificationId}")
    fun updateNotificationStatus(
        @PathVariable userId: UUID,
        @PathVariable notificationId: UUID,
        @RequestBody @Valid notificationDto: NotificationDto
    ): ResponseEntity<*> {
        val notification = notificationService.findByIdAndUserId(notificationId, userId)
            ?: return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Notification not found")

        notification.status = notificationDto.status

        notificationService.save(notification)

        return ResponseEntity.status(HttpStatus.OK).body(notification)
    }
}