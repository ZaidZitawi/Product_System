package com.example.productsystemdatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection databaseLink;

    public static Connection getConnection() {
        String databaseName = "dbpine";
        String databaseUser = "root";
        String databasePassword = "1203101";
        String url = "jdbc:mysql://127.0.0.1/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e){

            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }



}

//        public static ObservableList<Customer> getCustomer(){
//         Connection connection = connect();
//         ObservableList<Customer> list = FXCollections.observableArrayList();
//         try {
//             PreparedStatement ps = connection.prepareStatement("select * from users");
//             ResultSet rs = ps.executeQuery();
//
//             while (rs.next()){
//                 list.add(new Customer(Integer.parseInt(rs.getString("customerid")), rs.getString("customername"), Integer.parseInt(rs.getString("customerAge")),  rs.getString("PhoneNum"),  rs.getString("customerGender")));
//             }
//         }catch (Exception e){
//
//         }
//          return list;
//        }
//    }



