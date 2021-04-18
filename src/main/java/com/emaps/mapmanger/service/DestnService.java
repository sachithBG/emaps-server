package com.emaps.mapmanger.service;

import com.emaps.mapmanger.exception.ResourceNotFoundException;
import com.emaps.mapmanger.message.req.DestnReq;
import com.emaps.mapmanger.model.Destination;
import com.emaps.mapmanger.model.Origin;
import com.emaps.mapmanger.repo.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ResponseMessage;

import java.util.HashSet;
import java.util.Set;

@Service
public class DestnService {
    private final DestinationRepo destinationRepo;
    private final OrgnService orgnService;

    @Autowired
    private DestnService(DestinationRepo destinationRepo, OrgnService orgnService){
        this.destinationRepo = destinationRepo;
        this.orgnService = orgnService;
    }

    public ResponseEntity<?> addDst( Long id, DestnReq req) throws Exception{
        try {
            ResponseEntity<?> res = orgnService.findId(id);
            if (res.getStatusCodeValue() != 200){
                return res;
            }

            Destination ds = destinationRepo.save(new Destination( req.getAddress(), req.getLat(), req.getLng(), (Origin) res.getBody()));

            return new ResponseEntity<>(ds, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>((e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> update(Long id, DestnReq req) throws Exception {
        try {
            Destination destination = destinationRepo.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Object not found for this id :: " + id)
            );
            destination.setAddress(req.getAddress());
            destination.setLat(req.getLat());
            destination.setLng(req.getLng());
            destination = destinationRepo.save(destination);
            return new ResponseEntity<>(destination,
                    HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> deleteDenst(Long id) throws Exception {
        try {
            Destination destination = destinationRepo.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("Data not found for this id :: " + id)
            );
            destinationRepo.delete(destination);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(("Fail -> not deleted!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findAll(Long id) {
        Set<Destination> destinations = new HashSet<>();
        try {
            ResponseEntity<?> res = orgnService.findId(id);
            if (res.getStatusCodeValue() != 200){
                return res;
            }
            destinationRepo.findAllByOrigin((Origin) res.getBody()).forEach(destinations::add);
            return ResponseEntity.ok(destinations);
        }catch (Exception e){
            return new ResponseEntity<>((e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
