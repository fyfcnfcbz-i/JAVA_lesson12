package org.bookT;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    private Map<String, Set<String>> phoneBook;

    Scanner scanner = new Scanner(System.in);

    public static Map<String, Set<String>> createPhoneBook() {
        Map<String, Set<String>> phoneBook = new HashMap<>();
        phoneBook.computeIfAbsent("Ivan", k -> new HashSet<>()).add("123");
        phoneBook.computeIfAbsent("Olga", k -> new HashSet<>()).add("987");
        phoneBook.computeIfAbsent("Bob", k -> new HashSet<>()).add("555");
        phoneBook.computeIfAbsent("David", k -> new HashSet<>()).add("777");
        return phoneBook;
    }

    public PhoneBook() {
        this.phoneBook = createPhoneBook();
    }

    public void displayAllContacts() {
        List<Map.Entry<String, Set<String>>> sortedContacts = phoneBook.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .collect(Collectors.toList());

        System.out.println("Контакты:");
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Всего контактов: " + sortedContacts.size());
    }


    public void addContact() {
        System.out.println("Введите Имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите Номер Телефона: ");
        String phoneNumber = scanner.nextLine();
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public void deleteContact() {
        System.out.print("Введите имя для удаления: ");
        String name = scanner.nextLine();
        if (phoneBook.remove(name) != null) {
            System.out.println("Контакт " + name + " удален.");
        } else {
            System.out.println("Контакт " + name + " не найден.");
        }
    }
}
