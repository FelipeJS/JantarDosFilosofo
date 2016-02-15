package semaforo;

public class Principal {
	public static void main(String[] args) {

		Filosofo filosofo0 = new Filosofo("FELIPE", 0);
		Filosofo filosofo1 = new Filosofo("CLOVIS", 1);
		Filosofo filosofo2 = new Filosofo("SOCRATES", 2);
		Filosofo filosofo3 = new Filosofo("PLATAO", 3);
		Filosofo filosofo4 = new Filosofo("CORTELA", 4);

		Filosofo[] filosofos = new Filosofo[5];
		filosofos[0] = filosofo0;
		filosofos[1] = filosofo1;
		filosofos[2] = filosofo2;
		filosofos[3] = filosofo3;
		filosofos[4] = filosofo4;

		filosofo0.setFilosofos(filosofos);
		filosofo1.setFilosofos(filosofos);
		filosofo2.setFilosofos(filosofos);
		filosofo3.setFilosofos(filosofos);
		filosofo4.setFilosofos(filosofos);

		filosofo0.start();
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
	}

}
