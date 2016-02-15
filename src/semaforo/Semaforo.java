package semaforo;


public class Semaforo {
	// Propriedades
	/** Contador do semaforo */
	protected int iCount;

	// Construtor
	public Semaforo() {
		iCount = 1;
	}

	// Metodos
	/**
	 * Implementa o funcionamento da primitiva down Obs.: se Cont == 0 | entao
	 * Coloca Thread para dormir | senao Cont = Cont - 1 fimse
	 */
	public synchronized void down() {
		while (iCount == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Erro na primitiva DOWN : " + e);
				System.exit(0);
			}
		}
		iCount--;
	}

	/**
	 * implementar o funcionamento da primitiva up Obs.: Cont = Cont + 1 se
	 * exitir uma thread dormindo | entao seleciona uma thread para acordar
	 * fimse
	 */
	public synchronized void up() {
		iCount++;
		notifyAll();
	}
}
