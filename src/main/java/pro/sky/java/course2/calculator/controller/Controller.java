package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.CalculatedService;

@RestController
@RequestMapping("/calculator")
public class Controller {
    private final CalculatedService calculated;

    public Controller(CalculatedService calculated) {
        this.calculated = calculated;
    }

    @GetMapping
    public String getGreetings() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String showPlus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + calculated.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String showMinus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " - " + num2 + " = " + calculated.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String showMultiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " * " + num2 + " = " + calculated.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String showDivide(@RequestParam int num1, @RequestParam int num2) {
        if (calculated.divide(num1, num2) == -1) {
            return "Ошибка!!! Делить на ноль нельзя";
        } else {
            return num1 + " / " + num2 + " = " + calculated.divide(num1, num2);
        }
    }
}
