package com.sms.hrsam.repository;

import com.sms.hrsam.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    // Rolü isme göre bul
    Optional<Role> findByName(String name);

    // Rol olup olmadığını kontrol et
    boolean existsByName(String name);
}