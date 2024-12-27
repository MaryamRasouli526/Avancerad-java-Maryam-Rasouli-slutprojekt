# Min To-Do-List

## Beskrivning av projektet
Det jag har gjort är en To-Do-list som består av en GUI där du kan skriva in id,titel och beskrivning och lägga till det. Dessutom kan användaren radera, redigera och prioritera en uppgift baserat på id:et man väljer. Syftet med projektet var att kunna skapa backend och frontend och få dem att interagera med varandra. Detta kommer vara användbart då man jobbar mycket med API:er i arbetslivet som javautvecklare. Till exempel kommer man skapa API:er. För att tillhandahålla tjänster och data till andra system och klienter.

## Metoder ##
### toDoList(BE) ###

- Hämta alla uppgifter
- Hämta uppgift genom titeln
- Hämta uppgift genom id:et
- Lägga till uppgift
- Uppdatera uppgift
- Radera uppgift
- Hämta id
- Sätta id
- Hämta titel
- Sätta titel
- Hämta beskrivning
- Sätta beskrivning

### toDoListFE ###

- Hämta alla uppgifter (knapptryck)
- Lägga till ny uppgift (knapptryck)
- Radera uppgift genom id:et (knapptryck)
- Töm alla input-fält (knapptryck)
- Prioritera uppgift genom id:et (knapptryck)
- Ladda uppgift för redigering (knapptryck)
- Hämta alla uppgifter (servern) 
- Lägg till ny uppgift (servern)
- Radera uppgift genom id:et (servern)
- Prioritera uppgift genom id:et (servern)
- Hämta uppgift genom id:et (servern)
- Hämta id (servern)
- Sätta id (servern)
- Hämta titel (servern)
- Sätta titel (servern)
- Hämta beskrivning (servern)
- Sätta beskrivning (servern)


## Teknologier som används
- **Java**: Högnivå programmeringsspråk som används för att skapa applikationer.
- **IntelliJ**: Är ett IDE (integrated Development Environment) för att skriva och exekvera koden.
- **Maven**: Är ett verktyg för byggautomatisering och den hanterar projektets beroenden och struktur.
- **Jackson**: Ett populärt bibliotek i Java för att konvertera JSON-data till Java-objekt och tvärtom.
- **JSON**: Ett lättviktigt datautbytesformat som ofta används för att skicka och ta emot data mellan klienter och servrar.
- **Postman**: Ett verktyg för att utveckla, testa och felsöka API:er genom att skicka HTTP-förfrågningar och analysera svaren.
- **SceneBuilder**: Ett GUI-verktyg för att designa användargränssnitt i JavaFX visuellt genom att dra och släppa komponenter.
- **Spring Boot**: Ett ramverk som förenklar utvecklingen av Java-applikationer genom att erbjuda färdiga konfigurationer, inbyggd server och stöd för mikrotjänster.

## Installation

För att kunna köra projektet på ens dator måste detta vara installerat:

- **Java 8 eller högre**:
  Ladda ner det från [**Oracle**](https://www.oracle.com/se/java/technologies/downloads/)
- **IntelliJ eller annan IDE**:
  Ladda ner IntelliJ från [**JetBrains**](https://www.jetbrains.com/idea/download/?section=windows)
- **Maven**:
  Ladda ner det från [**Maven**](https://maven.apache.org/download.cgi)
- **JSON**:
- JSON är ett datautbytesformat och kräver ingen installation, men för att arbeta med JSON-filer behöver du redigeringsverktyg som din IDE eller textredigerare.
- **Jackson**:  
  Lägg till Jackson-biblioteket i ditt projekt som en Maven-beroende.
  ```xml
  <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.17.0</version> <!-- Kontrollera den senaste versionen -->
  </dependency>
- **Postman**:Ladda ner Postman från [**Postman**](https://www.postman.com/downloads/). Det används för att testa och felsöka API:er.
- **SceneBuilder**:Ladda ner [**SceneBuilder**](https://openjfx.io/). Det används för att designa JavaFX-användargränssnitt visuellt.
- **Spring Boot**: Lada ner från [**Spring Initializr**](https://start.spring.io/) Skapa ett nytt Spring Boot-projekt via Spring Initializr eller lägg till Spring Boot som en Maven-beroende i ditt projekt.



Om du vill hämta projektet och **bara köra det**, följ dessa steg:

### 1. Gå till GitHub

1. Gå till GitHub-sidan för detta projekt: [Avancerad-java-Maryam-Rasouli-slutprojekt](https://github.com/MaryamRasouli526/Avancerad-java-Maryam-Rasouli-slutprojekt.git).
2. Klicka på den gröna knappen **Code** och kopiera URL:en som visas (https://github.com/MaryamRasouli526/Avancerad-java-Maryam-Rasouli-slutprojekt.git).

### 2. **Öppna en terminal (Kommandoprompt eller Git Bash):**
Om du inte har Git installerat, kan du ladda ner det från [Git's officiella webbplats](https://git-scm.com/downloads).

### 3. **Klona repositoryt:**
I terminalen, navigera till den mapp där du vill lagra projektet och kör kommandot nedan. På så sätt kan du nu ha tillgång til det
```bash
git clone https://github.com/MaryamRasouli526/Avancerad-java-Maryam-Rasouli-slutprojekt.git
```

### Författare
Maryam Rasouli - utvecklaren

Email: maryam.rasouli@gritacademy.se

### Version
- 1.0


