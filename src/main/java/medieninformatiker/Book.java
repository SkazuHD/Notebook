package medieninformatiker;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class Book {

    Book(){
        //showOptions();
    }
    private ArrayList<String> notes = new ArrayList<>();

    String path = System.getProperty("user.home")+File.separator+"Documents" +File.separator+"NotesApp";
    File customDir = new File(path);
    File customPath = new File(path + "\\demo.txt");
    Scanner scan = new Scanner(System.in);

    public void loadEntry() throws FileNotFoundException {

       try {
           Scanner importer = new Scanner(new File(customPath.toURI()));
           while (importer.hasNext()){
               notes.add((importer.nextLine()));//
       }}catch (FileNotFoundException ee){
           System.out.println(ee.getMessage());
       }


        printEntrys();
    }
    public void saveEntrys() throws IOException {

        try {

            if (!customDir.exists()) {
                customDir.mkdirs();
            }
            Files.write(customPath.toPath(),notes, Charset.defaultCharset());
            System.out.println("Save Successfully");

        }catch (IOException e){
           System.out.println(e.getMessage());
       }



    }
    public void showOptions() throws IOException {
        System.out.println("| C:Create Note | E:Edit | D:Delete Note | S:Save | Q:Quit |");
        System.out.print("Make the next operation:");
        chooseOperation();
    }
    private void chooseOperation() throws IOException {
        String input = scan.nextLine();
        switch (input){
            case "C":
                createEntry();
                printEntrys();
                break;
            case "D":
                deleteEntry();
                printEntrys();
                break;
            case "E":
                editEntry();
                printEntrys();
                break;
            case "S":
                saveEntrys();
                break;

            case "Q":
                System.out.print("Save File? (Y/N):");
                if (scan.nextLine().equals("Y")){
                    saveEntrys();
                    System.exit(0);
                }else {
                    System.exit(0);
                }


                break;
            default:
                clearScreen();
                printEntrys();
                showOptions();
                break;
        }
    }
    public void createEntry(){
        System.out.print("Add your Note:");
        String newEntry = scan.nextLine();
        notes.add(newEntry);
        clearScreen();
    }
    public void deleteEntry(){
        clearScreen();
        printEntrys();
        System.out.print("Input the Index of the Item you want to delete:");
        int index = scan.nextInt();
        notes.remove(index-1);
        clearScreen();
    }
    public void editEntry(){
        clearScreen();
        printEntrys();
        System.out.print("Input the Index of the Item you want to Edit:");
        int index = scan.nextInt();
        index--;
        System.out.print("Input new Text:");
        Scanner scanText = new Scanner(System.in);
        String newText = scanText.nextLine();
          System.out.println(newText);
        notes.set(index, newText);
        clearScreen();

    }
    public void printEntrys(){
        System.out.println("Index|Note");
        for(int i=0; i<notes.size();i++){
            System.out.println(i+1+"     "+notes.get(i));
    }
}
    public void clearScreen(){
        for(int clear = 0; clear < 50; clear++)
        {
            System.out.println("\b") ;
        }
    }
}
