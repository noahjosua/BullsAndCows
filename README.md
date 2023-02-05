# BullsAndCows

Um die Anwendung direkt in der Konsole testen zu können, muss Oracle **OpenJDK version 18.0.1.1** (https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html) auf deinem System installiert und in den Umgebungsvariablen gesetzt sein. 
  - Systemvariable `JAVA_HOME` = Pfad zum heruntergeladenen JDK 18.0.1.1
  - der Systemvariable `Path` den Wert `%JAVA_HOME%\bin` hinzufügen 

Anschließend die Konsole öffnen und zu dem Order *...BullsAndCows-main/out/artifacts/BullsAndCows_jar/* navigieren. 
Nun mittels `java -jar BullsAndCows.jar` die Anwendung starten. 

### Hinweise zur Eingabe
Die Anzahl der möglichen Symbole im Code muss >= der Länge des Codes sein. 

### Troubleshoot Invalid VCS root mapping
Bis ich den Fehler behoben habe, kann er wie folgt beseitigt werden: 
1. klicke auf Configure...
2. klicke auf die Spalte VCS und wähle 'none' aus dem Dropdown Menü <none> an


Viel Spaß!
