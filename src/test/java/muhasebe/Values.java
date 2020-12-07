package muhasebe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Values extends Util {
    private static String name1 = "rasim1234";
    private static String email1 = "rasim.avci3@gmail.com";
    private static String company1 = "ronwell";
    private static String phonenumber1 = "string";
    private static String address1 = "myaddress";
    private static String lastlogin1 = Util.getCurrentDate();
    private static String activeuntil1 = Util.getCurrentDate();
    private static String password1 = "1234";
    private static String mytoken = "";
    private static String randomid = Util.randomid1;
    private static String kwargs = "kwargs";
    private static String adminId = "588";



    public static String getAdminId() {
        return adminId;
    }

    public static void setAdminId(String adminId) {
        Values.adminId = adminId;
    }

    public Values() {


    }

    public static String getKwargs() {
        return kwargs;
    }

    public static void setKwargs(String kwargs) {
        Values.kwargs = kwargs;
    }

    public static String getRandomid() {
        return randomid;
    }

    public static void setRandomid(String  randomid) {
        Values.randomid = randomid;
    }

    public static String getMytoken() {
        return mytoken;
    }

    public static void setMytoken(String mytoken) {
        mytoken = mytoken;
    }

    public static String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getCompany1() {
        return company1;
    }

    public void setCompany1(String company1) {
        this.company1 = company1;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLastlogin1() {
        return lastlogin1;
    }

    public void setLastlogin1(String lastlogin1) {
        this.lastlogin1 = lastlogin1;
    }

    public String getActiveuntil1() {
        return activeuntil1;
    }

    public void setActiveuntil1(String activeuntil1) {
        this.activeuntil1 = activeuntil1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
