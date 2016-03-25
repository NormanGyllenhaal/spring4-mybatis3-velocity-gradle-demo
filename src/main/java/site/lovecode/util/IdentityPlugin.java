package site.lovecode.util;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class IdentityPlugin extends PluginAdapter {

	private FullyQualifiedJavaType identity = new FullyQualifiedJavaType("com.jiajiao.core.common.mybatis.identity");
	
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeIdentity(topLevelClass,introspectedTable);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		makeIdentity(topLevelClass,introspectedTable);
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		makeIdentity(topLevelClass,introspectedTable);
		return true;
	}
	
	
	protected void makeIdentity(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {     
            topLevelClass.addImportedType(identity);
            topLevelClass.addSuperInterface(identity);  
    } 
	
	

    public static void generate() {
		String config = IdentityPlugin.class.getClassLoader().getResource("generator.xml").getFile();
		String[] arg = { "-configfile", config, "-overwrite" };
		ShellRunner.main(arg);
	}


	public static void main(String[] args){
		generate();
	}

}
