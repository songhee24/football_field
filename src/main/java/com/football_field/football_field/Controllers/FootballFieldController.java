package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Servicies.FootballFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/football")
public class FootballFieldController {
    @Autowired
    private FootballFieldService footballFieldService;

    @PostMapping("/save")
    public FootballField save(@RequestBody FootballField footballField){
        return footballFieldService.save(footballField);
    }


    @PostMapping("/create")
    public FootballField create(@RequestBody FootballField footballField){
        return footballFieldService.create(footballField);
    }

    @GetMapping("/getAll")
    public List<FootballField> getAll(){
        return footballFieldService.getAll();
    }
}
