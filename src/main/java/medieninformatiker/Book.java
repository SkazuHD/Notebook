package medieninformatiker;
import java.util.ArrayList;
import java.util.Scanner;



public class Book {

    Book(){
        //showOptions();
    }
    private ArrayList<String> notes = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void loadEntry(){

    }
    public void showOptions(){
        System.out.println("| C:Create Note | E:Edit | D:Delete Note | S:Save | Q:Quit |");
        System.out.print("Make the next operation:");
        chooseOperation();
    }
    private void chooseOperation(){
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
                break;
            case "Q":
                System.exit(0);
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
