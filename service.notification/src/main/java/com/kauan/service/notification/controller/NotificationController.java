package com.kauan.service.notification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kauan.service.notification.dto.request.NotificationRequest;

/**
 * REST controller responsible for handling notification requests.
 *
 * This controller exposes an endpoint for sending notifications
 * using a request payload defined by {@link NotificationRequest}.
 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    /**
     * Sends a notification based on the provided request.
     *
     * @param request the notification request containing the details required to send the notification
     * @return a {@link ResponseEntity} with an HTTP 200 status if the notification request is accepted
     */
    @PostMapping("/send")
    public ResponseEntity<Void> sendNotification(@RequestBody NotificationRequest request) {
        // Implement the logic to send the notification
        return ResponseEntity.ok().build();
    }

}
