# Maven Plugin for Google Closure Compiler

Combines and compiles your JavaScript files with Google Closure Compiler

## Usage

```xml
<plugin>
<groupId>com.kodcu</groupId>
<artifactId>closure-maven-plugin</artifactId>
<version>1.0.3</version>
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

## Requirements

Needs Java 8+

[![Analytics](https://ga-beacon.appspot.com/UA-52823012-1/closure-maven-plugin/readme)](https://github.com/rahmanusta/closure-maven-plugin)
