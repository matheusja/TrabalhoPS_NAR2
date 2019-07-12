MACRO DECLARE_CONST(label, value)
label: CONST value
END_MACRO

MACRO DECLARE_VAR  (label)
label: SPACE 1
END_MACRO


DECLARE_CONST(dividendo, 15)
DECLARE_CONST(divisor, 7)
DECLARE_VAR(resto)

