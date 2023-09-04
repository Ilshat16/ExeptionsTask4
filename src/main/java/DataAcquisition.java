import CustomExeptions.FormatExeption;

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
        boolean flag = false;
        setDataList();
        try {
            setBirthday();
        } catch (FormatExeption e){
            out.println(e.getMessage());
            flag = true;
        }
        try {
            setGender();
        } catch (FormatExeption e){
            out.println(e.getMessage());
            flag = true;
        }
        try {
            setPhoneNumber();
        } catch (FormatExeption e){
            out.println(e.getMessage());
            flag = true;
        }
        setSNP();
        if (flag)
            throw new RuntimeException("Повторите попытку ввода");
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
    private void setPhoneNumber() throws FormatExeption{
        for (int i = 0; i < dataList.length; i++) {
            try {
                userData.setPhoneNumber(Long.parseLong(dataList[i]));
                dataList[i] = null;
                break;
            } catch (NumberFormatException e){
                continue;
            }
        }
        if (userData.getPhoneNumber() == 0)
            throw new FormatExeption("Нет строки числового формата");
    }
    private void setBirthday() throws FormatExeption{
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < dataList.length; i++) {
            try {
                userData.setBirthday(ft.parse(dataList[i]));
                dataList[i] = null;
            } catch (ParseException e) {
                continue;
            }
        }
        if (userData.getBirthday() == null)
            throw new FormatExeption("Нет строки удовлетворяющей формату даты");
    }
    private void setGender() throws FormatExeption{
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
        if (userData.getGender() == null)
            throw new FormatExeption("Нет строки указывающего пол");
    }
}
