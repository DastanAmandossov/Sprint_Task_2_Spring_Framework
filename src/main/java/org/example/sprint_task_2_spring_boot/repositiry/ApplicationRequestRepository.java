package org.example.sprint_task_2_spring_boot.repositiry;

import org.example.sprint_task_2_spring_boot.model.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<ApplicationRequest, Long> {
}
