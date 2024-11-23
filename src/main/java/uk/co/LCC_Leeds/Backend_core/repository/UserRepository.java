package uk.co.LCC_Leeds.Backend_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.LCC_Leeds.Backend_core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
