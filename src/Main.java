import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Fruit> fruitArrayList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    private static  ObjectOutputStream outputStream;

    static {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("fruits.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ObjectInputStream inputStream;

    static {
        try {
            inputStream = new ObjectInputStream(new FileInputStream("fruits.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                    writeToFile(new Fruit(typeOfFruit));
                }
                case 3 -> {
                    System.exit(0);
                }
                default -> System.out.println("wrong input");
            }
        }

    }


    public static void writeToFile(Fruit fruit) throws IOException {
        outputStream.writeObject(fruit);
    }

    // TODO fix: Read from non existing file results in NullPointerException
    // TODO fix: After restart of application new InputStream erases stored files?
    public static void readFromFile() throws ClassNotFoundException, IOException {
        try {
            while (true) {
                fruitArrayList.add((Fruit) inputStream.readObject());
            }
        } catch (EOFException e) {
            System.out.println("end of file detected");
        }

    }

/*
    private static boolean fileExists() {
        File temp = new File("fruits.txt");
        return temp.exists();
    }
*/

/*
    public static void initStreams() throws IOException {
//        if (!fileExists())
    }
*/
}