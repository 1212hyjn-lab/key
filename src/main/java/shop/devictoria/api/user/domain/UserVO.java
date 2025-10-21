package shop.devictoria.api.user.domain;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@NoArgsConstructor
@AllArgsConstructor

public class UserVO {
    private String UserId;
    private String Survived;
    private String Pclass;
    private String Name;
    private String Sex;
    private String Age;
    private String SibSp;
    private String Parch;
    private String Ticket;
    private String Fare;
    private String Cabin;
    private String Embarked;

   
}
