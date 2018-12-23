Memory_Game
====
   
   ## Einleitung, Ziele, Randbedingungen

### EINLEITUNG:

Dieses Git- Repository entstand im Rahmen der Kurse Software Engineering und Programmieren mit Java. Wir, Anna Bourennane Lucie Wabartha und Florian Mercier, haben uns entschieden ein Memory spielen zu programmieren und darum unseren Software Engineering Project zu machen.


### ZIELE:

Unser Ziel war ein Memory Spiel zu programmieren, danke unsere er lehrten Fähigkeiten, und dazu ein Projekt herstellen.

### RANDBEDIGUNGEN:

Die Programmierung soll in JAVA mit Eclipse unter der Nutzung von Github und Maven erfolgen. Das Programm soll auf einem Windows, einem MAC und einem Linux funktionieren.

## Kurze Bedienungsanleitung

1) Zur starten des Spieles drucken Sie bitte auf « Run » in ihren Eclipse Applikation. Ein Java Fenster wird sich öffnen.
2) Lesen Sie die Regeln und drucken sie auf « Start ». Die Szene hat sich geändert. 
3) Mit den Regeln, die Sie davor gelesen haben, wissen Sie wie sie spielen sollen. 
4) Wenn Sie gewonnen haben kommen sie auf eine andere Szene.
5) Sie können entweder « Resume » um nochmal zu spielen oder « Exit » um den spiel zur verlassen.

## User Stories 

![](http://image.noelshack.com/fichiers/2018/51/7/1545591524-user-story.png)

## User Story Plan

![](http://image.noelshack.com/fichiers/2018/51/7/1545591524-user-story-plan-1.png)

![](http://image.noelshack.com/fichiers/2018/51/7/1545591524-user-story-plan-2.png)

![](http://image.noelshack.com/fichiers/2018/51/7/1545591524-user-story-plan-3.png)

## Releaseplan Sprint 1
 

![](http://image.noelshack.com/fichiers/2018/51/7/1545591524-release-plan.png)

## Velocity

Nach dem Aufteilen der User Stories in Tasks haben wir einen Gesamtaufwand von 75 Stunden. Da wir maximal 80 Stunden zur Verfügung haben (vierer Gruppe 80 Stunden) schaffen wir es mit 25 Stunden pro Studenten. Gesamt Story Point: 51.

## Dokumentation Sprint 1
 
  
 ### a. Taskliste 

![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-6a.png)
  
  ### b. Anreicherung der User Stories für die Umsetzung 
  
  
    User Story 1-3 :
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-user-story-1-3.png)
  
    User Story 5-8 + 14:  
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-user-story-5-8-14.png)
  
    User Story 9-13:  
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589217-user-story-9-13.png)
  
  
  ### c. UML Package, Klassen- und Sequenzdiagramm
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-6c.png)
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-6c2.png)
  
  ### d. Dokumentation wichtiger Code Snippets 
  
#### MEDIAPLAYER
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545593779-capture-musique-1.png)
  
  *String uriString = new File(‘’theme.mp3’’).toUri().toString();*
  
  Eine URI, aus dem englischen „Uniform Ressource Identifier“, ist genau übersetzt „Benutzer von einheitlichen Ressourcen“ und ist eine kurze Zeichenkette, die eine körperliche oder abstrakte Ressource auf einem Netzwerk identifiziert (z.B. eine Web Info).   
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545593779-capture-musique-2.png)  
  
  Hier bilden wir ein String vom Namen „URIString“, um unsere Tonspur dort hinsetzen zu können. Die Tonspur befindet sich in dem Ressource Programm (src). Wir werden den URI, und dann den String, suchen.  
  
  *MediaPlayer player = new MediaPlayer( new Media(uriString));*
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545594184-capture-musique-3.png)  
  
  Mediaplayer ist eine Klasse, aber wir müssen diese erst importieren, um Media und Mediaplayer benutzen zu können. Wir bauen ein neues Objekt in der Klasse auf. Mediaplayer, den wir hier Player nennen, geben wir den Wert Media (URIString), die unsere Tonspur ist. Der Media Player ist dann fertig.  
  
  *player.play() ;*
  
  Wir starten den MediaPlayer.  
    
    
    
    
  #### FONT
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545594335-capture-police-texte-2.png)
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545594184-capture-police-texte.png)  
  
  Um die Große und den Schriftstil des “Label“ Textes (hier nameGame und Instruktion) oder ein „Button“ (hier: button 1) zu andern , importiert man die Klasse javafx.scene.txt.Font.
Um den Schreibstil zu andern brauch man : NomDuBoutonOuLabel.setFont(Font.font(„den gewünschten Schriftstile“, Große des Schreibstils)).  
  
  
  
  
    
  #### TEXTFARBE
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545593779-capture-couleur-texte-1.png)
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545594184-capture-couleur-texte-2.png)
  
  Um die Farbe eines Label Textes oder eines Knopfes zu ändern, importiert man die Klasse javafx.scene.paint.Color. 
Um die Farbe zu ändern, braucht man: NomDuBoutonOuLabel.setTxtfill(Color.einerderangebotenenfarben).  
  
  
  
  
    
  #### CURSOR
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545593779-capture-curseur-2.png)
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545593779-capture-curseur.png)  
  
  
 Um die Form des Mauszeigers zu ändern, importiert man die Klasse javafx.scene.Cursor und man benutzt: nomDeLaScene.setCursor(Cursor.einederangebotenenmaus).  
   
   
   
    
 ###  e. Herleitung der Testfälle aus den Akzeptanzkriterien der User Stories
  
  ![](http://image.noelshack.com/fichiers/2018/51/7/1545589180-6e.png)


