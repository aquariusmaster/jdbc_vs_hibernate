package domain;

/**
 * Created by harkonnen on 27.05.16.
 */
public class User {
    private int id;
    private String name;
    private Room room;

    public User() {
    }

    public User(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    public User(int id, String name, Room room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
