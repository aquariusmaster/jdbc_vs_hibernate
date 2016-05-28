package dao;

import domain.Room;
import domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by harkonnen on 28.05.16.
 */
@Repository("hibernateWriter")
public class HibernateWriter implements Writer {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {

    }

    @Override
    public void save(Room room) {

    }

    @Override
    public void saveUsers(List<User> users) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(users);
    }

    @Override
    public void saveRooms(List<Room> rooms) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(rooms);
    }
}
