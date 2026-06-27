package com.kauan.service.task.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kauan.service.task.dto.request.NotificationRequest;

/**
 * Feign client for communicating with the {@code service-notification}
 * microservice.
 *
 * <p>This interface declares the remote endpoints that the task service
 * uses to send notification requests to the notification service. The
 * implementation is provided at runtime by Spring Cloud OpenFeign; callers
 * should only depend on the contract declared here.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * notificationClient.sendNotification(request);
 * }
 * </pre>
 *
 * @since 1.0
 */
@FeignClient(name = "service-notification")
public interface NotificationClient {

    /**
     * Send a notification to the notification service.
     *
     * <p>The {@code request} object is serialized as the HTTP request body
     * and POSTed to the notification service's {@code /notifications}
     * endpoint. This method does not return a value; any errors are expected
     * to be surfaced as exceptions from the Feign client.</p>
     *
     * @param request the notification payload to send. Must not be {@code null}.
     *                The payload typically contains recipient information,
     *                a title, a message body and any additional metadata
     *                required by the notification service.
     * @throws org.springframework.web.client.RestClientException if the
     *         remote call fails or returns an error status
     */
    @PostMapping("/notifications")
    void sendNotification(@RequestBody NotificationRequest request);

}
