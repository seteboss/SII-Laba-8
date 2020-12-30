package com.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductionModels {

    List<Rule> rules = new ArrayList<>();

    List<String> workingMemory = new ArrayList<>();

    public void straightRun() {
        List<String> result = new ArrayList<>();
        boolean applicationRule;
        do {
            applicationRule = false;
            for (int i = 0, size = rules.size(); i < size; i++) {
                if (checkRuleInWorkingMemory(rules.get(i))) {
                    applicationRule = true;
                    workingMemory.add(rules.get(i).getConsequent());
                    result.add(rules.get(i).getConsequent());
                    rules.remove(i);
                    size--;
                    i--;
                }
            }
            if (!applicationRule) {
                break;
            }
        } while (!rules.isEmpty());
        printResult(result);
    }

    private void printResult(List<String> list) {
        if (!list.isEmpty()) {
            System.out.println("Рекомендуется:");
            for (String s : list) {
                System.out.println(s);
            }
        } else {
            System.out.println("Алгоритм не дал результатов");
        }
    }


    private boolean checkRuleInWorkingMemory(Rule rule) {
        for (String antecedent : rule.getAntecedents()) {
            boolean premiseCheck = false;
            for (String premise : workingMemory) {
                if (premise.equals(antecedent)) {
                    premiseCheck = true;
                    break;
                }
            }
            if (!premiseCheck) {
                return false;
            }
        }
        return true;
    }

    public void initForTask1() {
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Натуральный", "Серия - Зима", "Цена - Небольшая"), "Каска - Труд"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Омон", "Цена - Средняя"), "Каска - Байкал"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Зима", "Цена - Высокая"), "Каска - СОМ 3-53 Люкс"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Рабочий", "Цена - Небольшая"), "Каска - СуперБосс"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Натуральный", "Серия - Комфорт", "Цена - Средняя"), "Каска - Эйрвинг"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Зима", "Цена - Высокая"), "Каска - Вигард"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Натуральный", "Серия - Зима", "Цена - Небольшая"), "Каска - Металлург"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Омон", "Цена - Средняя"), "Каска - Сварщик"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Натуральный", "Серия - Омон", "Цена - Высокая"), "Каска - Шахтер"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Натуральный", "Серия - Комфорт", "Цена - Небольшая"), "Каска - Термолюкс"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Рабочий", "Цена - Средняя"), "Каска - Вигард"));
        rules.add(new Rule(Arrays.asList("Защита - Голова", "Материал - Искусственный", "Серия - Рабочий", "Цена - Высокая"), "Каска - Люкс"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Натуральный", "Серия - Зима", "Цена - Небольшая"), "Рукавицы утепленные гладкокрашеные"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Зима", "Цена - Средняя"), "Рукавицы нагольные"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Натуральный", "Серия - Зима", "Цена - Высокая"), "Рукавицы меховые"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Натуральный", "Серия - Омон", "Цена - Небольшая"), "Рукавицы крытые"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Натуральный", "Серия - Омон", "Цена - Средняя"), "Рукавицы морозостойкие"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Рабочий", "Цена - Высокая"), "Рукавицы с двойным налодонником"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Рабочий", "Цена - Небольшая"), "Рукавицы джинсовые"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Зима", "Цена - Средняя"), "Рукавицы брезентовые"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Натуральный", "Серия - Комфорт", "Цена - Высокая"), "Рукавицы крагиспилковые"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Рабочий", "Цена - Небольшая"), "Рукавицы суконные"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Комфорт", "Цена - Средняя"), "Вачеги для металлурга"));
        rules.add(new Rule(Arrays.asList("Защита - Руки", "Материал - Искусственный", "Серия - Комфорт", "Цена - Высокая"), "Вачеги цельноспилковые"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Омон", "Цена - Небольшая"), "Костюм мужской Вектор"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Омон", "Цена - Средняя"), "Костюм мужской Вектор+"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Омон", "Цена - Высокая"), "Костюм мужской Амулет"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Зима", "Цена - Небольшая"), "Костюм мужской Диксон"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Зима", "Цена - Средняя"), "Костюм мужской Зимник"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Искусственный", "Серия - Рабочий", "Цена - Высокая"), "Костюм мужской Модуль"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Комфорт", "Цена - Небольшая"), "Костюм мужской Стим"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Комфорт", "Цена - Средняя"), "Костюм мужской Рейсер"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Зима", "Цена - Высокая"), "Костюм мужской Тайшет"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Зима", "Цена - Небольшая"), "Костюм мужской Буран КМФ"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Комфорт", "Цена - Средняя"), "Костюм мужской Аляска"));
        rules.add(new Rule(Arrays.asList("Защита - Корпус", "Материал - Натуральный", "Серия - Рабочий", "Цена - Высокая"), "Костюм мужской Легенда"));

        workingMemory.add("Защита - Руки");
        workingMemory.add("Материал - Искусственный");
        workingMemory.add("Серия - Зима");
        workingMemory.add("Цена - Средняя");
    }

}
