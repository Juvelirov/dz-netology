package ru.netology.adenisov;

import java.util.Arrays;
import java.util.Scanner;

import ru.netology.adenisov.domain.Customer;
import ru.netology.adenisov.domain.Operation;

public class Main {

    public final static int MAX_OPERATIONS = 1_000;
    public final static int MAX_CUSTOMERS = 100;
    private static final Operation[] operations = new Operation[MAX_OPERATIONS];
    private static final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private static final int[][] statement = new int[MAX_CUSTOMERS][MAX_OPERATIONS / MAX_CUSTOMERS];
    private static final int[] customer_operations_count = new int[MAX_CUSTOMERS];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        inputClients(scanner);
        inputOperations(scanner);
        System.out.println("Customers" + Arrays.toString(customers));
        System.out.println("Operations" + Arrays.toString(operations));
        System.out.println("Statement" + Arrays.deepToString(statement));
        System.out.println("Operations count: " + Arrays.toString(customer_operations_count));
    }

    private static void inputClients(Scanner scanner) {
        int customersCount = 0;
        while (true) {
            System.out.println("Customer name: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(customersCount, name);

            customers[customersCount] = customer;
            customersCount++;

            System.out.println("Do you want to enter next customer? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")) {
                break;
            }

            if (customersCount == MAX_CUSTOMERS) {
                break;
            }
        }
    }

    private static void inputOperations(Scanner scanner) {
        int operationId = 0;
        while (true) {
            System.out.println("Sum: ");
            int sum = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            Operation operation = new Operation(operationId, sum, currency, merchant);

            operations[operationId] = operation;
            operation.print(operation);
            operationId++;

            System.out.println("Customer: ");
            int customerId = scanner.nextInt();
            scanner.nextLine();

            int operationsCountForCustomer = customer_operations_count[customerId];
            statement[customerId][operationsCountForCustomer] = operationId;
            customer_operations_count[customerId] = operationsCountForCustomer + 1;

            System.out.println("Do you want to enter next operation? Y/N");
            String answer = scanner.nextLine();
            if (answer.equals("N")) {
                break;
            }

            if (operationId == MAX_OPERATIONS) {
                break;
            }
        }
    }
}
