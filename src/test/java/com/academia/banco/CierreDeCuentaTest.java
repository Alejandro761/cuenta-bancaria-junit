package com.academia.banco;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cierre de cuenta (hecho con TDD)")
class CierreDeCuentaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    void prepararCuenta() {
        cuenta = new CuentaBancaria("Ana");
    }

    @Test
    @DisplayName("1. una cuenta nueva está abierta")
    void cuentaNuevaAbierta() {
        assertFalse(cuenta.estaCerrada());
    }

    @Test
    @DisplayName("2. una cuenta sin saldo se puede cerrar")
    void cerrarSinSaldo() {
        cuenta.cerrar();

        assertTrue(cuenta.estaCerrada());
    }

    @Test
    @DisplayName("3. una cuenta con saldo NO se puede cerrar")
    void cerrarConSaldo() {
        cuenta.depositar(new BigDecimal("0.01"));
        String message = assertThrows(IllegalStateException.class, () -> cuenta.cerrar()).getMessage();
        assertAll(
            () -> assertEquals(message, "No puedes cerrar una cuenta con saldo: $0.01"),
            () -> assertFalse(cuenta.estaCerrada())
        );
    }

    @Test
    @DisplayName("4. en una cuenta cerrada no se puede depositar")
    void cuentaCerradaNoPuedeDepositar() {
        cuenta.cerrar();
        assertThrows(CuentaCerradaException.class, () -> cuenta.depositar(new BigDecimal("1000.00")));
    }

    @Test
    @DisplayName("5. de una cuenta cerrada no se puede retirar")
    void cuentaCerradaNoPuedeRetirar() {
        cuenta.cerrar();
        assertThrows(CuentaCerradaException.class, () -> cuenta.retirar(new BigDecimal("1000.00")));
    }

    @Test
    @DisplayName("6. no se puede transferir HACIA una cuenta cerrada, y el origen no cambia")
    void cuentaCerradaNoRecibeTransferencias() {
        cuenta.cerrar();

        CuentaBancaria origen = new CuentaBancaria("Ale");
        origen.depositar(new BigDecimal("1000.00"));
        
        assertAll(
            () -> assertThrows(CuentaCerradaException.class, () -> origen.transferir(new BigDecimal("100.00"), cuenta)),
            () -> assertEquals(new BigDecimal("1000.00"), origen.getSaldo())            
        );
    }

    @Test
    @DisplayName("7. una cuenta cerrada no se puede volver a cerrar")
    void cuentaCerradaNoSePuedeCerrar() {
        cuenta.cerrar();
        assertThrows(CuentaCerradaException.class, () -> cuenta.cerrar());
    }
}
