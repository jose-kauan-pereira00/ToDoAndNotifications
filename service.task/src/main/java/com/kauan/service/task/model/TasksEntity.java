package com.kauan.service.task.model;

import java.time.LocalDateTime;

import com.kauan.service.task.dto.request.TaskRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "task")
@Entity(name = "Task")

public class TasksEntity {

    /**
     * Entity representing a task stored in the database.
     * <p>
     * Maps to table "task" and contains basic task information such as title,
     * responsible email, due date and whether a notification was sent.
     */



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Title or short description of the task. */
    private String title;

    /** Email address of the user responsible for the task. */
    private String email;

    /** Date and time when the task is due. */
    private LocalDateTime dueDate;

    /** Flag indicating whether a notification about this task was already sent. */
    private boolean notified;


    /**
     * Constructs a TasksEntity from a TaskRequest DTO.
     *
     * @param task the request containing task data
     */
    public TasksEntity(TaskRequest task) {
        this.title = task.title();
        this.email = task.email();
        this.dueDate = task.dueDate();
        this.notified = task.notifide();
    }

    /**
     * Returns the email address of the user responsible for the task.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }
        public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

}
