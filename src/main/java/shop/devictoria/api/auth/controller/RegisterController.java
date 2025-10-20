package shop.devictoria.api.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
public class RegisterController {
    
    @GetMapping("/register")
    public String registerPage() {
        return "auth/register";
    }
    
    @GetMapping("/csv-test")
    public String runCsvReader(Model model) {
        List<Map<String, String>> csvData = new ArrayList<>();
        
        try {
            // CSV 파일 읽기
            ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
            Reader reader = new InputStreamReader(resource.getInputStream());
            
            CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            
            System.out.println("=== CSV 파일 상위 5명 데이터 ===");
            int count = 0;
            
            for (CSVRecord record : parser) {
                if (count >= 5) break;
                
                Map<String, String> passengerData = new HashMap<>();
                passengerData.put("PassengerId", record.get("PassengerId"));
                passengerData.put("Survived", record.get("Survived"));
                passengerData.put("Pclass", record.get("Pclass"));
                passengerData.put("Name", record.get("Name"));
                passengerData.put("Sex", record.get("Sex"));
                passengerData.put("Age", record.get("Age"));
                passengerData.put("SibSp", record.get("SibSp"));
                passengerData.put("Parch", record.get("Parch"));
                passengerData.put("Ticket", record.get("Ticket"));
                passengerData.put("Fare", record.get("Fare"));
                passengerData.put("Cabin", record.get("Cabin"));
                passengerData.put("Embarked", record.get("Embarked"));
                
                csvData.add(passengerData);
                
                // 터미널에도 출력
                System.out.println("--- " + (count + 1) + "번째 승객 ---");
                System.out.println("PassengerId: " + record.get("PassengerId"));
                System.out.println("Survived: " + record.get("Survived"));
                System.out.println("Pclass: " + record.get("Pclass"));
                System.out.println("Name: " + record.get("Name"));
                System.out.println("Sex: " + record.get("Sex"));
                System.out.println("Age: " + record.get("Age"));
                System.out.println("SibSp: " + record.get("SibSp"));
                System.out.println("Parch: " + record.get("Parch"));
                System.out.println("Ticket: " + record.get("Ticket"));
                System.out.println("Fare: " + record.get("Fare"));
                System.out.println("Cabin: " + record.get("Cabin"));
                System.out.println("Embarked: " + record.get("Embarked"));
                System.out.println();
                
                count++;
            }
            
            System.out.println("총 " + count + "명의 데이터를 출력했습니다.");
            
        } catch (IOException e) {
            System.err.println("CSV 파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        
        // 웹 페이지에 데이터 전달
        model.addAttribute("csvData", csvData);
        model.addAttribute("message", "CSV 데이터를 성공적으로 읽었습니다!");
        
        return "csv-test";
    }
}
