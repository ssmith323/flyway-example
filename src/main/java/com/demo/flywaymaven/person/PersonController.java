package com.demo.flywaymaven.person;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Person getAll(@PathVariable()  Long id) throws Exception {
        return personRepository.findById(id).orElseThrow(() -> new Exception());
    }
}
