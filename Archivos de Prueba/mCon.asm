     CPU "Z80.TBL"
     HOF "INT8"

BAND: DL TRUE
SMAC: MACRO
     IF NOT BAND
          CALL RUTINA
     END IF
     IF BAND
          BAND: DL FALSE
          RUTINA: LD B,A
                  ADD A,B
                  RET
     END IF
     MEND
INICIO: LD A,(1000H)
     SMAC
     ADD A,C
     INC D
     SMAC
     HALT
     END INICIO