package ArrayList.User;

import java.util.ArrayList;

public class UserTest1 {
    public static void main(String[] args) {
        //1.main方法中定义一个集合，存入三个用户对象。
        // 用户属性为:id，username，password
        // 2要求:定义一个方法，根据id查找对应的用户信息。
        // 如果存在，返回索引
        // 如果不存在，返回-1
        ArrayList<User> list = new ArrayList<>();
        User u1 =  new User("1","张三","123456");
        User u2 =  new User("2","李四","135ABC");
        User u3 =  new User("3","王五","abc123");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        int index = selectById(list,"7");
        System.out.println(index);
    }

    public static int selectById(ArrayList<User> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id)
                return i;
        }
        return -1;
    }
}
