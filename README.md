# MQTT build by Java
Prepare for OOP Game project.
## Paho Esclipce
This project build by Paho Esclipce library - a library support mqtt in many of language.
### Installation
Create a Maven project by IntelliJ IDEA. Add these line to pom.xml file.
```xml
    <dependencies>
        <dependency>
            <groupId>org.eclipse.paho</groupId>
            <artifactId>org.eclipse.paho.client.mqttv3</artifactId>
            <version>1.2.1</version>
        </dependency>
    </dependencies>

    <repositories>
        <repository>
            <id>Eclipse Paho Repo</id>
            <url>https://repo.eclipse.org/content/repositories/paho-releases/</url>
        </repository>
    </repositories>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
```
Reset the application then the library is installed.

## Set up broker
Paho Esclipce support to use tcp or ssl protocol to setup broker.
Example: "tcp://hcmiuiot.tech:1883"

## Usage
### Subscribe
Sub.java: subscribe function => subscribe message by a topic and a broker.
```java
Sub testSubClient = new Sub("hcmiuiot.tech", "id/test");
        testSubClient.subCore();
```
Add this code to main class => testSubClient.subCore() subscribes topic: "id/test" by broker: "tcp://hcmiuiot.tech:1883". (The tcp and port 1883 just can be changed in Sub.java)
### Publish
Pub.java: publish function => publish message to a topic by a broker.
```java
Pub testPubClient = new Pub("hcmiuiot.tech","id/test", "Msg from Kuerl!");
tesPubClient.pubCore();
```
Add this code to main class => testPubClient.pubCore() publish message to topic: "id/test" by broker: "tcp://hcmiuiot.tech:1883". (The tcp and port 1883 just can be changed in Pub.java)

## Notice:
Broker: "tcp://hcmiuiot.tech:1883" belongs to HCMIU - IOT club.

## React Native update:
Just sub, pub at hcmiuiotclub github :vv
