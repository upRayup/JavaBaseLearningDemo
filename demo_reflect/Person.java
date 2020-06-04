package demo_reflect;

public class Person {
    public String Name;
    private int age;

    public Person(String name, int age) {
        Name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
    public void eat(){
        System.out.println("eateateat");
    }
    public void eat(String food){
        System.out.println("eat"+food);
    }
}
