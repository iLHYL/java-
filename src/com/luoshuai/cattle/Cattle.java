package com.luoshuai.cattle;
//牛的类
public class Cattle {
	private int age;
	private boolean sex;
	
	static boolean Male=true;
	static boolean Female=false;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	public Cattle(){
		this.setAge(0);
		this.setSex(Math.random()>0.5);
	}
	
	public boolean alive(){
		//此处若考虑牛的意外死亡 else的方法体可为：return Math.random()>0.05;
		if(this.age>16){
			return (Math.random()*this.age)>3;
		}else return true;
	}
	
	public boolean canBorn(){
		return this.age%3==0&&this.sex==Female;
	}
	
	public Cattle grows(){
		this.age++;
		if(this.canBorn()&&this.alive()){
			Cattle c=new Cattle();
			return c;
		}else return null;
	}
	/* Test
	public static void main(String[] args) {
		Cattle c=new Cattle();
		c.setAge(10);
		c.setSex(true);
		c.grows();
		System.out.println(c.getAge()+" "+c.isSex()+" "+c.alive()+" "+c.canBorn());	
	}
	*/
}
