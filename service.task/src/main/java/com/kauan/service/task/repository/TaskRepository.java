package com.kauan.service.task.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kauan.service.task.model.TasksEntity;

/**
 * Repository interface for performing CRUD operations on TasksEntity.
 *
 * <p>Extends Spring Data JPA's {@link JpaRepository} to inherit standard
 * repository methods. Additional query methods for task-specific
 * retrievals can be defined here.</p>
 */
@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {

    /**
     * Finds tasks with a due date on or before the provided deadline and which
     * have not yet been notified.
     *
     * @param deadLine the upper bound for the task due date (inclusive)
     * @return a list of {@link TasksEntity} matching the criteria; may be empty
     */
    @Query("SELECT t FROM Task t WHERE t.dueDate <= :deadLine AND t.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadLine);

}
