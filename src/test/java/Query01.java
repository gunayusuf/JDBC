import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


         // 1- Driver Yukle
         Class.forName("com.mysql.jdbc.Driver");

         //2- Baglanti Olustur
       Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC","root","1234");
        // okul: baglanti yapacagimiz database'in ismi

        //3- Statement: SQL kodlarimizi yazmak icin bir obje olustur
        Statement st=con.createStatement();

        //4- ResultSet:
       ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5- sonuclari al

        while(veri.next()){
           // System.out.println(veri.getInt(1)+ veri.getString(2)
           // + veri.getString(3)+ veri.getString(4));

            //tablodaki sutunun indexi yerine tablodaki sutun isimlerini de kullanabiliriz

            System.out.println(veri.getInt("okul_no")+ veri.getString("ogrenci_ismi")
                    + veri.getString("sinif")+ veri.getString("cinsiyet"));

            // PRİNT F ile yazimi
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }

        //6- Kapatma
        con.close();
        st.close();
        veri.close();



    }
}
