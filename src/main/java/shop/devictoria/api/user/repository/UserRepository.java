package shop.devictoria.api.user.repository;

import org.springframework.stereotype.Repository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import shop.devictoria.api.user.domain.UserDTO;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Repository
public class UserRepository {
    
    public void printSamplePassengers() {
        List<UserDTO> passengers = getSamplePassengers();
        
        System.out.println("=== Titanic 승객 명단 (첫 5명) ===");
        
        for (int i = 0; i < passengers.size() && i < 5; i++) {
            UserDTO user = passengers.get(i);
            System.out.println("승객 " + (i + 1) + ":");
            System.out.println("  ID: " + user.getPassengerId());
            System.out.println("  이름: " + user.getName());
            System.out.println("  생존: " + (user.getSurvived().equals("1") ? "생존" : "사망"));
            System.out.println("  등급: " + user.getPclass() + "등급");
            System.out.println("  성별: " + user.getSex());
            System.out.println("  나이: " + user.getAge());
            System.out.println("  티켓: " + user.getTicket());
            System.out.println("  요금: " + user.getFare());
            System.out.println("  승선항구: " + user.getEmbarked());
            System.out.println("--------------------------------");
        }
    }
    
    public List<UserDTO> getSamplePassengers() {
        List<UserDTO> passengers = new ArrayList<>();
        
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";
            
            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
            
            int count = 0;
            
            // 처음 5명의 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5) break;
                
                UserDTO user = new UserDTO();
                user.setPassengerId(record.get("PassengerId"));
                user.setSurvived(record.get("Survived"));
                user.setPclass(record.get("Pclass"));
                user.setName(record.get("Name"));
                user.setSex(record.get("Sex"));
                user.setAge(record.get("Age"));
                user.setSibSp(record.get("SibSp"));
                user.setParch(record.get("Parch"));
                user.setTicket(record.get("Ticket"));
                user.setFare(record.get("Fare"));
                user.setCabin(record.get("Cabin"));
                user.setEmbarked(record.get("Embarked"));
                
                passengers.add(user);
                count++;
            }
            
            parser.close();
            reader.close();
            
        } catch (IOException e) {
            System.err.println("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        return passengers;
    }
}
 