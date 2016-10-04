package fr.univlille1.m2iagl.bacquetdurey.doclet;

import java.util.List;

import fr.univlille1.m2iagl.bacquetdurey.model.Model;

public class DocletLauncher {


	private final static String JAR_PATH = "./libraries/com-sun-javadoc.jar";
	private final static String DOCLET_SRC_FILE = "src/fr/univlille1/m2iagl/bacquetdurey/doclet/GetJavadocDoclet.java";
	private final static String DOCLET_OPTION = "fr.univlille1.m2iagl.bacquetdurey.doclet.GetJavadocDoclet";
	
	private final static String DOCLET_PATH_OPTION = "bin";

	private String pathToCheck;
	private List<String> packages;
	
	public DocletLauncher(String pathToCheck, List<String> packages){
		this.packages = packages;
		this.pathToCheck = pathToCheck;
	}

	public boolean start(){
		
		if(!compile())
			return false;

		boolean execResult = execute();
		
		System.out.println("Model : ");
		System.out.println(Model.actualModel);
		
		return execResult;
	}

	private boolean compile(){

		String command = "javac -classpath " + JAR_PATH + " " + DOCLET_SRC_FILE;
		
		System.out.println("Command : " + command);

		Runtime runTime = Runtime.getRuntime();

		Process process = null;

		try {
			process = runTime.exec(command);
			process.waitFor();
		} catch(Exception e){
			return false;
		}

		// javac -classpath ./libraries/com-sun-javadoc.jar src/fr/univlille1/m2iagl/bacquetdurey/doclet/ListClass.java 
		return true;
	}

	private boolean execute(){
		// javadoc -docletpath bin
        // -doclet fr.univlille1.m2iagl.bacquetdurey.doclet.GetJavadocDoclet -sourcepath /home/antonin/workspace/pje2/src/
		
		
		
		// Main.execute(new String[]{"-docletpath", DOCLET_PATH_OPTION, "-doclet", DOCLET_OPTION, "-sourcepath", pathToCheck, "annotations"});
		com.sun.tools.javadoc.Main.execute(new String[]{"-docletpath", DOCLET_PATH_OPTION, "-doclet", DOCLET_OPTION, "-sourcepath", pathToCheck, "annotations"});
		
		System.out.println("End of execution");
		
		return true;
	}
}
