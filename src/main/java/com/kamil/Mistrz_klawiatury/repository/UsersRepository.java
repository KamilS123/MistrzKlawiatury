package com.kamil.Mistrz_klawiatury.repository;


import com.kamil.Mistrz_klawiatury.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {

}
