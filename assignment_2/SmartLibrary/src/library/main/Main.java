package library.main;
import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.service.LibraryService;
import library.util.InputValidator;
public class Main {

    public static void main(String[] args) {

        LibraryResource[] resources =
                new LibraryResource[5];

        resources[0] = new Book(
                101,
                "Clean Code",
                "Robert C. Martin"
        );

        resources[1] = new DigitalResource(
                102,
                "Java Programming",
                "James Gosling"
        );

        resources[2] = new Book(
                103,
                "Effective Java",
                "Joshua Bloch"
        );

        resources[3] = new DigitalResource(
                104,
                "Data Structures",
                "Mark Allen Weiss"
        );

        resources[4] = new Book(
                105,
                "Operating System Concepts",
                "Abraham Silberschatz"
        );

        int[] overdueDays = {
            4,
            10,
            3,
            7,
            5
        };

        LibraryService service =
                new LibraryService();

        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {

            System.out.println(
                    "\n================================"
            );

            if (!InputValidator.validateResourceId(
                    resources[i].getResourceId())) {

                System.out.println(
                        "Invalid Resource ID"
                );

                continue;
            }

            service.displayResourceDetails(
                    resources[i]
            );

            System.out.println(
                    "Overdue Days  : " + overdueDays[i]
            );

            double fine = service.calculateFine(
                    resources[i],
                    overdueDays[i]
            );

            System.out.println(
                    "Fine          : Rs. " + fine
            );

            totalFine += fine;
        }

        System.out.println(
                "\n================================"
        );

        System.out.println(
                "TOTAL FINE: Rs. " + totalFine
        );

        System.out.println(
                "================================"
        );

        LibraryResource.displayTotalResources();
    }
}