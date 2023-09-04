import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileLoader {
    private UserData userData;

    public FileLoader(UserData userData) {
        this.userData = userData;
    }

    public void loadToFile(){
        String fileName = userData.getSurname();
        try (FileWriter fileWriter = new FileWriter(fileName + ".txt", true)){
            fileWriter.append(formattingData() + "\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String formattingData(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        sb.append("<" + userData.getSurname() + ">");
        sb.append("<" + userData.getName() + ">");
        sb.append("<" + userData.getPatronymic() + ">");
        sb.append("<" + df.format(userData.getBirthday()) + ">");
        sb.append("<" + userData.getPhoneNumber() + ">");
        sb.append("<" + userData.getGender() + ">");
        return sb.toString();
    }
}
