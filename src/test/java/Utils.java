import domain.Room;
import domain.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by harkonnen on 27.05.16.
 */
public class Utils {

    final static int MAX_WORD_SIZE = 100;

    static List<Room> getRandomRooms(int count){

        List<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i< count; i++){
            rooms.add(new Room(Utils.randomString()));
        }

        return rooms;
    }


    /**
     * This method is used to get list of random users .
     * @param count is size of random Users list that will returned
     * @param rooms is list of existed rooms that users are use
     */
    static List<User> getRandomUsers(int count, List<Room> rooms){

        List<User> users = new ArrayList<User>();
        Random rand = new Random();

        for (int i = 0; i< count; i++){
            users.add(new User(Utils.randomString(), rooms.get(rand.nextInt(rooms.size()))));
        }

        return users;
    }

    static String randomString(){
        String word = "";
        Random rand = new Random();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i <rand.nextInt(MAX_WORD_SIZE-5)+5; i++){
            word+=alphabet[rand.nextInt(alphabet.length)];
        }

        return word;
    }
}
