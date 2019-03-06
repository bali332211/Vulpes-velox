package com.vulpes.velox.repositories;

import com.vulpes.velox.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

  List<Item> findAll();
}
