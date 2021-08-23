package hu.ulyssys.java.course.dao.Impl;

import hu.ulyssys.java.course.dao.OrderDAO;
import hu.ulyssys.java.course.entity.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderDAOImpl extends CoreDAOImpl<Order> implements OrderDAO {
    @Override
    protected Class<Order> getManagedClass() {
        return Order.class;
    }
}
