package shop.devictoria.api.user.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import shop.devictoria.api.common.domain.Messenger;
import shop.devictoria.api.user.domain.UserDTO;
import shop.devictoria.api.user.service.UserService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
    @GetMapping("/users")
    public String printFirstFivePassengers(Model model) {
        try {
            // CSV 파일 경로
            String csvFilePath = "src/main/resources/static/csv/train.csv";

            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);

            List<UserDTO> users = new ArrayList<>();
            int count = 0;

            // 처음 5명의 데이터만 읽기
            boolean isFirstRecord = true;
            for (CSVRecord record : parser) {
                if (isFirstRecord) {
                    isFirstRecord = false;
                    continue; // 헤더 건너뛰기
                }
                
                if (count >= 5)
                    break;

                UserDTO user = new UserDTO();
                user.setPassengerId(record.get(0)); // PassengerId
                user.setSurvived(record.get(1)); // Survived
                user.setPclass(record.get(2)); // Pclass
                user.setName(record.get(3)); // Name
                user.setSex(record.get(4)); // Sex
                user.setAge(record.get(5)); // Age
                user.setSibSp(record.get(6)); // SibSp
                user.setParch(record.get(7)); // Parch
                user.setTicket(record.get(8)); // Ticket
                user.setFare(record.get(9)); // Fare
                user.setCabin(record.get(10)); // Cabin
                user.setEmbarked(record.get(11)); // Embarked

                users.add(user);
                count++;
            }

            parser.close();
            reader.close();

            Messenger messenger = userService.getFirstFivePassengers(users);
            // 데이터 처리 완료
            model.addAttribute("messenger", messenger);
            model.addAttribute("users", users);
            return "user/userlist";

        } catch (IOException e) {
            Messenger messenger = new Messenger();
            messenger.setCode(1);
            messenger.setMessage("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            model.addAttribute("messenger", messenger);
            return "user/userlist";
        }
    }
}