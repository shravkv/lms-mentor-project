package com.bridgelabz.lmsmentor.controller;


import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.service.IMentorService;
import com.bridgelabz.lmsmentor.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mentors")
public class MentorController {

    @Autowired
    IMentorService mentorService;


    @PostMapping("/addMentor")
    public ResponseEntity<Response> addMentor(@RequestHeader String token,
                                              @Valid @RequestBody MentorDTO mentorDTO) {
        Response response = mentorService.addMentor(token, mentorDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/addProfilePicUrl")
    public ResponseEntity<Response> addProfilePic(@RequestHeader String token, @RequestParam String profilePic,
                                                  @RequestParam Long id) {
        Response response = mentorService.addProfilePic(token, id, profilePic);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getAllMentrs")
    public ResponseEntity<List<?>> getAllMentors(@RequestHeader String token) {
        List<MentorModel> response = mentorService.getAllMentors(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/updateMentorDetails/{id}")
    public ResponseEntity<Response> updateMentorDetails(@RequestHeader String token,
                                                        @Valid @RequestBody MentorDTO mentorDTO,
                                                        @PathVariable Long id) {
        Response response = mentorService.updateMentorDetails(token, id, mentorDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/deleteMentorDetails/{id}")
    public ResponseEntity<Response> deleteDetails(@RequestHeader String token,
                                                  @PathVariable Long id) {
        Response response = mentorService.deleteDetails(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getMentorById/{id}")
    public ResponseEntity<Response> getByMentorId(@RequestHeader String token,
                                                  @PathVariable Long id) {
        Response response = mentorService.getMentorsDetailsById(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/mentorsCont")
    public ResponseEntity<Long> mentorsCount(@RequestHeader String token) {
        Long response = mentorService.mentorsCount(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getMentorByRole")
    public ResponseEntity<Long> mentorRole(@RequestHeader String token,
                                           @RequestParam String mentorRole) {
        Long response = mentorService.getMentorByRole(mentorRole,token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllCount")
    public ResponseEntity<Long> getAllCount(@RequestHeader String token) {
        Long response = mentorService.getAllCount(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
