MACRO DECLARE_CONST(label, value)
label: CONST value
END_MACRO

MACRO DECLARE_VAR  (label)
label: SPACE 1
END_MACRO


DECLARE_CONST(dividendo, 20)
DECLARE_CONST(divisor, 10)
DECLARE_VAR(resto)

