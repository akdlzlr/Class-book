package edu.iot.leo.weapon;

public class Sword implements Weapon {
	int power;
	
	public Sword(int power) {
		this.power = power;
	}
	
	@Override
	public void attack(Unit target) {
		System.out.println("칼을 휘두릅니다.");
		target.damage(power);
	}

}
