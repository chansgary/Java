package studentManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {
    // 创建集合对象，用于存储学生数据
    public static ArrayList<Student> Students = new ArrayList<>();
    public static Set<String> NumberSet = new HashSet<>();

    // 主界面
    public static void mainMenu() {
        System.out.println("**********欢迎来到陈老板的学生管理系统**********");
        System.out.println("**********     1. 添加学生信息     **********");
        System.out.println("**********     2. 删除学生信息     **********");
        System.out.println("**********     3. 修改学生信息     **********");
        System.out.println("**********     4. 查看所有学生     **********");
        System.out.println("**********     5. 退出程序        **********");
        System.out.println("**********     请输入您的选择      **********");
    }

    // 定义方法，用于添加学生信息
    // public Student(String sid, String name, String age, String address)
    public static void addStudent() {
        // 先创建一个可以存储学生的ArrayList
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生学号");
        String sid = sc.nextLine();
        if (!NumberSet.contains(sid)){
            System.out.println("请输入学生姓名");
            String name = sc.nextLine();

            System.out.println("请输入学生年龄");
            String age = sc.nextLine();

            System.out.println("请输入学生居住地");
            String address = sc.nextLine();

            // 创建新的学生实例
            Student s = new Student(sid, name, age, address);

            // 添加到Students列表中
            Students.add(s);
            NumberSet.add(sid);
        } else {
            System.out.println("系统中已存在该学号，请更换学号");
            return;
        }
    }

    // 定义方法，用于查看学生信息
    public static void showStudent() {
        // 显示表头信息
        System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t居住地");
        for (var student : Students) {
            System.out.println(student);
        }
    }

    // 定义方法，用于删除学生信息
    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的学号: ");
        String sid = sc.nextLine();

        // 即将删除的学生
        Student deletedStudent = null;

        // 遍历Students寻找要被删除的student
        for (var student : Students) {
            // 字符串的比较应该用.equals 而不是==
            if (student.getSid().equals(sid)) {
                deletedStudent = student;
            }
        }

        if (deletedStudent == null) {
            System.out.println("您要删除的学生不存在");
            System.out.println("\t提示: 请重新查看所有学生再操作");
            return;
        }

        // 提醒用户是否要删除信息
        // 并显示表头+详细信息
        if (deletedStudent != null) {
            System.out.println("请问您确定要删除学生:[y/n]" +
                    "\n(提示: 不区分大小写)");
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t居住地");
            System.out.println(deletedStudent.toString());

            while (true) {
                switch (sc.next().toLowerCase()) {
                    case "y":
                        Students.remove(deletedStudent);
                        System.out.println("删除成功");
                        return;
                    case "n":
                        System.out.println("删除操作回滚");
                        return;
                    default:
                        System.out.println("请问您确定要删除学生:y/n");
                        continue;
                }
            }
        }


    }


    // 定义方法，用于修改学生信息
    public static void editStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要修改的学生的学号:");
        String sid = sc.nextLine();

        // 即将修改的学生
        Student editedStudent = null;

        // 遍历Students寻找要被修改的student
        for (var student : Students) {
            // 字符串的比较应该用.equals 而不是==
            if (student.getSid().equals(sid)) {
                editedStudent = student;
            }
        }

        if (editedStudent == null) {
            System.out.println("您要修改的学生不存在");
            System.out.println("\t提示: 请重新查看所有学生再操作");
            return;
        }


        if (editedStudent != null) {
            // 提醒用户是否要修改学生信息
            // 并显示表头+详细信息
            System.out.println("请问您确定要修改学生:[y/n]" +
                    "\n(提示: 不区分大小写)");
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t居住地");
            System.out.println(editedStudent.toString());

            while (true) {
                switch (sc.next().toLowerCase()) {
                    case "y":
                        Students.remove(editedStudent);
                        // 将要修改的学生删除并重新添加一名新的学生
                        addStudent();
                        return;
                    case "n":
                        System.out.println("修改操作回滚");
                        return;
                    default:
                        System.out.println("请问您确定要修改学生:y/n");
                        continue;
                }
            }
        }

    }

    public static void switchChoice(String s) {
        switch (s) {
            case "1":
                System.out.println("**********     1. 添加学生信息     **********");
                addStudent();
                break;
            case "2":
                System.out.println("**********     2. 删除学生信息     **********");
                deleteStudent();
                break;
            case "3":
                System.out.println("**********     3. 修改学生信息     **********");
                editStudent();
                break;
            case "4":
                if (Students.size() == 0) {
                    System.out.println("无信息，请先添加信息再查询！");
                } else {
                    System.out.println("**********     4. 查看所有学生     **********");
                    showStudent();
                }
                break;
            case "5":
                System.out.println("欢迎使用陈老板的程序,再见");
                System.exit(0); // JVM退出
            default:
                System.out.println("请遵守陈老板的规则！");
                System.out.println("\t提示:只能输入数字1-5");
        }

    }

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            mainMenu();
            String line = sc.nextLine();
            switchChoice(line);
            System.out.println();
        }
    }
}
