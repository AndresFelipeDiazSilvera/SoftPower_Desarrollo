package com.softpower;

import com.softpower.entities.UserSoftPower;
import com.softpower.models.services.IUserSoftpowerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private IUserSoftpowerService iUserSoftpowerService;

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Test
    void contextLoads() {
        UserSoftPower userSoftPower=new UserSoftPower();
        userSoftPower.setUsername("code");
        userSoftPower.setPassword(encoder.encode("134"));
        iUserSoftpowerService.save(userSoftPower);
    }

}
