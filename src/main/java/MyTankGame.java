import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;


public class MyTankGame extends JFrame {
    Mypanel mp=null;
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        MyTankGame mtg=new MyTankGame();
    }
    //构造函数
    public MyTankGame()
    {
        super("坦克大战"); // JFrame窗口名称
        mp=new Mypanel();
        this.add(mp);
        this.setSize(800,600); //窗口高度和宽度
        this.setLocation(200,100); //窗口位置（相对左上角）
//        this.setBounds(200,100,800,600); //设置窗口大小和位置
//        this.setLocationRelativeTo(null); // 设置窗口在屏幕中央
        this.setVisible(true);  // 默认为false——JFrame不可见，true可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

//坦克类
class Tank
{
    //表示坦克横坐标
    int x=0;

    //表示坦克纵坐标
    int y=0;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}

//我的Tank
class Hero extends Tank
{

    public Hero(int x, int y) {
        super(x, y);
        // TODO 自动生成的构造函数存根
    }

}


//我的面板
class Mypanel extends JPanel
{
    //定义一个我的坦克
    Hero hero=null;

    //构造函数
    public Mypanel()
    {
        hero=new Hero(100,100);
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        //设置面板背景色，全部填充即可，默认为黑色
        g.fillRect(0, 0, 800, 600);
        //画出我的tank，放到paint函数中
        this.DrawTank(hero.getX(), hero.getY(), g,0,0);//hero.getX(), hero.getY()就将x,y传过去了
    }

    //画出tank
    public void DrawTank(int x,int y,Graphics g,int direct,int type)
    {
        //判断是什么类型坦克
        switch(type)
        {
            case 0://我的tank
                g.setColor(Color.cyan);
                break;
            case 1://敌人的tank
                g.setColor(Color.orange);
                break;
        }
        //判断坦克的方向
        switch(direct)
        {
            //向上
            case 0:
                //画出左边矩形
                g.fill3DRect(x, y, 5, 30, false);
                //画出右边矩形
                g.fill3DRect(x+15, y, 5, 30, false);
                //画出中间矩形
                g.fill3DRect(x+5, y+5, 10, 20, false);
                //画出中间圆形
                g.fillOval(x+5, y+10, 10, 10);
                //画出中间直线
                g.fillRect(x+9, y, 2, 10);
                break;
        }
    }
}

/*
                          画出左边矩形
            g.fill3DRect(hero.getX(), hero.getY(), 5, 30, false);
            //画出右边矩形
            g.fill3DRect(hero.getX()+15, hero.getY(), 5, 30, false);
            //画出中间矩形
            g.fill3DRect(hero.getX()+5, hero.getY()+5, 10, 20, false);
            //画出中间圆形
            g.fillOval(hero.getX()+5, hero.getY()+10, 10, 10);
            //画出中间直线
            g.drawLine(hero.getX()+10, hero.getY()+15, 10, 20);
            break;

 */