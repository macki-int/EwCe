package pl.mj.EwCe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mj.EwCe.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
