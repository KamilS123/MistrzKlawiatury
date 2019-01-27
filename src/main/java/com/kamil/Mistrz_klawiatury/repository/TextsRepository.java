package com.kamil.Mistrz_klawiatury.repository;

import com.kamil.Mistrz_klawiatury.model.Texts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextsRepository extends CrudRepository<Texts,Long> {
}
