package by.itclass._01_jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class Main {
    public static void main(String[] args) {
        //var datasource = new DriverManagerDataSource();
        var datasource = new SimpleDriverDataSource();
        datasource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        datasource.setUrl("jdbc:mysql://localhost:3306/po_2211");
        datasource.setUsername("root");
        datasource.setPassword("");

        var jdbcTemplate = new JdbcTemplate(datasource);

        var users = jdbcTemplate.query("SELECT * FROM user", new UserRowMapping());
        users.forEach(System.out::println);

        System.out.println("________________________________________________");
        jdbcTemplate.query("SELECT * FROM user WHERE id > ?", new UserRowMapping(), new Object[]{1})
                .forEach(System.out::println);
        System.out.println("________________________________________________");
        jdbcTemplate.update("UPDATE user SET name = ? WHERE id = ?", "Vasiok Pupkin", 1);
        jdbcTemplate.query("SELECT * FROM user", new UserRowMapping())
                .forEach(System.out::println);
    }

}
