package edu.iot.leo.weapon;

public class Missile implements Weapon {
	int power;
	
	public Missile(int power) {
		this.power = power;
	}

	@Override
	public void attack(Unit target) {
		System.out.println("미사일 공격");
		target.damage(power);
	}
}
