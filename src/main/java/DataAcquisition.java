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
        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i] != null)
                if (userData.getSurname() == null)
                    userData.setSurname(dataList[i]);
                else if (userData.getName() == null)
                    userData.setName(dataList[i]);
                else if (userData.getPatronymic() == null)
                    userData.setPatronymic(dataList[i]);
        }
    }
    private void setPhoneNumber(){
        for (int i = 0; i < dataList.length; i++) {
            try {
                userData.setPhoneNumber(Integer.parseInt(dataList[i]));
                dataList[i] = null;
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
                dataList[i] = null;
            } catch (ParseException e) {
                continue;
            }
        }
    }
    private void setGender(){
        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i] != null) {
                if (dataList[i].equalsIgnoreCase("male")){
                    userData.setGender(Gender.MALE);
                    dataList[i] = null;
                }
                else if (dataList[i].equalsIgnoreCase("female")) {
                    userData.setGender(Gender.FEMALE);
                    dataList[i] = null;
                }
            }
        }
    }
}
