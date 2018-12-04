package edu.iot.leo.weapon;

import edu.iot.common.util.Random;

public class RobotExample {

	public static void main(String[] args) {
		Weapon []weapons = { 
			new Missile(30),
			new Sword(10),
			new Gun(20)
		};
		
		Robot robot1 = new Robot("건담", 100);
		Unit robot2 = new Robot("자쿠", 100);
		
		// 5회 공격
		for(int i=0; i<5; i++) {
			int select = Random.rand(0, weapons.length);
			Weapon w = weapons[select];
			robot1.attack(w, robot2);
			if(robot2.getHp() <0) {
				System.out.println(robot2.getName() + "파괴됨");
				break;
			}
			robot2.printStatus();			
		}

		Unit building = new Building("사령부", 60);
		// 5회 공격
		for(int i=0; i<5; i++) {
			int select = Random.rand(0, weapons.length);
			Weapon w = weapons[select];
			robot1.attack(w, building);
			if(building.getHp() <0) {
				System.out.println(building.getName() + "파괴됨");
				break;
			}
			building.printStatus();			
		}	

		
	}

}
