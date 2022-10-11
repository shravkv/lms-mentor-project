package com.bridgelabz.lmsmentor.service;

import com.bridgelabz.lmsmentor.dto.MentorDTO;
import com.bridgelabz.lmsmentor.model.MentorModel;
import com.bridgelabz.lmsmentor.util.Response;

import java.util.List;

public interface IMentorService {

    Response addMentor(String token, MentorDTO mentorsDTO);

    Response addProfilePic(String token, Long id, String profilePic);

    List<MentorModel> getAllMentors(String token);

    Response updateMentorDetails(String token, Long id, MentorDTO mentorsDTO);

    Response deleteDetails(String token, Long id);

    Response getMentorsDetailsById(String token, Long id);

    Long mentorsCount(String token);

    Long getMentorByRole(String token, String s);

    Long getAllCount(String token);
}
