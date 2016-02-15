package semaforo;

public class FilosofoSemaforo {
	Filosofo[] filosofos = new Filosofo[5];
	Semaforo semaforo = new Semaforo();

	public FilosofoSemaforo(Filosofo[] filosofos) {
		this.filosofos = filosofos;
	}

	@SuppressWarnings("static-access")
	public void pegarGarfo(int numero) {
		int ESQUERDO = (filosofos[numero].getNumero() + 5 - 1) % 5;
		int DIREITO = (filosofos[numero].getNumero() + 1) % 5;
		
		semaforo.down();
		filosofos[numero].setEstado(1);
		System.out.println("O filosofo " + filosofos[numero].getNome() + " fome");
		
		if (filosofos[ESQUERDO].getEstado() != 2 && filosofos[DIREITO].getEstado() != 2) {
			filosofos[numero].setEstado(2);
			System.out.println("O filosofo " + filosofos[numero].getNome() + " comendo");
		} else {
			System.out.println("O filosofo " + filosofos[numero].getNome() + " não pode comer ainda");
		}
		semaforo.up();
		
		try {
			filosofos[numero].sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public void devolverGarfo(int numero) {
		semaforo.down();
		filosofos[numero].setEstado(0);
		System.out.println("O filosofo " + filosofos[numero].getNome() + " pensando");
		semaforo.up();
	}

	public void setFilosofos(Filosofo[] filosofos) {
		this.filosofos = filosofos;
	}
}
