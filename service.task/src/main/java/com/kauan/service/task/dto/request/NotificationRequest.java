package com.kauan.service.task.dto.request;

/**
 * Data transfer object representing a notification request.
 *
 * <p>Contains the notification message to be delivered and the recipient's
 * email address.</p>
 *
 * @param message the notification text to send
 * @param email   the recipient's email address
 */
public record NotificationRequest(String message, String email) {

}
