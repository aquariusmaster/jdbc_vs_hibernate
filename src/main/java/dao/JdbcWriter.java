package dao;

import domain.Room;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by harkonnen on 27.05.16.
 */
@Repository("jdbcWriter")
public class JdbcWriter implements Writer  {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO mydb.User(name, room_number) VALUE (?, ?)";
        jdbcTemplate.update(sql, new Object[]{user.getName(), user.getRoom().getId()});
    }

    @Override
    public void save(Room room) {
        String sql = "INSERT INTO mydb.Room(room_name) VALUE (?)";
        jdbcTemplate.update(sql, new Object[]{room.getRoom_name()});
    }

    @Override
    public void saveUsers(List<User> users) {

        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mydb.User(name, room_number) VALUES ");

        for (int i = 0; i < users.size(); i++) {

            sb.append("('" + users.get(i).getName() + "',");
            sb.append(users.get(i).getRoom().getId() + ")");
            if(i < users.size() - 1){
                sb.append(",");
            }else{
                sb.append(";");
            }

        }

        jdbcTemplate.update(sb.toString());
    }

    @Override
    public void saveRooms(List<Room> rooms) {
        final StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO mydb.Room(room_name) VALUES ");

        for (int i = 0; i < rooms.size(); i++) {

            sb.append("('" + rooms.get(i).getRoom_name() + "')");

            if(i < rooms.size() - 1){
                sb.append(",");
            }else{
                sb.append(";");
            }

        }

        jdbcTemplate.update(sb.toString());
    }
}
