package java2;

import java.util.Scanner;

public class Email {
    @SuppressWarnings("resource")
	public static void main(String[] args) {

        String[] emailIDs = new String[]{"ID_1", "ID_2", "ID_3", "ID_4", "ID_5"};
        /*
         * Screen :
         *          press 1 to search
         *          press 0 to exit
         */

        Scanner scanner = new Scanner(System.in);
        String read;
        String isFoundMsg;
        int option;
        while (true) {
            System.out.println("Screen Options :\n\t\t\t\tpress 1 to search\n\t\t\t\tpress 0 to exit");
            // first read option input from user
            // try to remove any spaces in start or end option input
            read = scanner.nextLine().trim();
            try {
                // try to convert input to into to ensure that behavior occurs
                option = Integer.parseInt(read);
                switch (option) {
                    case 0 -> {
                        System.out.println("Goodbye...");
                        return;
                    }
                    case 1 -> {
                        System.out.print("Enter emailID which you want to search about it: ");
                        read = scanner.nextLine().trim();
                        /**
                         * important hint : it's tricky
                         * Don't use == in comparing strings because strings is reference data types
                         * which mean when comparing using == you compare references not content
                         * but in our cause we need to sure that content the same
                         */
                        // i suggest that every time i search item not found the isFoundMsg variable is false before start searching
                        isFoundMsg = "Not Found";
                        for (String emailID : emailIDs) {
                            if (emailID.equals(read)) {
                                isFoundMsg = "Found";
                                break;
                            }
                        }
                        System.out.println("\nEmail ID: " + read + " " + isFoundMsg + "\n");
                    }
                    default -> System.out.println("\nPlease enter valid Choice in range [ 0 , 1 ]\n");
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter numbers only and in range [ 0, 1 ]!!!\n");
            }
        }
    }
}
