package test2;

import java.util.Random;

public class Role {
    private String name;
    private int blood;
    private char gender;
    private String face;

    String[] boyfaces = {"风流俊雅", "气字轩昂", "相貌英俊", "五官端正", "相貌平平", "一塌糊涂", "面目狰狞" };
    String[] girlfaces = {"美奂绝伦", "沉鱼落雁", "婷婷玉立", "身材娇好", "相貌平平", "相貌简陋", "惨不忍睹" };

    //attack 攻击描述:
    String[] attacks_desc = {
            "%s使出了一招【背心钉】，转到对方的身后，一学问%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变学为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶问%s双腿。",
            "%s运气于学，一瞬间掌心变得血红，一式【学心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的问%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s"
    };

    //injured 受伤描述:
    String[] injureds_desc = {
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果「轰」的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public Role() {
    }

    public Role(String name, int blood, char gender) {
        this.name = name;
        this.blood = blood;
        this.gender = gender;
        setFace(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {

        this.blood = blood;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        if(this.gender == '男'){
            int randomIndex = r.nextInt(boyfaces.length);
            this.face = boyfaces[randomIndex];
        }else {//女
            int randomIndex = r.nextInt(girlfaces.length);
            this.face = girlfaces[randomIndex];
        }
    }

    public void attack(Role role){
        //计算造成的伤害1-20
        Random r = new Random();
        int hurt = r.nextInt(20)+1;

        //计算剩余血量
        int remainBlood = role.getBlood()-hurt;
        if(remainBlood<0){
            remainBlood = 0;
        }
        //修改被揍的人的血量
        role.setBlood(remainBlood);
        //攻击语句
        int randomIndex = r.nextInt(attacks_desc.length);
        System.out.printf(attacks_desc[randomIndex],this.name,role.getName());
        System.out.println();
        //受伤的描述
        // 血量>90  0索引的描述
        // 80~90   1索引的描述
        // 70 ~80  2索引的描述
        //60 ~70   3索引的描述
        //40 ~60   4索引的描述
        //20 ~40   5索引的描述
        //10 ~20   6索引的描述
        //0 ~10   7索引的描述
        if(remainBlood>90){
            System.out.printf(injureds_desc[0],role.getName());
        } else if (remainBlood>80 &&remainBlood<=90) {
            System.out.printf(injureds_desc[1],role.getName());
        }else if (remainBlood>70 &&remainBlood<=80) {
            System.out.printf(injureds_desc[2],role.getName());
        }else if (remainBlood>60 &&remainBlood<=70) {
            System.out.printf(injureds_desc[3],role.getName());
        }else if (remainBlood>40 &&remainBlood<=60) {
            System.out.printf(injureds_desc[4],role.getName());
        }else if (remainBlood>20 &&remainBlood<=40) {
            System.out.printf(injureds_desc[5],role.getName());
        }else if (remainBlood>10 &&remainBlood<=20) {
            System.out.printf(injureds_desc[6],role.getName());
        }else if (remainBlood>0 &&remainBlood<=10) {
            System.out.printf(injureds_desc[7],role.getName());
        }
        System.out.println();


    }

    public void showInfo(){
        System.out.println("姓名为："+this.name);
        System.out.println("血量为："+this.blood);
        System.out.println("性别为："+this.gender);
        System.out.println("面貌为："+this.face);
    }

}
