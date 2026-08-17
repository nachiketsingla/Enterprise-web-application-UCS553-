package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public void displayResourceDetails(
            LibraryResource resource) {

        if (resource instanceof Printable) {

            Printable printable = (Printable) resource;

            printable.printDetails();
        }
    }

    public double calculateFine(
            LibraryResource resource,
            int overdueDays) {

        if (!InputValidator.validateFineDays(overdueDays)) {

            System.out.println("Invalid overdue days.");

            return 0;
        }

        return resource.calculateFine(overdueDays);
    }
}