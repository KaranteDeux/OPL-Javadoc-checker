package fr.univlille1.m2iagl.bacquetdurey.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	
	public static Model actualModel = new Model();
	
	
	private List<ClassModel> classModels;
	
	public Model(){
		classModels = new ArrayList<>();
	}
	
	public void addClassModel(ClassModel classModel){
		classModels.add(classModel);
	}

	@Override
	public String toString() {
		return "Model [classModels=" + classModels + "]";
	}
	
}
