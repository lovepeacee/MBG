package config;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * mybatis generator生成注释插件
 * <p>
 * Created by huhaichao on 2017/5/15.
 */
public class MyToStringGenerator extends PluginAdapter {

    private boolean useToStringFromRoot;


    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        this.useToStringFromRoot = StringUtility.isTrue(properties.getProperty("useToStringFromRoot"));
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.generateToString(introspectedTable, topLevelClass);
        return true;
    }

    private void generateToString(IntrospectedTable introspectedTable, TopLevelClass topLevelClass) {
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getStringInstance());
        method.setName("toString");
        if (introspectedTable.isJava5Targeted()) {
            method.addAnnotation("@Override");
        }

        this.context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        method.addBodyLine("StringBuilder sb = new StringBuilder();");
        method.addBodyLine("sb.append(getClass().getSimpleName());");
        method.addBodyLine("sb.append(\" [\");");
        StringBuilder sb = new StringBuilder();
        List<Field> fields = topLevelClass.getFields();
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            String property = field.getName();
            sb.setLength(0);
            if (0 == i) {
                sb.append("sb.append(\"").append(property).append("=\")").append(".append(").append(property).append(");");
            } else {
                sb.append("sb.append(\"").append(", ").append(property).append("=\")").append(".append(").append(property).append(");");
            }
            method.addBodyLine(sb.toString());

        }


        method.addBodyLine("sb.append(\"]\");");
        if (this.useToStringFromRoot && topLevelClass.getSuperClass() != null) {
            method.addBodyLine("sb.append(\", from super class \");");
            method.addBodyLine("sb.append(super.toString());");
        }

        method.addBodyLine("return sb.toString();");
        topLevelClass.addMethod(method);
    }

}
