package com.kodcu;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.SourceFile;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by usta on 15.07.2014.
 */
@Mojo(name = "precompile",defaultPhase = LifecyclePhase.PROCESS_RESOURCES)
public class App extends AbstractMojo {


    @Parameter
    private String inputPath;

    @Parameter
    private List<String> jss;

    @Parameter
    private String outputPath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {


        try {
            startExecution();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws ScriptException, IOException, URISyntaxException {

        new App().startExecution();
    }

    private void startExecution() throws IOException {

        System.out.println("Started Compiling JavaScript Files");

        StringBuffer buffer = new StringBuffer();

        jss
                .stream()
                .map(jss -> Paths.get(inputPath).resolve(jss))
                .map(IOHelper::readAllBytes)
                .map(bayt -> new String(bayt, Charset.forName("UTF-8")))
                .forEach(buffer::append);

        String concanatedScript = buffer.toString();

        Compiler compiler = new Compiler();
        CompilerOptions options = new CompilerOptions();
        CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(options);

        compiler.compile(SourceFile.fromCode("fake.js", ""),
                SourceFile.fromCode("script.min.js", concanatedScript), options);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputPath));) {

            bufferedWriter.write(compiler.toSource());
        }
        System.out.println("Completed Closure JavaScript Files");
    }

}
