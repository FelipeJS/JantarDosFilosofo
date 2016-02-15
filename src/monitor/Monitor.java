package monitor;

public class Monitor {
	Filosofo[] filosofos = new Filosofo[5];

	public Monitor(Filosofo[] filosofos) {
		this.filosofos = filosofos;
	}

	@SuppressWarnings("static-access")
	public synchronized void pegarGarfo(int numero) {
		int ESQUERDO = (filosofos[numero].getNumero() + 5 - 1) % 5;
		int DIREITO = (filosofos[numero].getNumero() + 1) % 5;
		filosofos[numero].setEstado(1);
		System.out.println("O filosofo " + filosofos[numero].getNome() + " está com fome");
		
		if (filosofos[ESQUERDO].getEstado() != 2 && filosofos[DIREITO].getEstado() != 2) {
			filosofos[numero].setEstado(2);
			System.out.println("O filosofo " + filosofos[numero].getNome() + " está comendo");
		} else {
			System.out.println("O filosofo " + filosofos[numero].getNome() + " não pode comer ainda");
		}

		try {
			filosofos[numero].sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void devolverGarfo(int numero) {
		filosofos[numero].setEstado(0);
		System.out.println("O filosofo " + filosofos[numero].getNome() + " está pensando");
	}

	public void setFilosofos(Filosofo[] filosofos) {
		this.filosofos = filosofos;
	}
}
