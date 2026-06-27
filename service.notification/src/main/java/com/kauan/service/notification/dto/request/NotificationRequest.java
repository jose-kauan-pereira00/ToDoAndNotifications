package com.kauan.service.notification.dto.request;

/**
 * Data transfer object representing a request to create or send a notification.
 * <p>
 * This record holds the notification message content and the recipient email
 * address. It is intended for use when receiving notification creation requests
 * (for example, from a controller or an external API) and transporting the
 * necessary data through the service layer.
 * </p>
 *
 * @param message the text content of the notification
 * @param email   the recipient email address for the notification
 */
public record NotificationRequest(String message, String email) {

}
