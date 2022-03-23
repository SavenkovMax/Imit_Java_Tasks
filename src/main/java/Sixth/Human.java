package Sixth;

import java.util.Arrays;
import java.util.Objects;

public class Human implements Comparable<Human> {
    private String surname;
    private String name;
    private String patronymic;
    private String[] fullName;
    private int age;

    public Human(String surname, String name, String patronymic, int age) {
        if (surname == null) {
            throw new IllegalArgumentException("The surname string is null");
        }
        if (name == null) {
            throw new IllegalArgumentException("The name string is null");
        }
        if (patronymic == null) {
            throw new IllegalArgumentException("The patronymic string is null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("The age is less than zero");
        }
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.fullName = new String[]{surname, name, patronymic};
    }

    public Human(Human human) {
        this.surname = human.surname;
        this.name = human.name;
        this.patronymic = human.patronymic;
        this.age = human.age;
        this.fullName = new String[]{surname, name, patronymic};
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return getAge() == human.getAge() &&
                getSurname().equals(human.getSurname()) &&
                getName().equals(human.getName()) &&
                getPatronymic().equals(human.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getPatronymic(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Human human) {
        for (int i = 0; i < 3; i++) {
            if (fullName[i].compareTo(human.fullName[i]) > 0) {
                return 1;
            }
            if (fullName[i].compareTo(human.fullName[i]) < 0) {
                return -1;
            }
        }
        return 0;
    }
}
