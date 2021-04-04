import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxim on 04.04.2021.
 */
@Entity
public class Animal {

    @Id
    private int id;
    private String kindOfAnimal;
    private int age;
    private boolean tail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isTail() {
        return tail;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }
}
