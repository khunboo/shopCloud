package com.khunboo.utils;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "manage")
@Data
public class ManageUtils {

    private String passwordSalt;
}
