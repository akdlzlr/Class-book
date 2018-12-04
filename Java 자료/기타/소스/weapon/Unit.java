package edu.iot.leo.weapon;

public abstract class Unit {
	protected String name;
	protected int hp;
	
	public Unit(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}
	
	public int getHp() {
		return hp;
	}


	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printStatus() {
		System.out.print("["+ name + " HP] ");
		int len = hp / 10;
		for(int i=0; i < len; i++) {
			System.out.print("#");
		}
		System.out.println("(" + hp +")");
	}
	
	public abstract void damage(int loss);
}
