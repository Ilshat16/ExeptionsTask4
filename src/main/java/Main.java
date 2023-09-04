import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        DataAcquisition dataAcquisition = new DataAcquisition();
        dataAcquisition.setUserData();
        FileLoader fileLoader = new FileLoader(dataAcquisition.getUserData());
        fileLoader.loadToFile();
    }
}
