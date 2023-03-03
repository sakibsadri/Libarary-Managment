/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sakib Sadri
 */
import java.util.Scanner;


 class DigitalLibrary {


    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int bookQtyCopy;


    Scanner input = new Scanner(System.in);


    public DigitalLibrary()
    {

        System.out.println("Enter Serial number of Book:");
        this.sNo = input.nextInt();
        input.nextLine();

        System.out.println("Enter Name of Book:");
        this.bookName = input.nextLine();

        System.out.println("Enter Name of Author :");
        this.authorName = input.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = input.nextInt();
        bookQtyCopy = this.bookQty;
    }
}

class books {


    DigitalLibrary theBooks[] = new DigitalLibrary[50];
    public static int count;

    Scanner input = new Scanner(System.in);


    public int compareBookObjects(DigitalLibrary b1, DigitalLibrary b2)
    {


        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {


            System.out.println(
                    "Book of the Name Already Exists!");
            return 0;
        }


        if (b1.sNo == b2.sNo) {


            System.out.println(
                    "Book of the Serial number Already Exists!");

            return 0;
        }
        return 1;
    }


    public void addBook(DigitalLibrary b)
    {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i])
                    == 0)
                return;
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println(
                    "Unfortunately There is No Space to Add More Books.");
        }
    }


    public void searchBySno()
    {


        System.out.println(
                "\t\t\t\tSEARCH THE BOOK BY SERIAL NUMBER\n");


        int sNo;
        System.out.println("Enter Serial NUMBER of Book:");
        sNo = input.nextInt();

        int flag = 0;
        System.out.println(
                "Serial Number\t\tName of book\t\tAuthor of book\t\tAvailable Qty of book");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].bookQtyCopy + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial Number "
                    + sNo + " Found.");
    }


    public void searchByAuthorName()
    {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY THE AUTHOR'S NAME");

        input.nextLine();

        System.out.println("Enter The Author Name:");
        String authorName = input.nextLine();

        int flag = 0;

        System.out.println(
                "Serial Number\t\tName of book\t\tAuthor of book\t\tAvailable Qty of book\t\tTotal Qty of book");

        for (int i = 0; i < count; i++) {


            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {


                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].bookQtyCopy + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
            }
        }


        if (flag == 0)
            System.out.println("No Books of " + authorName
                    + " Found.");
    }


    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "Serial Number\t\tName of book\t\tAuthor of book\t\tAvailable Qty of book\t\tTotal Qty of book");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBooks[i].sNo + "\t\t"
                            + theBooks[i].bookName + "\t\t"
                            + theBooks[i].authorName + "\t\t"
                            + theBooks[i].bookQtyCopy + "\t\t"
                            + theBooks[i].bookQty);
        }
    }


    public void upgradeBookQty()
    {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF THE BOOK\n");
        System.out.println("Enter Serial Number of Book");

        int sNo = input.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                // Display message
                System.out.println(
                        "Enter Number of Books to be Added:");

                int addingQty = input.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].bookQtyCopy += addingQty;

                return;
            }
        }
    }


    public void dispMenu()
    {


        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
                "Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
                "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }


    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].bookQtyCopy > 0) {

                    System.out.println(
                            "Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("No Book of Serial Number "
                + " Available in Library.");
        return -1;
    }

    public DigitalLibrary checkOutBook()
    {

        System.out.println(
                "Enter Serial Number of Book to be Checked Out.");
        int sNo = input.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].bookQtyCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }


    public void checkInBook(DigitalLibrary b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQtyCopy++;
                return;
            }
        }
    }
}

class student {


    String studentName;
    String regNum;

    DigitalLibrary borrowedBooks[] = new DigitalLibrary[3];
    public int booksCount = 0;


    Scanner input = new Scanner(System.in);

    public student()
    {

        System.out.println("Enter Student Name:");


        this.studentName = input.nextLine();


        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}

class students {


    Scanner input = new Scanner(System.in);
    student theStudents[] = new student[50];

    public static int count = 0;


    public void addStudent(student s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(
                    theStudents[i].regNum)) {


                System.out.println(
                        "Student of Registration Number " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            theStudents[count] = s;
            count++;
        }
    }


    public void showAllStudents()
    {

        System.out.println("Student Name\t\tRegistration Number");
        for (int i = 0; i < count; i++) {

            System.out.println(theStudents[i].studentName
                    + "\t\t"
                    + theStudents[i].regNum);
        }
    }


    public int isStudent()
    {

        System.out.println("Enter Registration Number:");

        String regNum = input.nextLine();

        for (int i = 0; i < count; i++) {

            if (theStudents[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }


        System.out.println("Student is not Registered.");
        System.out.println("Get Registered First.");

        return -1;
    }


    public void checkOutBook(books book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            DigitalLibrary b = book.checkOutBook();

            System.out.println("checking out");
            if (b != null) {

                if (theStudents[studentIndex].booksCount
                        <= 3) {

                    System.out.println("adding book");
                    theStudents[studentIndex].borrowedBooks
                            [theStudents[studentIndex]
                            .booksCount]
                            = b;
                    theStudents[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student Can not Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }


    public void checkInBook(books book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {


            System.out.println(
                    "Serial Number\t\t\tBook Name\t\t\tAuthor Name");

            student s = theStudents[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(
                        s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }

            System.out.println(
                    "Enter Serial Number of Book to be Checked In:");

            int sNo = input.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.checkInBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial Number " + sNo
                    + "not Found");
        }
    }
}

class Library {


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);


        System.out.println(
                "*******Welcome to the digital Library!*******");
        System.out.println(
                "				 Select From The Following Options:			 ");
        System.out.println(
                "************************");


        books ob = new books();

        students obStudent = new students();

        int choice;
        int searchChoice;


        do {

            ob.dispMenu();
            choice = input.nextInt();


            switch (choice) {


                case 1:
                    DigitalLibrary b = new DigitalLibrary();
                    ob.addBook(b);
                    break;


                case 2:
                    ob.upgradeBookQty();
                    break;


                case 3:

                    System.out.println(
                            " press 1 to Search with Book Serial Number.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();


                    switch (searchChoice) {


                        case 1:
                            ob.searchBySno();
                            break;


                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;


                case 4:
                    ob.showAllBooks();
                    break;


                case 5:
                    student s = new student();
                    obStudent.addStudent(s);
                    break;


                case 6:
                    obStudent.showAllStudents();
                    break;


                case 7:
                    obStudent.checkOutBook(ob);
                    break;


                case 8:
                    obStudent.checkInBook(ob);
                    break;


                default:


                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }


        while (choice != 0);
    }
}
