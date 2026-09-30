// https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html#anatomy-of-a-typical-sql-injection-vulnerability

import java.sql.*;
import javax.servlet.http.HttpServletRequest;

public class SqlInjection {
    public static ResultSet doQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = " + customerName;
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }

    public static ResultSet doLoginQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String query = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        return(results);
    }
}
