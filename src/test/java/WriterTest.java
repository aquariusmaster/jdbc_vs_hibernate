import dao.HibernateWriter;
import dao.JdbcWriter;
import dao.Writer;
import domain.Room;
import domain.User;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by harkonnen on 27.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:database-context.xml", "classpath:hibernate.cfg.xml"})
public class WriterTest {

    @Autowired
    @Qualifier("jdbcWriter")
    private Writer jdbcWriter;
    @Autowired
    @Qualifier("hibernateWriter")
    private Writer hibernateWriter;

    @Autowired
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql0 = "SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;";
        String sql1 = "DROP TABLE IF EXISTS `mydb`.`Room` ;";
        String sql2 = "CREATE TABLE IF NOT EXISTS `mydb`.`Room` (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `room_name` VARCHAR(100) NOT NULL," +
                "  PRIMARY KEY (`id`))" +
                "ENGINE = InnoDB" +
                "DEFAULT CHARACTER SET = utf8";

        String sql3 = "DROP TABLE IF EXISTS `mydb`.`User` ;";
        String sql4= "CREATE TABLE IF NOT EXISTS `mydb`.`User` (" +
                "  `id` INT NOT NULL AUTO_INCREMENT," +
                "  `name` VARCHAR(124) NOT NULL," +
                "  `room_number` INT NOT NULL," +
                "  PRIMARY KEY (`id`, `room_number`)," +
                "  INDEX `fk_User_Room_idx` (`room_number` ASC)," +
                "  CONSTRAINT `fk_User_Room`" +
                "    FOREIGN KEY (`room_number`)" +
                "    REFERENCES `mydb`.`Room` (`id`)" +
                "    ON DELETE NO ACTION" +
                "    ON UPDATE NO ACTION)" +
                "ENGINE = InnoDB" +
                "DEFAULT CHARACTER SET = utf8;";

        jdbcTemplate.execute(sql0);
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
        jdbcTemplate.execute(sql3);
        jdbcTemplate.execute(sql4);

    }

    @Test
    public void testFillRandom() throws Exception {

        System.out.println("In test");
        final int roomsCounts  = 200;
        final int usersCounts  = 10_000;

        //Get randoms lists of rooms and users
        List<Room> rooms = Utils.getRandomRooms(200);
        List<User> users = Utils.getRandomUsers(10000, rooms);

        long start = System.currentTimeMillis();
        jdbcWriter.saveRooms(rooms);
        jdbcWriter.saveUsers(users);
        System.out.println("Processing time: " + (System.currentTimeMillis() - start));






    }

    @Test
    public void testHibernate() throws Exception {

        System.out.println("Hiber test");
        final int roomsCounts  = 200;
        final int usersCounts  = 10_000;

        //Get randoms lists of rooms and users
        List<Room> rooms = Utils.getRandomRooms(200);
        List<User> users = Utils.getRandomUsers(10000, rooms);

        long start = System.currentTimeMillis();
        hibernateWriter.saveRooms(rooms);
        hibernateWriter.saveUsers(users);
        System.out.println("Hibernate processing time: " + (System.currentTimeMillis() - start));

    }
}