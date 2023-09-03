import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DataAcquisition dataAcquisition = new DataAcquisition();
        dataAcquisition.setUserData();
        System.out.println(dataAcquisition.getUserData().getBirthday());
    }
}
