package jantarfilosofos.semaforo;

import jantarfilosofos.monitor.Filosofo;

public class FilosofoSemaforo extends Thread {
	public int numeroDoFilosofo;
	public String nome;
	int N = 5;
	int esquerda = (numeroDoFilosofo + N - 1) % N;
	int direita = (numeroDoFilosofo + 1) % N;
	int pensando = 0;
	int fome = 1;
	int comendo = 2;
	int[] estado = new int[N];
	Semaforo mutex;
	Semaforo s;

	@Override
	public void run() {
		estado[0] = fome;
		estado[1] = comendo;
		while (true) {
			pensar();
			pegarGarfos(numeroDoFilosofo);
			comer();
			devolverGarfos(numeroDoFilosofo);
		}
	}

	public void pegarGarfos(int numeroDoFilosofo) {
		mutex.down();
		estado[numeroDoFilosofo] = fome;
		System.out.println(nome + " fome");
		testar(numeroDoFilosofo);
		mutex.up();
		if (estado[numeroDoFilosofo] != comendo) {
			s.down();
		}
	}

	public void devolverGarfos(int numeroDoFilosofo) {
		mutex.down();
		estado[numeroDoFilosofo] = pensando;
		testar(esquerda);
		testar(direita);
		mutex.up();
	}

	public void pensar() {
		try {
			if (estado[numeroDoFilosofo] == pensando) {
				wait(5000);
				System.out.println(nome + " pensando");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void comer() {
		try {
			if (estado[numeroDoFilosofo] == comendo) {
				wait(5000);
				System.out.println(nome + " comendo");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void testar(int numeroDoFilosofo) {
		if (estado[numeroDoFilosofo] == fome && estado[esquerda] != comendo && estado[direita] != comendo) {
			estado[numeroDoFilosofo] = comendo;
			s.up();
		}
	}

	public static void main(String[] args) {
		Filosofo filosofo0 = new Filosofo();
		Filosofo filosofo1 = new Filosofo();
		Filosofo filosofo2 = new Filosofo();
		Filosofo filosofo3 = new Filosofo();
		Filosofo filosofo4 = new Filosofo();

		filosofo0.nome = "PLATAO";
		filosofo0.numeroDoFilosofo = 0;

		filosofo1.nome = "ARISTOTELES";
		filosofo1.numeroDoFilosofo = 1;

		filosofo2.nome = "FELIPE";
		filosofo2.numeroDoFilosofo = 2;

		filosofo3.nome = "ILDA";
		filosofo3.numeroDoFilosofo = 3;

		filosofo4.nome = "TALES";
		filosofo4.numeroDoFilosofo = 4;

		filosofo0.start();
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
	}
}
