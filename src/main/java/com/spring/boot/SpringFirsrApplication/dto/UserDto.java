package com.spring.boot.SpringFirsrApplication.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public int id;
    public String firstName;
    public String lastName;
    public String email;

}
