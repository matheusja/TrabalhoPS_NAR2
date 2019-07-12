
# So para testar o processador de macros
# Nao compilar tudo


MACRO definidor(teste)
  teste_RELATIVE: definindo macros
  MACRO definido(alfa)
    teste         :
    teste + alfa
  END_MACRO
END_MACRO

definido(teste)
definidor(beta)
definido(teste)

MACRO definidor(teste, teste2)
  definido(alfa)
  teste
  teste2__RELATIVE
END_MACRO

definidor(func, ionou)
