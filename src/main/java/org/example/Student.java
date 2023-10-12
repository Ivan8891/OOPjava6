package org.example;

import java.util.Comparator;
import java.util.List;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class StudentExtended extends Student{
    public StudentExtended(String name) {
        super(name);

    }
}

// Параметризованный класс для представления группы студентов
class User {
    String name;
    String surname;
    String patronymic;

    public User(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return  name + ' ' +
                surname + ' ' +
                patronymic + ' ';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

}

class UserComparator<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int resultOfComparing = o1.getSurname().compareTo(o2.getSurname());
        if (resultOfComparing == 0) {
            resultOfComparing = o1.getName().compareTo(o2.getName());
            if (resultOfComparing == 0) {
                return o1.getPatronymic().compareTo(o2.getPatronymic());
            } else {
                return resultOfComparing;
            }
        } else {
            return resultOfComparing;
        }
    }
}

class StudentGroup<T extends User> {

    private String nameGroup;
    private List<T> group;

    public StudentGroup(String nameGroup, List<T> group) {
        this.nameGroup = nameGroup;
        this.group = group;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public List<T> getGroup() {
        return group;
    }

    public void addStudent(T user) {
        group.add(user);
    }

    public void removeStudent(T user) {
        group.remove(user);
    }
}
