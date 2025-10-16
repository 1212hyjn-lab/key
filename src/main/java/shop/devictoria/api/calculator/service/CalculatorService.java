package shop.devictoria.api.calculator.service;

import org.springframework.stereotype.Service;

import shop.devictoria.api.calculator.domian.CalculatorDTO;


@Service
public class CalculatorService {
    
    public int calculator(CalculatorDTO calculatorDTO) {
        System.out.println("계산기 서비스 호출됨");
        System.out.println("서비스로 전달된 첫 번째 숫자: " + calculatorDTO.getNum1());
        System.out.println("서비스로 전달된 두 번째 숫자: " + calculatorDTO.getNum2());
        int num1 = calculatorDTO.getNum1();
        int num2 = calculatorDTO.getNum2();
if (calculatorDTO.getOperator().equals("+")) {
    return num1 + num2;
} else if (calculatorDTO.getOperator().equals("-")) {
    return num1 - num2;
} else if (calculatorDTO.getOperator().equals("*")) {
    return num1 * num2;
} else if (calculatorDTO.getOperator().equals("/")) {
    return num1 / num2;
}
        return 0;
    }
}
