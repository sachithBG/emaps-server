package com.emaps.mapmanger.controller;

import com.emaps.mapmanger.message.req.DestnReq;
import com.emaps.mapmanger.service.DestnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/denst")
public class DestnController {
    private final DestnService destnService;

    public DestnController(DestnService destnService){
        this.destnService = destnService;
    }

    @PostMapping(path = "/{orgn_id}")
    public ResponseEntity<?> addDst(@PathVariable(value = "orgn_id") Long orgn_id, @RequestBody DestnReq req) throws Exception {
        return destnService.addDst(orgn_id, req);
    }

    @GetMapping(path = "/find/{id}")
    public ResponseEntity<?> getAllDstn(@PathVariable(value = "id") Long id){
        return destnService.findAll(id);
    }

    @PutMapping(path = "/update/{loc_id}")
    public ResponseEntity<?> updateDstn(@PathVariable(value = "loc_id") Long id, @RequestBody DestnReq req) throws Exception {
        return destnService.update(id, req);
    }

    @DeleteMapping(path = "/delete/{info_id}")
    public ResponseEntity<?> deleteDstn(@PathVariable(value = "info_id") Long info_id) throws Exception {
        return destnService.deleteDenst(info_id);
    }
}
