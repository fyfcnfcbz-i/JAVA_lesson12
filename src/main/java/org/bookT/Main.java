package org.bookT;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== Телефонная книга =====");
            System.out.println("1. Показать все контакты");
            System.out.println("2. Добавить контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    phoneBook.displayAllContacts();
                    break;
                case 2:
                    phoneBook.addContact();
                    break;
                case 3:
                    phoneBook.deleteContact();
                    break;
                case 0:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }

        } while (choice != 0);
        scanner.close();
    }
}







