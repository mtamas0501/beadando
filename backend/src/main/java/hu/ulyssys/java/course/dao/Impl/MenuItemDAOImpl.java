package hu.ulyssys.java.course.dao.Impl;

import hu.ulyssys.java.course.dao.MenuItemDAO;
import hu.ulyssys.java.course.entity.MenuItem;

import javax.ejb.Stateless;

@Stateless
public class MenuItemDAOImpl extends CoreDAOImpl<MenuItem> implements MenuItemDAO {

    @Override
    protected Class<MenuItem> getManagedClass() {
        return MenuItem.class;
    }
}