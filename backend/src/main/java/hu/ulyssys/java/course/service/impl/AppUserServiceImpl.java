package hu.ulyssys.java.course.service.impl;

import hu.ulyssys.java.course.dao.AppUserDAO;
import hu.ulyssys.java.course.entity.AppUser;
import hu.ulyssys.java.course.service.AppUserService;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class AppUserServiceImpl extends CoreServiceImpl<AppUser> implements AppUserService {
    @Override
    public AppUser findByUsername(String username) {
        return ((AppUserDAO)dao ).findByUsername(username);
    }

}
