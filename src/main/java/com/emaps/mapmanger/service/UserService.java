package com.emaps.mapmanger.service;

import com.emaps.mapmanger.exception.ResourceNotFoundException;
import com.emaps.mapmanger.message.req.UserReq;
import com.emaps.mapmanger.model.Address;
import com.emaps.mapmanger.model.Origin;
import com.emaps.mapmanger.model.Users;
import com.emaps.mapmanger.repo.AddressRepo;
import com.emaps.mapmanger.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserRepo userRepo;
    private  OrgnService orgnService;
    private AddressRepo addressRepo;

    @Autowired
    public UserService(UserRepo userRepo, OrgnService orgnService, AddressRepo addressRepo){
        this.userRepo = userRepo;
        this.orgnService = orgnService;
        this.addressRepo = addressRepo;
    }

    public ResponseEntity<?> addUser(UserReq usr_rq) throws Exception{
        try {

            if (userRepo.existsByEmail(usr_rq.getEmail())) {
                return new ResponseEntity<>("Fail -> email is already taken!",
                        HttpStatus.BAD_REQUEST);
            }

            Users user= new Users(usr_rq.getEmail());
            Users user1 =  userRepo.save(user);
            orgnService.addOrg(new Origin(usr_rq.getOrigin().getLat(), usr_rq.getOrigin().getLng(), user1));
            addressRepo.save(new Address(usr_rq.getAddress().getHouse_no(), usr_rq.getAddress().getStreet_address(),
                    usr_rq.getAddress().getCity(), usr_rq.getAddress().getState(),
                    usr_rq.getAddress().getZipcode(), usr_rq.getAddress().getCountry(), user1));
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>((e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findUsers(String email){
        try {
            Users user = userRepo.findByEmail(email).orElseThrow(() ->
                    new ResourceNotFoundException("User not found for this id :: " + email)
            );
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(new ResourceNotFoundException("Fail -> User is not found!"),
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> delete(Long user_id) throws Exception {
        try {
            Users user = userRepo.findById(user_id).orElseThrow(() ->
                    new ResourceNotFoundException("User not found for this id :: " + user_id)
            );
            userRepo.delete(user);
            return new ResponseEntity<>(("User deleted successfully!"), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(("Fail -> User is not deleted!"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
