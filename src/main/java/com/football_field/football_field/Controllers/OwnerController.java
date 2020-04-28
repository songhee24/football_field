package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Servicies.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;


    @PostMapping
    public Owner save(@RequestBody Owner owner){
        return ownerService.save(owner);
    }

    @GetMapping
    public Owner getById(@RequestParam Long id){
        return ownerService.getById(id);
    }

}
