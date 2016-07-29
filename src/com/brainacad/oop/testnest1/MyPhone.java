package com.brainacad.oop.testnest1;

import java.util.Arrays;
import java.util.Comparator;

public class MyPhone {

    private MyPhoneBook myPhoneBook = new MyPhoneBook();

    public MyPhone() {
    }

    class SimCard {

    }

    class MemoryCard{

    }

    class PowerOnButton{

    }

    class MyPhoneBook {

        private PhoneNumber[] phoneNumbers = new PhoneNumber[10];

        class PhoneNumber {

            String name;
            String phone;

            public PhoneNumber(String name, String phone) {
                this.name = name;
                this.phone = phone;
            }

            public String getName() {
                return name;
            }

            public String getPhone() {
                return phone;
            }

            @Override
            public String toString() {
                return "PhoneNumber{" +
                        "name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        '}';
            }
        }

        public void addPhoneNumber(String name, String phone) {

            for (int i = 0; i < phoneNumbers.length; i++) {
                if (phoneNumbers[i] == null) {
                    phoneNumbers[i] = new PhoneNumber(name, phone);
                    break;
                }
            }
        }

        public void printPhoneBook() {

            for (PhoneNumber item : phoneNumbers) {
                if (item == null) {
                    continue;
                }
                System.out.println(item.toString());
            }
        }

        public void sortByName() {

            Arrays.sort(phoneNumbers, new Comparator<PhoneNumber>() {
                @Override
                public int compare(PhoneNumber o1, PhoneNumber o2) {
                    if (o1 != null && o2 != null) {
                        if (o1.getName().compareTo(o2.getName()) > 1) return 1;
                        if (o1.getName().compareTo(o2.getName()) < 1) return -1;
                    }
                    return 0;
                }
            });
        }

        public void sortByPhoneNumber() {

            Arrays.sort(phoneNumbers, new Comparator<PhoneNumber>() {
                @Override
                public int compare(PhoneNumber o1, PhoneNumber o2) {
                    if (o1 != null && o2 != null) {
                        if (o1.getPhone().compareTo(o2.getPhone()) > 1) return 1;
                        if (o1.getPhone().compareTo(o2.getPhone()) < 1) return -1;
                    }
                    return 0;
                }
            });
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyPhoneBook)) return false;

            MyPhoneBook that = (MyPhoneBook) o;

            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(phoneNumbers, that.phoneNumbers);

        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(phoneNumbers);
        }

        public PhoneNumber[] getPhoneNumbers() {
            return phoneNumbers;
        }
    }

    public MyPhoneBook getMyPhoneBook() {
        return myPhoneBook;
    }

    public void setMyPhoneBook(MyPhoneBook myPhoneBook) {
        this.myPhoneBook = myPhoneBook;
    }

    public void switchOn() {

        System.out.println("Loading PhoneBook records…");

        MyPhoneBook myPhoneBook = new MyPhoneBook();
        myPhoneBook.addPhoneNumber("person5", "0505123456");
        myPhoneBook.addPhoneNumber("person6", "0679877565");
        myPhoneBook.addPhoneNumber("person1", "0672674848");
        myPhoneBook.addPhoneNumber("person4", "0674887955");
        myPhoneBook.addPhoneNumber("person2", "0679587546");
        myPhoneBook.addPhoneNumber("person3", "0997471212");
        myPhoneBook.addPhoneNumber("person9", "0664584551");
        myPhoneBook.addPhoneNumber("person10", "0504875584");
        myPhoneBook.addPhoneNumber("person8", "0684545425");
        myPhoneBook.addPhoneNumber("person7", "0679454546");

        myPhoneBook.sortByName();
        myPhoneBook.printPhoneBook();

        setMyPhoneBook(myPhoneBook);

        System.out.println();
    }

    public MyPhoneBook.PhoneNumber call(int index) {
        return this.getMyPhoneBook().phoneNumbers[index];
    }
}
