import java.util.LinkedList;
import java.util.Queue;

/**
 * TicketCounter demonstrates the use of a queue for
 * simulating a line of customers at a movie theatre.
 */
public class TicketCounter {

    // time required to process one customer (in seconds)
    private static final int PROCESS = 120;

    // maximum number of cashiers to test
    private static final int MAX_CASHIERS = 10;

    // total number of customers in the simulation
    private static final int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {

        Customer customer;
        Queue<Customer> customerQueue = new LinkedList<Customer>();

        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime;
        int averageTime;
        int departs;
        int start;

        // run the simulation for various numbers of cashiers
        for (int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++) {

            // set each cashier's time to zero initially
            for (int i = 0; i <= cashiers; i++) {
                cashierTime[i] = 0;
            }

            // (re)load customer queue, customers arrive every 15 seconds
            customerQueue.clear();
            for (int i = 1; i <= NUM_CUSTOMERS; i++) {
                customerQueue.add(new Customer(i * 15));
            }

            totalTime = 0;

            // process all customers in the queue
            while (!customerQueue.isEmpty()) {
                for (int i = 0; i <= cashiers; i++) {
                    if (!customerQueue.isEmpty()) {
                        customer = customerQueue.remove();

                        if (customer.getArrivalTime() > cashierTime[i]) {
                            start = customer.getArrivalTime();
                        } else {
                            start = cashierTime[i];
                        }

                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[i] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }

            // output results for this simulation
            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println("Number of cashiers: " + (cashiers + 1));
            System.out.println("Average time (sec): " + averageTime);
            System.out.println();
        }
    }
}
