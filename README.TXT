
-Feld
    -Feld wird in Java erzeugt )
    -8*8 als Standard festlegen
    -es wird auf dunkel gespielt
    -es wird angezeigt wie viele eigene Figuren Im Spiel sind und wie viele ausgeschaltet wurden
-Spieler
    -Spieler darf nur die eigenen Figuren bewegen => abwechseln der Züge
    -Wenn der Spieler eine eigene(!) Figur anklickt, wird diese markiert
-Züge
    -Wenn ein Zug erforderlich ist, wird die Figur/Figuren rot markiert. 
        => nur markierte Figuren sind spielbar
        => nur gültige Züge sind spielbar(!)
    -Nur gültige Züge sind möglich  
-Regeln: ==> Kontrolle im main-game-loop, Neustart des Loops, wenn ein Spieler seinen Zug getätigt hat
    -Rückwerts Sprünge sind nicht möglich
        ==>(dunkel nur in y-positiv Richtung, hell nur in y-negativ Richtung)
    -Wenn ein Sprung möglich ist, muss dieser getätigt werden 
        => Spiel erlaubt andere Züge nicht(!)
    -Wenn man auf der anderen Seite des Gegners ankommt, wird die normale Figur zur Dame
        =>Dame darf ein Feld in alle Richtungen gehen 
-Figur:
	-Figur kennt die eigenen Zustand inclusive der eigenen Farbe(ausgedrückt durch int Zustand)
 	-Es gibt folgende Zustände(-1=nicht-Dame hell, 1= Dame hell, -2=nicht-Dame dunkel, 2=Dame dunkel, )
-Steuerung
    -Durch Maus:
        -Anklicken der Figur, die bewegt werden soll
        -Figur wird durch klicken markiert 
        -Anklicken des Feldes, auf dem dir Figur gehen soll
        -Programm wartet bis eine gültige Eingabe erfolgt (do-while loop?)
OPTINAL:
    -Netzwerkspiel machen
    -Farben anpassbar machen
    -Feldgroße veränderbar
    -optionale Regeln hinzufügen (z.B. Russisches Dame)