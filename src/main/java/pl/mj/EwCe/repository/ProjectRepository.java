package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mj.EwCe.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
