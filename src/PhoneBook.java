/*Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре
будут повторяющиеся имена с разными телефонами, их необходимо
считать, как одного человека с разными телефонами. Вывод должен
быть отсортирован по убыванию числа телефонов.
Иванов Иван Иванович
89998887766
89997776655
Петров Петр Петрович
89996665544
Алексеев Алексей Алексеевич
89991112233
Дмитриев Дмитрий Дмитриевич
89994567897
89991325648
89523658978
84567894512
Сергеев Сергей Сергеевич
45679879879
12564556455
45645654545
 */

import java.util.*;

public class PhoneBook {
    private static final HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();

    public static void main(String[] args) {

        addSubscriber("Иванов Иван Иванович", 89998887766L);
        addSubscriber("Иванов Иван Иванович", 89997776655L);
        addSubscriber("Петров Петр Петрович", 89996665544L);
        addSubscriber("Алексеев Алексей Алексеевич", 89991112233L);
        addSubscriber("Дмитриев Дмитрий Дмитриевич", 89991325648L);
        addSubscriber("Дмитриев Дмитрий Дмитриевич", 89994567897L);
        addSubscriber("Дмитриев Дмитрий Дмитриевич", 89523658978L);
        addSubscriber("Дмитриев Дмитрий Дмитриевич", 84567894512L);
        addSubscriber("Сергеев Сергей Сергеевич", 45679879879L);
        addSubscriber("Сергеев Сергей Сергеевич", 12564556455L);
        addSubscriber("Сергеев Сергей Сергеевич", 45645654545L);

        System.out.println("Неотсортированный список: ");
        printPhoneBook(phoneBook);
        System.out.println("Отсортированный список: ");
        printSortPhoneBook();

    }

    static void addSubscriber(String name, long number) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(number);
        } else {
            ArrayList<Long> list = new ArrayList<>();
            list.add(number);
            phoneBook.put(name, list);
        }
    }

    static void printPhoneBook(Map<String, ArrayList<Long>> tempMap) {
        for (Map.Entry<String, ArrayList<Long>> temp : tempMap.entrySet()) {
            System.out.print(temp.getKey() + ":\n");
            for (Long num : tempMap.get(temp.getKey())) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printSortPhoneBook() {
        LinkedHashMap<String, ArrayList<Long>> tempList = new LinkedHashMap<>();
        for (int i = 0; i < phoneBook.size(); i++) {
            int max = 0;
            String mark = "";
            for (Map.Entry<String, ArrayList<Long>> temp : phoneBook.entrySet()) {
                int size = phoneBook.get(temp.getKey()).size();
                if (size >= max && !tempList.containsKey(temp.getKey())) {
                    max = size;
                    mark = temp.getKey();
                }
            }
            tempList.put(mark, phoneBook.get(mark));
        }
        printPhoneBook(tempList);
    }
}

