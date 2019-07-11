MACRO DECLARE_CONST(label, value)
label: CONST value
END_MACRO

MACRO DECLARE_VAR  (label)
label: SPACE 1
END_MACRO

MACRO MOD(dividendo,divisor, resto)
MUA  dividendo #acc = dividendo
DELF divisor   #acc = dividendo / divisor
MNOF divisor   #acc = (dividendo / divisor) * divisor
ODUF dividendo #acc = dividendo - (dividendo / divisor) * divisor = - dividendo mod divisor
PZAF    #acc = dividendo mod divisor
AUM  resto     #resto = acc = dividendo mod divisor
END_MACRO

MOD(dividendo, divisor, resto)

DECLARE_CONST(dividendo, 20)
DECLARE_CONST(divisor, 10)
DECLARE_VAR(resto)

