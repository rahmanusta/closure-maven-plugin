# Maven Plugin for Goole Closure Compiler

Combines and compiles your JavaScript files with Google Closure Compiler

## Usage

```xml
<plugin>
<groupId>com.kodcu</groupId>
<artifactId>closure-maven-plugin</artifactId>
<version>1.0.1</version>
<configuration>
	<inputPath>${basedir}/src/main/webapp/js/</inputPath>
	<jss>
		<js>vendor/jquery.js</js>
		<js>vendor/modernizr.js</js>
		<js>foundation/foundation.js</js>
		<js>app.js</js>
	</jss>
	<outputPath>${basedir}/src/main/webapp/js/script.min.js</outputPath>
</configuration>
</plugin>
```

## Repository

```xml
<pluginRepositories>
    <pluginRepository>
        <id>bintray-central</id>
        <name>bintray</name>
        <url>http://dl.bintray.com/rahmanusta/maven</url>
    </pluginRepository>
</pluginRepositories>
```
## Requirements

Needs Java 8+