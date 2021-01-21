import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Fruit> fruitArrayList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("1: read, 2 write, 3 exit");
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1 -> {
                    readFromFile();
                    System.out.println(fruitArrayList);
                }
                case 2 -> {
                    System.out.println("Type of fruit");
                    input.nextLine();
                    String typeOfFruit = input.nextLine();
                    fruitArrayList.add(new Fruit(typeOfFruit));
                    writeToFile(new Fruit(typeOfFruit));
                }
                case 3 -> System.exit(0);
                default -> System.out.println("wrong input");
            }
        }

    }


    public static void writeToFile(Fruit fruit) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("fruits.txt"));
        outputStream.writeObject(fruitArrayList);
        outputStream.close();
    }

    // TODO fix: Read from non existing file results in NullPointerException
    // TODO fix: Read from existing file only reads one object
    public static void readFromFile() throws ClassNotFoundException, IOException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("fruits.txt"));
        fruitArrayList = (ArrayList<Fruit>) inputStream.readObject();
        inputStream.close();
    }

/*
    private static boolean fileExists() {
        File temp = new File("fruits.txt");
        return temp.exists();
    }
*/

}