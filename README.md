* Maven 3 installieren: http://maven.apache.org/download.cgi
* in das Verzechnis mediathekplus-b7/mediathekplus-b7 wechseln, wo die Datei pom.xml liegt

    $ mvn clean install

ausführen und schauen ob es fehlerfrei baut:

    [INFO] ------------------------------------------------------------------------
    [INFO] Reactor Summary:
    [INFO] 
    [INFO] mediathekplus-b7 .................................. SUCCESS [0.342s]
    [INFO] mediathekplus-b7-model ............................ SUCCESS [1.416s]
    [INFO] mediathekplus-b7-service-api ...................... SUCCESS [0.453s]
    [INFO] mediathekplus-b7-client ........................... SUCCESS [0.424s]
    [INFO] mediathekplus-b7-service-impl-mock ................ SUCCESS [3.623s]
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    

Der Mock-Server wird so gestartet:

    $ cd mediathekplus-b7-service-impl-mock
    $ mvn exec:exec

Er ist auf den Port 4499 konfiguriert. Das kann man aber in der Datei ./mediathekplus-b7-service-impl-mock/pom.xml ändern.
Die Pfade bitte aus der separaten Doku entnehmen.

Client-Implementierung: /mediathekplus-b7-client/src/main/java/de/br/multimedia/mediathekplus/b7/client/RecordingDeliveryRestServiceClient.java
XSD: /mediathekplus-b7-model/src/main/resources/b7-dtm.xsd
Client/Server-Test: /mediathekplus-b7-service-impl-mock/src/test/java/de/br/multimedia/mediathekplus/b7/service/rest/mock/MockedRecordingDeliveryServiceTest.java
