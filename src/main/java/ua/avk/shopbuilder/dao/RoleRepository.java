package ua.avk.shopbuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.avk.shopbuilder.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
}
