import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "1234");
        // okul: baglanti yapacagimiz database'in ismi




        //Statement st = con.createStatement();

        //Statement yerine kullandik
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler");

        ResultSet rs= ps.executeQuery();

        ResultSetMetaData rsmd= rs.getMetaData();

        System.out.println("1. Sutun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. Sutun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. Sutun ismi : " + rsmd.getColumnName(3));
        System.out.println("4. Sutun ismi : " + rsmd.getColumnName(4));

        System.out.println("Toplam Sutun sayisi : " + rsmd.getColumnCount());

        System.out.println("===============================================================================");


        System.out.println("1. Sutunun data Tipi : " +rsmd.getColumnTypeName(1));
        System.out.println("2. Sutunun data Tipi : " +rsmd.getColumnTypeName(2));
        System.out.println("3. Sutunun data Tipi : " +rsmd.getColumnTypeName(3));
        System.out.println("4. Sutunun data Tipi : " +rsmd.getColumnTypeName(4));

        System.out.println("===============================================================================");


        System.out.println("Tablonun ismi : " + rsmd.getTableName(1));
        System.out.println(rsmd.getColumnDisplaySize(1));
        System.out.println(rsmd.getCatalogName(1));

        while (rs.next()){
            System.out.println(rs.getInt(1)+ rs.getString(2)+ rs.getString(3)+rs.getString(4));
        }

    }
}
