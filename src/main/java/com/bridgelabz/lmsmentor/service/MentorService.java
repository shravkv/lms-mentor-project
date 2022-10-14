package com.bridgelabz.lmsmentor.service;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.exception.LMSException;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.repository.MentorRepository;
import com.bridgelabz.lmsmentor.util.Response;
import com.bridgelabz.lmsmentor.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
 * Purpose : MentorService is used to Implement the Business Logic
 * Version : 1.0
 * @author : Sravan Kumar
 * */

@Service
public class MentorService implements IMentorService {

    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    MentorRepository mentorRepository;
    @Autowired
    RestTemplate restTemplate;

    /*
     * Purpose : Implement the Logic for Creating Mentor Details
     * @author : Sravan Kumar
     * @Param :  token and mentorsDTO
     * */

    @Override
    public Response addMentor(String token, MentorDTO mentorDTO) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            MentorModel mentorModel = new MentorModel(mentorDTO);
            mentorModel.setCreatedTimeStamp(LocalDateTime.now());
            mentorRepository.save(mentorModel);
            String body = "Mentor Added Successfully With Id is : " + mentorModel.getId();
            String subject = "Mentor Registration Successfully ...";
            mailService.send(mentorModel.getEmail(), body, subject);
            return new Response(200, "Success", mentorModel);
        }
        throw new LMSException(400, "Token Wrong");

    }

    /*
     * Purpose : Implement the Logic for Adding Mentor profilePic
     * @author : Sravan Kumar
     * @Param :  token,id and profilePic
     * */

    @Override
    public Response addProfilePic(String token, Long id, String profilePic) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(id);
            if (isMentorPresent.isPresent()) {
                isMentorPresent.get().setProfilePic(profilePic);
                mentorRepository.save(isMentorPresent.get());
                String body = "Mentor profilePic Added With Id is : " + isMentorPresent.get().getId();
                String subject = "Mentor ProfilePic Uploaded ...";
                mailService.send(isMentorPresent.get().getEmail(), body, subject);
                return new Response(200, "Success", isMentorPresent.get());
            } else {
                throw new LMSException(400, "Not found with this id");
            }
        }
        throw new LMSException(400, "Token Wrong");

    }

    /*
     * Purpose : Implement the Logic to Get All Mentors Details
     * @author : Sravan Kumar
     * @Param :  token
     * */


    @Override
    public List<MentorModel> getAllMentors(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            List<MentorModel> isMentors = mentorRepository.findAll();
            if (isMentors.size() > 0) {
                return isMentors;
            } else {
                throw new LMSException(400, "Mentors not found");
            }
        }
        throw new LMSException(400, "Token Wrong");
    }

    /*
     * Purpose : Implement the Logic to Update Mentor Details
     * @author : Sravan Kumar
     * @Param :  token,id and mentorsDTO
     * */

    @Override
    public Response updateMentorDetails(String token, Long id, MentorDTO mentorDTO) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(id);
            if (isMentorPresent.isPresent()) {
                isMentorPresent.get().setEmployeeId(mentorDTO.getEmployeeId());
                isMentorPresent.get().setFirstName(mentorDTO.getFirstName());
                isMentorPresent.get().setLastName(mentorDTO.getLastName());
                isMentorPresent.get().setMentorDesc(mentorDTO.getMentorDesc());
                isMentorPresent.get().setMentorRole(mentorDTO.getMentorRole());
                isMentorPresent.get().setMentorsType(mentorDTO.getMentorsType());
                isMentorPresent.get().setEmail(mentorDTO.getEmail());
                isMentorPresent.get().setStatus(mentorDTO.getStatus());
                isMentorPresent.get().setExperienceYears(mentorDTO.getExperienceYears());
                isMentorPresent.get().setMobileNumber(mentorDTO.getMobileNumber());
                isMentorPresent.get().setStartDate(mentorDTO.getStartDate());
                isMentorPresent.get().setPreferredTime(mentorDTO.getPreferredTime());
                isMentorPresent.get().setCreatorUser(mentorDTO.getCreatorUser());
                isMentorPresent.get().setSupervisorId(mentorDTO.getSupervisorId());
                isMentorPresent.get().setUpdatedTimeStamp(LocalDateTime.now());
                mentorRepository.save(isMentorPresent.get());
                String body = "Mentors Details Updated With Id is : " + isMentorPresent.get().getId();
                String subject = "Mentors Details Updated Successfully ...";
                mailService.send(isMentorPresent.get().getEmail(), body, subject);
                return new Response(200, "Success", isMentorPresent.get());
            } else {
                throw new LMSException(400, "Mentors not found");
            }
        }
        throw new LMSException(400, "Token Wrong");
    }

    /*
     * Purpose : Implement the Logic for Deleting Mentors Details
     * @author : Sravan Kumar
     * @Param :  token and id
     * */


    @Override
    public Response deleteDetails(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<MentorModel> isMentor = mentorRepository.findById(id);
            if (isMentor.isPresent()) {
                mentorRepository.delete(isMentor.get());
                String body = "Mentor Details Deleted With Id is : " + isMentor.get().getId();
                String subject = "Mentor Details Deleted Successfully ...";
                mailService.send(isMentor.get().getEmail(), body, subject);
                return new Response(200, "Success", isMentor.get());

            } else {
                throw new LMSException(400, "Not found with this id");
            }
        }
        throw new LMSException(400, "Token Wrong");

    }

    /*
     * Purpose : Implement the Logic to Get Mentors Details By I'd
     * @author : Sravan Kumar
     * @Param :  token and bankDetailsDTO
     * */


    @Override
    public Response getMentorsDetailsById(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<MentorModel> isMentor = mentorRepository.findById(id);
            if (isMentor.isPresent()) {
                return new Response(200, "Success", isMentor);
            } else {
                throw new LMSException(400, "Not found with this id");
            }
        }
        throw new LMSException(400, "Token Wrong");
    }

    /*
     * Purpose : Implement the Logic to Get All Mentors Count
     * @author : Sravan Kumar
     * @Param :  token and bankDetailsDTO
     * */


    @Override
    public Long mentorsCount(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long mentorsCount = mentorRepository.mentorsCount();
            return mentorsCount;
        }
        throw new LMSException(400, "Token Wrong");
    }
    /*
     * Purpose : Implement the Logic to Get Mentor Detail By Role
     * @author : Sravan Kumar
     * @Param :  token and bankDetailsDTO
     * */


    @Override
    public Long getMentorByRole(String mentorRole, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long mentorCountByRole = mentorRepository.mentorsCountByRole(mentorRole);
            return mentorCountByRole;
        }
        throw new LMSException(400, "Token Wrong");
    }

    //Without Query get count;

    @Override
    public Long getAllCount(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://ADMIN-SERVICE:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            long count = mentorRepository.count();
            if (count > 0) {
                return count;
            } else {
                throw new LMSException(400, "No Data Found");
            }
        }
        throw new LMSException(400, "Token Wrong");
    }
}
