package edu.iot.leo.weapon;

public class Building extends Unit {

	public Building(String name, int hp) {
		super(name, hp);
	}

	@Override
	public void damage(int loss) {
		hp -= loss;
	}

}
