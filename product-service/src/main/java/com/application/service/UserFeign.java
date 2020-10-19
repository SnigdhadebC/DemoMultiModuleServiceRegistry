package com.application.service;

import com.application.model.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-service", fallbackFactory = HystrixFallbackImplementation.class)
public interface UserFeign {

    @RequestMapping("/api/v1/user/{userId}")
    public User getUser(@PathVariable("userId") String name);
}

@Component
class HystrixFallbackImplementation implements FallbackFactory<UserFeign>{

    @Override
    public UserFeign create(Throwable exception) {
        return new UserFeign() {
            @Override
            public User getUser(String name) {
                System.out.println(exception.getMessage());
                return new User();
            }
        };
    }
}
