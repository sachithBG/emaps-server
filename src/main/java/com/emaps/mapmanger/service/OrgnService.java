package com.emaps.mapmanger.service;

import com.emaps.mapmanger.exception.ResourceNotFoundException;
import com.emaps.mapmanger.message.req.OriginReq;
import com.emaps.mapmanger.model.Origin;
import com.emaps.mapmanger.model.Users;
import com.emaps.mapmanger.repo.OriginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrgnService {
    private final OriginRepo originRepo;

    @Autowired
    private OrgnService(OriginRepo originRepo){
        this.originRepo = originRepo;
    }

    public ResponseEntity<?> addOrg( Origin req) throws Exception{
        try {
            System.out.println(req.getLat());
            originRepo.save(req);
            return new ResponseEntity<>(("submitted successfully!"), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>((e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findId(Long id){
        try {
            Origin org = originRepo.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("object not found for this id :: " + id)
            );
            return new ResponseEntity<>(org, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ResourceNotFoundException("Fail -> Object is not found!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> delete(Long info_id) {
        try {
            Origin user = originRepo.findById(info_id).orElseThrow(() ->
                    new ResourceNotFoundException("Origin not found for this id :: " + info_id)
            );
            originRepo.delete(user);
            return new ResponseEntity<>(("Origin deleted successfully!"), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(("Fail -> Origin is not deleted!"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
