package com.football_field.football_field.Controllers;

import com.football_field.football_field.Entities.Request;
import com.football_field.football_field.Servicies.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    private RequestService requestService;


    @PostMapping
    public Request createRequest(@RequestBody Request request, @RequestParam Long id){
        return requestService.createRequest(request,id);
    }
}
