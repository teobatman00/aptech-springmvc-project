package org.example.repository;

import org.example.entity.CategoryEntity;

public interface CategoryRepository extends BaseRepository<CategoryEntity, Long> {

    boolean existedByName(String name);
}
