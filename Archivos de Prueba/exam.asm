     CPU "Z80.TBL"
     HOF "INT8"
     LD A, (200H)
     LD D,A
     LD A, 8
     LD C,0
eti1: CP C
     JP Z, eti2
     BIT 0, D
     JP NZ, eti2
     INC C
     RR D
     JP eti1
eti2: HALT
