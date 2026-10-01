# Errores encontrados en la versión del compañero

Mi suite (MP-1 a MP-4) atrapó sola **5** de los 5 errores: elCuartoRetiroCobraComision, retirarExactamenteElLimiteSePermite

| Queja | Prueba que la reproduce | Qué estaba mal en el código (la línea y por qué) | ¿Mi suite ya lo atrapaba? |
|---|---|---|---|
| 1 | tercerRetiroGratis | 81: La función comisionDelRetiro comparaba el número de retiros gratis con < en vez de <= | sí |
| 2 | retiroExactoDelLimite | 46: la función retirar tomaba comparaba el límite con >= en vez de >  | sí |
| 3 | transferenciaRechazadaNoCambiaElSaldo | 67: se estaba restando el monto del saldo y se comparaba si era negativo | sí |
| 4 | laComisionApareceEnElHistorial | 55: en ningún momento se valida que la varibale retiros sea mayor a 3 para insertar la comisión en el historial | sí |
| 5 | elHistorialNoSePuedeModificar | 97: la lista no se envuelve en Collections.unmodifiableList para hacerla de solo lectura al código externo | sí |