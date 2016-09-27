package fr.univlille1.m2iagl.bacquetdurey.parser;

import com.sun.javadoc.*;

public class ListClass {
    public static boolean start(RootDoc root) {
        ClassDoc[] classes = root.classes();
        for (int i = 0; i < classes.length; ++i) {
            ClassDoc classDoc = classes[i];
            System.out.println(classDoc.commentText());
            ConstructorDoc[] constructorsDoc = classDoc.constructors();
            
            for(int j=0;j<constructorsDoc.length;j++){
            	System.out.println(constructorsDoc[j].commentText());
            }
            
            FieldDoc[] fieldsDoc = classDoc.fields();
            	
            for(int j=0;j<fieldsDoc.length;j++){
            	System.out.println(fieldsDoc[j].commentText());
            }
            
            
            MethodDoc[] methodsDoc = classDoc.methods();
            	
            for(int j=0;j<methodsDoc.length;j++){
            	System.out.println(methodsDoc[j].commentText());
            }
            
        }
        return true;
    }
}