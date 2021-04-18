package com.emaps.mapmanger.controller;

import com.emaps.mapmanger.service.OrgnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orgn")
public class OrgnController {
    private final OrgnService orgnService;

    public OrgnController( OrgnService orgnService){
        this.orgnService = orgnService;
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<?> getOrgn(@PathVariable(value = "id") Long id){
        return orgnService.findId(id);
    }

    @DeleteMapping(path = "/delete/{info_id}")
    public ResponseEntity<?> deleteOrgn(@PathVariable(value = "info_id") Long info_id) throws Exception {
        return orgnService.delete(info_id);
    }

}
