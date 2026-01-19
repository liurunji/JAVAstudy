package ArrayList.User;

import java.util.ArrayList;

/*
要求:定义一个方法，根据id查找对应的用户信息。
        // 如果存在，返回索引
        // 如果不存在，返回-1
要求:定义一个方法，根据id查找对应的用户信息。
 // 如果存在，返回true如果不存在，返回false
 */
public class UserTest2 {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        User u1 =  new User("1","张三","123456");
        User u2 =  new User("2","李四","135ABC");
        User u3 =  new User("3","王五","abc123");
        list.add(u1);
        list.add(u2);
        list.add(u3);

        boolean result = selectById1(list,"1");
        System.out.println(result);
    }

    public static boolean selectById1(ArrayList<User> list,String id){
        /*for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id) ){
                return true;
            }
        }
        return false;
        */
        return selectById2(list,id) >=0;   //直接调用下面的方法 >=0说明找到了，返回true,-1说明没找到 直接返回false
    }

    public static int selectById2(ArrayList<User> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id)
                return i;
        }
        return -1;
    }


}
