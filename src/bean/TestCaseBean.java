package bean;

public class TestCaseBean {
public static final int PAGE_SIZE=20;
private String caseID;
private String modID;
private String modelName;
private String functions;
private String testCaseName;
private String ext;
private String interpret;
private String descrip;
public String getDescrip() {
	return descrip;
}
public void setDescrip(String descrip) {
	this.descrip = descrip;
}
public String getCaseID() {
	return caseID;
}
public void setCaseID(String caseID) {
	this.caseID = caseID;
}
public String getModID() {
	return modID;
}
public void setModID(String modID) {
	this.modID = modID;
}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public String getFunctions() {
	return functions;
}
public void setFunctions(String functions) {
	this.functions = functions;
}
public String getTestCaseName() {
	return testCaseName;
}
public void setTestCaseName(String testCaseName) {
	this.testCaseName = testCaseName;
}
public String getExt() {
	return ext;
}
public void setExt(String ext) {
	this.ext = ext;
}
public String getInterpret() {
	return interpret;
}
public void setInterpret(String interpret) {
	this.interpret = interpret;
}

}
