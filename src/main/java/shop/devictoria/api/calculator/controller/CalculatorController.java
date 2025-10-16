package shop.devictoria.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import shop.devictoria.api.calculator.domian.CalculatorDTO;
import shop.devictoria.api.calculator.service.CalculatorService;

@Controller
public class CalculatorController {


    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }



    
    @GetMapping("/calculator/calculate")
    public int calculate(
            @RequestParam ("num1") int num1,
            @RequestParam ("num2") int num2,
            @RequestParam ("operator") String operator) {
        
        System.out.println("계산기 컨트롤러로 들어옴");
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("operator: " + operator);
        
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setOperator(operator);

        
        return calculatorService.calculator(calculatorDTO);
    }   
}

