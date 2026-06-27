package com.kauan.service.task.dto.request;

import java.time.LocalDateTime;

/**
 * Data transfer object for task requests.
 * Represents the structure of a task creation or update request.
 *
 * @param title the title of the task
 * @param email the email associated with the task
 * @param dueDate the due date and time for the task
 * @param notifide flag indicating whether notifications are enabled for the task
 */
public record TaskRequest(String title, String email, LocalDateTime dueDate, boolean  notifide) {
}
