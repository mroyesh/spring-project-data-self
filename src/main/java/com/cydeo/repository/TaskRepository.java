package com.cydeo.repository;

import com.cydeo.entity.Project;
import com.cydeo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    List<Task> findAllByProject(Project project);





}
