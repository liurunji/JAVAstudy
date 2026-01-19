package test4;

public class GirlFriend {
    private String name;
    private int age;
    private char gender;
    private String hobby;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age, char gender, String hobby) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hobby = hobby;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void showInfo(){
        System.out.println("姓名为："+this.name);
        System.out.println("年龄为："+this.age);
        System.out.println("性别为："+this.gender);
        System.out.println("爱好为："+this.hobby);
    }
}
