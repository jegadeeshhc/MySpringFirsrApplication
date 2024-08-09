package com.spring.boot.SpringFirsrApplication.service;

import com.spring.boot.SpringFirsrApplication.dto.UserDto;
import com.spring.boot.SpringFirsrApplication.model.User;
import com.spring.boot.SpringFirsrApplication.repository.UserRepository;
import com.spring.boot.SpringFirsrApplication.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public CommonResponse<List<UserDto>> getAllUserDetails(){
        try {
            List<User> userList=userRepository.findAll();
            if(! userList.isEmpty()) {
                List<UserDto> userDtoList = new ArrayList<UserDto>();
                for (User user : userList) {
                    UserDto userDto = new UserDto();
                    userDto.setId(user.getId());
                    userDto.setFirstName(user.getFirstName());
                    userDto.setLastName(user.getLastName());
                    userDto.setEmail(user.getEmail());
                    userDtoList.add(userDto);
                }
                return new CommonResponse<List<UserDto>>(true, "All User Details Fetched", userDtoList, null);
            }else{
                return new CommonResponse<>(true,"NO User details is there",null,null);
            }
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"All User details not fetched",null,null);
        }
    }

    public  CommonResponse<UserDto> getuserdetailsById(int id){
        try {
            Optional<User> optionalUser= userRepository.findById(id);
            if (optionalUser.isPresent()){
               User user = optionalUser.get();
               UserDto userDto = new UserDto();
               userDto.setEmail(user.getEmail());
               userDto.setFirstName(user.getFirstName());
               userDto.setLastName(user.getLastName());
               userDto.setId(user.getId());
               return new CommonResponse<UserDto>(true,"User Details fetched in this id :"+id ,userDto,null);
            }else {
                return new CommonResponse<UserDto>(true,"User id \""+id+"\" is invalid" ,null,null);
            }
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User details not fetched for this id :"+id ,null,"ERROR");
        }
    }

    public CommonResponse<UserDto> getUserDetailsByEmailId(String email){
        try{
              Optional<User> optionalUser = userRepository.findByEmail(email);
              if(optionalUser.isPresent()){
                  User user = optionalUser.get();
                  UserDto userDto = new UserDto();
                  userDto.setEmail(user.getEmail());
                  userDto.setId(user.getId());
                  userDto.setEmail(user.getEmail());
                  userDto.setFirstName(user.getFirstName());
                  userDto.setLastName(user.getLastName());
                  return new CommonResponse<>(true,"user details fetched in this email id :"+email,userDto,null);
              }else{
                  return new CommonResponse<>(true,"User email id \""+email+"\" is invalid ",null,null);
              }
        } catch (Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User details not fetched for this email id :"+email ,null,"ERROR");
        }
    }

    public  CommonResponse<User> createUser(User user){
        try {
            User userDetails= userRepository.save(user);
            return new CommonResponse<>(true,"User is created successfully",userDetails,null);
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User is not created",null,"ERROR");
        }
    }

    public  CommonResponse<UserDto> upadteUserDetailsById(int id,User newUser){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()){
                System.out.println("new User  ===>> "+newUser);
                User user =  optionalUser.get();
                user.setFirstName(newUser.getFirstName());
                user.setLastName(newUser.getLastName());
                user.setEmail(newUser.getEmail());
                user.setPhoneNumber(newUser.getPhoneNumber());
                System.out.println("User  ===>> "+user);
                userRepository.save(user);
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setEmail(user.getEmail());
                userDto.setFirstName(user.getFirstName());
                userDto.setLastName(user.getLastName());
                System.out.println("User DTO  ===>> "+userDto);
                return new CommonResponse<>(true,"User Details updated Successfully ",userDto,null);
            }else{
                return new CommonResponse<>(true,"User Id \""+id+"\" is invalid ",null,null);
            }
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User details not Updated in this id :"+id ,null,"ERROR");
        }
    }

    public CommonResponse<UserDto> updateUserDetailsByEmail(User newUser,String email){
       try{
           Optional<User> optionalUser = userRepository.findByEmail(email);
           if (optionalUser.isPresent()) {
               System.out.println("NEw User  ===>> "+newUser);
               User user = optionalUser.get();
               user.setFirstName(newUser.getFirstName());
               user.setLastName(newUser.getLastName());
               user.setEmail(newUser.getEmail());
               user.setPhoneNumber(newUser.getPhoneNumber());
               System.out.println("User  ===>> "+user);
               userRepository.save(user);
               UserDto userDto = new UserDto();
               userDto.setId(user.getId());
               userDto.setEmail(user.getEmail());
               userDto.setFirstName(user.getFirstName());
               userDto.setLastName(user.getLastName());
               System.out.println("User DTO  ===>> "+userDto);
               return new CommonResponse<>(true, "User Details updated Successfully ", userDto, null);
           }else{
               return new CommonResponse<>(true,"User email id \""+email+"\" is invalid ",null,null);
           }
       }catch(Exception exception){
           System.out.println("Exception ---<><><> "+exception);
           return new CommonResponse<>(false,"User details not updated ",null,null);
       }
    }
    public CommonResponse delateUser(int id){
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                userRepository.delete(user);
                return new CommonResponse(true,"User Details deleted Successfully",null,null);
            }else{
                return new CommonResponse<>(true,"User Id \""+id+"\" is invalid ",null,null);
            }
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User details not Deleted",null,"ERROR");
        }
    }

    public CommonResponse deleteUserByEmail( String email){
        try{
            Optional<User> optionalUser = userRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                userRepository.delete(user);
                return new CommonResponse(true, "User Details deleted Successfully", null, null);
            }else{
                return new CommonResponse<>(true,"User email id  \""+email+"\" is invalid ",null,null);
            }
        }catch(Exception exception){
            System.out.println("Exception ---<><><> "+exception);
            return new CommonResponse<>(false,"User details not Deleted",null,"ERROR");
        }

    }

}
