MACRO MOD(dividendo,divisor, resto)
PIR X0 dividendo
PIR X1 divisor
MUA  dividendo #acc = dividendo
DELF divisor   #acc = dividendo / divisor
MNOF divisor   #acc = (dividendo / divisor) * divisor
ODUF dividendo #acc = dividendo - (dividendo / divisor) * divisor = - dividendo mod divisor
PZAF           #acc = dividendo mod divisor
AUM  resto     #resto = acc = dividendo mod divisor
PIR X2 resto
END_MACRO


MOD(dividendo, divisor, resto)


ZAR # Encerrar a execução(depois vem dados)