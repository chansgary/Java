package AtheletsCoach_proj0730;

/*
 * 测试类
 * */

/*
 * 实现功能：有乒乓球运动员和篮球运动员，乒乓球教练和篮球教练
 * 为了出国,乒乓球相关的人员都需要学习英语
 *
 * 抽象类： 运动员Athletes 教练Coaches
 *
 * 接口：学习英语 LearnEnglish
 * 接口：职业 Profession
 * */
public class ACDemo {
    public static void main(String[] args) {


        System.out.println("乒乓球运动员在做啥呢？？？");
        PingPongA ppa = new PingPongA();
        ppa.learn();
        ppa.learnEnglish();

        System.out.println("----------------------");

        System.out.println("乒乓球教练在做啥呢？？？");
        PingPongT ppt = new PingPongT();
        ppt.teach();
        ppt.learnEnglish();

        System.out.println("----------------------");


        System.out.println("篮球运动员在做啥呢？？？");
        BasketBallA bba = new BasketBallA();
        bba.learn();
//        bba.learnEnglish();

        System.out.println("----------------------");

        System.out.println("篮球教练在做啥呢？？？");
        var bbt = new BasketBallT();
        bbt.teach();
//        bbt.learnEnglish();


    }
}
