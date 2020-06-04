package demo_reflect;

public class Pig {
    public String pigName;
    public int age;
    public Pig() {
    }

    @Override
    public String toString() {
        return "Pig{" +
                "pigName='" + pigName + '\'' +
                ", age=" + age +
                '}';
    }

    public Pig(String pigName, int age) {
        this.pigName = pigName;
        this.age = age;
    }

    public String getPigName() {
        return pigName;
    }

    public void setPigName(String pigName) {
        this.pigName = pigName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void sleep(){
        System.out.println("sleep all day");
    }
}
