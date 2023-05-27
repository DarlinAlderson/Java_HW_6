/*Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
Класс сделать в отдельном файле.
Приветствие
Выбор параметра
Выбор конкретнее
Вывод подходящих */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ChooseYourNote {
    public static void main(String[] args) {
        HashSet<NotebookCatalogue> notebooks = new HashSet<>();
        notebooks.add(new NotebookCatalogue(0, 250, 16, 14, "Windows10", "black", "Asus"));
        notebooks.add(new NotebookCatalogue(1, 250, 32, 14, "Windows11", "black", "Asus"));
        notebooks.add(new NotebookCatalogue(2, 250, 64, 14, "Windows11", "silver", "Asus"));
        notebooks.add(new NotebookCatalogue(3, 500, 16, 15, "Dos", "black", "Lenovo"));
        notebooks.add(new NotebookCatalogue(4, 750, 16, 16, "None", "blue", "Acer"));
        notebooks.add(new NotebookCatalogue(5, 1000, 32, 15, "Windows11", "red", "Sony"));
        notebooks.add(new NotebookCatalogue(6, 750, 32, 15, "Windows11", "red", "Xiaomi"));
        notebooks.add(new NotebookCatalogue(7, 750, 64, 15, "Windows11", "white", "Acer"));
        notebooks.add(new NotebookCatalogue(8, 750, 32, 15, "Windows11", "silver", "Sony"));
        Filter(userRequest(), notebooks);

    }

    public static HashMap<String, String> userRequest() {
        HashMap<String, String> userRequest = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте! Введите параметры для поиска:");
        System.out.print("Введите тип ОС:");
        userRequest.put("os_type", scanner.nextLine());
        System.out.print("Введите цвет корпуса:");
        userRequest.put("color", scanner.nextLine());
        System.out.print("Введите производителя:");
        userRequest.put("brand", scanner.nextLine());
        System.out.print("Введите минимальный объем жесткого диска:");
        userRequest.put("hdd_volume", scanner.nextLine());
        System.out.print("Введите минимальный объем оперативной памяти:");
        userRequest.put("ram_volume", scanner.nextLine());
        System.out.print("Введите минимальную диагональ дисплея:");
        userRequest.put("display_size", scanner.nextLine());
        scanner.close();
        return userRequest;
    }

    public static void Filter(HashMap<String, String> userRequest, HashSet<NotebookCatalogue> catalog) {
        Boolean noResultsFlag = true;
        for (NotebookCatalogue nb : catalog) {
            if (userRequest.get("brand").equals(nb.getBrand()) || userRequest.get("brand") == "") {
                if (userRequest.get("color").equals(nb.getBrand()) || userRequest.get("color") == "") {
                    if (userRequest.get("os_type").equals(nb.getBrand()) || userRequest.get("os_type") == "") {
                        if (nb.getDisplSize() >= Integer.parseInt(userRequest.get("display_size")) &&
                                (nb.getHDDvolume() >= Integer.parseInt(userRequest.get("hdd_volume"))) &&
                                (nb.getRAMvolume() >= Integer.parseInt(userRequest.get("ram_volume")))) {
                            System.out.println(nb);
                            noResultsFlag = false;
                        }
                    }
                }
            }

        }
        if (noResultsFlag) {
            System.out.println("По вашему запросу ничего не найдено.");
        }
    }
}