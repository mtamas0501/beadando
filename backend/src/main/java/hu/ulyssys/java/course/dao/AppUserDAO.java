package hu.ulyssys.java.course.dao;

import hu.ulyssys.java.course.entity.AppUser;

public interface AppUserDAO extends CoreDAO<AppUser>{
    AppUser findByUserName(String username);
}
