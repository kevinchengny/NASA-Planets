import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NeoViewer {
    public static void main(String[] args) {
        NeoDatabase database = new NeoDatabase();
        String input = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("  Welcome to NEO Viewer!\n");
        while (!input.equalsIgnoreCase("Q")) {
            menu();
            System.out.print("\nSelect a menu option: ");
            String temp = scanner.nextLine();
            input = temp.toUpperCase();

            switch (input) {

                case "A": // A - Add a page to the database
                    try {
                        System.out.println("Enter the page to Load: ");
                        String strPage = scanner.nextLine();
                        int page = Integer.parseInt(strPage);
                        database.addAll(database.buildQueryURL(page));
                        System.out.println("Page loaded Successfully");

                    } catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;

                case "S": // S - Sort the database
                    System.out.println("   R) Sort by referenceID\n" +
                            "   D) Sort by diameter\n" +
                            "   A) Sort by approach date\n" +
                            "   M) Sort by miss distance");
                    System.out.print("\nSelect a menu option: ");
                    String temp2 = scanner.nextLine();
                    String inputS = temp2.toUpperCase();

                    switch(inputS) {
                        case "R": // Table sorted on Reference ID
                            try {
                                database.sort(new ReferenceIDComparator());
                                System.out.println("Table sorted on Reference ID.\n");
                                break;
                            } catch(IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } catch(EmptyArrayException ex) {
                                System.out.println(ex.getMessage());
                            } catch(Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;

                        case "D": // Table sorted on Diameter
                            try {
                                database.sort(new DiameterComparator());
                                System.out.println("Table sorted on Diameter.\n");
                                break;
                            } catch(IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } catch(EmptyArrayException ex) {
                                System.out.println(ex.getMessage());
                            } catch(Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;

                        case "A": // Table sorted on approach date
                            try {
                                database.sort(new ApproachDateComparator());
                                System.out.println("Table sorted on Approach Date.\n");
                                break;
                            } catch(IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } catch(EmptyArrayException ex) {
                                System.out.println(ex.getMessage());
                            } catch(Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;

                        case "M": // Table sorted on miss distance
                            try {
                                database.sort(new MissDistanceComparator());
                                System.out.println("Table sorted on miss distance.\n");
                                break;
                            } catch(IllegalArgumentException ex) {
                                System.out.println(ex.getMessage());
                            } catch(EmptyArrayException ex) {
                                System.out.println(ex.getMessage());
                            } catch(Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;

                case "P": // P - Print all storage boxes
                    database.printTable();
//                    System.out.println("Done");
                    break;

            }
        }
        System.out.println("\nProgram terminating normally... \n");
    }

    /**
     * method to display a menu
     */
    public static void menu() {
        String menu = "\nOption Menu:\n" +
                "    A) Add a page to the database\n" +
                "    S) Sort the database \n" +
                "    P) Print the database as a table.\n" +
                "    Q) Quit";
        System.out.println(menu);
    }
}
