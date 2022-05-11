package de.materna.taschenrechner;

import java.util.HashMap;
import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Application {
    public static void main(String[] args) {
        HashMap<String, Double> tempStorage= new HashMap<>();

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.contains("=")){
                String tempKey = input.substring(0, input.indexOf("="));
                Double tempValue = Double.parseDouble(input.substring(input.indexOf("=") + 1));
                tempStorage.put(tempKey, tempValue);
                System.out.println(tempValue);
                continue;
            }
            Expression expression = new ExpressionBuilder(input)
                    .variables(tempStorage.keySet())
                    .build()
                    .setVariables(tempStorage);

            System.out.println(expression.evaluate());
        }
    }
}
