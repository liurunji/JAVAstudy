package StudentManagement;

import javax.swing.plaf.metal.MetalBorders;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    static ArrayList<User> list = new ArrayList<>();
    static {
        User u1 = new User("user01","123456","370101200001010101","13120100287");
        list.add(u1);
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作:1登录 2注册 3忘记密码 4退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1":
                    login(list);
                    break;
                case "2":
                    register(list);
                    break;
                case "3":
                    updatePassword(list);
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("无效输入");
                    break;
            }
        }
    }

    public static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        String username = "";
        while (true) {
            //输入用户名并进行核验
            System.out.println("请输入用户名：");
            username = sc.next();
            /*开发细节:
            先验证格式是否正确，再验证是否唯一
            因为在以后所有的数据，都是存在数据库中，如果我们要校验，需要使用到网络资源。
            */
            if (getIndex(list, username) >= 0) {
                //正值代表集合里存在当前username
                System.out.println("用户名已存在，请重新输入");
            } else {
                //不存在，则判断长度是否符合要求
                if (username.length() < 3 || username.length() > 15) {
                    System.out.println("长度不符合要求");
                } else {
                    //长度符合要求,则继续判断具体内容
                    int figure = 0, letter = 0; //对数字和字母进行计数
                    boolean flag = true;
                    for (int i = 0; i < username.length(); i++) {
                        char c = username.charAt(i);
                        if (c < '0' || c > '9' && c < 'A' || c > 'Z' && c < 'a' || c > 'z') {
                            //如果出现了一个不在1-9、a-z、A-Z之间的字符则认为用户名是不合法的
                            flag = false;
                            break;
                        } else if (c >= '0' && c <= '9') {
                            figure++;
                        } else {
                            letter++;
                        }
                    }

                    //判定
                    if (!flag) {
                        //出现了非法字符
                        System.out.println("输入了非法字符！");
                    } else if (figure != 0 && letter != 0) {
                        //完全合法的用户名
                        user.setUserName(username);
                        break;
                    } else {
                        //只有数字或只有字母
                        System.out.println("密码必须是字母和数字的组合！");
                    }
                }
            }

        }

        String password1 = "";
        String password2 = "";
        while (true) {
            //密码核验
            System.out.println("请输入密码：");
            password1 = sc.next();
            System.out.println("请再次输入密码：");
            password2 = sc.next();
            if (password2.equals(password1)) {
                user.setPassword(password1);
                System.out.println("密码设置成功");
                break;
            } else {
                System.out.println("两次密码不一致");
            }
        }

        String IdCard = "";
        while (true) {
            System.out.println("请输入身份证：");
            IdCard = sc.next();
            if (IdCard.length() != 18) {
                System.out.println("身份证长度非法");
            } else {
                if (IdCard.charAt(0) == '0') {
                    System.out.println("身份证不能以0开头");
                } else {
                    boolean flag = true;
                    for (int i = 0; i < IdCard.length() - 1; i++) {
                        if (IdCard.charAt(i) < '0' || IdCard.charAt(i) > '9') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        //前17位都是数字
                        //判定第18位
                        if (IdCard.charAt(17) == 'x' || IdCard.charAt(17) == 'X' ||
                                (IdCard.charAt(17) >= '0' && IdCard.charAt(17) <= '9')) {
                            user.setIdCard(IdCard);
                            System.out.println("身份证设置成功");
                            break;
                        } else {
                            System.out.println("最后一位有误");
                        }
                    } else {
                        System.out.println("前17位有非法字符");
                    }
                }
            }
        }

        String phone = "";
        while (true) {
            System.out.println("请输入手机号：");
            phone = sc.next();
            if (phone.length() != 11) {
                System.out.println("手机号长度非法");
            } else {
                if (phone.charAt(0) == '0') {
                    System.out.println("手机号不能以0开头");
                } else {
                    boolean flag = true;
                    for (int i = 0; i < phone.length(); i++) {
                        if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        user.setPhoneNumber(phone);
                        System.out.println("手机号设置成功");
                        break;
                    } else {
                        System.out.println("手机号中有非数字");
                    }
                }
            }
        }

        list.add(user);

    }

    public static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名");
        String username = sc.next();
        int index = getIndex(list, username);  //根据用户名查询用户是否存在并返回其下标
        //用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册
        if (index < 0) { //负值代表不存在该用户
            System.out.println("用户未注册，请先注册");
            return;
        }

        // 判断验证码是否正确，如不正确，重新输入
        while (true) {
            String verificationCode = generateVerificationCode();
            System.out.println("验证码:" + verificationCode);
            System.out.println("请输入验证码");
            String userInputCode = sc.next();
            if (userInputCode.equals(verificationCode)) {
                System.out.println("验证码正确");
                break;
            } else {
                System.out.println("验证码错误，请重新输入");
            }
        }

        // 再判断用户名和密码是否正确，有3次机会
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码");
            String password = sc.next();
            if (list.get(index).getUserName().equals(username) &&
                    list.get(index).getPassword().equals(password)) {
                System.out.println("密码正确,登录成功");
                //登录后跳转
                StudentSystem ss = new StudentSystem();
                //这里如果原方法没有static会自动提示，加上static就没有提示了，但是写完不会报错
                ss.startSystem();
                break;
            } else {
                System.out.println("密码输入错误，你还有" + (2 - i) + "次机会");
            }

        }
    }

    public static void updatePassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        int index = getIndex(list, username);  //根据用户名查询用户是否存在并返回其下标
        //用户名如果未注册，直接结束方法，并提示：用户名未注册，请先注册
        if (index < 0) { //负值代表不存在该用户
            System.out.println("用户未注册，请先注册");
            return;
        }
        System.out.println("请输入身份证号");
        String IdCard = sc.next();
        System.out.println("请输入手机号");
        String phone = sc.next();
        if (list.get(index).getIdCard().equals(IdCard) &&
                list.get(index).getPhoneNumber().equals(phone)) {
            System.out.println("请输入密码");
            String password = sc.next();
            list.get(index).setPassword(password);
        } else {
            System.out.println("账号信息不匹配，修改失败");
        }
    }

    //根据用户名查询用户是否存在并返回其下标
    public static int getIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(username))
                return i;
        }
        return -1;
    }

    //生成随机验证码
    public static String generateVerificationCode() {
        char[] ch = new char[52];
        for (int i = 0; i < ch.length; i++) {
            if (i >= 0 && i <= 25) {
                ch[i] = (char) ('a' + i);
            } else {
                ch[i] = (char) ('A' + i - 26);
            }
        }
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        int randomIndex;
        for (int i = 0; i < 3; i++) {
            randomIndex = r.nextInt(ch.length);
            sb.append(ch[randomIndex]);
        }
        int randomNumber = r.nextInt(10);
        char[] randomChar = sb.append(randomNumber).toString().toCharArray();
        for (int i = 0; i < randomChar.length; i++) {
            randomIndex = r.nextInt(randomChar.length);
            char temp = randomChar[randomIndex];
            randomChar[randomIndex] = randomChar[i];
            randomChar[i] = temp;
        }
        String verificationCode = new String(randomChar);
        return verificationCode;
    }
}
