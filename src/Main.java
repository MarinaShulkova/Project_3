import java.util.*;

public class Main {
    static List<Flat> flats = new ArrayList<Flat>();
    static List<Estate> estates = new ArrayList<Estate>();

    public static void main(String[] args) {
        setFlats();
        setEstates();
        menu(print_menu());


    }

    public static void menu(int menu_item) {
        switch (menu_item) {
            case 1:  //добавление объекта
                    if (menu_2() == 1) {
                    Flat f = new Flat("f", "f", "f", 5, 55, 55000,5);
                    flats.add(f);
                    flats.add(addProperty(1));
                }
                //               else estates.add((Estate) addProperty(2));
                menu(print_menu());
                break;

            case 2:  //удаление объекта
                flats.remove(1);
            case 3:  //сорти5ровка по возрастанию
                if (menu_2() == 1) {
                flats.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(System.out::println);}
                else {
                    estates.stream().sorted(Comparator.comparing(Estate::getPrice)).forEach(System.out::println);}
                menu(print_menu());
            case 4:  //сортировка по убыванию
                if (menu_2() == 1) {
                flats.stream().sorted(Comparator.comparing(Flat::getPrice).reversed()).forEach(System.out::println);}
                else {
                    estates.stream().sorted(Comparator.comparing(Estate::getPrice).reversed()).forEach(System.out::println);}
                    menu(print_menu());
            case 5:  //вывести квартиру с наивысшей оценкой
            case 6:  //печать списка квартир на продажу
                flats.stream().forEach(System.out::println);
                menu(print_menu());

                break;
            case 7:  //удалить все
            case 8:  //распечатать сгруппированные списки по типу недвижимости
            case 9: //выход из программы
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
                        "5 Print high rate property \n" +
                        "6 Print all property \n" +
                        "7 Delete all \n" +
                        "8 Print property grouped by type \n" +
                        "9 Exit");

        System.out.println("Choose menu item: ");
        Scanner scr = new Scanner(System.in);
        int menu_item = scr.nextInt();
        return menu_item;
    }

    public static Flat addProperty(int t) {
        Flat f = new Flat("", "", "", 0, 0, 0, 0);
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


        if (t == 1) {
            System.out.println("Enter quantity of rooms: ");
            int room = scr.nextInt();
            f = new Flat(name, metro, address, room, area, price, rate);



 /*       else {
            System.out.println("Enter type of commercial real estate: ");
            String type = scr.nextLine();
            Estate e = new Estate(name, metro, address, type, area, price, rate);
            return e;

  */

        }
        return f;
    }

    public static void setFlats(){
        flats.add(new Flat("Flat 1", "Pervomayskaya", "9 Parkovaya 36", 2, 47.3, 10200000, 4.2F));
        flats.add(new Flat("Flat 2", "Strogino", "Stroginskaya 12", 2, 68, 15000000, 4.7F));
        flats.add(new Flat("Flat 3", "Domodedovskaya", "Domodedovskaya 58", 3, 105.8, 23000000, 4.8F));
        flats.add(new Flat("Flat 4", "Tverskaya", "2 Tverskaya-Yamskya", 1, 13.2, 25000000, 3.5F));}

    public static void setEstates(){
        estates.add(new Estate("Estate 1", "Tulskaya", "Tulskaya 42", "office", 87, 18328000, 3.2F));
        estates.add(new Estate("Estate 2", "Altufevo", "Leskova 52/1", "office", 125.8, 27000000, 4.9F));
        estates.add(new Estate("Estate 3", "Kuzminki", "Zelenodolskaya 35", "kiosk", 15.3, 5236000, 1.8F));
        estates.add(new Estate("Estate 4", "Ohotnyi ryad", "Krasnaya ploschad 9", "mausoleum", 220, 138000000, 4.28F));
        estates.add(new Estate("Estate 5", "Krasnoselskaya", "Krasnoselskaya 3a", "shop", 73, 42180000, 4.5F));}

    public static int menu_2 () {
        System.out.println("Choose property: \n 1.Flat \n 2.Commercial real estate");
        Scanner scr = new Scanner(System.in);
        int menu_3 = scr.nextInt();
        return menu_3;
    }
}





