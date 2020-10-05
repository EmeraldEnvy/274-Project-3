/**
 * Alexander Pham
 * October 31, 2019
 * Add, Remove, Search through, Update, and Display a text file of contacts
 */

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class main {
    public static void main( String[] args ){
        LinkedList list = new LinkedList();
        list = populateList( list );
        while ( true ){
            list.sort();
            /**Menu*/
            displayMenu();
            System.out.print( "Choose an option : " );
            int userChoice = CheckInput.getIntRange(1 , 6 );
            System.out.println();

            /**Add contact*/
            if ( userChoice == 1 ){
                System.out.print( "Enter the last name : " );
                String lastName = CheckInput.getString();
                System.out.print( "Enter the first name : " );
                String firstName = CheckInput.getString();
                System.out.print( "Enter the phone number : " );
                String phoneNumber = CheckInput.getString();
                System.out.print( "Enter the address : " );
                String addr = CheckInput.getString();
                System.out.print( "Enter the city : " );
                String city = CheckInput.getString();
                System.out.print( "Enter the zip code : " );
                String zipCode = CheckInput.getString();
                Contact contact = new Contact( lastName , firstName , phoneNumber , addr , city, zipCode );
                list.add( contact );
            }

            /**Remove contact*/
            if ( userChoice == 2) {
                System.out.println( "How would you like to remove a contact" );
                System.out.println( "1. By full name\n2. By index" );
                System.out.print( "Choose an option : " );
                int removeChoice = CheckInput.getIntRange( 1 , 2 );
                /**Remove by full name*/
                if ( removeChoice == 1 ){
                    System.out.print( "Enter the first name : " );
                    String firstName = CheckInput.getString();
                    System.out.print( "Enter the last name : " );
                    String lastName = CheckInput.getString();
                    Contact fullName = new Contact( lastName , firstName );
                    if ( list.remove( fullName )  ){
                        System.out.println( "Contact removed" );
                    }
                    /**Contact not in list*/
                    else {
                        System.out.println( "No contact found, nothing removed" );
                    }

                }
                /**Remove by index*/
                if ( removeChoice == 2 ){
                    System.out.println( list );
                    System.out.print( "Enter the index you would like to remove : " );
                    int userIndex = CheckInput.getIntRange( 1 , list.size() );
                    list.remove( userIndex - 1 );
                }
            }

            /**Search for contact*/
            if ( userChoice == 3 ){
                System.out.println( "How would you like to search for a contact" );
                System.out.println( "1. By last name\n2. By zip code" );
                int remChoice = CheckInput.getIntRange(1 , 2);
                /**Search by last name*/
                if ( remChoice == 1 ){
                    ArrayList <Contact> lastNameList = new ArrayList<Contact>();
                    System.out.print( "Enter the last name : " );
                    String lastName = CheckInput.getString();
                    lastNameList = list.searchName( lastName );
                    /**No contacts added to list*/
                    if ( lastNameList.size() == 0 ){
                        System.out.println( "No contacts found" );
                        System.out.println(" ");
                    }
                    /**Read from arrayList*/
                    for ( int i = 0; i < lastNameList.size() ; i++ ){
                        System.out.println( lastNameList.get( i ) );
                    }
                }
                /**Search by zip code*/
                if ( remChoice == 2 ){
                    ArrayList <Contact> zipCodeList = new ArrayList<Contact>();
                    System.out.print( "Enter the zip code : " );
                    String zipCode = CheckInput.getString();
                    zipCodeList = list.searchZip( zipCode );
                    /**No contacts added to list*/
                    if ( zipCodeList.size() == 0 ){
                        System.out.println( "No contacts found" );
                    }
                    /**Read from arrayList*/
                    for ( int i = 0; i < zipCodeList.size() ; i++ ) {
                        System.out.println( zipCodeList.get( i ) );
                    }

                }
            }

            /**Update existing contact*/
            if ( userChoice == 4 ){
                System.out.print( "Enter contact's first name : " );
                String firstName = CheckInput.getString();
                System.out.print( "Enter contact's last name : " );
                String lastName = CheckInput.getString();
                Contact fullName = new Contact( lastName , firstName );
                Contact contact = list.searchName( fullName );
                /**No matching contacts*/
                if ( contact == null ){
                    System.out.println( "No contact found" );
                }
                else{
                    System.out.println( "Which parameter would you like to update" );
                    System.out.println( "1. Last name\n" +
                            "2. First name\n" +
                            "3. Phone number\n" +
                            "4. Address\n" +
                            "5. City\n" +
                            "6. Zip code\n" +
                            "7. Do nothing");
                    int userUpdate = CheckInput.getIntRange(1 , 7 );
                    /**New last name*/
                    if ( userUpdate == 1 ){
                        System.out.print( "Enter new last name : " );
                        lastName = CheckInput.getString();
                        contact.setLastName( lastName );
                    }
                    /**New first name*/
                    if ( userUpdate == 2 ){
                        System.out.print( "Enter new first name : " );
                        firstName = CheckInput.getString();
                        contact.setFirstName( firstName );
                    }
                    /**New phone number*/
                    if ( userUpdate == 3 ){
                        System.out.print( "Enter new phone number : " );
                        String phoneNumber = CheckInput.getString();
                        contact.setPhoneNumber( phoneNumber );
                    }
                    /**New address*/
                    if ( userUpdate == 4 ){
                        System.out.print( "Enter new address : " );
                        String address = CheckInput.getString();
                        contact.setAddress( address );
                    }
                    /**New city*/
                    if ( userUpdate == 5 ){
                        list.sort();
                        System.out.print( "Enter new city : " );
                        String city = CheckInput.getString();
                        contact.setCity( city );
                    }
                    /**New zip code*/
                    if ( userUpdate == 6 ){
                        System.out.print( "Enter new zip code : " );
                        String zipCode = CheckInput.getString();
                        contact.setZipCode( zipCode );
                    }
                }

            }

            /**Display contacts*/
            if ( userChoice == 5 ){
                System.out.println();
                System.out.println( list.toString() );
            }

            /**Quit*/
            if ( userChoice == 6 ){
                /**Print writer*/
                try{
                    PrintWriter writer = new PrintWriter("contacts.txt" );
                    writer.print( list.toFile() );
                    writer.close();
                } catch( FileNotFoundException fnf ){
                    System.out.println( "File was not found" );
                }
                System.out.println( "❤ See ya later cutie ❤" );
                break;
            }
        }
    }

    /**
     * Populate linked list by reading from file
     * @param list
     * @return populated list
     */
    public static LinkedList populateList( LinkedList list ){
        /**Read File*/
        try {
            Scanner read = new Scanner( new File( "contacts.txt" ) );
            do {
                String line = read.nextLine();
                String[] arrOfLine = line.split(",");
                Contact contact = new Contact( arrOfLine[0] , arrOfLine[1] , arrOfLine[2] , arrOfLine[3] , arrOfLine[4], arrOfLine[5] );
                list.add( contact );
            }
            while (read.hasNext());
        } catch ( FileNotFoundException fnf ) {
            System.out.println( "File was not found" );
        }
        return list;
    }

    /**
     * Display menu
     */
    public static void displayMenu(){
        System.out.println( "------------------------------------" );
        System.out.println( "1. Add contact\n" +
                "2. Remove contact\n" +
                "3. Search contact\n" +
                "4. Update contact\n" +
                "5. Display contacts\n" +
                "6. Quit"
        );
    }

}
