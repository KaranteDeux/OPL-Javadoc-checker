package fr.univlille1.m2iagl.bacquetdurey.parser;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;

import fr.univlille1.m2iagl.bacquetdurey.model.ClassModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ConstructorModel;
import fr.univlille1.m2iagl.bacquetdurey.model.FieldModel;
import fr.univlille1.m2iagl.bacquetdurey.model.MethodModel;
import fr.univlille1.m2iagl.bacquetdurey.model.ParameterModel;

public class Parser {
	
	public static ClassModel parseClass(ClassDoc classDoc){
		
		ClassModel classModel = new ClassModel(classDoc.name(), classDoc.commentText());
		ConstructorDoc[] constructorsDoc = classDoc.constructors();
		
		for(int i=0;i<constructorsDoc.length;i++){
			ConstructorDoc constructorDoc = constructorsDoc[i];
			classModel.addConstructorModel(Parser.parseConstructor(constructorDoc));
		}
		
		FieldDoc[] fieldsDoc = classDoc.fields();
		
		for(int i=0;i<fieldsDoc.length;i++){
			FieldDoc fieldDoc = fieldsDoc[i];
			classModel.addFieldModel(Parser.parseField(fieldDoc));
		}
		
		MethodDoc[] methodsDoc = classDoc.methods();
		
		for(int i=0;i<methodsDoc.length;i++){
			MethodDoc methodDoc = methodsDoc[i];
			classModel.addMethodModel(Parser.parseMethod(methodDoc));
		}
		
		return classModel;
	}
	
	public static ConstructorModel parseConstructor(ConstructorDoc constructorDoc){
		
		ConstructorModel constructorModel = new ConstructorModel(constructorDoc.commentText());		

		
		for(ParamTag paramTag : constructorDoc.paramTags()){
			constructorModel.addParameterModel(Parser.parseParameter(paramTag));
		}
		
		return constructorModel;
	}
	
	public static ParameterModel parseParameter(ParamTag paramTag){
		return new ParameterModel("", paramTag.parameterName(), paramTag.parameterComment());
	}
	
	public static FieldModel parseField(FieldDoc fieldDoc){
		return new FieldModel(fieldDoc.name(), fieldDoc.type().typeName(), fieldDoc.commentText());
	}
	
	public static MethodModel parseMethod(MethodDoc methodDoc){
		
		MethodModel methodModel = new MethodModel(Parser.getVisibility(methodDoc), methodDoc.returnType().typeName(), methodDoc.name(), methodDoc.commentText());
		
		for(ParamTag paramTag : methodDoc.paramTags()){

			methodModel.addParameterModel(Parser.parseParameter(paramTag));
		}
		
		return methodModel;
	}
	
	private static String getVisibility(MethodDoc methodDoc){
		if(methodDoc.isPublic())
			return "public";
		
		if(methodDoc.isPrivate())
			return "private";
		
		if(methodDoc.isProtected())
			return "protected";
		
		return "";
	}
	
	
}
