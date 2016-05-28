package domain;

import javax.persistence.*;

/**
 * Created by harkonnen on 27.05.16.
 */
@Entity
@Table(name="Room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="room_name")
    private String room_name;

    public Room() {
    }

    public Room(String room_name) {
        this.room_name = room_name;
    }

    public Room(int id, String room_name) {
        this.id = id;
        this.room_name = room_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                '}';
    }
}
