package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Entities.Owner;
import com.football_field.football_field.Servicies.FootballFieldService;
import com.football_field.football_field.Statuses.Status;
import com.football_field.football_field.side_models.FootballFieldNoOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping
    public List<FootballFieldNoOwner> getFields() {
        return footballFieldService.getAllWithoutOwner();
    }

    @GetMapping("/owner")
    public List<FootballField> getFieldsByOwner(@RequestParam Long id) {
        return footballFieldService.getAllByOwner_Id(id);
    }
}
