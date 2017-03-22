package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.User;

/**
 * Created by Ilgiz on 03.05.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByName(String name);

    User findOneByEmail(String email);
}
