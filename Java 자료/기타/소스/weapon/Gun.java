package edu.iot.leo.weapon;

public class Gun implements Weapon {
	int power;
	
	public Gun(int power) {
		this.power = power;
	}

	@Override
	public void attack(Unit target) {
		System.out.println("총을 쏩니다.");
		target.damage(power);
	}
}
