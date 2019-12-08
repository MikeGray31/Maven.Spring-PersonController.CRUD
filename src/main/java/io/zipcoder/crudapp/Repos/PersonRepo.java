package io.zipcoder.crudapp.Repos;

import io.zipcoder.crudapp.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo  extends CrudRepository <Person, Integer>{}
