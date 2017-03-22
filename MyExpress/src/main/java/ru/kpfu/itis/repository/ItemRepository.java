package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Category;
import ru.kpfu.itis.model.Item;

import java.util.List;

/**
 * Created by Ilgiz on 03.05.2016.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByRecom(Integer recom);

    Item findOneByName(String name);

    List<Item> findAllByCategory(Category category);
}
