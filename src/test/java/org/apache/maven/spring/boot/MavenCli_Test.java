package org.apache.maven.spring.boot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.maven.cli.MavenCli;
import org.apache.maven.shared.utils.logging.MessageUtils;
import org.junit.jupiter.api.Test;

public class MavenCli_Test {

	private static void doBefore() {
		
		MessageUtils.systemInstall();
		MessageUtils.registerShutdownHook();

		String mavenHomeProperty = System.getProperty("maven.home");
		if (mavenHomeProperty != null) {
			System.setProperty("maven.multiModuleProjectDirectory", mavenHomeProperty);
		}
		mavenHomeProperty = System.getenv().get("M2_HOME");
		if (mavenHomeProperty != null) {
			System.setProperty("maven.multiModuleProjectDirectory", mavenHomeProperty);
		}
		mavenHomeProperty = System.getenv().get("MAVEN_HOME");
		if (mavenHomeProperty != null) {
			System.setProperty("maven.multiModuleProjectDirectory", mavenHomeProperty);
		}
	}

	//@Test
	public void testInstall() {

		doBefore();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		
		MavenCli cli = new MavenCli();

		int result = cli.doMain(
			new String[] {"install:install-file", "-Dfile=p6spy-3.7.0.jar", "-DgroupId=p6spy", "-DartifactId=p6spy",
					"-Dversion=3.7.0-xx", "-Dpackaging=jar", "-DgeneratePom=true", "-DcreateChecksum=true" }, // maven command line
			"D:\\", // System.getProperty("user.home") + "/anotherProject", // working dir
			out, // output stream
			System.err // error stream
		);

		out.close();
		System.out.print(baos.toString());
		
		MessageUtils.systemUninstall();

		System.out.println(result);

	}

	@Test
	public void testDeploy() {

		doBefore();

		MavenCli cli = new MavenCli();

		int result = cli.doMain(new String[] {"deploy:deploy-file", "-Dfile=p6spy-3.7.0.jar", "-DgroupId=p6spy", "-DartifactId=p6spy",
				"-Dversion=3.7.0-xx2", "-Dpackaging=jar", "-Durl=http://10.71.19.153:8081/nexus/content/repositories/thirdparty/", "-DrepositoryId=nexus-thirdparty"}, // maven
																														// line
				"D:\\", // System.getProperty("user.home") + "/anotherProject", // working dir
				System.out, // output stream
				System.err // error stream
		);

		MessageUtils.systemUninstall();

		System.out.println(result);

	}

	// @Test
	public void testExecute()  {

		doBefore();
		
		MavenCli cli = new MavenCli();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		int result = cli.doMain(new String[] { "install" }, "path/to/project/root", out, out);
		out.close();
		System.out.print(baos.toString());


	}

}
