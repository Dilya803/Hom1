import java.util.*;

/**
 * Телефонная книга
 */
public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook;

    /**
     * Конструктор телефонной книги
     */
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    /**
     * Метод добавления контактов
     * @param name Имя контакта
     * @param phone Телефонный номер
     */
    public void addEntry(String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    /**
     * Отображение всех контактов с сортировкой по убыванию числа телефонов
     */
    public void displayPhoneBook() {
        List<Map.Entry<String, HashSet<String>>> entryList = new ArrayList<>(phoneBook.entrySet());
        entryList.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        for (Map.Entry<String, HashSet<String>> entry : entryList) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }

    /**
     * Метод с которого запускается исполнение кода, для примера добавлены контакты и номера
     * @param args
     */
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addEntry("Alice", "123-456-7890");
        phoneBook.addEntry("Bob", "234-567-8901");
        phoneBook.addEntry("Alice", "098-765-4321");
        phoneBook.addEntry("Charlie", "345-678-9012");
        phoneBook.addEntry("Bob", "678-901-2345");
        phoneBook.addEntry("Alice", "111-222-3333");

        phoneBook.displayPhoneBook();
    }
}

