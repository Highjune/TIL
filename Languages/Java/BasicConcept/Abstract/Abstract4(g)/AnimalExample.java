package test;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound(); //멍멍
		cat.sound(); //야옹
		System.out.println("-----");
		
		// 변수의 자동 타입 변환
		Animal animal = null;
		animal = new Dog();
		animal.sound(); //멍멍
		animal = new Cat();
		animal.sound(); //야옹
		System.out.println("-----");
		
		// 메소드의 다형성
		animalSound(new Dog()); //멍멍
		animalSound(new Cat()); //야옹
		
	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}
}
