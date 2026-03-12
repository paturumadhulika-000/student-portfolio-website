import java.util.*;

public class PortfolioMakerDSA {

    // ---------------- HASHING ----------------
    // HashMap used for storing username and password
    // Topic: Hashing (Hash Function concept using key-value storage)

    static HashMap<String, String> users = new HashMap<>();

    // ---------------- LIST ADT ----------------
    // LinkedList used to store portfolio projects
    // Topic: List ADT, Linked List implementation

    static LinkedList<String> projects = new LinkedList<>();

    // ---------------- STACK ----------------
    // Stack used for navigation history (LIFO)
    // Topic: Stack ADT

    static Stack<String> navigation = new Stack<>();

    // ---------------- QUEUE ----------------
    // Queue used to store contact messages (FIFO)
    // Topic: Queue ADT

    static Queue<String> messages = new LinkedList<>();


    static Scanner sc = new Scanner(System.in);


    // ---------------- SIGNUP ----------------
    static void signup() {

        System.out.print("Enter username: ");
        String user = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        users.put(user, pass);   // Hashing insertion

        System.out.println("Signup successful\n");
    }


    // ---------------- LOGIN ----------------
    static boolean login() {

        System.out.print("Enter username: ");
        String user = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        if (users.containsKey(user) && users.get(user).equals(pass)) {
            System.out.println("Login successful\n");
            return true;
        }

        System.out.println("Invalid login\n");
        return false;
    }


    // ---------------- ADD PROJECT ----------------
    static void addProject() {

        sc.nextLine();

        System.out.print("Enter project name: ");
        String p = sc.nextLine();

        projects.add(p); // Linked List insertion

        navigation.push(p); // Stack operation

        System.out.println("Project added to portfolio\n");
    }


    // ---------------- VIEW PROJECTS ----------------
    static void viewProjects() {

        System.out.println("Your Portfolio Projects:");

        for (String p : projects) {
            System.out.println(p);
        }

        System.out.println();
    }


    // ---------------- LINEAR SEARCH ----------------
    // Topic: Searching – Linear Search

    static void linearSearch() {

        sc.nextLine();

        System.out.print("Enter project to search: ");
        String key = sc.nextLine();

        for (int i = 0; i < projects.size(); i++) {

            if (projects.get(i).equalsIgnoreCase(key)) {

                System.out.println("Project found at position " + i);
                return;
            }
        }

        System.out.println("Project not found");
    }


    // ---------------- BUBBLE SORT ----------------
    // Topic: Sorting – Bubble Sort

    static void bubbleSort() {

        for (int i = 0; i < projects.size() - 1; i++) {

            for (int j = 0; j < projects.size() - i - 1; j++) {

                if (projects.get(j).compareTo(projects.get(j + 1)) > 0) {

                    String temp = projects.get(j);
                    projects.set(j, projects.get(j + 1));
                    projects.set(j + 1, temp);
                }
            }
        }

        System.out.println("Projects sorted using Bubble Sort\n");
    }


    // ---------------- INSERTION SORT ----------------
    // Topic: Sorting – Insertion Sort

    static void insertionSort() {

        for (int i = 1; i < projects.size(); i++) {

            String key = projects.get(i);
            int j = i - 1;

            while (j >= 0 && projects.get(j).compareTo(key) > 0) {

                projects.set(j + 1, projects.get(j));
                j--;
            }

            projects.set(j + 1, key);
        }

        System.out.println("Projects sorted using Insertion Sort\n");
    }


    // ---------------- SELECTION SORT ----------------
    // Topic: Sorting – Selection Sort

    static void selectionSort() {

        for (int i = 0; i < projects.size() - 1; i++) {

            int min = i;

            for (int j = i + 1; j < projects.size(); j++) {

                if (projects.get(j).compareTo(projects.get(min)) < 0)
                    min = j;
            }

            String temp = projects.get(min);
            projects.set(min, projects.get(i));
            projects.set(i, temp);
        }

        System.out.println("Projects sorted using Selection Sort\n");
    }


    // ---------------- QUEUE MESSAGE ----------------
    // Topic: Queue ADT operations

    static void addMessage() {

        sc.nextLine();

        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        messages.add(msg);

        System.out.printl("Message added to queue\n");
    }


    static void viewMessages() {

        System.out.println("Messages:");

        for (String m : messages)
            System.out.println(m);

        System.out.println();
    }


    // ---------------- PRIORITY QUEUE (HEAP) ----------------
    // Topic: Priority Queue / Binary Heap

    static void priorityProjects() {

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.addAll(projects);

        System.out.println("Projects by Priority:");

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }


    // ---------------- MAIN MENU ----------------

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("----- PORTFOLIO MAKER -----");
            System.out.println("1. Signup");
            System.out.println("2. Login");
            System.out.println("3. Add Project");
            System.out.println("4. View Projects");
            System.out.println("5. Search Project (Linear Search)");
            System.out.println("6. Sort Projects (Bubble)");
            System.out.println("7. Sort Projects (Insertion)");
            System.out.println("8. Sort Projects (Selection)");
            System.out.println("9. Add Message (Queue)");
            System.out.println("10. View Messages");
            System.out.println("11. Priority Projects (Heap)");
            System.out.println("12. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: signup(); break;
                case 2: login(); break;
                case 3: addProject(); break;
                case 4: viewProjects(); break;
                case 5: linearSearch(); break;
                case 6: bubbleSort(); break;
                case 7: insertionSort(); break;
                case 8: selectionSort(); break;
                case 9: addMessage(); break;
                case 10: viewMessages(); break;
                case 11: priorityProjects(); break;

                case 12: System.out.println("Exiting..."); break;

                default: System.out.println("Invalid choice");
            }

        } while (choice != 12);
    }
}