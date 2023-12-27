package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.Sql;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = Sql.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByGeneratedIdThenMustBeTheSame() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item(item.getId(), "new_item");
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId())).isEqualTo(newItem);
    }

    @Test
    public void whenDeleteItemAndFindByGeneratedIdThenMustBeNull() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindAllItemsAndContainsAllIsTrue() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll().containsAll(List.of(item, item1, item2))).isTrue();
    }

    @Test
    public void whenFindByNameItemsAndContainsAllIsTrue() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        Item item2 = new Item("item");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("item").containsAll(List.of(item, item2))).isTrue();
    }

    @Test
    public void whenFindByIdItemAndFindByGeneratedIdThenMustBeIsNotNull() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isNotNull();
    }

    @Test
    public void whenDeleteOneItemAndFindByGeneratedIdAnotherItemThenMustBeTheSame() {
        Sql tracker = new Sql(connection);
        Item item = new Item("item");
        Item item1 = new Item("item1");
        tracker.add(item);
        tracker.add(item1);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item1.getId())).isEqualTo(item1);
    }

}
