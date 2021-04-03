package bojo;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxim on 03.04.2021.
 */
@Entity
public class Person {
    @Id
    private int id;
    private String name;
    private int age;
    private boolean marriaged;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarriaged() {
        return marriaged;
    }

    public void setMarriaged(boolean marriaged) {
        this.marriaged = marriaged;
    }
}
