package dao;

import domain.Room;
import domain.User;

import java.util.List;

/**
 * Created by harkonnen on 27.05.16.
 */
public interface Writer {
    void save(User user);
    void save(Room room);
    void saveUsers(List<User> users);
    void saveRooms(List<Room> rooms);
}
