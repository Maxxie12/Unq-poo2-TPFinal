package ar.edu.unq.poo2.CommonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.poo2.Common.Coordenada;

class CoordenadaTest {

	Coordenada coordenadaTest;

    @BeforeEach
    public void setUp() {
        coordenadaTest = new Coordenada(10,22);
    }

    @Test
    public void testCoordenadaInicial() {
    	assertEquals(10, coordenadaTest.getLongitud());
        assertEquals(22, coordenadaTest.getLatitud()); 
    }

    @Test
    public void testDistanciaEntreDosCoordendas() {

        Coordenada coordenadaSegunda = new Coordenada(25, 50);
        
        assertEquals(coordenadaTest.distanciaALaCoordenda(coordenadaSegunda),31,765);
    }
}
