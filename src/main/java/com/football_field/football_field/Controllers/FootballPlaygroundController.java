package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.FootballPlayground;
import com.football_field.football_field.Servicies.FootballPlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/football")
public class FootballPlaygroundController {
    @Autowired
    private FootballPlaygroundService footballPlaygroundService;

    @PostMapping("/save")
    public FootballPlayground save(@RequestBody FootballPlayground footballPlayground){
        return footballPlaygroundService.save(footballPlayground);
    }


    @PostMapping("/create")
    public FootballPlayground create(@RequestBody FootballPlayground footballPlayground){
        return footballPlaygroundService.create(footballPlayground);
    }

    @GetMapping("/getAll")
    public List<FootballPlayground> getAll(){
        return footballPlaygroundService.getAll();
    }
}
