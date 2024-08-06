package com.spring.boot.SpringFirsrApplication.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {

    public boolean status;
    public String message;
    public T data;
    public String error;

//    public CommonResponse(boolean status,String message,T data,String error){
//        this.message=message;
//        this.status=status;
//        this.data=data;
//        this.error=error;
//    }


}
