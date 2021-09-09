        CPU "Z80.TBL"
        HOF "INT8"
          
CARGA: MACRO #a1, #a2, #a3
         LD #a1, A
         LD #a2, B
         LD #a3, C
       MEND
CAMBIA: MACRO #a4, #a5
         PUSH #a4
         PUSH #a5
         POP #a4
         POP #a5
         POP #a10
        MEND
MUEVE: MACRO #a6, #a7, #a8
         LD #a6, A
         LD #a7, B
         LD #a8, C
       MEND
INICIO:  LD A,02H
         LD D,A
         CARGA E,H,L
         ADD A,B
         INC A
         CAMBIA AF,BC
         SLA B
         MUEVE (100H),(IX),(IY+2)
         CAMBIA HL,DE
         HALT
         END INICIO