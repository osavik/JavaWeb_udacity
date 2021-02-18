package com.udacity.dogerest.service;

import com.udacity.dogerest.entity.Dog;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreeds();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
    List<Dog> retrieveAllDogs();
}
