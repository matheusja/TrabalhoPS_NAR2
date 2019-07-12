MACRO MOD(dividendo,divisor, resto)
MUA  dividendo #acc = dividendo
DELF divisor   #acc = dividendo / divisor
MNOF divisor   #acc = (dividendo / divisor) * divisor
ODUF dividendo #acc = dividendo - (dividendo / divisor) * divisor = - dividendo mod divisor
PZAF           #acc = dividendo mod divisor
AUM  resto     #resto = acc = dividendo mod divisor
END_MACRO

MOD(dividendo, divisor, resto)
