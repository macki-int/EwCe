package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mj.EwCe.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
