package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class demoConfig {
    @Bean
    public Student getStudent(){
        return new Student(42, "Jimothy");
    }

    @Bean
    @Primary
    public Address getAddress(){
        return new Address("Houston", "Texas", "US", "77033");
    }

    @Bean
    public List<Phone> getPhone(){
        List<Phone> tempPhone = new ArrayList<>();
        tempPhone.add(new Phone("8325851189"));
        return tempPhone;

    }
}
