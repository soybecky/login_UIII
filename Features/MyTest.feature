Feature: Realizacion de casos ingresando nombre de usuario y contraseña

  Scenario: verificacion de ingreso de sesion
    Given Abrir Chrome
    When ingresa Username "usr2" y Password "2222"
    Then inicia sesion 