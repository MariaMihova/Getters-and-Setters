package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	private - print all private fields
        //•	protected - print all protected fields
        //•	public - print all public fields
        //•	all - print ALL declared fields
        //•	HARVEST - end the input

        Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
        List<Field> fields = Arrays.stream(richSoilLandClass.getDeclaredFields())
                .collect(Collectors.toList());

        String command = scanner.nextLine();
        boolean isHarvest = false;


        while (!command.equals("HARVEST")) {
            if ("private".equals(command)) {
                fields.stream()
                        .filter(field -> field.getModifiers() == Modifier.PRIVATE)
                        .forEach(field ->{
                                System.out.printf("%s %s %s%n"
                                        ,Modifier.toString(field.getModifiers()),field.getType().getSimpleName(), field.getName());
                        });
            } else if ("protected".equals(command)) {
                fields.stream()
                        .filter(field -> field.getModifiers() == Modifier.PROTECTED)
                        .forEach(field ->
                                System.out.printf("%s %s %s%n"
                                        , Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
            } else if ("public".equals(command)) {
                fields.stream()
                        .filter(field -> field.getModifiers() == Modifier.PUBLIC)
                        .forEach(field ->
                                System.out.printf("%s %s %s%n"
                                        , Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
            } else if ("all".equals(command)) {
                fields.forEach(field -> System.out.printf("%s %s %s%n"
                        , Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));

            }

            command = scanner.nextLine();

        }


    }
}
