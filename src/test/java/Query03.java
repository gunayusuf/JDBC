import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch59?serverTimezone=UTC", "root", "1234");
        // okul: baglanti yapacagimiz database'in ismi


        Statement st = con.createStatement();


        // SORU1: Bölümler tablosundan tüm kayıtları listeleyiniz.

        ResultSet veri = st.executeQuery("select * from bolumler");

        while (veri.next()) {

            System.out.printf("%-6d %-15.15s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3));
        }


        System.out.println("====================================================================");


        // SORU2:SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını,
        // maaş ters sıralı listeleyiniz.
        ResultSet rs2 = st.executeQuery("select personel_isim, maas from personel" +
                " where bolum_id in(10,30)" +
                " order by maas desc");
        while (rs2.next()){
            System.out.println(rs2.getString(1)+"\t"+rs2.getInt(2));
        }
        System.out.println("==================================================================================");
        // Soru3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,
        // bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.
        ResultSet rs3 = st.executeQuery("select personel.personel_isim, bolumler.bolum_isim, personel.maas from personel " +
                "right join bolumler " +
                "on personel.bolum_id = bolumler.bolum_id " +
                "order by bolumler.bolum_isim, personel.maas");
        while (rs3.next()){
            System.out.println(rs3.getString(1) + "\t" + rs3.getString(2) + "\t" + rs3.getInt(3));
        }


        // SORU4: Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz.
        System.out.println("==================================================================================");

        ResultSet rs4=st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas " +
                "from bolumler b left join personel p" +
                " on b.bolum_id=p.bolum_id " +
                "order by maas desc limit 10");

        while (rs4.next()){
            System.out.printf("%-10s %-10s %6d\n",rs4.getString(1),rs4.getString(2),rs4.getInt(3));
        }



        con.close();
        st.close();
        veri.close();
        rs2.close();
        rs3.close();
        rs4.close();
    }
}
