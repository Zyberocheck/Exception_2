package SEM_3;

import java.io.FileWriter;
import java.util.Scanner;

public class Who_a_u {

    private String firstName;
    private String lastName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    private void Attention() {
        System.out.println("Все данные вводятся на Английском языке!");
        System.out.println();
    }

    private void FirstName() {
        System.out.println("Введите Имя: ");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым!\n Попробуйте снова!");
        }
    }

    private void LastName() {
        System.out.println("Введите Фамилию:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым!\n Попробуйте снова!");
        }
    }

    private void MiddleName() {
        System.out.println("Введите Отчество: ");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым!\n Попробуйте снова!");
        }
    }

    private void YearOfBirth() {
        System.out.println("Введите год рождения: ");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое поле не может быть пустым!\n Попробуйте снова!");
        }
    }

    private void NumberPhone() {
        try {
            System.out.println("Введите номер телефона: ");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое поле не может быть пустым!\n Попробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("Введен не корректный номер! Попробуйте снова!");
        }
    }

    private void Gender() {
        System.out.println("Введите ваш пол(f - Муж. , m - Жен.): ");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Нужно указать 'f' или 'm' \n Попробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Нужно указать 'f' или 'm' ");
        }
    }

    private void OutPutAll() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n"
                + "Middle name \t- \t" + middleName + "\n" + "Year of birth \t- \t" + yearOfBirth + "\n"
                + "Number phone \t- \t" + numberPhone + "\n" + "Gender   \t- \t" + gender);
    }

    private void United() {
        Attention();
        FirstName();
        LastName();
        MiddleName();
        YearOfBirth();
        NumberPhone();
        Gender();
        OutPutAll();
    }

    public void SaveUnited() {

        United();
        String file = "SEM_3/people/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(" " + firstName + "-" + lastName + "-" + middleName + "-" + yearOfBirth
                    + "-" + numberPhone + "-" + gender + "\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }

}
