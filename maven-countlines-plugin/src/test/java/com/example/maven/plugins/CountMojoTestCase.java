package com.example.maven.plugins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.test.plugin.BuildTool;
import org.apache.maven.shared.test.plugin.ProjectTool;
import org.apache.maven.shared.test.plugin.TestToolsException;


public class CountMojoTestCase extends AbstractMojoTestCase{

		private BuildTool buildTool;
		private ProjectTool projectTool;
	
		protected void setUp() throws Exception{
			super.setUp();
			buildTool = (BuildTool) lookup(BuildTool.ROLE,"default");
			projectTool = (ProjectTool) lookup(ProjectTool.ROLE,"default");
	
		}
		public void testExecute() throws TestToolsException, InvalidPropertiesFormatException, IOException{
	
			Properties cliProperties = new Properties();
	
			/*
			 */
			List<String> goals = new ArrayList<String>();
			goals.add("com.example.maven.plugins:maven-countlines-plugin:1.0-SNAPSHOT:countlines");
	
			File buildLogFile = new File(getBasedir(),"target/test-classes/build.log");
	
			File testPom = new File(getBasedir(), "src/test/resources/countlines/pom.xml");
			
//			MavenProject project = projectTool.readProjectWithDependencies(testPom);
//			System.out.println("baseDir : "+project.getBasedir());
//			System.out.println(project.getGroupId());
//			System.out.println(project.getDependencies());
//			System.out.println(project.getProperties());
//			System.out.println(project.getParentArtifact());
//			System.out.println(project.getPluginArtifactMap());
//			System.out.println(project.getPluginManagement());
//
//			
//			
//			InvocationRequest req = buildTool.createBasicInvocationRequest(testPom , cliProperties, goals, buildLogFile);
			cliProperties.setProperty( "countlines", "countlines" );

			InvocationResult res = buildTool.executeMaven(testPom , cliProperties, goals, buildLogFile);
	
			System.out.println(res.getExitCode());
			
		}

//	public void testhoge(){
//
//		/*
//		 * プラグインを実行するだけのjavaファイルなので、プラグインさえ追加すればよい
//		 */
//		File testPom = new File(getBasedir(),"src/test/resources/countlines/pom.xml");
//
//		CountlinesMojo mojo;
//		try {
//
//			//このプラグインプロジェクト自体のpomを参照
//			File pluginPom = new File( getBasedir(), "pom.xml" );
//			Xpp3Dom pluginPomDom = Xpp3DomBuilder.build( new FileReader( pluginPom ) );
//			//pomからプラグイン自身のartifactIdを取得
//			String artifactId = pluginPomDom.getChild( "artifactId" ).getValue();
//			
//			//テスト単体のpomの中から、上で取得したプラグインのartifactIdを探し、そのプラグインのconfigurationを取得する
//			PlexusConfiguration configuration = extractPluginConfiguration( artifactId, testPom );
//			Reader reader = new FileReader( testPom );
//			Xpp3Dom pomDom = Xpp3DomBuilder.build( reader );
//			extractPluginConfiguration( artifactId, pomDom );
//
//			int items = configuration.getChildCount();
//			for ( int i = 0; i < items; i++ )
//			{
//				PlexusConfiguration childConfiguration = configuration.getChild( i );
//				String elementName = childConfiguration.getName();
//				System.out.println(elementName);
//				//				ComponentValueSetter valueSetter = new ComponentValueSetter( fromXML( elementName ), object, converterLookup, listener );
//				//				valueSetter.configure( childConfiguration, classLoader, expressionEvaluator );
//			}
//
//			//プロジェクトのpom.xmlから、mojoインターフェイスを取得し、
//			//mojoインターフェイスを実装した自作クラスにキャストしたmojoオブジェクト(プラグイン)を取得する
//			//このとき設定ファイルが、Countlinesmojoに反映される
//			mojo = (CountlinesMojo) lookupMojo("countlines", testPom);
//
//			//pom.xmlから取得しているのではなく、mojoオブジェクトからフィールドを取得
//			String dir = (String) getVariableValueFromObject(mojo, "dir");
//			System.out.println("dir : "+dir);
//			String ext = (String) getVariableValueFromObject(mojo, "ext");
//			//			System.out.println(ext);
//			//以下でMojoメソッド実行(内容は実装次第)
//			//実行先のプラグインの設定は、通常プラグインを使用する時のように、感知する必要はない。
//			mojo.execute();
//
//
//
//			String dirExpected = new String("C:\\tmp\\maven-countlines-plugin");
//			String extExpected = "xml";
//			assertEquals(dirExpected,dir);
//			System.out.println(dir+" : "+dirExpected);
//			assertEquals(extExpected, ext);
//			System.out.println(ext+" : "+extExpected);
//
//		} catch (Exception e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return;
//		}
//
//	}
//
//
//
//	protected String fromXML( String elementName )
//	{
//		return StringUtils.lowercaseFirstLetter( StringUtils.removeAndHump( elementName, "-" ) );
//	}
}
