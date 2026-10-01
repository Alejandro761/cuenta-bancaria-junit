# Cuenta bancaria — pruebas unitarias con JUnit 5

**Autor:** Alejandro Elías Castañeda Ibarra

## Cómo correr las pruebas

    ./probar.sh final

## Qué prueba cada clase

| Clase de prueba | Qué prueba | Cuántas pruebas |
|---|---|---|
| DepositoTest | Que una cuenta nueva empiece su saldo en 0, y que la función depositar suma al saldo de la cuenta | 2 |
| RetiroTest | Comprueba que no se pueda retirar números negativos o más saldo del que se tiene, además de comprobar que al retirar sí se esté restando el saldo | 8 |
| TransferenciaTest | Se comprueban que los saldos cambien al realizarse una transferencia, asi como verificar que no se cobre comisión. También prueba que la transferencia se rechace cuando se quiere transferir mas saldo que el total, cuando se intenta transferir una cuenta a sí misma o si no manda la cuenta destino | 7 |
| InteresTest | Se prueba el cálculo de intereses de diferentes saldos y que un saldo negativo lanza un error | 2 |
| ComisionTest | Se prueba que el cuarto retiro cobra comisión y que el número de retiro es un entero mayor a 0 | 2 |
| QuejasTest | Reglas del negocio como que el tercer retiro sigue siendo gratis, se pueden retirar 5000, no se puede modificar el historial o que la comisión aparezca en el historial | 5 |
| CierreDeCuentaTest | Se prueba que las cuentas se puedan cerrar cuando no tengan saldo y que no pueden realizar acciones en ese estado (retiros, depositos, recibir transferencias) | 7 |

## Boleto de salida

1. ¿Por qué una prueba que nunca viste en rojo no es confiable? Hay muchas maneras de probarlas, un ejemplo es con los intereses, hay dos tipos de interes y para probarlo se deben cubrir ambos casos.

2. ¿Qué error se escondía en un valor frontera, y qué prueba lo atrapó? La queda 1, el cual tomaba el tercer deposito con comisión debido a una lógica erronea en la condición 

3. ¿Qué cambió en tu forma de programar al escribir la prueba ANTES del código (MP-6)? Al hacer las pruebas te das cuenta que tu código sigue teniendo ciertos "agujeros" y te obliga a corregirlos, te da un panorama mas extenso sobre como el estado y como mejorar de las reglas del negocio en el código.