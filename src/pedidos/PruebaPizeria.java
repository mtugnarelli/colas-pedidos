package pedidos;

import org.junit.Assert;
import org.junit.Test;


public class PruebaPizeria {

	private Pizzeria pizzeria = new Pizzeria();
	
	@Test
	public void terminoUnPedido() {
		
		pizzeria.tomarOrden(Pizza.JAMON);
		pizzeria.preparar();
		pizzeria.hornear();
		pizzeria.entregar();
		
		Assert.assertTrue(pizzeria.termino());
		Assert.assertEquals(0, pizzeria.contarPendientes());
	}
	
	@Test
	public void tomo4OrdeneresPreparo2Horneo1Entrego1() {
		
		pizzeria.tomarOrden(Pizza.MUZZARELLA);
		pizzeria.tomarOrden(Pizza.JAMON);
		pizzeria.preparar();
		pizzeria.tomarOrden(Pizza.FUGAZZETTA);
		pizzeria.hornear();
		pizzeria.preparar();
		pizzeria.entregar();
		pizzeria.tomarOrden(Pizza.ROQUEFORT);
		
		Assert.assertFalse(pizzeria.termino());
		Assert.assertEquals(3, pizzeria.contarPendientes());
	}
}
