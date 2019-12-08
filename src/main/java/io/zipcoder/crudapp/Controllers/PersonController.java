package io.zipcoder.crudapp.Controllers;

import io.zipcoder.crudapp.Repos.PersonRepo;
import io.zipcoder.crudapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @PostMapping (path = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @GetMapping (path = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Integer id){
        return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.OK);
    }

    @GetMapping (path = "/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @PutMapping (path = "/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable("id") Integer id){
        if (person.getId() == null) return createPerson(person);  //create new person
        else return new ResponseEntity<>(personRepo.save(person), HttpStatus.OK); // update existing person
    }

    @DeleteMapping (path = "/people/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        personRepo.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
