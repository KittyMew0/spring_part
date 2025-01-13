package com.example.fifthseminarhw.repository;

import com.example.fifthseminarhw.model.Task;
import com.example.fifthseminarhw.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
