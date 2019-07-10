MACRO DECLARE_CONST(label, value)
label: CONST value
END_MACRO

MACRO MOD(dividendo,divisor, resto)
MUA  dividendo
DELF divisor
MULF divisor
ODUF dividendo
PZAF NOARGS
END_MACRO





DECLARE_CONST(value, 10)
