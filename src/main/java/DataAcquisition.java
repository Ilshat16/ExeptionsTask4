import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static java.lang.System.*;

public class DataAcquisition {
    private String[] dataList;
    private UserData userData;

    public DataAcquisition() {
        dataList = new String[6];
        userData = new UserData();
    }

    public UserData getUserData() {
        return userData;
    }

    public void setDataList(){
        try (Scanner scanner = new Scanner(System.in);){
            String dataString = scanner.nextLine();
            dataList = dataString.split(" ");
        }
    }
    public void setUserData(){
        setDataList();
        setBirthday();
        setPhoneNumber();
        setGender();
        setSNP();
    }
    private void setSNP(){

    }
    private void setPhoneNumber(){
        int phoneNumber = 0;
        for (int i = 0; i < dataList.length; i++) {
            try {
                phoneNumber = Integer.parseInt(dataList[i]);
                userData.setPhoneNumber(phoneNumber);
                break;
            } catch (NumberFormatException e){
                continue;
            }
        }
    }
    private void setBirthday(){
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < dataList.length; i++) {
            try {
                userData.setBirthday(ft.parse(dataList[i]));
            } catch (ParseException e) {
                continue;
            }
        }
    }
    private void setGender(){

    }
}
