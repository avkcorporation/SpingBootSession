package ua.avk.shopbuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.avk.shopbuilder.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
