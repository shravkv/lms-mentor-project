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

    /*
     * Purpose : Create Mentor Details
     * @author : Sravan Kumar
     * @Param : mentorDTO and token
     */


    @PostMapping("/addMentor")
    public ResponseEntity<Response> addMentor(@RequestHeader String token,
                                              @Valid @RequestBody MentorDTO mentorDTO) {
        Response response = mentorService.addMentor(token, mentorDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Add ProfilePic Url to Mentor
     * @author : Sravan Kumar
     * @Param :  token,profilePic and id
     * */
    @PostMapping("/addProfilePicUrl")
    public ResponseEntity<Response> addProfilePic(@RequestHeader String token, @RequestParam String profilePic,
                                                  @RequestParam Long id) {
        Response response = mentorService.addProfilePic(token, id, profilePic);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Retrieve all Metors Details
     * @author : Sravan Kumar
     * @Param :  token
     * */

    @GetMapping("/getAllMentrs")
    public ResponseEntity<List<?>> getAllMentors(@RequestHeader String token) {
        List<MentorModel> response = mentorService.getAllMentors(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Update Existing Mentor Details
     * @author : Sravan Kumar
     * @Param :  mentorsDTO,token and id
     * */


    @PutMapping("/updateMentorDetails/{id}")
    public ResponseEntity<Response> updateMentorDetails(@RequestHeader String token,
                                                        @Valid @RequestBody MentorDTO mentorDTO,
                                                        @PathVariable Long id) {
        Response response = mentorService.updateMentorDetails(token, id, mentorDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Delete Existing Mentor Details
     * @author : Sravan Kumar
     * @Param :  id and token
     * */


    @DeleteMapping("/deleteMentorDetails/{id}")
    public ResponseEntity<Response> deleteDetails(@RequestHeader String token,
                                                  @PathVariable Long id) {
        Response response = mentorService.deleteDetails(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Retrieve Particular Mentor By id
     * @author : Stavan Kumar
     * @Param :  id and token
     * */


    @GetMapping("/getMentorById/{id}")
    public ResponseEntity<Response> getByMentorId(@RequestHeader String token,
                                                  @PathVariable Long id) {
        Response response = mentorService.getMentorsDetailsById(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Retrieve All Mentors Count
     * @author : Sravan Kumar
     * @Param :  token
     * */


    @GetMapping("/mentorsCont")
    public ResponseEntity<Long> mentorsCount(@RequestHeader String token) {
        Long response = mentorService.mentorsCount(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /*
     * Purpose : Retrieve Mentor Details By mentorRole
     * @author : Sravan Kumar
     * @Param :  token and mentorRole
     * */


    @GetMapping("/getMentorByRole")
    public ResponseEntity<Long> mentorRole(@RequestHeader String token,
                                           @RequestParam String mentorRole) {
        Long response = mentorService.getMentorByRole(mentorRole,token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Without Query get Count

    @GetMapping("/getAllCount")
    public ResponseEntity<Long> getAllCount(@RequestHeader String token) {
        Long response = mentorService.getAllCount(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
