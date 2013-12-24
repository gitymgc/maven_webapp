package com.example.maven.plugins;

import java.io.File;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Count Lines of selected files
 *
 * @goal countlines
 */
public class CountlinesMojo extends AbstractMojo {
    /**
     * 
     * @parameter alias = "dir"
     * @required
     */
    private String dir;
 
    /**
     * select extension.
     *
     * @parameter expression="${ext}"
     * @required
     */
    private String ext;
 
    public void execute() throws MojoExecutionException, MojoFailureException {
    	System.out.println("dirs : "+dir);
        File directory = new File(dir);
        String[] extensions = ext.split(",");
 
        if (!directory.isDirectory()) {
            throw new MojoFailureException("There is no file");
        }
 
        CountExecuter executer = new CountExecuter(directory, extensions);
 
        try {
            executer.count();
        } catch (IOException e) {
            throw new MojoExecutionException(e.getMessage());
        }
    }
}
