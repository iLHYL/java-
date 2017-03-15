package com.luoshuai.cattle;
//农场有100头牛 母牛每3年生一次小牛 性别随机 牛16岁后就可能死亡 20年后农场共有多少头牛
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		//初始化
		List<Cattle> cattles=new ArrayList<Cattle>();
		for(int i=0;i<100;i++){
			Cattle c=new Cattle();
			c.setAge((int)(Math.random()*10));
			c.setSex(Math.random()>0.5);
			cattles.add(c);
		}
		//20年
		for(int i=0;i<20;i++){
			//建立新生牛的列表
			List<Cattle> newCattles=new ArrayList<Cattle>();
			for (Cattle cattle : cattles) {
				Cattle newBorn=cattle.grows();
				if(newBorn!=null) newCattles.add(newBorn);
			}
			if(newCattles!=null) cattles.addAll(newCattles);
		}
		//去除死掉的牛
		int counter=0;
		for (Cattle cattle : cattles) {
			//System.out.print(cattle.getAge()+" ");
			if(cattle.getAge()<16) counter++;
		}
		System.out.println("the number of dead cattles is "+(cattles.size()-counter));
		System.out.println("the number of alive cattles is "+counter);
	}
}

