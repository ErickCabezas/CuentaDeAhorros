/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ec.edu.epn.modelo;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ec.edu.epn.excepciones.ExcepcionCuentaNoCreada;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Marcela
 */
public class CuentaAhorrosTest {
    double monto=180;
    CuentaAhorros cuentaAhorrosObtenida;
    CuentaAhorros cuentaPararetirar;
    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws ExcepcionCuentaNoCreada {
        //entrada por calase de equivalencia valida y por valoor limite 
        cuentaAhorrosObtenida= new CuentaAhorros(monto);
        cuentaPararetirar=new CuentaAhorros();
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void  testCuentaAhorro1(){
        String categoriaEsperada="Normal";
        int antiguedadEsperada=0;
        probarParametros(categoriaEsperada, antiguedadEsperada, monto);
    }

    @Test
    public void  testCuentaAhorro2() throws ExcepcionCuentaNoCreada {
        cuentaAhorrosObtenida=new CuentaAhorros(3000);
        String categoriaEsperada="VIP";
        int antiguedadEsperada=0;
        probarParametros(categoriaEsperada, antiguedadEsperada, 3000);
    }
    private void probarParametros(String categoriaEsperada, int antiguedadEsperada,double monto) {
        assertEquals(categoriaEsperada,cuentaAhorrosObtenida.getCategoria());
        assertEquals(antiguedadEsperada,cuentaAhorrosObtenida.getAntiguedad());
        assertEquals(monto,cuentaAhorrosObtenida.getMonto());
    }

    @Test

    public void testCuentaAhorros_4(){

        double monto = 179;

        String resultadoEsperado = "La cuenta no se puede crear con menos de $180";

        ExcepcionCuentaNoCreada resultadoObtenido

                = assertThrows(ExcepcionCuentaNoCreada.class, () -> new CuentaAhorros(monto));

        assertEquals(resultadoEsperado, resultadoObtenido.getMessage());

    }
    
    @Test
    public void  testDepositar1(){
        String categoriaEsperada="VIP";
        double montoEsperado=3180;
        int antiguedadEsperada=0;
        cuentaAhorrosObtenida.depositar(3000);
        probarParametros(categoriaEsperada, antiguedadEsperada,montoEsperado);
    }

    private void probarCuentaPararetirar(String categoriaEsperada, int antiguedadEsperada, double montoEsperado) {
        assertEquals(categoriaEsperada,cuentaPararetirar.getCategoria());
        assertEquals(antiguedadEsperada,cuentaPararetirar.getAntiguedad());
        assertEquals(montoEsperado,cuentaPararetirar.getMonto());
    }

    @Test
    public void  testRetirar1(){
        cuentaPararetirar.setAntiguedad(5);
        cuentaPararetirar.setCategoria("VIP");
        cuentaPararetirar.setMonto(3180);
        String categoriaEsperada="VIP";
        double montoEsperado=3000;
        int antiguedadEsperada=5;
        cuentaPararetirar.retirar(180);
        probarCuentaPararetirar(categoriaEsperada, antiguedadEsperada, montoEsperado);
    }

    @Test
    public void  testRetirar2(){
        cuentaPararetirar.setAntiguedad(4);
        cuentaPararetirar.setCategoria("VIP");
        cuentaPararetirar.setMonto(3180);
        String categoriaEsperada="VIP";
        double montoEsperado=3180;
        int antiguedadEsperada=4;
        cuentaPararetirar.retirar(180);
        probarCuentaPararetirar(categoriaEsperada, antiguedadEsperada, montoEsperado);
    }

    @Test
    public void  testIdentificarCategoria1(){
        cuentaPararetirar.setAntiguedad(5);
        cuentaPararetirar.setMonto(3180);
        String categoriaEsperada="VIP";
        cuentaPararetirar.retirar(180);
        assertEquals(categoriaEsperada,cuentaPararetirar.getCategoria());
    }
    @Test
    public void  testIdentificarCategoria2(){
        String categoriaEsperada="Normal";
        assertEquals(categoriaEsperada,cuentaAhorrosObtenida.getCategoria());
    }

    @Test
    public void  testPuedeRetirar1(){
        assertFalse(cuentaAhorrosObtenida.puedeRetirar());
    }
    @Test
    public void  testPuedeRetirar2(){
        cuentaPararetirar.setAntiguedad(5);
        assertTrue(cuentaPararetirar.puedeRetirar());
    }
    @Test
    public void  testIncrementarAntiguedad2(){
        cuentaAhorrosObtenida.incrementarAntiguedad();
        cuentaAhorrosObtenida.incrementarAntiguedad();
        int antiguedadEsperada=2;
        assertEquals(antiguedadEsperada,cuentaAhorrosObtenida.getAntiguedad());
    }
    
}
