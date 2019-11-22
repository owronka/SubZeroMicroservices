package com.axxessio.axx2cld.login;
 
import java.io.IOException;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import com.axxessio.axx2cld.login.controller.CreateDataAtBeginning;
 
@SpringBootApplication
public class LoginApplication {
 
    public static void main(String[] args) throws IOException {
        SpringApplication.run(LoginApplication.class, args);
 
         
    }
 
}