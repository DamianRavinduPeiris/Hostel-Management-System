package com.damian.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class LoginDetails_DTO implements SuperDTO{
    private String user_ID;
    private String userName;
    private String password;
}
