package shop.devictoria.api.user.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

private String PassengerId;
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