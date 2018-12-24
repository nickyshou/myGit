package bean;

public class HistoryBean {

public int getCaseListID() {
	return caseListID;
}
public void setCaseListID(int caseListID) {
	this.caseListID = caseListID;
}
public String getCaseName() {
	return caseName;
}
public void setCaseName(String caseName) {
	this.caseName = caseName;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public String getRunTime() {
	return runTime;
}
public void setRunTime(String runTime) {
	this.runTime = runTime;
}
public String getFailures() {
	return failures;
}
public void setFailures(String failures) {
	this.failures = failures;
}
public static final int PAGE_SIZE=10;
private int caseListID;
private String caseName;
private String result;
private String runTime;
private String failures;
}
