package com.bridgelabz.lmsmentor.model;


import com.bridgelabz.lmsmentor.dto.MentorDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "mentors")
@Data
public class MentorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String mentorsType;
    private String mentorRole;
    private String mobileNumber;
    private String email;
    private String experienceYears;
    private String preferredTime;
    private String status;
    private String mentorDesc;
    private String profilePic;
    private LocalDate startDate;
    private int creatorUser;
    private long supervisorId;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;


    public MentorModel(MentorDTO mentorDTO) {
        this.employeeId = mentorDTO.getEmployeeId();
        this.firstName = mentorDTO.getFirstName();
        this.lastName = mentorDTO.getLastName();
        this.mentorsType = mentorDTO.getMentorsType();
        this.mentorRole = mentorDTO.getMentorRole();
        this.mobileNumber = mentorDTO.getMobileNumber();
        this.email = mentorDTO.getEmail();
        this.experienceYears = mentorDTO.getExperienceYears();
        this.preferredTime = mentorDTO.getPreferredTime();
        this.status = mentorDTO.getStatus();
        this.mentorDesc = mentorDTO.getMentorDesc();
        this.startDate = mentorDTO.getStartDate();
        this.creatorUser = mentorDTO.getCreatorUser();
        this.supervisorId = mentorDTO.getSupervisorId();
    }

    public MentorModel() {

    }


}
