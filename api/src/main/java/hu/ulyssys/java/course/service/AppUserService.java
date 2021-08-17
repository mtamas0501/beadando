package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.AppUser;



public interface AppUserService extends CoreService<AppUser>{

    AppUser findByUsername(String username);
}
