package com.kauan.service.task.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.kauan.service.task.service.TaskService;

/**
 * Scheduled component that periodically invokes the TaskService to
 * detect tasks that are due and send notifications.
 *
 * <p>The schedule uses a fixed rate to trigger the check at a regular
 * interval. The {@link TaskService#sendNotificationForDueTasks()} method
 * is delegated the responsibility of finding due tasks and performing
 * notification delivery.</p>
 */
@Component
public class TaskNotificationSchedule {

    /** Service used to detect due tasks and send notifications. */
    private final TaskService taskService;

    /**
     * Create a new schedule that delegates to the provided TaskService.
     *
     * @param taskService service responsible for task processing and notifications
     */
    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Periodically invoked method that triggers notification sending for due tasks.
     *
     * <p>The method is scheduled with a fixed rate (in milliseconds). It simply
     * delegates to {@link TaskService#sendNotificationForDueTasks()}.</p>
     */
    @Scheduled(fixedRate = 600)
    public void checkAndNotifyDueTasks() {
        this.taskService.sendNotificationForDueTasks();
    }
}
