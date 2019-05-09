package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mj.EwCe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
