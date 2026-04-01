package main;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Створення вектору (blockCapacity=4) ===");
        MyVector vec = new MyVector(4);

        System.out.println("\n--- 1. Додавання в кінець (addLast) ---");
        vec.addLast(10);
        vec.addLast(20);
        vec.addLast(30);
        vec.addLast(40);
        vec.addLast(50);
        System.out.println("Після додавання 10,20,30,40,50: " + vec);
        System.out.println("Size=" + vec.size() + ", Capacity=" + vec.capacity());

        System.out.println("\n--- 2. Додавання на початок (addFirst) ---");
        vec.addFirst(5);
        System.out.println("Після addFirst(5): " + vec);
        System.out.println("Size=" + vec.size() + ", Capacity=" + vec.capacity());

        System.out.println("\n--- 3. Додавання в середину (addMiddle) ---");
        vec.addMiddle(3, 99);
        System.out.println("Після addMiddle(3, 99): " + vec);
        System.out.println("Size=" + vec.size() + ", Capacity=" + vec.capacity());

        System.out.println("\n--- 4. Отримання за індексом (get) ---");
        System.out.println("get(0) = " + vec.get(0));
        System.out.println("get(3) = " + vec.get(3));
        System.out.println("get(6) = " + vec.get(6));

        System.out.println("\n--- 5. Метрики ---");
        System.out.println("size()     = " + vec.size());
        System.out.println("capacity() = " + vec.capacity());

        System.out.println("\n--- 6. Видалення за індексом (remove) ---");
        int removed = vec.remove(0);
        System.out.println("remove(0) повернув: " + removed);
        System.out.println("Після видалення: " + vec);

        removed = vec.remove(2);
        System.out.println("remove(2) повернув: " + removed);
        System.out.println("Після видалення: " + vec);
        System.out.println("Size=" + vec.size() + ", Capacity=" + vec.capacity());

        System.out.println("\n--- 7. Очищення (clear) ---");
        vec.clear();
        System.out.println("Після clear(): " + vec);
        System.out.println("Size=" + vec.size() + ", Capacity=" + vec.capacity());

        System.out.println("\n--- Додавання після clear() ---");
        vec.addLast(1);
        vec.addLast(2);
        vec.addLast(3);
        System.out.println("Після додавання 1,2,3: " + vec);

        System.out.println("\n--- Перевірка виключення (get за невірним індексом) ---");
        try {
            vec.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Спіймано виключення: " + e.getMessage());
        }

        System.out.println("\nГотово!");
    }
}
