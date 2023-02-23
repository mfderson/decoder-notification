package com.ead.notification.consumers


import com.ead.notification.dtos.NotificationCommandDto
import com.ead.notification.dtos.toNotificationModel
import com.ead.notification.models.NotificationModel
import com.ead.notification.services.NotificationService
import org.modelmapper.ModelMapper
import org.springframework.amqp.core.ExchangeTypes
import org.springframework.amqp.rabbit.annotation.Exchange
import org.springframework.amqp.rabbit.annotation.Queue
import org.springframework.amqp.rabbit.annotation.QueueBinding
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class NotificationConsumer(
    val notificationService: NotificationService
) {
    @RabbitListener(
        bindings = [QueueBinding(
            value = Queue(
                value = "\${ead.broker.queue.notificationCommandQueue.name}",
                durable = "true"
            ),
            exchange = Exchange(
                value = "\${ead.broker.exchange.notificationCommandExchange}",
                type = ExchangeTypes.TOPIC
            ),
            key = ["\${ead.broker.key.notificationCommandKey}"]
        )]
    )
    fun listen(@Payload notificationDto: NotificationCommandDto) {
        val notification = notificationDto.toNotificationModel()
        notificationService.save(notification)
    }
}