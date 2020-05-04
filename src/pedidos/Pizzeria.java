package pedidos;

import java.util.ArrayDeque;
import java.util.Queue;

public class Pizzeria {

	private Queue<Pizza> pedidas;
	private Queue<Pizza> preparadas;
	private Queue<Pizza> terminadas;
	
	public Pizzeria() {
		
		pedidas = new ArrayDeque<Pizza>();
		preparadas = new ArrayDeque<Pizza>();
		terminadas = new ArrayDeque<Pizza>();
	}
	
	public void tomarOrden(Pizza orden) {
		
		pedidas.offer(orden);
	}
	
	public void preparar() {
		
		if (!pedidas.isEmpty()) {
			
			Pizza pizza = pedidas.poll();
			
			preparar(pizza);
			
			preparadas.offer(pizza);
		}
	}

	public void hornear() {
		
		if (!preparadas.isEmpty()) {
			
			Pizza pizza = preparadas.poll();
			
			hornear(pizza);
			
			terminadas.offer(pizza);
		}
	}

	public void entregar() {
		
		if (! terminadas.isEmpty()) {
			
			Pizza pizza = terminadas.poll();
			
			entregar(pizza);
		}
	}

	private void preparar(Pizza pizza) {
		
		System.out.printf("Preparando: %s %n", pizza);
	}
	
	private void hornear(Pizza pizza) {

		System.out.printf("Horneando: %s %n", pizza);
	}
	
	private void entregar(Pizza pizza) {

		System.out.printf("Entregando: %s %n", pizza);
	}
	
	public boolean termino() {
		
		return pedidas.isEmpty() && preparadas.isEmpty() && terminadas.isEmpty();
	}
	
	public int contarPendientes() {
		
		return pedidas.size() + preparadas.size() + terminadas.size();
	}
}
