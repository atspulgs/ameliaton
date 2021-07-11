package eu.keystruck.ameliaton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Ameliaton {
    static final Logger logger = LogManager.getLogger(Ameliaton.class);
    //reference
     /*logger.fatal("Fatal Message");
        logger.error("Error Message");
        logger.info("Info Message");
        logger.debug("Debug Message");
        logger.trace("Trace Message");*/
    
    //Command Line options.
    private static final String ARG_HELP = "--help";
    private static final String ARG_HELP_SHORT = "-h";
    private static final String ARG_VERSION = "--version";
    private static final String ARG_VERSION_SHORT = "-v";
    
    //Command Descriptions
    private static final String DESC_HELP = "This command print this blob of text. Hopefully filled with helpful information.";
    private static final String DESC_VERSION = "Prints the version of the application.";
    
    //Flags
    private static boolean run = true;
    
    public static void main(String... args) {
        if(args != null) for(int i = 0; i < args.length; i++) switch(args[i]) {
            case ARG_HELP, ARG_HELP_SHORT -> { printHelp(); run = false; return; }
            case ARG_VERSION, ARG_VERSION_SHORT -> { printVersion(); run = false; return; } 
            default -> { System.out.println("Unrecognized command: "+args[i]); }
        }
        if(run) {
            System.out.println("Building and running the application.");
        }
    }
    
    public static void printHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(ARG_HELP).append(" | ").append(ARG_HELP_SHORT).append(" - ").append(DESC_HELP).append("\n");
        sb.append("\t").append(ARG_VERSION).append(" | ").append(ARG_VERSION_SHORT).append(" - ").append(DESC_VERSION).append("\n");
        System.out.println(sb.toString());
    }
    
    //This is where im working on the version as well as the pom file. I think the best is using java manifest in one way or another.
    public static void printVersion() {
        Package p = Ameliaton.class.getPackage();
        StringBuilder sb = new StringBuilder();
        sb.append("Implementation Title: ").append(p.getImplementationTitle()).append("\n");
        sb.append("Implementation Vendor: ").append(p.getImplementationVendor()).append("\n");
        sb.append("Implementation Version: ").append(p.getImplementationVersion()).append("\n");
        System.out.println(sb.toString());
        
        // Another solution
        /*Class clazz = MyClass.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        if (!classPath.startsWith("jar")) {
          // Class not from JAR
          return;
        }
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) + 
            "/META-INF/MANIFEST.MF";
        Manifest manifest = new Manifest(new URL(manifestPath).openStream());
        Attributes attr = manifest.getMainAttributes();
        String value = attr.getValue("Manifest-Version");*/
        //fetch version from the manifest. probbaly only possible when built.
        //how should my code know if its run from IDE and when its fully built?
        //we can leave this blank until we are ready to release the first version.
    }
}
