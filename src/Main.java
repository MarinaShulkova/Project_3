import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Flat> flats = new ArrayList<Flat>();
    static List<Estate> estates = new ArrayList<Estate>();

    public static void main(String[] args) {
        setFlats(); //инициализация начального списка квартир
        setEstates(); //инициализация начального списка комм.недвижимости
        menu(print_menu());
    }

//Процедура работы меню
    public static void menu(int menu_item) {
        switch (menu_item) {
            case 1:  //добавление объекта
                if (menu_2() == 1) flats.add((Flat)addProperty(1));
                else estates.add((Estate) addProperty(2));
                menu(print_menu());
            case 2:  //удаление объекта
                if (menu_2() == 1) {
                    flats.stream().forEach(e-> {
                        System.out.print(flats.indexOf(e));
                        System.out.println(". " + e);});
                    System.out.println("Enter number to delete");
                    Scanner scr = new Scanner(System.in);
                    flats.remove(scr.nextInt());
                } else {
                    estates.stream().forEach(e-> {
                        System.out.print(estates.indexOf(e));
                        System.out.println(". " + e);});
                    System.out.println("Enter number to delete");
                    Scanner scr = new Scanner(System.in);
                    estates.remove(scr.nextInt());
                };
                menu(print_menu());
            case 3:  //сортировка по возрастанию
                if (menu_2() == 1) flats.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(System.out::println);
                else estates.stream().sorted(Comparator.comparing(Estate::getPrice)).forEach(System.out::println);
                menu(print_menu());
            case 4:  //сортировка по убыванию
                if (menu_2() == 1) flats.stream().sorted(Comparator.comparing(Flat::getPrice).reversed()).forEach(System.out::println);
                else estates.stream().sorted(Comparator.comparing(Estate::getPrice).reversed()).forEach(System.out::println);                menu(print_menu());
            case 5:  //сгруппировать квартиры по станциям метро
                if (menu_2() == 1) {
                    Map<String, List<Flat>> group_metro = flats.stream().collect(Collectors.groupingBy(Flat::getMetro));
                    group_metro.forEach((metro, flats) -> {
                        System.out.println("Metro: " + metro);
                        flats.forEach(e -> System.out.println(" " + e));
                        System.out.println();});
                }
                else {
                    Map<String, List<Estate>> group_metro = estates.stream().collect(Collectors.groupingBy(Estate::getMetro));
                    group_metro.forEach((metro, estates) -> {
                                System.out.println("Metro: " + metro);
                                estates.forEach(e -> System.out.println(" " + e));
                                System.out.println();});
                }
                    menu(print_menu());
           case 6:  //вывести квартиру с наивысшей оценкой
               if (menu_2() == 1) flats.stream().max(Comparator.comparing(Flat::getRate)).ifPresent(System.out::println);
               else estates.stream().max(Comparator.comparing(Estate::getRate)).ifPresent(System.out::println);
               menu(print_menu());
           case 7:  //печать списков недвижиости
                flats.stream().forEach(e -> System.out.println("Property:" + e.name + ", Address: " + e.address + ", Rooms: " + e.room + ", Area: " + e.area + ", Price: " + e.price + ", Rate:" + e.rate));
                estates.stream().forEach(e -> System.out.println("Property:" + e.name + ", Address: " + e.address + ", Type: " + e.type + ", Area: " + e.area + ", Price: " + e.price + ", Rate:" + e.rate));
                menu(print_menu());
           case 8:  //удалить все
               if(flats.removeAll(flats)&&estates.removeAll(estates)) System.out.println("All property has deleted");
               menu(print_menu());
           case 9:  //распечатать сгруппированные списки по типу недвижимости
               System.out.println("Flat");
               flats.stream().forEach(System.out::println);
               System.out.println("Estate");
               estates.stream().forEach(System.out::println);
               menu(print_menu());
           case 10: //выход из программы
                System.exit(404);
                break;
        }
    }

// Вывод меню в консоль и возвращаем выбранное значение из консоли
    public static int print_menu() {
        System.out.println(
                "1 Add property \n" +
                        "2 Delete property \n" +
                        "3 Sort ascending \n" +
                        "4 Sort descending \n" +
                        "5 Group flat by metro \n" +
                        "6 Print high rate property \n" +
                        "7 Print all property \n" +
                        "8 Delete all \n" +
                        "9 Print property grouped by type \n" +
                        "10 Exit");

        System.out.println("Choose menu item: ");
        Scanner scr = new Scanner(System.in);
        return scr.nextInt();
    }

//подменю выбора типа недвижимости. Возвращаем: 1 - Квартира, 2 - Коммерческая
    public static int menu_2 () {
        System.out.println("Choose property: \n 1.Flat \n 2.Commercial real estate");
        Scanner scr = new Scanner(System.in);
        return scr.nextInt();
    }

//Процедура добавления объекта в списки недвижимости
    public static <T,R>Object addProperty(int p) {
        Flat T;
        Estate R;
        Flat t = new Flat("", "", "", 0, 0, 0, 0);
        Estate r = new Estate("", "", "", "", 0, 0, 0);

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scr.nextLine();
        System.out.println("Enter metro");
        String metro = scr.nextLine();
        System.out.println("Enter address");
        String address = scr.nextLine();
        System.out.println("Enter area");
        Double area = scr.nextDouble();
        System.out.println("Enter price");
        int price = scr.nextInt();
        System.out.println("Enter rate");
        Float rate = scr.nextFloat();

        if (p == 1) {
            System.out.println("Enter quantity of rooms: ");
            int room = scr.nextInt();
            t = new Flat(name, metro, address, room, area, price, rate);
            return t;
        } else {
            System.out.println("Enter type of commercial real estate: ");
            String type = scr.nextLine();
            r = new Estate(name, metro, address, type, area, price, rate);
            return r;
        }
    }

//Начальные списки объектов
    public static void setFlats(){
        flats.add(new Flat("Flat 1", "Pervomayskaya", "9 Parkovaya 36", 2, 47.3, 10200000, 4.2F));
        flats.add(new Flat("Flat 2", "Pervomayskaya", "10 Parkovaya 12", 2, 68, 15000000, 4.7F));
        flats.add(new Flat("Flat 3", "Domodedovskaya", "Domodedovskaya 58", 3, 105.8, 23000000, 4.8F));
        flats.add(new Flat("Flat 4", "Tverskaya", "2 Tverskaya-Yamskya", 1, 13.2, 25000000, 3.5F));}

    public static void setEstates(){
        estates.add(new Estate("Estate 1", "Tulskaya", "Tulskaya 42", "office", 87, 18328000, 3.2F));
        estates.add(new Estate("Estate 2", "Altufevo", "Leskova 52/1", "office", 125.8, 27000000, 4.9F));
        estates.add(new Estate("Estate 3", "Kuzminki", "Zelenodolskaya 35", "kiosk", 15.3, 5236000, 1.8F));
        estates.add(new Estate("Estate 4", "Ohotnyi ryad", "Krasnaya ploschad 9", "mausoleum", 220, 138000000, 4.28F));
        estates.add(new Estate("Estate 5", "Krasnoselskaya", "Krasnoselskaya 3a", "shop", 73, 42180000, 4.5F));}


}





