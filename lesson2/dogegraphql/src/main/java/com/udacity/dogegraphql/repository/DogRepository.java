package com.udacity.dogegraphql.repository;

import com.udacity.dogegraphql.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    /* don't need them now
    @Query("select d.id, d.breed from Dog d where d.id=?1")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
    */

}
