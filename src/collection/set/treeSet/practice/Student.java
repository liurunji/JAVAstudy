package collection.set.treeSet.practice;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int Chinese;
    private int math;
    private int English;

    public Student() {
    }

    public Student(String name, int age, int Chinese, int math, int English) {
        this.name = name;
        this.age = age;
        this.Chinese = Chinese;
        this.math = math;
        this.English = English;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return Chinese
     */
    public int getChinese() {
        return Chinese;
    }

    /**
     * 设置
     *
     * @param Chinese
     */
    public void setChinese(int Chinese) {
        this.Chinese = Chinese;
    }

    /**
     * 获取
     *
     * @return math
     */
    public int getMath() {
        return math;
    }

    /**
     * 设置
     *
     * @param math
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * 获取
     *
     * @return English
     */
    public int getEnglish() {
        return English;
    }

    /**
     * 设置
     *
     * @param English
     */
    public void setEnglish(int English) {
        this.English = English;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", Chinese = " + Chinese + ", math = " + math + ", English = " + English + ",总分 = "+(Chinese+math+English)+"}";
    }


    @Override
    public int compareTo(Student o) {
        /*
        需求:创建5个学生对象属性:(姓名,年龄，语文成绩,数学成绩,英语成绩)
        按照总分从高到低输出到控制台
        如果总分一样，按照语文成绩排
        如果语文一样，按照数学成绩排
        如果数学成绩一样，按照英语成绩排
        如果英文成绩一样，按照年龄排
        如果年龄一样，按照姓名的字母顺序排
        如果都一样，认为是同一个学生，不存。
         */
        int sum1 = this.getChinese() + this.getMath() + this.getEnglish();
        int sum2 = o.getChinese() + o.getMath() + o.getEnglish();
        //比较总成绩
        int i = sum1 - sum2;
        //总成绩一样比较语文
        i = i == 0 ? this.getChinese() - o.getChinese() : i;
        //语文成绩一样比较数学成绩
        i = i == 0 ? this.getMath() - o.getMath() : i;
        //数学成绩一样则比较英语成绩
        i = i == 0 ? this.getEnglish() - o.getEnglish() : i;
        //英语成绩一样则按照年龄排序
        i = i == 0 ? this.getAge() - o.getAge() : i;
        //年龄一样，按照姓名的字母顺序排
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;
        return i;
    }
}
