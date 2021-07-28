package studentManager;

import javax.swing.text.html.parser.TagElement;
import java.util.Objects;

public class Student {

    // 成员变量
    private String sid;
    private String name;
    private String age;
    private String address;

    public Student(String sid, String name, String age, String address) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    public String getAddress() {
        return this.address;
    }

    public String getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getSid() {
        return this.sid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return  sid + "\t\t\t"+name+"\t\t"+age+"岁\t\t"+address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) && Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(address, student.address);
    }
}
