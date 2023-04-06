package com.damian.hms.convertor;

import com.damian.hms.dto.LoginDetails_DTO;
import com.damian.hms.entity.LoginDetails;

import java.util.ArrayList;

public class Convertor {
    public static LoginDetails_DTO convertLoginDetailsToLoginDetails_DTO(LoginDetails loginDetails) {
        return new LoginDetails_DTO( loginDetails.getUser_ID(),loginDetails.getUserName(), loginDetails.getPassword());
    }
    public static LoginDetails convertLoginDetails_DTOToLoginDetails(LoginDetails_DTO loginDetails_dto) {
        return new LoginDetails(loginDetails_dto.getUser_ID(), loginDetails_dto.getUserName(), loginDetails_dto.getPassword());
    }


}
