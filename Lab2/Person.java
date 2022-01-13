import com.google.gson.Gson;

import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;
    private String middleName;
    private short age;

    public Person(String firstName, String secondName, String middleName, short age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.age = age;
    }

    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = new Person("John", "Johnson", "Text", (short) 18);
        System.out.println("Before json: " + person.toString());
        String json = gson.toJson(person);
        System.out.println("json: " + json);
        Person twin = gson.fromJson(json, Person.class);
        System.out.println("After json: " + twin.toString());
        System.out.println("Equals result: " + person.equals(twin));
    }



    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(middleName, person.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, middleName, age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
