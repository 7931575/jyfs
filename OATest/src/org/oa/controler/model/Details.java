package org.oa.controler.model;

/*
 * œÍœ∏–≈œ¢±Ì
 */
public class Details {
	private int detailsId;
	private int employeeId;
	private String employeeBirthday;
	private String employeeNation;
	private int employeeGender;
	private int age;
	private String employeeIdNumber;
	private String employeeIphone;
	private String employeeAddress;
	private String employeeEduBackground;
	private String employeeGraduateSchool;
	private int employeeJobId;
	private int employeeDepartmentId;
	private int employeeMarry;
	private String employeeEntryTiime;
	private String employeeHeadImg;
	private String employeeName;
	private String employeePassWord;
	private String employeeAccount;
    private String departmentName;
    private String jobName; 
    private int workAge;
    
	public int getWorkAge() {
		return workAge;
	}

	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}

	public Details(int employeeId, int age, String employeeIphone, int employeeJobId, int employeeDepartmentId,
			String employeeName, String employeeAccount, int workAge) {
		super();
		this.employeeId = employeeId;
		this.age = age;
		this.employeeIphone = employeeIphone;
		this.employeeJobId = employeeJobId;
		this.employeeDepartmentId = employeeDepartmentId;
		this.employeeName = employeeName;
		this.employeeAccount = employeeAccount;
		this.workAge = workAge;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Details() {

	}
	

	public Details(int employeeId, String employeeIphone, String employeeAddress, int employeeMarry,
			String employeePassWord) {
		super();
		this.employeeId = employeeId;
		this.employeeIphone = employeeIphone;
		this.employeeAddress = employeeAddress;
		this.employeeMarry = employeeMarry;
		this.employeePassWord = employeePassWord;
	}

	public Details(String employeeBirthday, String employeeNation, int employeeGender, int age, String employeeIdNumber,
			String employeeIphone, String employeeAddress, String employeeEduBackground, String employeeGraduateSchool,
			int employeeJobId, int employeeDepartmentId, int employeeMarry, String employeeEntryTiime,
			String employeeHeadImg, String employeeName, String employeePassWord, String employeeAccount) {
		super();
		this.employeeBirthday = employeeBirthday;
		this.employeeNation = employeeNation;
		this.employeeGender = employeeGender;
		this.age = age;
		this.employeeIdNumber = employeeIdNumber;
		this.employeeIphone = employeeIphone;
		this.employeeAddress = employeeAddress;
		this.employeeEduBackground = employeeEduBackground;
		this.employeeGraduateSchool = employeeGraduateSchool;
		this.employeeJobId = employeeJobId;
		this.employeeDepartmentId = employeeDepartmentId;
		this.employeeMarry = employeeMarry;
		this.employeeEntryTiime = employeeEntryTiime;
		this.employeeHeadImg = employeeHeadImg;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
	}

	public Details(int detailsId, int employeeId, String employeeBirthday, String employeeNation, int employeeGender,
			int age, String employeeIdNumber, String employeeIphone, String employeeAddress,
			String employeeEduBackground, String employeeGraduateSchool, int employeeJobId, int employeeDepartmentId,
			int employeeMarry, String employeeEntryTiime, String employeeHeadImg, String employeeName,
			String employeePassWord, String employeeAccount) {
		super();
		this.detailsId = detailsId;
		this.employeeId = employeeId;
		this.employeeBirthday = employeeBirthday;
		this.employeeNation = employeeNation;
		this.employeeGender = employeeGender;
		this.age = age;
		this.employeeIdNumber = employeeIdNumber;
		this.employeeIphone = employeeIphone;
		this.employeeAddress = employeeAddress;
		this.employeeEduBackground = employeeEduBackground;
		this.employeeGraduateSchool = employeeGraduateSchool;
		this.employeeJobId = employeeJobId;
		this.employeeDepartmentId = employeeDepartmentId;
		this.employeeMarry = employeeMarry;
		this.employeeEntryTiime = employeeEntryTiime;
		this.employeeHeadImg = employeeHeadImg;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
	}



	public Details(int employeeId, String employeeBirthday, String employeeNation, int employeeGender, int age,
			String employeeIdNumber, String employeeIphone, String employeeAddress, String employeeEduBackground,
			String employeeGraduateSchool, int employeeJobId, int employeeDepartmentId, int employeeMarry,
			String employeeEntryTiime, String employeeHeadImg, String employeeName, String employeePassWord,
			String employeeAccount) {
		super();
		this.employeeId = employeeId;
		this.employeeBirthday = employeeBirthday;
		this.employeeNation = employeeNation;
		this.employeeGender = employeeGender;
		this.age = age;
		this.employeeIdNumber = employeeIdNumber;
		this.employeeIphone = employeeIphone;
		this.employeeAddress = employeeAddress;
		this.employeeEduBackground = employeeEduBackground;
		this.employeeGraduateSchool = employeeGraduateSchool;
		this.employeeJobId = employeeJobId;
		this.employeeDepartmentId = employeeDepartmentId;
		this.employeeMarry = employeeMarry;
		this.employeeEntryTiime = employeeEntryTiime;
		this.employeeHeadImg = employeeHeadImg;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
	}



	public Details(int employeeId, String employeeNation, int employeeGender, int age,
			String employeeIdNumber, String employeeIphone, String employeeAddress, String employeeEduBackground,
			String employeeGraduateSchool, int employeeJobId, int employeeDepartmentId, int employeeMarry,
			String employeeEntryTiime, String employeeName, String employeePassWord, String employeeAccount,String employeeHeadImg) {		
		super();
		this.employeeId = employeeId;		
		this.employeeNation = employeeNation;
		this.employeeGender = employeeGender;
		this.age = age;
		this.employeeIdNumber = employeeIdNumber;
		this.employeeIphone = employeeIphone;
		this.employeeAddress = employeeAddress;
		this.employeeEduBackground = employeeEduBackground;
		this.employeeGraduateSchool = employeeGraduateSchool;
		this.employeeJobId = employeeJobId;
		this.employeeDepartmentId = employeeDepartmentId;
		this.employeeMarry = employeeMarry;
		this.employeeEntryTiime = employeeEntryTiime;
		this.employeeName = employeeName;
		this.employeePassWord = employeePassWord;
		this.employeeAccount = employeeAccount;
		this.employeeHeadImg = employeeHeadImg;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeBirthday() {
		return employeeBirthday;
	}

	public void setEmployeeBirthday(String employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}

	public String getEmployeeNation() {
		return employeeNation;
	}

	public void setEmployeeNation(String employeeNation) {
		this.employeeNation = employeeNation;
	}

	public int getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(int employeeGender) {
		this.employeeGender = employeeGender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmployeeIdNumber() {
		return employeeIdNumber;
	}

	public void setEmployeeIdNumber(String employeeIdNumber) {
		this.employeeIdNumber = employeeIdNumber;
	}

	public String getEmployeeIphone() {
		return employeeIphone;
	}

	public void setEmployeeIphone(String employeeIphone) {
		this.employeeIphone = employeeIphone;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeEduBackground() {
		return employeeEduBackground;
	}

	public void setEmployeeEduBackground(String employeeEduBackground) {
		this.employeeEduBackground = employeeEduBackground;
	}

	public String getEmployeeGraduateSchool() {
		return employeeGraduateSchool;
	}

	public void setEmployeeGraduateSchool(String employeeGraduateSchool) {
		this.employeeGraduateSchool = employeeGraduateSchool;
	}

	public int getEmployeeJobId() {
		return employeeJobId;
	}

	public void setEmployeeJobId(int employeeJobId) {
		this.employeeJobId = employeeJobId;
	}

	public int getEmployeeDepartmentId() {
		return employeeDepartmentId;
	}

	public void setEmployeeDepartmentId(int employeeDepartmentId) {
		this.employeeDepartmentId = employeeDepartmentId;
	}

	public int getEmployeeMarry() {
		return employeeMarry;
	}

	public void setEmployeeMarry(int employeeMarry) {
		this.employeeMarry = employeeMarry;
	}

	public String getEmployeeEntryTiime() {
		return employeeEntryTiime;
	}

	public void setEmployeeEntryTiime(String employeeEntryTiime) {
		this.employeeEntryTiime = employeeEntryTiime;
	}

	public String getEmployeeHeadImg() {
		return employeeHeadImg;
	}

	public void setEmployeeHeadImg(String employeeHeadImg) {
		this.employeeHeadImg = employeeHeadImg;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassWord() {
		return employeePassWord;
	}

	public void setEmployeePassWord(String employeePassWord) {
		this.employeePassWord = employeePassWord;
	}

	public String getEmployeeAccount() {
		return employeeAccount;
	}

	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}

	@Override
	public String toString() {
		return "Details [detailsId=" + detailsId + ", employeeId=" + employeeId + ", employeeBirthday="
				+ employeeBirthday + ", employeeNation=" + employeeNation + ", employeeGender=" + employeeGender
				+ ", age=" + age + ", employeeIdNumber=" + employeeIdNumber + ", employeeIphone=" + employeeIphone
				+ ", employeeAddress=" + employeeAddress + ", employeeEduBackground=" + employeeEduBackground
				+ ", employeeGraduateSchool=" + employeeGraduateSchool + ", employeeJobId=" + employeeJobId
				+ ", employeeDepartmentId=" + employeeDepartmentId + ", employeeMarry=" + employeeMarry
				+ ", employeeEntryTiime=" + employeeEntryTiime + ", employeeHeadImg=" + employeeHeadImg
				+ ", employeeName=" + employeeName + ", employeePassWord=" + employeePassWord + ", employeeAccount="
				+ employeeAccount + "]";
	}

	
}
