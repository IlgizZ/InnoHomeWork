package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Category;

/**
 * Created by Ilgiz on 04.05.2016.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findOneByName(String name);
}
