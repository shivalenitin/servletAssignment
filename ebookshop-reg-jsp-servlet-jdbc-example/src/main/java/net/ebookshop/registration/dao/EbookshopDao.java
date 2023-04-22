package net.ebookshop.registration.dao;

import net.ebookshop.registration.model.Ebookshop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EbookshopDao {

    public int registerEbookshop(Ebookshop ebookshop) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO ebookshop" +
            "  (book_id, book_title, book_author, book_price, quantity) VALUES " +
            " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/demoebook?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, ebookshop.getBook_id());
            preparedStatement.setString(2, ebookshop.getBook_title());
            preparedStatement.setString(3, ebookshop.getBook_author());
            preparedStatement.setString(4, ebookshop.getBook_price());
            preparedStatement.setInt(5, ebookshop.getQuantity());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
}