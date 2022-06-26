import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query06 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("com.mysql.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        // okul: baglanti yapacagimiz database'in ismi


        Statement st = con.createStatement();


        // SORU1: Bölümler tablosunda yeni bir kayıt (80, 'ARGE', 'ISTANBUL')

        //executeUpdate etkilenen satir sayisini dondurur
       // int s1 = st.executeUpdate("insert into bolumler values (80, 'ARGE', 'ISTANBUL')");
       // System.out.println(s1+ " Satir eklendi");


        /*

        // SORU2; Bölümler tablosuna birden fazla kayıt ekleyelim.
        //1.YOL;
        String [] veri1= {"insert into bolumler values (95, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (85, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (75, 'OFIS2', 'TRABZON')"};

        int count=0;
        for (String each:veri1
             ) {
            count=count+ st.executeUpdate(each);
        }
        System.out.println(count + " Data eklendi");

         */

/*
        //2.YOL;
        String [] veri2= {"insert into bolumler values (21, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (84, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (74, 'OFIS2', 'TRABZON')"};


        for (String each:veri2
             ) {
            st.addBatch(each);   //Yukaridaki verilerin tamamini bir araya topluyor tek bir veri haline getiriyor
        }
        st.executeBatch();       // Bir araya getirilen verileri tek seferde gonderiyor

        System.out.println("Veriler DataBase eklendi");

*/

        // SORU3; Bölümler tablosuna birden fazla kayıt ekleyelim.
        //1.YOL;
        String [] veri3= {"insert into bolumler values (100, 'YEMEKHANE', 'ISTANBUL')",
                "insert into bolumler values (101, 'OFIS1', 'ANKARA')",
                "insert into bolumler values (102, 'OFIS2', 'TRABZON')",
                "insert into bolumler values (103, 'OFIS3', 'TRABZON')",
                "insert into bolumler values (104, 'OFIS4', 'TRABZON')"};

        for (String each : veri3){
            st.addBatch(each);
        }
        st.executeBatch();

        System.out.println("Veriler DataBase eklendi");

    }
}
