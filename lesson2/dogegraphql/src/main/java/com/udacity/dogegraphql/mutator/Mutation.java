package com.udacity.dogegraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dogegraphql.entity.Dog;
import com.udacity.dogegraphql.exception.BreedNotFoundException;
import com.udacity.dogegraphql.exception.DogNotFoundException;
import com.udacity.dogegraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;

        // get all dog
        Iterable <Dog> dogs = dogRepository.findAll();

        // iterate over dogs if dog has breed
        for(Dog dog: dogs){
            if(dog.getBreed().equals(breed)){
                // delete it from DB by ID
                dogRepository.deleteById(dog.getId());
                deleted = true;
            }
        }

        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return true;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }else{
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }


}
