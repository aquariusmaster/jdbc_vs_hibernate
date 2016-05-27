package domain;

/**
 * Created by harkonnen on 27.05.16.
 */
public class Room {
    private int id;
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
