
# So para testar o processador de macros
# Nao compilar tudo


MACRO definidor(teste)
MACRO definido(alfa)
teste + alfa
END_MACRO
END_MACRO

definidor(beta)
definido(teste)

MACRO definidor(teste, teste2)
definido(alfa)
teste
teste2
END_MACRO

definidor(func, ionou)
