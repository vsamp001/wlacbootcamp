import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableModel;




//import java.io.*;
public class StudentInfoSystemFinal extends JFrame {
	//window size
	private final int WINDOW_WIDTH = 640;
	private final int WINDOW_HEIGHT = 360;
	//Database
	private StudentInfoSysDB db;
	/*For Menu bar*/
	private JLabel messageLabel; //Start Welcome Label
	private JPanel welcomePanel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu studentInfoMenu;
	private JMenu coursesMenu;
	private JMenu enrollmentMenu;
	private JMenu facultyMenu;
	private JMenu departmentMenu;
	private JMenu gradesMenu;
	private JMenu reportMenu;
	private JMenuItem exitItem;
	private JRadioButtonMenuItem searchStudentItem;
	private JRadioButtonMenuItem addStudentItem;
	private JRadioButtonMenuItem searchCoursesItem;
	private JRadioButtonMenuItem addCoursesItem;
	private JRadioButtonMenuItem searchEnrollItem;
	private JRadioButtonMenuItem addEnrollItem;
	private JRadioButtonMenuItem addFacultyItem;
	private JRadioButtonMenuItem searchFacultyItem;
	private JRadioButtonMenuItem addDepartmentItem;
	private JRadioButtonMenuItem searchDepartmentItem;
	private JMenuItem gradeManagement;
	private JMenuItem generateReport;
	private JButton searchStudentButton;
	
	/*For student search*/
	private JPanel StudentSPanel = new JPanel(); //main panel for student info	
	private JPanel StudentBannerPanel; //panel for the banner
	private JPanel StudentSearchPanel; //panel for label text field and button
	private JPanel StudentSearchResultPanel;//panel for the search result
	private JLabel SearchBannerLabel; //Banner Label for search student
	private JLabel searchStudentIDLabel;
	private JTextField searchStudentIDField;
	private JPanel SearchIDLabel;
	private JPanel SearchTextField;
	private JPanel SearchButton;
	private JPanel searchBuffers; //for layout 
	private JLabel idResultLabel; //Labels and panels for the search results
	private JTextField idResult;
	private JPanel SearchResultID; //panel for ID label and JText field 
	private JPanel SResultIDTextPanel; //panel for the text id panel
	private JLabel nameResultLabel;
	private JTextField nameResult;
	private JPanel SearchResultName; // panel for name label and JText Field 
	private JPanel SResultNameTextPanel; //panel for the text name panel
	private JLabel addressResultLabel;
	private JTextField addressResult;
	private JPanel SearchResultAddress; // panel for the address label and JText Field 
	private JPanel SResultAddressTextPanel; //panel for the text address panel
	private JButton editStudentButton;
	private JPanel SearchEditPanel; // panel for the Edit button
	private JPanel SearchResultLabelPanel; //panel for the labels
	private JPanel SearchResultTextBoxPanel; //panel for the text field panel and edit button
	
	/*For Student add*/
	private JPanel StudentAPanel = new JPanel();
	private JPanel AddStudentPanel; //panel for adding students.
	private JPanel AddStudentLabels; //panel for the labels
	private JPanel AddStudentTextFields; //panel for the text fields 
	private JLabel AddFirstNameLabel;
	private JLabel AddAddressLabel;
	private JLabel AddLastNameLabel;
	private JLabel AddCityLabel;
	private JButton AddButton;
	private JTextField FirstNameField;
	private JLabel AddStateLabel;
	private JLabel AddZipLabel;
	private JTextField LastNameField;
	private JTextField AddressField;
	private JTextField CityField;
	private JTextField StateField;
	private JTextField ZipField;
	private JButton ClearButton;
	//private long counterAdd = 0;
	/*For Student Edit*/
	private JPanel StudentEPanel = new JPanel();
	private JLabel EditIDStudentLabel;
	private JPanel EditStudentPanel;
	private JPanel EditStudentLabels;
	private JPanel EditStudentTextFields;
	private JLabel EditFirstNameLabel;
	private JLabel EditAddressLabel;
	private JLabel EditLastNameLabel;
	private JLabel EditCityLabel;
	private JButton UpdateButton;
	private JTextField EFirstNameField;
	private JLabel EditStateLabel;
	private JLabel EditZipLabel;
	private JTextField EIDStudentField;
	private JTextField ELastNameField;
	private JTextField EAddressField;
	private JTextField ECityField;
	private JTextField EStateField;
	private JTextField EZipField;
	private JButton CancelEditButton;
	private int recordNumber;
	/*For Add Course */
	private JPanel CourseAPanel = new JPanel();
	private JPanel AddCoursesPanel; //panel for adding students. 
	private JPanel AddCoursesLabels; //panel for the labels
	private JPanel AddCoursesTextFields; //panel for the text fields 
	private JLabel AddCourseNameLabel;
	private JLabel AddInstructorLabel;
	//private JLabel AddCourseLocationLabel;
	private JLabel AddCourseYearLabel;
	private JLabel AddCourseQuarterLabel;
	private JButton AddCButton;
	private JTextField CourseNameField;
	private JComboBox CourseInstructor;
	private Object[] instructorNames;
	
	//private JComboBox CourseLocation;
	private JComboBox CourseYear;
	private JComboBox CourseQuarter;
	private JButton ClearCourseButton;
	private String selectedInstructor;
	private String selectedQuarter;
	//private long counterCourse = 0;
	/*For Search Course*/
	private JPanel CourseSPanel = new JPanel();
	private JPanel CourseSearchPanel;
	private JPanel CourseResultPanel;
	private JPanel CourseResultLabels;
	private JPanel CourseResultTextFields;
	private JLabel SearchCourseID;
	private JTextField SearchCourseIDField;
	private JButton SearchCourseButton;
	private JLabel CourseIDResult;
	private JLabel CourseNameResult;
	private JLabel CourseInstructorResult;
	private JLabel CourseQuarterResult;
	private JLabel CourseYearResult; 
	//private JLabel CourseLocationResult; // ***********
	private JTextField CourseIDResultField;
	private JTextField CourseNameResultField;
	private JTextField CourseInstructorResultField;
	private JTextField CourseQuarterResultField;
	private JTextField CourseYearResultField;
	//private JTextField CourseLocationResultField; //**********
	private JButton CourseEditButton;
	/*For Edit Course*/
	private JPanel CourseEPanel = new JPanel();
	private JPanel EditCoursePanel;
	private JPanel EditCourseLabels;
	private JPanel EditCourseTextFields;
	private JLabel EditIDCourseLabel;
	private JLabel EditInstructorNameLabel;
	private JLabel EditCourseNameLabel;
	private JLabel EditCourseYearLabel;
	private JLabel EditCourseQuarterLabel;
	private JButton UpdateCButton;
	private JTextField EIDCourseField;
	private JTextField ECourseNameField;
	private JComboBox ECourseInstructor;
	private JComboBox ECourseYear;
	private JComboBox ECourseQuarter;
	private JButton ECancelCourseButton;
	private String selectedEInstructor;
	private String selectedEYear;
	private String selectedEQuarter;
	/*For Add Enrollment*/
	private JPanel AddEnrollPanel = new JPanel();
	private JPanel AddEnrollSearchPanel;
	private JLabel AddEnrollStudentIDLabel;
	private JTextField AddEnrollIDTextField;
	private JPanel AddEnrollResultPanel; 
	private JPanel AddEnrollResultButtonPanel;
	private JButton AddEnrollButton;
	private JLabel AddEnrollCourseIDLabel;
	private JTextField AddEnrollCourseIDTextField;

	private String[] courseYear = {"2017","2018","2019","2020"};
	private String[] courseQuarter = {"Fall","Winter", "Spring","Summer"};
	private Object[] courseNames;
	private JButton AddEnrollCancelButton;
	private String selectedYear;

	/*For Search Enrollment*/
	private JPanel SearchEnrollPanel = new JPanel();
	private JPanel SearchEnrollIDPanel;
	private JLabel SearchEnrollIDLabel;
	private JTextField SearchEnrollIDField;
	private JButton SearchEnrollButton;
	private JPanel SearchEnrollResultPanel;
	private JPanel SearchEnrollButtonPanel;
	private JPanel SearchEnrollTablePanel;
	private JButton SearchEnrollDropButton;
	private JButton SearchEnrollCancelButton;

	private int removeCourseID;
	/*For Search Grade Management */
	private JPanel GradeManPanel = new JPanel();
	private JPanel GradeManSearchPanel;
	private JLabel GradeManStudentIDLabel;
	private JTextField GradeManStudentField;
	private JComboBox GradeManYearBox;
	private JComboBox GradeManQuarterBox;
	private JButton GradeManSearchButton;
	private JPanel GradeManSearchResultLabelPanel;
	private JLabel GradeManSearchResultLabel;
	private JPanel GradeManTextAreaPanel;
	private JPanel GradeManButtonPanel;
	private JButton GradeManEditButton;
	private JButton GradeManCancelButton;
	private String selectedManYear;
	private String selectedManQuarter;
	/*For Edit Grade Management */
	private JPanel GradeManEditPanel= new JPanel();
	private JPanel GradeManEditRowInfo;
	private JPanel GradeManEditButtons;
	private JLabel GradeManEnrollIDLabel;
	private JTextField GradeManEnrollIDField;
	private JLabel GradeManCourseIDLabel;
	private JTextField GradeManCourseIDField;
	private JLabel GradeManGradeLabel;
	private String[] Grades = {"A","B","C","D","F"};
	private JComboBox GradeManGradeBox;
	private JButton GradeManUpdateButton;
	private JButton GradeManCancelEditButton;
	private String selectedGrade;
	private int updateGradeSid;
	private int updateGrade;
	int count = 0;
	/*For Generate Report*/
	private JPanel GenReportPanel= new JPanel();
	private JPanel GenReportCoursesSearchPanel;
	private JPanel GenReportSearchResultPanel;
	private JComboBox GenReportCourseNameBox;
	private JComboBox GenReportYearBox;
	private JButton GenReportSearchButton;
	private JScrollPane scrollPane;
	private String selectYearGR;
	private String selectCourseGR;
	private Object[][] rowData;
	private Object[] columnNames;
	private JTable CoursesTable;
	private JTable EnrollmentTable;
	private JTable GradeTable;
	private JTable GradeListTable;
	private TableModel GradeListTableModel;
	private TableModel GradeTableModel;
	private TableModel CourseTableListModel;
	private TableModel EnrollmentTableModel;
	private int CourseIDint;
	/*For faculty */
	private JPanel FacultyViewPanel = new JPanel();
	private JPanel FacultyViewBorderPanel;
	private JTable FacultyTable;
	private TableModel FacultyTableModel;
	private JButton EditFacultyB;
	private JPanel FacultyEditPanel = new JPanel();
	private JPanel FacultyEditBoderPanel;
	private JPanel FacultyEditAddLabelsPanel;
	private JLabel FacultyEditNameLabel;
	private JLabel FacultyEditDepatmentLabel;
	private JButton FacultyEditAddButton;
	private JPanel FacultyEditAddTBPanel;
	private JTextField FacultyEditNameField;
	private JComboBox FacultyEditDepCB;
	private int facultyEdit;
	private JButton FacultyEditAddCancelButton;
	private JPanel FacultyAddPanel = new JPanel();
	private JPanel FacultyAddBorderPanel;
	private JPanel FacultyAddLabelsPanel;
	private JLabel FacultyNameLabel;
	private JLabel FacultyDepatmentLabel;
	private JButton FacultyAddButton;
	private JPanel FacultyAddTBPanel;
	private JTextField FacultyNameField;
	private JComboBox FacultyDepCB;
	private Object[] DepList;
	private JButton FacultyAddCancelButton;
	private String SelectedDep;
	/*For Department*/
	private JPanel DepartmentViewPanel = new JPanel();
	private JPanel DepartmentViewBorderPanel;
	private JTable DepartmentTable;
	private TableModel DepartmentTableModel;
	private JButton EditDepartmentB;
	private JPanel DepartmentEditPanel = new JPanel();
	private JPanel DepartmentEditBoderPanel;
	private JPanel DepartmentEditAddLabelsPanel;
	private JLabel DepartmentEditNameLabel;
	private JLabel DepartmentEditFacultyLabel;
	private JButton DepartmentEditAddButton;
	private JPanel DepartmentEditAddTBPanel;
	private JTextField DepartmentEditNameField;
	private JComboBox DepartmentEditDepCB;
	private int depEdit;
	private JButton DepartmentEditAddCancelButton;
	private JPanel DepartmentAddPanel = new JPanel();
	private JPanel DepartmentAddBorderPanel;
	private JPanel DepartmentAddLabelsPanel;
	private JLabel DepartmentNameLabel;
	private JLabel DepartmentFacultyLabel;
	private JButton DepartmentAddButton;
	private JPanel DepartmentAddTBPanel;
	private JTextField DepartmentNameField;
	private JComboBox DepartmentFacultyCB;
//	private Object[] DepList;
	private JButton DepartmentAddCancelButton;
	private String SelectedFaculty;
	//constructor
	public StudentInfoSystemFinal(){
	//set title bar text.
		setTitle("Student Information System");
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		messageLabel = new JLabel("Welcome, use the menu bar to use the Student Information System.", SwingConstants.CENTER);
		messageLabel.setPreferredSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));
		messageLabel.setForeground(Color.BLACK);
		messageLabel.setFont(new Font("SansSerif",Font.BOLD,18));
		welcomePanel = new JPanel();
		welcomePanel.add(messageLabel);
		add(welcomePanel);
		try{
			db = new StudentInfoSysDB();
		} catch (SQLException e){
			e.printStackTrace();
		}
		buildMenuBar();
	//pack and display the window.
		pack();
		setVisible(true);	
	}
	//This builds the menu bar 
	private void buildMenuBar(){
		menuBar = new JMenuBar(); //create the menu bar
	//create the File, Student Info, Courses, Enrollment, Grades, and Report Menus.
		buildFileMenu();
		buildStudentInfoMenu();
		buildCoursesMenu();
		buildFacultyMenu();
		buildDepartmentMenu();
		buildEnrollmentMenu();
		buildGradesMenu();
		buildReportMenu();
	//add the File, Student Info, Courses, Enrollment, Grades, and Report Menus to the menu bar.
		menuBar.add(fileMenu);
		menuBar.add(studentInfoMenu);
		menuBar.add(coursesMenu);
		menuBar.add(enrollmentMenu);
		menuBar.add(facultyMenu);
		menuBar.add(departmentMenu);
		menuBar.add(gradesMenu);
		menuBar.add(reportMenu);
	//set the window's menu bar.
		setJMenuBar(menuBar);
	}
	/*
	 The buildFileMenu method builds the File menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildFileMenu(){
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.addActionListener(new ExitListener());
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		fileMenu.add(exitItem);
	}
	/*
	 The buildStudentInfoMenu method builds the Student Information menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildStudentInfoMenu(){
		searchStudentItem = new JRadioButtonMenuItem("Search", true);
		//searchStudentItem.setMnemonic(KeyEvent.VK_S);
		searchStudentItem.addActionListener(new StudentInfo());
		
		addStudentItem = new JRadioButtonMenuItem("Add");
		//addStudentItem.setMnemonic(KeyEvent.VK_A);
		addStudentItem.addActionListener(new StudentInfo());
		//create a button group 
		ButtonGroup studentGroup = new ButtonGroup();
		studentGroup.add(searchStudentItem);
		studentGroup.add(addStudentItem);
		//Create a JMenu object for the Student Information menu
		studentInfoMenu = new JMenu("Student Information");
		studentInfoMenu.setMnemonic(KeyEvent.VK_S);
		//add the menu items to the Student Information Menu.
		studentInfoMenu.add(searchStudentItem);
		studentInfoMenu.add(addStudentItem);
		
	}	

	/*
	 The buildStudentInfoMenu method builds the Courses menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildCoursesMenu(){
		searchCoursesItem = new JRadioButtonMenuItem("Search", true);
		//searchCoursesItem.setMnemonic(KeyEvent.VK_S);
		searchCoursesItem.addActionListener(new CoursesListener());
		
		addCoursesItem = new JRadioButtonMenuItem("Add");
		//addCoursesItem.setMnemonic(KeyEvent.VK_A);
		addCoursesItem.addActionListener(new CoursesListener());
		//create a button group 
		ButtonGroup coursesGroup = new ButtonGroup();
		coursesGroup.add(searchCoursesItem);
		coursesGroup.add(addCoursesItem);
		//Create a JMenu object for the Courses menu
		coursesMenu = new JMenu("Courses");
		coursesMenu.setMnemonic(KeyEvent.VK_C);
		//add the menu items to the Courses Menu.
		coursesMenu.add(searchCoursesItem);
		coursesMenu.add(addCoursesItem);
	}
	
	/*
	 The buildStudentInfoMenu method builds the Enrollment menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildEnrollmentMenu(){
		searchEnrollItem = new JRadioButtonMenuItem("Search", true);
		//searchEnrollItem.setMnemonic(KeyEvent.VK_S);
		searchEnrollItem.addActionListener(new EnrollmentListener());
		
		addEnrollItem = new JRadioButtonMenuItem("Add");
		//addEnrollItem.setMnemonic(KeyEvent.VK_A);
		addEnrollItem.addActionListener(new EnrollmentListener());
		//create a button group
		ButtonGroup enrollGroup = new ButtonGroup();
		enrollGroup.add(searchEnrollItem);
		enrollGroup.add(addEnrollItem);
		//Create a JMenu object for the Enrollment menu
		enrollmentMenu = new JMenu("Enrollment");
		enrollmentMenu.setMnemonic(KeyEvent.VK_N);
		//add the menu items to the Enrollment Menu.
		enrollmentMenu.add(searchEnrollItem);
		enrollmentMenu.add(addEnrollItem);
	}	
	private void buildFacultyMenu(){
		searchFacultyItem = new JRadioButtonMenuItem("View", true);
		//searchCoursesItem.setMnemonic(KeyEvent.VK_S);
		searchFacultyItem.addActionListener(new FacultyListener());
		
		addFacultyItem = new JRadioButtonMenuItem("Add");
		//addCoursesItem.setMnemonic(KeyEvent.VK_A);
		addFacultyItem.addActionListener(new FacultyListener());
		//create a button group 
		ButtonGroup facultyGroup = new ButtonGroup();
		facultyGroup.add(searchFacultyItem);
		facultyGroup.add(addFacultyItem);
		//Create a JMenu object for the Courses menu
		facultyMenu = new JMenu("Faculty");
		//facultyMenu.setMnemonic(KeyEvent.VK_C);
		//add the menu items to the Courses Menu.
		facultyMenu.add(searchFacultyItem);
		facultyMenu.add(addFacultyItem);
	}
	private void buildDepartmentMenu(){
		searchDepartmentItem = new JRadioButtonMenuItem("View", true);
		//searchCoursesItem.setMnemonic(KeyEvent.VK_S);
		searchDepartmentItem.addActionListener(new DepartmentListener());
		
		addDepartmentItem = new JRadioButtonMenuItem("Add");
		//addCoursesItem.setMnemonic(KeyEvent.VK_A);
		addDepartmentItem.addActionListener(new DepartmentListener());
		//create a button group 
		ButtonGroup DepartmentGroup = new ButtonGroup();
		DepartmentGroup.add(searchDepartmentItem);
		DepartmentGroup.add(addDepartmentItem);
		//Create a JMenu object for the Courses menu
		departmentMenu = new JMenu("Department");
		//facultyMenu.setMnemonic(KeyEvent.VK_C);
		//add the menu items to the Courses Menu.
		departmentMenu.add(searchDepartmentItem);
		departmentMenu.add(addDepartmentItem);
	}
	
	/*
	 The buildStudentInfoMenu method builds the Grades menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildGradesMenu(){
		gradeManagement = new JMenuItem("Grade Management");
		//gradeManagement.setMnemonic(KeyEvent.VK_M);
		gradeManagement.addActionListener(new GradeListener());
		//Create a JMenu object for the Grades menu
		gradesMenu = new JMenu("Grades");
		gradesMenu.setMnemonic(KeyEvent.VK_G);
		//add the menu items to the Grades Menu.
		gradesMenu.add(gradeManagement);
	}	
	/*
	 The buildStudentInfoMenu method builds the Report menu 
	 and returns a reference to is JMenu object.
	 */
	private void buildReportMenu(){
		//Create a JMenu object for the Grades menu
		generateReport = new JMenuItem("Generate Report");
		generateReport.addActionListener(new ReportListener());
		reportMenu = new JMenu("Report");
		reportMenu.setMnemonic(KeyEvent.VK_R);
		reportMenu.add(generateReport);
	}
	/*
	Private inner class that handles the event that is generated 
	when the user selects Exit from the file menu. 
	 */
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	/*
	Private inner class that handles the event that is generated 
	when the user selects Search or Add from the Student Info menu. 
	 */
	private class StudentInfo implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			DepartmentAddPanel.setVisible(false);
			DepartmentViewPanel.setVisible(false);
			if(searchStudentItem.isSelected()){
				StudentAPanel.setVisible(false);
				StudentSearchDisplay();	
			} else if (addStudentItem.isSelected()){
				StudentSPanel.setVisible(false);
				StudentAddDisplay();
			}
		}
	}

	/* 
	Private inner class that handles the display for Student Search result
	*/
	private void StudentSearchDisplay(){
		
		StudentSPanel = new JPanel();//main panel for student info
		StudentSPanel.setLayout(new GridLayout(2,1));
		SearchBannerLabel = new JLabel("Search for Student");
		StudentBannerPanel = new JPanel(); //panel for the banner
		StudentBannerPanel.add(SearchBannerLabel);
		StudentSearchPanel = new JPanel(new GridLayout(1,1)); //panel for search label, text field and button
		searchStudentIDLabel = new JLabel("Enter Student ID");
		searchStudentIDField = new JTextField(10);
		searchStudentButton = new JButton("Search");
		
		SearchIDLabel = new JPanel();
		SearchTextField = new JPanel();
		SearchButton = new JPanel();
		SearchIDLabel.add(searchStudentIDLabel);
		SearchTextField.add(searchStudentIDField);
		SearchButton.add(searchStudentButton);
		StudentSearchPanel.add(SearchIDLabel);
		StudentSearchPanel.add(SearchTextField);
		StudentSearchPanel.add(SearchButton);
		searchBuffers = new JPanel(new GridLayout(4,1)); //for search panel buffers	
		searchBuffers.add(StudentBannerPanel);
		searchBuffers.add(new JPanel());
		searchBuffers.add(StudentSearchPanel);
		searchBuffers.add(new JPanel());
		StudentSPanel.add(searchBuffers);
		StudentSearchResultPanel = new JPanel(new GridLayout(1,2));
		StudentSearchResultPanel.setBorder(BorderFactory.createTitledBorder("Search Result"));			
		//make StudentSearchResultPanel visible after pressing search.*****************************************************************
		StudentSearchResultPanel.setVisible(false);
		idResultLabel = new JLabel("ID");
		idResult = new JTextField(25);
		idResult.setEditable(false);
		// Set text after pressing search ***********************************
		
		SearchResultID = new JPanel(); // for label
		SearchResultID.add(idResultLabel);
		SResultIDTextPanel = new JPanel(); //for textbox
		SResultIDTextPanel.add(idResult);	
		
		nameResultLabel = new JLabel("Name");
		nameResult = new JTextField(25);
		nameResult.setEditable(false);
		// Set text after pressing search ***********************************
		
		SearchResultName = new JPanel(); //for label
		SearchResultName.add(nameResultLabel);
		SResultNameTextPanel = new JPanel(); //for text
		SResultNameTextPanel.add(nameResult);
		
		addressResultLabel = new JLabel("Address");
		addressResult = new JTextField(25);
		addressResult.setEditable(false);
		// Set text after pressing search ***********************************
	
		SearchResultAddress = new JPanel(); //for label
		SearchResultAddress.add(addressResultLabel);
		SResultAddressTextPanel = new JPanel(); //for text 
		SResultAddressTextPanel.add(addressResult);
		// GO TO EDIT SCREEN **************************************************
		editStudentButton = new JButton("Edit");
		
		SearchEditPanel = new JPanel();
		SearchEditPanel.add(editStudentButton);
		
		SearchResultLabelPanel = new JPanel(new GridLayout(4,1));
		SearchResultLabelPanel.add(SearchResultID);
		SearchResultLabelPanel.add(SearchResultName);
		SearchResultLabelPanel.add(SearchResultAddress);
		
		SearchResultTextBoxPanel = new JPanel(new GridLayout(4,1));
		SearchResultTextBoxPanel.add(SResultIDTextPanel);
		SearchResultTextBoxPanel.add(SResultNameTextPanel);
		SearchResultTextBoxPanel.add(SResultAddressTextPanel);
		SearchResultTextBoxPanel.add(SearchEditPanel);
		
		StudentSearchResultPanel.add(SearchResultLabelPanel);
		StudentSearchResultPanel.add(SearchResultTextBoxPanel);
	
		StudentSPanel.add(StudentSearchResultPanel);
		searchStudentButton.addActionListener(new SearchStudent());
		editStudentButton.addActionListener(new EditStudent());
		add(StudentSPanel);
	}
	private class SearchStudent implements ActionListener {
		public void actionPerformed(ActionEvent e){
		try {
				recordNumber = Integer.parseInt(searchStudentIDField.getText());
				//StudentInfoSysDB searchStudent = new StudentInfoSysDB();
				ResultSet studentRecord = db.getStudentRecordDB(recordNumber);
				idResult.setText(Integer.toString(recordNumber));
				nameResult.setText(studentRecord.getString("FirstName") + " " + studentRecord.getString("LastName"));
				addressResult.setText(studentRecord.getString("Address") + ", " +studentRecord.getString("City") + ", " + studentRecord.getString("State") + " " + studentRecord.getInt("Zip"));
				StudentSearchResultPanel.setVisible(true);
				
			} catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Error: Student ID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Student ID Not Found.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e3){
				e3.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class EditStudent implements ActionListener {
		public void actionPerformed(ActionEvent e1){
			StudentSPanel.setVisible(false);
			StudentEditDisplay();
		}
	}
	private void StudentEditDisplay(){
		StudentEPanel = new JPanel();//main panel for Student Edit 
		EditStudentPanel = new JPanel(new GridLayout(1,2)); 
		EditStudentPanel.setBorder(BorderFactory.createTitledBorder("Edit Student"));
		EditStudentLabels = new JPanel(new GridLayout(8,1));
		EditStudentTextFields = new JPanel(new GridLayout(8,1));
		EditIDStudentLabel = new JLabel("ID");
		EditStudentLabels.add(EditIDStudentLabel);
		EditFirstNameLabel = new JLabel("First Name");
		EditStudentLabels.add(EditFirstNameLabel);
		EditLastNameLabel = new JLabel("Last Name");
		EditStudentLabels.add(EditLastNameLabel);
		EditAddressLabel = new JLabel("Address");
		EditStudentLabels.add(EditAddressLabel);
		EditCityLabel = new JLabel("City");
		EditStudentLabels.add(EditCityLabel);
		EditStateLabel = new JLabel("State");
		EditStudentLabels.add(EditStateLabel);
		EditZipLabel = new JLabel("Zip Code");
		EditStudentLabels.add(EditZipLabel);
		UpdateButton = new JButton("Update");
		UpdateButton.addActionListener(new StudentEditButton());
		EditStudentLabels.add(UpdateButton);
		EIDStudentField = new JTextField(20);
		EIDStudentField.setEditable(false);
		EditStudentTextFields.add(EIDStudentField);
		EFirstNameField = new JTextField(20);
		EditStudentTextFields.add(EFirstNameField);
		ELastNameField = new JTextField(20);
		EditStudentTextFields.add(ELastNameField);
		EAddressField = new JTextField(20);
		EditStudentTextFields.add(EAddressField);
		ECityField = new JTextField(20);
		EditStudentTextFields.add(ECityField);
		EStateField = new JTextField(20);
		EditStudentTextFields.add(EStateField);
		EZipField = new JTextField(20);
		EditStudentTextFields.add(EZipField);
		CancelEditButton = new JButton("Cancel");
		CancelEditButton.addActionListener(new EditStudentCancelButton());

		try {
			//StudentInfoSysDB searchStudent = new StudentInfoSysDB();
			ResultSet studentRecord = db.getStudentRecordDB(recordNumber);
			EIDStudentField.setText(Integer.toString(recordNumber));
			EFirstNameField.setText(studentRecord.getString("FirstName"));
			ELastNameField.setText(studentRecord.getString("LastName"));
			EAddressField.setText(studentRecord.getString("Address"));
			ECityField.setText(studentRecord.getString("City"));
			EStateField.setText(studentRecord.getString("State"));
			EZipField.setText(Integer.toString(studentRecord.getInt("Zip")));

		} catch (NullPointerException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Student ID Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e3){
			e3.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
		}
				
		EditStudentTextFields.add(CancelEditButton);
		EditStudentPanel.add(EditStudentLabels);
		EditStudentPanel.add(EditStudentTextFields);
		StudentEPanel.add(EditStudentPanel);
		add(StudentEPanel);
	}
	private class StudentEditButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String FN, LN, A, C, S;
			int Z;
			try{
				if (EFirstNameField.getText().trim().isEmpty() || ELastNameField.getText().trim().isEmpty() 
						|| EAddressField.getText().trim().isEmpty()  || ECityField.getText().trim().isEmpty() 
						|| EStateField.getText().trim().isEmpty() || EZipField.getText().trim().isEmpty()){
					throw new Exception();
				} else {
					try{
						//StudentInfoSysDB editStudent = new StudentInfoSysDB();

						FN = EFirstNameField.getText();
						LN = ELastNameField.getText();
						A = EAddressField.getText();
						C = ECityField.getText();
						S = EStateField.getText();
						Z = Integer.parseInt(EZipField.getText());

						db.updateStudentToDB(recordNumber, FN, LN, A, C, S, Z);
						JOptionPane.showMessageDialog(null, "Student " + FN
									+ " " + LN + " was updated.\nTo see results reload the search.");
						StudentEPanel.setVisible(false);
						StudentSPanel.setVisible(true);
					} catch (SQLException e3){
						e3.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
					}
			
				}
				} catch (IllegalArgumentException error){
					JOptionPane.showMessageDialog(null, "Error: Enter the Zip Code in numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
				} catch(Exception error){
					JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
				} 
		}
	}
	/*Private class that handles showing the search results page when
	user does not want to edit a student file. */
	private class EditStudentCancelButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			StudentEPanel.setVisible(false);
			StudentSPanel.setVisible(true);
		}
	}
	
	private void StudentAddDisplay(){
		StudentAPanel = new JPanel();//main panel for student info
		AddStudentPanel = new JPanel(new GridLayout(1,2));
		AddStudentPanel.setBorder(BorderFactory.createTitledBorder("Add Student"));
		AddStudentLabels = new JPanel(new GridLayout(7,1));
		AddStudentTextFields = new JPanel(new GridLayout(7,1));
		AddFirstNameLabel = new JLabel("First Name");
		AddStudentLabels.add(AddFirstNameLabel);
		AddLastNameLabel = new JLabel("Last Name");
		AddStudentLabels.add(AddLastNameLabel);
		AddAddressLabel = new JLabel("Address");
		AddStudentLabels.add(AddAddressLabel);
		AddCityLabel = new JLabel("City");
		AddStudentLabels.add(AddCityLabel);
		AddStateLabel = new JLabel("State");
		AddStudentLabels.add(AddStateLabel);
		AddZipLabel = new JLabel("Zip Code");
		AddStudentLabels.add(AddZipLabel);
		AddButton = new JButton("Add");
		AddButton.addActionListener(new StudentAddButton());
		AddStudentLabels.add(AddButton);
		FirstNameField = new JTextField(20);
		AddStudentTextFields.add(FirstNameField);
		LastNameField = new JTextField(20);
		AddStudentTextFields.add(LastNameField);
		AddressField = new JTextField(20);
		AddStudentTextFields.add(AddressField);
		CityField = new JTextField(20);
		AddStudentTextFields.add(CityField);
		StateField = new JTextField(20);
		AddStudentTextFields.add(StateField);
		ZipField = new JTextField(20);
		AddStudentTextFields.add(ZipField);
		ClearButton = new JButton("Clear");
		ClearButton.addActionListener(new AddStudentClearButton());
		AddStudentTextFields.add(ClearButton);
		AddStudentPanel.add(AddStudentLabels);
		AddStudentPanel.add(AddStudentTextFields);
		StudentAPanel.add(AddStudentPanel);
		add(StudentAPanel);
	}
	private class StudentAddButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			//StudentPanel.setVisible(false);
			String FN, LN, A, C, S;
			int Z;
			try{
				if (FirstNameField.getText().trim().isEmpty() || LastNameField.getText().trim().isEmpty() 
						|| AddressField.getText().trim().isEmpty()  || CityField.getText().trim().isEmpty() 
						|| StateField.getText().trim().isEmpty() || ZipField.getText().trim().isEmpty()){
					throw new Exception();
				} else {
					try {
					FN = FirstNameField.getText();
					LN = LastNameField.getText();
					A = AddressField.getText();
					C = CityField.getText();
					S = StateField.getText();
					Z = Integer.parseInt(ZipField.getText());
					//StudentInfoSysDB addStudent = new StudentInfoSysDB();
					db.addStudentToDB(FN, LN, A, C, S, Z);
					ResultSet studentRecord = db.getStudentRecordDB(FN, LN, Z);					
					JOptionPane.showMessageDialog(null, "Student ID: "  + studentRecord.getInt("ID") + 
							"\nName: " + FN + " " + LN + 
							"\nAddress: " + A + " " + C + ", " + S + " " + Z);
			
					} catch (SQLException e3){
						e3.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				} catch (IllegalArgumentException error){
					JOptionPane.showMessageDialog(null, "Error: Enter the Zip Code in numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
				} catch(Exception error){
					JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
				}
		}
	}
	private class AddStudentClearButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FirstNameField.setText("");
			LastNameField.setText("");
			AddressField.setText("");
			CityField.setText("");
			StateField.setText("");
			ZipField.setText("");
		}
	}
	
	private class CoursesListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			DepartmentAddPanel.setVisible(false);
			DepartmentViewPanel.setVisible(false);
			if (searchCoursesItem.isSelected()){
				CourseAPanel.setVisible(false);
				CoursesSeachDisplay();
			}else if (addCoursesItem.isSelected()){
				CourseSPanel.setVisible(false);
				CoursesAddDisplay();
			}
		}
	}
	private void CoursesAddDisplay() {
		CourseAPanel =  new JPanel(); // main panel for course add 
		AddCoursesPanel = new JPanel(new GridLayout(1,2));
		AddCoursesPanel.setBorder(BorderFactory.createTitledBorder("Add Course"));
		AddCoursesLabels = new JPanel(new GridLayout(5,1));
		AddCoursesTextFields = new JPanel(new GridLayout(5,1)); //******************************
		AddCourseNameLabel = new JLabel("Course Name");
		AddCoursesLabels.add(AddCourseNameLabel);
		AddInstructorLabel = new JLabel("Instructor Name");
		AddCoursesLabels.add(AddInstructorLabel);
		AddCourseQuarterLabel = new JLabel("Quarter");
		AddCoursesLabels.add(AddCourseQuarterLabel);
		AddCourseYearLabel = new JLabel("Year");
		AddCoursesLabels.add(AddCourseYearLabel);
		AddCButton = new JButton("Add");
		AddCButton.addActionListener(new CoursesAddButton());
		AddCoursesLabels.add(AddCButton);
		CourseNameField = new JTextField(20);
		AddCoursesTextFields.add(CourseNameField);
		try {
			//StudentInfoSysDB inNames = new StudentInfoSysDB();
			instructorNames = db.getFacultyNameList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not connecting");
		}
		
		CourseInstructor = new JComboBox(instructorNames);
		CourseInstructor.setSelectedIndex(-1);
		CourseInstructor.addActionListener(new InstructorComboBoxListener());
		AddCoursesTextFields.add(CourseInstructor);
		//private JComboBox CourseYear;
		//private JComboBox CourseQuarter;
		CourseQuarter = new JComboBox(courseQuarter);
		CourseQuarter.addActionListener(new QuarterComboBoxListener());
		CourseQuarter.setSelectedIndex(-1);
		AddCoursesTextFields.add(CourseQuarter);
		CourseYear = new JComboBox(courseYear);
		CourseYear.addActionListener(new YearComboBoxListener());
		CourseYear.setSelectedIndex(-1);
		AddCoursesTextFields.add(CourseYear);
		ClearCourseButton = new JButton("Clear");
		ClearCourseButton.addActionListener(new CoursesClearButton());
		AddCoursesTextFields.add(ClearCourseButton);
		AddCoursesPanel.add(AddCoursesLabels);
		AddCoursesPanel.add(AddCoursesTextFields);
		CourseAPanel.add(AddCoursesPanel);
		add(CourseAPanel);
		
	}
	private class InstructorComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedInstructor = (String) CourseInstructor.getSelectedItem();
			System.out.println(selectedInstructor);
		}
	}
	private class QuarterComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedQuarter = (String) CourseQuarter.getSelectedItem();
		}
	}
	private class YearComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			selectedYear = (String) CourseYear.getSelectedItem();
		}
	}
	private class CoursesClearButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			CourseNameField.setText("");
			CourseInstructor.setSelectedIndex(-1);
			CourseQuarter.setSelectedIndex(-1);
			CourseYear.setSelectedIndex(-1);
			
		}
	}
	private class CoursesAddButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String cn, in, q;
			int fid, y;
			try{
			if (CourseNameField.getText().trim().isEmpty() || CourseInstructor.getSelectedIndex() == -1 || CourseYear.getSelectedIndex() == -1|| CourseQuarter.getSelectedIndex() == -1){
				throw new Exception();
			} else {
				try {
				cn = CourseNameField.getText().trim();
				in = selectedInstructor;
				q = selectedQuarter;
				y = Integer.parseInt(selectedYear);

				//StudentInfoSysDB addCourse = new StudentInfoSysDB();
				ResultSet facultyRecord = db.getFacultyRecord(in);
				fid  = facultyRecord.getInt("FacultyID");
				db.addCourseToDB(cn, q, y, fid);
				ResultSet courseRecord = db.getCourseRecordDB(cn);
				JOptionPane.showMessageDialog(null, "CourseID " + courseRecord.getInt("CourseID") +    
							"\nCourse Name: "  + cn +
							"\nInstructor Name: " + in +
							"\nQuarter: " + q +
							"\nYear: " + y);
				} catch (SQLException e3){
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
	
			} catch(Exception error){
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private void CoursesSeachDisplay() {
		CourseSPanel = new JPanel(); // main panel for course search
		CourseSearchPanel = new JPanel();
		CourseSearchPanel.setBorder(BorderFactory.createTitledBorder("Search Courses"));
		CourseResultPanel = new JPanel(new GridLayout(1,2));
		CourseResultPanel.setBorder(BorderFactory.createTitledBorder("Search Result"));
		CourseResultPanel.setVisible(false);
		CourseResultLabels = new JPanel(new GridLayout(6,1));
		CourseResultTextFields = new JPanel(new GridLayout(6,1));

		SearchCourseID = new JLabel("Enter Course ID");
		SearchCourseIDField = new JTextField(10);
		SearchCourseButton = new JButton("Search");
		SearchCourseButton.addActionListener(new SearchCoursesButtonListener());
		CourseSearchPanel.add(SearchCourseID);
		CourseSearchPanel.add(SearchCourseIDField);
		CourseSearchPanel.add(SearchCourseButton);
		CourseIDResult = new JLabel("Course ID");
		CourseResultLabels.add(CourseIDResult);
		CourseNameResult = new JLabel("Course Name");
		CourseResultLabels.add(CourseNameResult);
		CourseInstructorResult = new JLabel("Instructor");
		CourseResultLabels.add(CourseInstructorResult);
		CourseQuarterResult = new JLabel("Quarter");
		CourseResultLabels.add(CourseQuarterResult);
		CourseYearResult =  new JLabel("Year");
		CourseResultLabels.add(CourseYearResult);
		
		CourseIDResultField = new JTextField(20);
		CourseIDResultField.setEditable(false);
		CourseResultTextFields.add(CourseIDResultField);
		
		CourseNameResultField = new JTextField(20);
		CourseNameResultField.setEditable(false);
		CourseResultTextFields.add(CourseNameResultField);
		
		CourseInstructorResultField = new JTextField(20);
		CourseInstructorResultField.setEditable(false);
		CourseResultTextFields.add(CourseInstructorResultField);
		
		CourseQuarterResultField = new JTextField(20);
		CourseQuarterResultField.setEditable(false);
		CourseResultTextFields.add(CourseQuarterResultField);
		
		CourseYearResultField = new JTextField(20);
		CourseYearResultField.setEditable(false);
	
		CourseResultTextFields.add(CourseYearResultField);
		CourseEditButton = new JButton("Edit");
		CourseEditButton.addActionListener(new EditCourseButtonListener());
		CourseResultTextFields.add(CourseEditButton);
		
		CourseResultPanel.add(CourseResultLabels);
		CourseResultPanel.add(CourseResultTextFields);
		CourseSPanel.add(CourseSearchPanel);
		CourseSPanel.add(CourseResultPanel);
		add(CourseSPanel);
		
	}

	private class SearchCoursesButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		try {
			recordNumber = Integer.parseInt(SearchCourseIDField.getText());
			//StudentInfoSysDB searchCourse = new StudentInfoSysDB();
			ResultSet courseRecord = db.getCourseRecordDB(recordNumber);
			
			int fid  = courseRecord.getInt("FacultyID");
			ResultSet facultyRecord = db.getFacultyRecord(fid);
			
			CourseIDResultField.setText(Integer.toString(recordNumber));
			CourseNameResultField.setText(courseRecord.getString("CourseName"));
			CourseInstructorResultField.setText(facultyRecord.getString("FacultyName"));
			CourseQuarterResultField.setText(courseRecord.getString("Quarter"));
			CourseYearResultField.setText(courseRecord.getString("Year"));
			CourseResultPanel.setVisible(true);
		} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Error: Course ID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Course ID Not Found.","Error" ,JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e3){
			e3.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
		}catch (Exception e4){
			JOptionPane.showMessageDialog(null, e4.getMessage(),"Error" ,JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	private class EditCourseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			CourseSPanel.setVisible(false);
			CoursesEditDisplay();
		}
	}
	private void CoursesEditDisplay() {
		/*	
		private JButton EClearCourseButton;
	    */
		CourseEPanel = new JPanel();//main panel for course edit
		EditCoursePanel = new JPanel(new GridLayout(1,2));
		EditCoursePanel.setBorder(BorderFactory.createTitledBorder("Edit Course"));
		EditCourseLabels = new JPanel(new GridLayout(6,1));
		EditCourseTextFields = new JPanel(new GridLayout(6,1));
		EditIDCourseLabel = new JLabel("Course ID");
		EditCourseLabels.add(EditIDCourseLabel);
		EditCourseNameLabel = new JLabel("Course Name");
		EditCourseLabels.add(EditCourseNameLabel);
		EditInstructorNameLabel = new JLabel("Instructor Name");
		EditCourseLabels.add(EditInstructorNameLabel);
		EditCourseQuarterLabel = new JLabel("Quarter");
		EditCourseLabels.add(EditCourseQuarterLabel);
		EditCourseYearLabel = new JLabel("Year");
		EditCourseLabels.add(EditCourseYearLabel);
		UpdateCButton = new JButton("Update");
		UpdateCButton.addActionListener(new UpdateCourseListener());
		EditCourseLabels.add(UpdateCButton);
	
		EIDCourseField = new JTextField(20);
		EIDCourseField.setEditable(false);
		
		EditCourseTextFields.add(EIDCourseField);
		ECourseNameField = new JTextField(20);
		
		EditCourseTextFields.add(ECourseNameField);
		try {
			//StudentInfoSysDB inNames = new StudentInfoSysDB();
			instructorNames = db.getFacultyNameList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not connecting");
		}
		ECourseInstructor = new JComboBox(instructorNames);
		
		ECourseInstructor.addActionListener(new InstructorEComboBoxListener());
		EditCourseTextFields.add(ECourseInstructor);
		ECourseQuarter = new JComboBox(courseQuarter);
		
		ECourseQuarter.addActionListener(new QuarterEComboBoxListener());
		EditCourseTextFields.add(ECourseQuarter);
		ECourseYear = new JComboBox(courseYear);
		
		ECourseYear.addActionListener(new YearEComboBoxListener());
		EditCourseTextFields.add(ECourseYear);
		
		
		ECancelCourseButton = new JButton("Cancel");
		ECancelCourseButton.addActionListener(new CancelCourseEditListener());
		EditCourseTextFields.add(ECancelCourseButton);
		EditCoursePanel.add(EditCourseLabels);
		EditCoursePanel.add(EditCourseTextFields);
		try {
				//StudentInfoSysDB editCourse = new StudentInfoSysDB();
				ResultSet courseRecord = db.getCourseRecordDB(recordNumber);
				int fid  = courseRecord.getInt("FacultyID");
				ResultSet facultyNames = db.getFacultyRecord(fid);
				EIDCourseField.setText(Integer.toString(recordNumber));
				ECourseNameField.setText(courseRecord.getString("CourseName"));
				ECourseInstructor.setSelectedItem(facultyNames.getString("FacultyName"));
				ECourseQuarter.setSelectedItem(courseRecord.getString("Quarter"));
				ECourseYear.setSelectedItem(courseRecord.getString("Year"));
	
		} catch (NullPointerException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Course ID Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e3){
				e3.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		CourseEPanel.add(EditCoursePanel);
		add(CourseEPanel);
		
	}
	private class InstructorEComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedEInstructor = (String) ECourseInstructor.getSelectedItem();
		}
	}
	private class QuarterEComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedEQuarter = (String) ECourseQuarter.getSelectedItem();
		}
	}
	private class YearEComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedEYear = (String) ECourseYear.getSelectedItem();
		}
	}
	private class UpdateCourseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String cn, in, q;
			int fid, y;
			try{
			if (ECourseNameField.getText().trim().isEmpty() || ECourseInstructor.getSelectedIndex() == -1 || ECourseYear.getSelectedIndex() == -1 || ECourseQuarter.getSelectedIndex() == -1){
				throw new Exception();
			} else {

				try {
					cn = ECourseNameField.getText().trim();
					in = selectedEInstructor;
					q = selectedEQuarter;
					y = Integer.parseInt(selectedEYear);
					
					//StudentInfoSysDB upCourse = new StudentInfoSysDB();
					ResultSet facultyRecord = db.getFacultyRecord(in);
					fid  = facultyRecord.getInt("FacultyID");
					db.updateCourseToDB(cn, q, y, fid, recordNumber);
					JOptionPane.showMessageDialog(null, "CourseID " + (recordNumber) + " was updated.\nTo see results reload the search.");
					CourseEPanel.setVisible(false);
					CourseSPanel.setVisible(true);
				} catch (SQLException e3){
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				}
	
			} catch (NullPointerException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Course ID Not Found.", "Error", JOptionPane.ERROR_MESSAGE);
			} catch(Exception error){
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class CancelCourseEditListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			CourseEPanel.setVisible(false);
			CourseSPanel.setVisible(true);
		}
	}
	private class EnrollmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			DepartmentAddPanel.setVisible(false);
			DepartmentViewPanel.setVisible(false);
			if (searchEnrollItem.isSelected()){
				AddEnrollPanel.setVisible(false);
				EnrollSearchDisplay();
			}else if (addEnrollItem.isSelected()){
				SearchEnrollPanel.setVisible(false);
				EnrollAddDisplay();
			}
		}
	}
	private void EnrollAddDisplay(){
		AddEnrollPanel = new JPanel(new GridLayout(3,1));
		AddEnrollSearchPanel = new JPanel(); 
		//AddEnrollSearchPanel.setBorder(BorderFactory.createTitledBorder("Classes Available to Enroll"));
		AddEnrollStudentIDLabel = new JLabel("Enter Student ID");
		AddEnrollIDTextField = new JTextField(10);
		AddEnrollSearchPanel.add(AddEnrollStudentIDLabel);
		AddEnrollSearchPanel.add(AddEnrollIDTextField);
		AddEnrollCourseIDLabel = new JLabel("Enter Course ID");
		AddEnrollCourseIDTextField = new JTextField(10);
		AddEnrollSearchPanel.add(AddEnrollCourseIDLabel);
		AddEnrollSearchPanel.add(AddEnrollCourseIDTextField);
		AddEnrollResultPanel = new JPanel(); 
		AddEnrollResultButtonPanel = new JPanel(); // new GridLayout(1,2)

		try {
			//StudentInfoSysDB coursesList = new StudentInfoSysDB();
			rowData = db.getCoursesList();
			columnNames = db.getCoursesColumns();
			CourseTableListModel = new DefaultTableModel(rowData, columnNames);
			CoursesTable = new JTable(CourseTableListModel);
			//CoursesTable.getSelectionModel().addListSelectionListener(new CourseSelctionIDListener());
			CoursesTable.setPreferredScrollableViewportSize(new Dimension(600,80));
			scrollPane = new JScrollPane(CoursesTable);
			AddEnrollResultPanel.add(scrollPane);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Error: No Courses in select Year and Quarter. Try Again.");
		}
	    
//		} catch (FileNotFoundException e1) {
//			JOptionPane.showMessageDialog(null, "Error: Courses.dat not found.","Error" ,JOptionPane.ERROR_MESSAGE);
//		} catch (NumberFormatException e2){
//			JOptionPane.showMessageDialog(null, "Error: Course ID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
//		} catch (IOException e3){
//			JOptionPane.showMessageDialog(null, "Error: Course ID Not Found.","Error" ,JOptionPane.ERROR_MESSAGE);
//		}
		
	    AddEnrollButton = new JButton("Enroll");
	  	AddEnrollButton.addActionListener(new AddEnrollButtonListener());
	    AddEnrollCancelButton = new JButton("Clear");
	    AddEnrollCancelButton.addActionListener(new AddEnrollCancelListener());
	    AddEnrollResultButtonPanel.add(AddEnrollButton);
	    AddEnrollResultButtonPanel.add(AddEnrollCancelButton);
	   
	 
		AddEnrollPanel.add(AddEnrollSearchPanel);
		AddEnrollPanel.add(AddEnrollResultPanel);
		AddEnrollPanel.add(AddEnrollResultButtonPanel);
		add(AddEnrollPanel);
	}
	
//	private class CourseSelctionIDListener implements ListSelectionListener{
//	public void valueChanged(ListSelectionEvent e){
//		//CourseID =  CourseTableListModel.getValueAt(e.getSource()., columnIndex)
//		System.out.println();
//		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
//		int firstIndex = e.getFirstIndex();
//        int lastIndex = e.getLastIndex();
//		System.out.println(firstIndex);
//		
//	}
//}
	private class AddEnrollButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int sid;
			int cid;
			
			try{
				if (AddEnrollIDTextField.getText().trim().isEmpty() || AddEnrollCourseIDTextField.getText().trim().isEmpty())
					throw new Exception();
				else {
					sid = Integer.parseInt(AddEnrollIDTextField.getText());
					cid = Integer.parseInt(AddEnrollCourseIDTextField.getText());
					try {
						//StudentInfoSysDB addEnroll = new StudentInfoSysDB();
						db.addEnrollmentToDB(sid, cid);
						ResultSet enrollRecord = db.getCourseRecordDB(cid);			
					JOptionPane.showMessageDialog(null, 
								"\nStudentID: " + sid  + "\tCourseID: " + cid + "\nEnrolled in: \nCourse: " + enrollRecord.getString("CourseName") +
								"\nYear: " + enrollRecord.getString("Year") + "\nQuarter: " + enrollRecord.getString("Quarter"));
					} catch(SQLException e2){
						JOptionPane.showMessageDialog(null, "Student is already enrolled. Try Again." ); //***************************CHECK IF STUDENT ID DOES NOT EXIST
						e2.printStackTrace();
					}
				}
			} catch(Exception error){
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.");
			}
		}
	}

	private class AddEnrollCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
		AddEnrollIDTextField.setText("");
		AddEnrollCourseIDTextField.setText("");
	}
}
	
	private void EnrollSearchDisplay(){
		SearchEnrollPanel = new JPanel();
		SearchEnrollIDPanel = new JPanel();
		SearchEnrollIDPanel.setBorder(BorderFactory.createTitledBorder("Search by Student ID"));
		SearchEnrollIDLabel = new JLabel("Enter Student ID");
		SearchEnrollIDField = new JTextField(10);
		SearchEnrollButton = new JButton("Search");
		SearchEnrollButton.addActionListener(new SearchEnrollButtonListener());
		SearchEnrollIDPanel.add(SearchEnrollIDLabel);
		SearchEnrollIDPanel.add(SearchEnrollIDField);
		SearchEnrollIDPanel.add(SearchEnrollButton);
		SearchEnrollResultPanel = new JPanel(new GridLayout(2,1));
		SearchEnrollResultPanel.setVisible(false);
		SearchEnrollTablePanel = new JPanel();
		SearchEnrollButtonPanel = new JPanel();
		//*************************************************************
		
		SearchEnrollDropButton = new JButton("Drop");
		SearchEnrollDropButton.addActionListener(new DropEnrollListener());
		SearchEnrollCancelButton = new JButton("Clear");
		SearchEnrollCancelButton.addActionListener(new SearchEnrollCancelListener());
		SearchEnrollButtonPanel.add(SearchEnrollDropButton);
		SearchEnrollButtonPanel.add(SearchEnrollCancelButton);
		SearchEnrollResultPanel.add(SearchEnrollTablePanel);
		SearchEnrollResultPanel.add(SearchEnrollButtonPanel);
		
		SearchEnrollPanel.add(SearchEnrollIDPanel);
		SearchEnrollPanel.add(SearchEnrollResultPanel);
		add(SearchEnrollPanel);
	}
	
	private class SearchEnrollCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SearchEnrollIDField.setText("");
			
			SearchEnrollTablePanel.remove(scrollPane);
			SearchEnrollTablePanel.revalidate();
			SearchEnrollTablePanel.repaint();
			SearchEnrollResultPanel.setVisible(false);
		}
	}
	private class SearchEnrollButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				
				recordNumber = Integer.parseInt(SearchEnrollIDField.getText());
				//StudentInfoSysDB coursesList = new StudentInfoSysDB();
				rowData = db.getEnrollmentList(recordNumber);
				
				columnNames = db.getEnrollmentColumns(recordNumber);
				EnrollmentTableModel = new DefaultTableModel(rowData, columnNames);
				EnrollmentTable = new JTable(EnrollmentTableModel);
				//CoursesTable.getSelectionModel().addListSelectionListener(new CourseSelctionIDListener());
				EnrollmentTable.setPreferredScrollableViewportSize(new Dimension(600,80));
				scrollPane = new JScrollPane(EnrollmentTable);
				SearchEnrollTablePanel.add(scrollPane);
				SearchEnrollResultPanel.setVisible(true);
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error: Enrollment record not found. Try Again.","Error" ,JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Error: StudentID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (Exception e3){	
				JOptionPane.showMessageDialog(null,e3.getMessage() ,"Error" ,JOptionPane.ERROR_MESSAGE);
				SearchEnrollResultPanel.setVisible(false);
				SearchEnrollIDField.setText("");
			}
			
			
			
		}
	}
	private class DropEnrollListener implements ActionListener {
		public void actionPerformed (ActionEvent e){
			try {
				String remove;
				recordNumber = Integer.parseInt(SearchEnrollIDField.getText());
				//StudentInfoSysDB coursesList = new StudentInfoSysDB();
				remove = JOptionPane.showInputDialog(null, "Enter the course ID you want to drop:");
				removeCourseID = Integer.parseInt(remove);
				db.dropEnrollmentToDB(recordNumber, removeCourseID);
				JOptionPane.showMessageDialog(null, "EnrollID " + (removeCourseID ) + " was dropped.\nTo see results clear and reload the search.");
		
			} catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Error: EnrollID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: No enrollment record to drop. Try Again.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	private class GradeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			DepartmentAddPanel.setVisible(false);
			DepartmentViewPanel.setVisible(false);
			GradeManPanel = new JPanel();
			GradeManSearchPanel = new JPanel();
			GradeManSearchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
			GradeManStudentIDLabel = new JLabel("Input Student ID");
			GradeManStudentField = new JTextField(10);
			GradeManYearBox = new JComboBox(courseYear);
			GradeManYearBox.setSelectedIndex(-1);
			GradeManYearBox.addActionListener(new GradeManYearListener());
			GradeManQuarterBox = new JComboBox(courseQuarter);
			GradeManQuarterBox.setSelectedIndex(-1);
			GradeManQuarterBox.addActionListener(new GradeManQuarterListener());
			GradeManSearchButton = new JButton("Search");
			GradeManSearchButton.addActionListener(new GradeManSearchListener());
			GradeManSearchPanel.add(GradeManStudentIDLabel);
			GradeManSearchPanel.add(GradeManStudentField);
			GradeManSearchPanel.add(GradeManYearBox);
			GradeManSearchPanel.add(GradeManQuarterBox);
			GradeManSearchPanel.add(GradeManSearchButton);
			
			GradeManSearchResultLabelPanel = new JPanel();
			GradeManSearchResultLabel = new JLabel("Search Result (blank means no grade assigned)");
			GradeManSearchResultLabelPanel.add(GradeManSearchResultLabel);
			
			GradeManTextAreaPanel = new JPanel();			
			GradeManButtonPanel = new JPanel();
			GradeManEditButton = new JButton("Edit");
			GradeManEditButton.addActionListener(new GradeManEditListener());
			GradeManCancelButton = new JButton("Clear");
			GradeManCancelButton.addActionListener(new GradeManCancelListener());
			GradeManButtonPanel.add(GradeManEditButton);
			GradeManButtonPanel.add(GradeManCancelButton);
			
			GradeManSearchResultLabelPanel.setVisible(false);
			GradeManTextAreaPanel.setVisible(false);
			GradeManButtonPanel.setVisible(false);
			
			GradeManPanel.add(GradeManSearchPanel);
			GradeManPanel.add(GradeManSearchResultLabelPanel);
			GradeManPanel.add(GradeManTextAreaPanel);
			GradeManPanel.add(GradeManButtonPanel);
			add(GradeManPanel);
		}
	}
	private class GradeManYearListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			selectedManYear = (String) GradeManYearBox.getSelectedItem();
		}
	}
	private class GradeManQuarterListener implements ActionListener {
		public void actionPerformed(ActionEvent e ){
			selectedManQuarter = (String) GradeManQuarterBox.getSelectedItem();
		}
	}
	private class GradeManSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try{
				
				if (GradeManStudentField.getText().trim().isEmpty() || GradeManYearBox.getSelectedIndex() == -1 || GradeManQuarterBox.getSelectedIndex() == -1){
					throw new Exception("Error: Fill out all the fields.");
				}
				else {
					int studentID = Integer.parseInt(GradeManStudentField.getText());
				//	StudentInfoSysDB gradesList = new StudentInfoSysDB();
					rowData = db.getEnrollmentList(studentID,selectedManYear, selectedManQuarter);
					columnNames = db.getEnrollmentColumns(studentID,selectedManYear, selectedManQuarter);
					GradeTableModel = new DefaultTableModel(rowData, columnNames);
					GradeTable = new JTable(GradeTableModel);
					GradeTable.setPreferredScrollableViewportSize(new Dimension(600,80));
					scrollPane = new JScrollPane(GradeTable);
					GradeManTextAreaPanel.add(scrollPane);
				
					GradeManSearchResultLabelPanel.setVisible(true);
					GradeManTextAreaPanel.setVisible(true);
					GradeManButtonPanel.setVisible(true);
//				if(file.getNumberOfRecords() == 0 ){
//					throw new Exception("Enrollment file is empty.\nAdd enrollment data to continue. ");
//				} ______---------if StudentID is not real then throw an error? 
				}
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error: Student not enrolled in selected year and quarter.","Error" ,JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			} catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Error: StudentID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (Exception e3){
				JOptionPane.showMessageDialog(null, e3.getMessage() ,"Error" ,JOptionPane.ERROR_MESSAGE);		
			}
		}
	}
	private class GradeManEditListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try{
				String update = JOptionPane.showInputDialog(null, "Enter the CourseID you want to update the grade:");
				updateGrade = Integer.parseInt(update);
				updateGradeSid = Integer.parseInt(GradeManStudentField.getText());
				GradeManPanel.setVisible(false);
				GradeManEditPanel = new JPanel();
				GradeManEditRowInfo = new JPanel();
				GradeManEditButtons = new JPanel();
				GradeManEnrollIDLabel = new JLabel("Student ID");
				GradeManEnrollIDField = new JTextField(10);
				
				GradeManEnrollIDField.setText(Integer.toString(updateGradeSid));
				GradeManEnrollIDField.setEditable(false);
				GradeManCourseIDLabel = new JLabel("Course ID");
				GradeManCourseIDField = new JTextField(10);
				GradeManCourseIDField.setText(Integer.toString(updateGrade));
				GradeManCourseIDField.setEditable(false);
				GradeManGradeLabel = new JLabel("Choose Grade");
				GradeManGradeBox = new JComboBox(Grades);
				GradeManGradeBox.setSelectedIndex(-1);
				GradeManGradeBox.addActionListener(new GradeCBListener());
				GradeManEditRowInfo.add(GradeManEnrollIDLabel);
				GradeManEditRowInfo.add(GradeManEnrollIDField);
				GradeManEditRowInfo.add(GradeManCourseIDLabel);
				GradeManEditRowInfo.add(GradeManCourseIDField);
				GradeManEditRowInfo.add(GradeManGradeLabel);
				GradeManEditRowInfo.add(GradeManGradeBox);
				GradeManUpdateButton = new JButton("Update Grade");
				GradeManUpdateButton.addActionListener(new UpdateGradeListener());
				GradeManCancelEditButton = new JButton("Cancel");
				GradeManCancelEditButton.addActionListener(new CancelGradeManEditListener());
				GradeManEditButtons.add(GradeManUpdateButton);
				GradeManEditButtons.add(GradeManCancelEditButton);
				GradeManEditPanel.add(GradeManEditRowInfo);
				GradeManEditPanel.add(GradeManEditButtons);
				add(GradeManEditPanel);
				
			}catch (NumberFormatException e2){
				JOptionPane.showMessageDialog(null, "Error: EnrollID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
				
			
		}
	}
	private class UpdateGradeListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try{
				if (GradeManGradeBox.getSelectedIndex() == -1) {
					throw new Exception("Error: Select a grade. ");
				} else {
					//StudentInfoSysDB addgrades = new StudentInfoSysDB();
					db.addGradeToDB(updateGradeSid, updateGrade, selectedGrade);
					
				JOptionPane.showMessageDialog(null,"Grade Updated\nReload the search to see the results. ");
				GradeManEditPanel.setVisible(false);
				GradeManTextAreaPanel.remove(scrollPane);
				GradeManTextAreaPanel.revalidate();
				GradeManTextAreaPanel.repaint();
				GradeManPanel.setVisible(true);
				GradeManSearchResultLabelPanel.setVisible(false);
				GradeManTextAreaPanel.setVisible(false);
				GradeManButtonPanel.setVisible(false);
			}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Error: Grade not updated..","Error" ,JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}catch (IOException e3){
				JOptionPane.showMessageDialog(null, "Error: EnrollID Not Found.","Error" ,JOptionPane.ERROR_MESSAGE);
			}catch (Exception e3){
				JOptionPane.showMessageDialog(null, e3.getMessage() ,"Error" ,JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}
	private class GradeManCancelListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			GradeManSearchResultLabelPanel.setVisible(false);
			GradeManTextAreaPanel.setVisible(false);
			GradeManButtonPanel.setVisible(false);
			GradeManStudentField.setText("");
			GradeManTextAreaPanel.remove(scrollPane);
			GradeManTextAreaPanel.revalidate();
			GradeManTextAreaPanel.repaint();
		}
	}
	private class CancelGradeManEditListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			GradeManPanel.setVisible(true);
			GradeManEditPanel.setVisible(false);
			GradeManTextAreaPanel.remove(scrollPane);
			GradeManTextAreaPanel.revalidate();
			GradeManTextAreaPanel.repaint();
		}
	}
	private class GradeCBListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			selectedGrade = (String) GradeManGradeBox.getSelectedItem();
		}
	}
	private class ReportListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);

			GenReportPanel = new JPanel();
			GenReportCoursesSearchPanel = new JPanel();
			GenReportCoursesSearchPanel.setBorder(BorderFactory.createTitledBorder("Select Course and Year"));
			GenReportSearchResultPanel = new JPanel();

			try {
				//StudentInfoSysDB cNames = new StudentInfoSysDB();
				courseNames = db.getCourseNameList();
			} catch (Exception e3) {
				e3.printStackTrace();
				System.out.println("******");
			}
			GenReportCourseNameBox = new JComboBox(courseNames);
			GenReportCourseNameBox.addActionListener(new GenReportCourseCB());
			GenReportCourseNameBox.setSelectedIndex(-1);
			GenReportYearBox = new JComboBox(courseYear);
			GenReportYearBox.addActionListener(new GenReportYearCB());
			GenReportYearBox.setSelectedIndex(-1);
			GenReportSearchButton = new JButton("Search");
			GenReportSearchButton.addActionListener(new GenReportSearchListener());
			GenReportCoursesSearchPanel.add(GenReportSearchResultPanel);
			GenReportCoursesSearchPanel.add(GenReportCourseNameBox);
			GenReportCoursesSearchPanel.add(GenReportYearBox);
			GenReportCoursesSearchPanel.add(GenReportSearchButton);
			scrollPane = new JScrollPane();
			
			GenReportSearchResultPanel.setVisible(false);
			GenReportPanel.add(GenReportCoursesSearchPanel);
			GenReportPanel.add(GenReportSearchResultPanel);
			add(GenReportPanel);
		}
	}
	private class GenReportYearCB implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			selectYearGR = (String) GenReportYearBox.getSelectedItem();
		}
	}
	private class GenReportCourseCB implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			selectCourseGR = (String) GenReportCourseNameBox.getSelectedItem();
		}
	}
	private class GenReportSearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try {
				if ( GenReportCourseNameBox.getSelectedIndex() == -1 || GenReportYearBox.getSelectedIndex() == -1){
					throw new Exception("Error: Select all the fields.");
					}
				else {
					try {
						try {
							//StudentInfoSysDB courseId = new StudentInfoSysDB();
							ResultSet c = db.getCourseRecordDB(selectCourseGR);
							CourseIDint = c.getInt("CourseID");
						} catch (Exception e3) {
							e3.printStackTrace();
							System.out.println(e3.getMessage());
						}
						int y = Integer.parseInt(selectYearGR);
						//StudentInfoSysDB resultsList = new StudentInfoSysDB();
						rowData = db.getReportList(CourseIDint, y);
						columnNames = db.getReportColumns(CourseIDint, y);
						GradeListTableModel = new DefaultTableModel(rowData, columnNames);
						GradeListTable = new JTable(GradeListTableModel);
						GradeListTable.setPreferredScrollableViewportSize(new Dimension(600,200));
						scrollPane = new JScrollPane(GradeListTable);
						GenReportSearchResultPanel.add(scrollPane);
						GenReportSearchResultPanel.setVisible(true);
			
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					}
				}
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "Error: Enrollment.dat not found.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e2){
			JOptionPane.showMessageDialog(null, "Error: StudentID uses numbers.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (Exception e3){
			JOptionPane.showMessageDialog(null, e3.getMessage() ,"Error" ,JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	private class FacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			DepartmentAddPanel.setVisible(false);
			DepartmentViewPanel.setVisible(false);
			if (searchFacultyItem.isSelected()){
				FacultyAddPanel.setVisible(false);
				FacultyViewDisplay();
			} else if (addFacultyItem.isSelected()){
				FacultyViewPanel.setVisible(false);
				FacultyAddDisplay();
			}
		}
	}
	private void FacultyViewDisplay() {
		FacultyViewPanel = new JPanel();
		FacultyViewBorderPanel = new JPanel();
		FacultyViewBorderPanel.setBorder(BorderFactory.createTitledBorder("Faculty"));	
		EditFacultyB = new JButton("Edit");
		EditFacultyB.addActionListener(new EditFacultyListener());
		try {
			rowData = db.getFacultyList();
			columnNames = db.getFacultyColumns();
			FacultyTableModel = new DefaultTableModel(rowData, columnNames);
			FacultyTable = new JTable(FacultyTableModel);
			FacultyTable.setPreferredScrollableViewportSize(new Dimension(600,250));
			scrollPane = new JScrollPane(FacultyTable);
			FacultyViewBorderPanel.add(scrollPane);
			
			FacultyViewPanel.add(FacultyViewBorderPanel);
			FacultyViewPanel.add(EditFacultyB);
			FacultyViewPanel.setVisible(true);
			add(FacultyViewPanel);
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}

	private class EditFacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			try {
			String edit = JOptionPane.showInputDialog(null, "Enter the FacultyID you want to edit:");
			facultyEdit = Integer.parseInt(edit);
			FacultyViewPanel.setVisible(false);
			
			FacultyEditPanel = new JPanel();
			FacultyEditBoderPanel = new JPanel(new GridLayout(1,2));
			FacultyEditBoderPanel.setBorder(BorderFactory.createTitledBorder("Edit Faculty"));	
			FacultyEditAddLabelsPanel = new JPanel(new GridLayout(3,1));
			FacultyEditNameLabel = new JLabel("Faculty Name");
			FacultyEditDepatmentLabel = new JLabel("Department");
			FacultyEditAddButton = new JButton("Update");
			FacultyEditAddButton.addActionListener(new UpdateFacultyListener());
			FacultyEditAddLabelsPanel.add(FacultyEditNameLabel);
			FacultyEditAddLabelsPanel.add(FacultyEditDepatmentLabel);
			FacultyEditAddLabelsPanel.add(FacultyEditAddButton);
			FacultyEditAddTBPanel = new JPanel(new GridLayout(3,1));
			FacultyEditNameField = new JTextField(10);
			ResultSet test = db.getFacultyRecordWithDep(facultyEdit);
			//System.out.println(test.getString("FacultyID"));
			FacultyEditNameField.setText(test.getString("FacultyName"));
			//int did = Integer.parseInt(test.getString("DepartmentID"));
			//ResultSet depID = db.getDepartmentRecord(did);
			DepList = db.getDepartmentNameList();
			FacultyEditDepCB = new JComboBox(DepList);
			FacultyEditDepCB.setSelectedIndex(-1);
			FacultyEditDepCB.addActionListener(new DepEditComboBoxListener());
			FacultyEditAddCancelButton = new JButton("Cancel");
			FacultyEditAddCancelButton.addActionListener(new CancelEditFacultyListener());
			FacultyEditAddTBPanel.add(FacultyEditNameField);
			FacultyEditAddTBPanel.add(FacultyEditDepCB);
			FacultyEditAddTBPanel.add(FacultyEditAddCancelButton);
			
			FacultyEditBoderPanel.add(FacultyEditAddLabelsPanel);
			FacultyEditBoderPanel.add(FacultyEditAddTBPanel);
			FacultyEditPanel.add(FacultyEditBoderPanel);
			FacultyEditPanel.setVisible(true);
			add(FacultyEditPanel);
			} catch (SQLException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			}
			
		}
	}	
	
	private class UpdateFacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			try {
				if ( FacultyEditDepCB.getSelectedIndex() == -1|| FacultyEditNameField.getText().trim().isEmpty()){ //
					throw new Exception();
				} else {
					String fn = FacultyEditNameField.getText().trim();
					String ds = SelectedDep;
		
					ResultSet depRecord = db.getDepartmentRecord(ds);
					int did  = depRecord.getInt("DepartmentID");
					db.updateFacultyDB(facultyEdit, fn, did);
					//ResultSet recordID = db.getFacultyRecord(fn);
					JOptionPane.showMessageDialog(null, "Faculty ID: " + facultyEdit +    
								"\nName: "  + fn + "\nDepartment: " + ds +"\nUpdated.");
					FacultyViewPanel.revalidate();
					FacultyViewPanel.repaint();
					FacultyViewPanel.setVisible(true);
					FacultyEditPanel.setVisible(false);
				}
			} catch (SQLException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	private class DepEditComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			SelectedDep = (String) FacultyEditDepCB.getSelectedItem();
		}
	}
	private class CancelEditFacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			FacultyEditPanel.setVisible(false);
			FacultyViewPanel.setVisible(true);
		}
	}
	
	
	
	
	private void FacultyAddDisplay() {
		try {	
			FacultyAddPanel = new JPanel();
			FacultyAddBorderPanel = new JPanel(new GridLayout(1,2));
			FacultyAddBorderPanel.setBorder(BorderFactory.createTitledBorder("Add Faculty"));	
			FacultyAddLabelsPanel = new JPanel(new GridLayout(3,1));
			FacultyNameLabel = new JLabel("Faculty Name");
			FacultyDepatmentLabel = new JLabel("Department");
			FacultyAddButton = new JButton("Add");
			FacultyAddButton.addActionListener(new AddFacultyListener());
			FacultyAddLabelsPanel.add(FacultyNameLabel);
			FacultyAddLabelsPanel.add(FacultyDepatmentLabel);
			FacultyAddLabelsPanel.add(FacultyAddButton);
			FacultyAddTBPanel = new JPanel(new GridLayout(3,1));
			FacultyNameField = new JTextField(10);
			DepList = db.getDepartmentNameList();
			FacultyDepCB = new JComboBox(DepList);
			FacultyDepCB.setSelectedIndex(-1);
			FacultyDepCB.addActionListener(new DepComboBoxListener());
			FacultyAddCancelButton = new JButton("Cancel");
			FacultyAddCancelButton.addActionListener(new CancelAddFacultyListener());
			FacultyAddTBPanel.add(FacultyNameField);
			FacultyAddTBPanel.add(FacultyDepCB);
			FacultyAddTBPanel.add(FacultyAddCancelButton);
			
			FacultyAddBorderPanel.add(FacultyAddLabelsPanel);
			FacultyAddBorderPanel.add(FacultyAddTBPanel);
			FacultyAddPanel.add(FacultyAddBorderPanel);
			FacultyAddPanel.setVisible(true);
			add(FacultyAddPanel);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
}
	
	
	private class AddFacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			try {
				if ( FacultyDepCB.getSelectedIndex() == -1 || FacultyNameField.getText().trim().isEmpty()){
					throw new Exception();
				} else {
					String fn = FacultyNameField.getText().trim();
					String ds = SelectedDep;
		
					ResultSet depRecord = db.getDepartmentRecord(ds);
					int did  = depRecord.getInt("DepartmentID");
					db.addFacultyToDB(fn, did);
					ResultSet recordID = db.getFacultyRecord(fn);
					JOptionPane.showMessageDialog(null, "Faculty ID: " + recordID.getInt("FacultyID") +    
								"\nName: "  + fn + "\nDepartment: " + ds );
				}
			} catch (SQLException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	private class CancelAddFacultyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			FacultyDepCB.setSelectedIndex(-1);
			FacultyNameField.setText("");
		}
	}
	private class DepComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			SelectedDep = (String) FacultyDepCB.getSelectedItem();
		}
	}
	
	
	private class DepartmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			welcomePanel.setVisible(false);
			CourseAPanel.setVisible(false);
			CourseSPanel.setVisible(false);
			CourseEPanel.setVisible(false);
			AddEnrollPanel.setVisible(false);
			SearchEnrollPanel.setVisible(false);
			GradeManPanel.setVisible(false);
			GradeManEditPanel.setVisible(false);
			GenReportPanel.setVisible(false);
			StudentEPanel.setVisible(false);
			StudentAPanel.setVisible(false);
			StudentSPanel.setVisible(false);
			FacultyEditPanel.setVisible(false);
			FacultyAddPanel.setVisible(false);
			FacultyViewPanel.setVisible(false);
			DepartmentEditPanel.setVisible(false);
			if (searchDepartmentItem.isSelected()){
				DepartmentAddPanel.setVisible(false);
				DepartmentViewDisplay();
			} else if (addDepartmentItem.isSelected()){
				DepartmentViewPanel.setVisible(false);
				DepartmentAddDisplay();
			}
		}
	}
	
	
	private void DepartmentViewDisplay() {
		DepartmentViewPanel = new JPanel();
		DepartmentViewBorderPanel = new JPanel();
		DepartmentViewBorderPanel.setBorder(BorderFactory.createTitledBorder("Department"));	
		EditDepartmentB = new JButton("Edit");
		EditDepartmentB.addActionListener(new EditDepartmentListener());
		try {
			rowData = db.getDepartmentList();
			columnNames = db.getDepartmentColumns();
			DepartmentTableModel = new DefaultTableModel(rowData, columnNames);
			DepartmentTable = new JTable(DepartmentTableModel);
			DepartmentTable.setPreferredScrollableViewportSize(new Dimension(600,250));
			scrollPane = new JScrollPane(DepartmentTable);
			DepartmentViewBorderPanel.add(scrollPane);
			
			DepartmentViewPanel.add(DepartmentViewBorderPanel);
			DepartmentViewPanel.add(EditDepartmentB);
			DepartmentViewPanel.setVisible(true);
			add(DepartmentViewPanel);
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	
	private class EditDepartmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			try {
				String edit = JOptionPane.showInputDialog(null, "Enter the DepartmentID you want to edit:");
				depEdit = Integer.parseInt(edit);
				DepartmentViewPanel.setVisible(false);
				DepartmentEditPanel = new JPanel();
				DepartmentEditBoderPanel = new JPanel(new GridLayout(1,2));
				DepartmentEditBoderPanel.setBorder(BorderFactory.createTitledBorder("Edit Department"));	
				DepartmentEditAddLabelsPanel = new JPanel(new GridLayout(3,1));
				DepartmentEditNameLabel = new JLabel("Department Name");
				DepartmentEditFacultyLabel = new JLabel("Faculty");
				DepartmentEditAddButton = new JButton("Update");
				DepartmentEditAddButton.addActionListener(new UpdateDepartmentListener());
				DepartmentEditAddLabelsPanel.add(DepartmentEditNameLabel);
				DepartmentEditAddLabelsPanel.add(DepartmentEditFacultyLabel);
				DepartmentEditAddLabelsPanel.add(DepartmentEditAddButton);
				DepartmentEditAddTBPanel = new JPanel(new GridLayout(3,1));
				DepartmentEditNameField = new JTextField(25);
				ResultSet test = db.getDepartmentRecord(depEdit);
				DepartmentEditNameField.setText(test.getString("DeptName"));
				instructorNames = db.getFacultyNameList();
				DepartmentEditDepCB = new JComboBox(instructorNames);
				DepartmentEditDepCB.setSelectedIndex(-1);
				DepartmentEditDepCB.addActionListener(new FacultyEditComboBoxListener());
				DepartmentEditAddCancelButton = new JButton("Cancel");
				DepartmentEditAddCancelButton.addActionListener(new CancelEditDepartmentListener());
				DepartmentEditAddTBPanel.add(DepartmentEditNameField);
				DepartmentEditAddTBPanel.add(DepartmentEditDepCB);
				DepartmentEditAddTBPanel.add(DepartmentEditAddCancelButton);
				
				DepartmentEditBoderPanel.add(DepartmentEditAddLabelsPanel);
				DepartmentEditBoderPanel.add(DepartmentEditAddTBPanel);
				DepartmentEditPanel.add(DepartmentEditBoderPanel);
				DepartmentEditPanel.setVisible(true);
				add(DepartmentEditPanel);
			} catch (NullPointerException e1){
				JOptionPane.showMessageDialog(null, "Error: Department ID does not exist.","Error" ,JOptionPane.ERROR_MESSAGE);
				DepartmentEditPanel.setVisible(false);
				DepartmentViewPanel.setVisible(true);
			} catch (SQLException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Department ID does not exist.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			}
		}
		
	}
	
	
	
	private class FacultyEditComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SelectedFaculty = (String) DepartmentEditDepCB.getSelectedItem();
		}
	}
	
	private class UpdateDepartmentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if ( DepartmentEditDepCB.getSelectedIndex() == -1|| DepartmentEditNameField.getText().trim().isEmpty()){ //
					throw new Exception();
				} else {
					String fn = SelectedFaculty;
					String ds = DepartmentEditNameField.getText().trim();
		
					ResultSet faRecord = db.getFacultyRecord(fn);
					int fid  = faRecord.getInt("FacultyID");
					db.updateDepartmentDB(depEdit, ds, fid);
		
					JOptionPane.showMessageDialog(null, "Department ID: " + depEdit +    
								"\nName: "  + ds + "\nDepartment head: " + fn +"\nUpdated.");
//					DepartmentViewPanel.revalidate();
//					DepartmentViewPanel.repaint();
					DepartmentEditPanel.setVisible(false);
					DepartmentViewPanel.setVisible(true);
				}
			} catch (SQLException e1){
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
			} catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
			}
		}
	}

private class CancelEditDepartmentListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		DepartmentViewPanel.setVisible(true);
		DepartmentEditPanel.setVisible(false);
	}	
}
	
	
	
private void DepartmentAddDisplay() {
	try {	
		DepartmentAddPanel = new JPanel();
		DepartmentAddBorderPanel = new JPanel(new GridLayout(1,2));
		DepartmentAddBorderPanel.setBorder(BorderFactory.createTitledBorder("Add Department"));	
		DepartmentAddLabelsPanel = new JPanel(new GridLayout(3,1));
		DepartmentNameLabel = new JLabel("Department Name");
		DepartmentFacultyLabel = new JLabel("Department Head");
		DepartmentAddButton = new JButton("Add");
		DepartmentAddButton.addActionListener(new AddDepartmentListener());
		DepartmentAddLabelsPanel.add(DepartmentNameLabel);
		DepartmentAddLabelsPanel.add(DepartmentFacultyLabel);
		DepartmentAddLabelsPanel.add(DepartmentAddButton);
		DepartmentAddTBPanel = new JPanel(new GridLayout(3,1));
		DepartmentNameField = new JTextField(25);
		instructorNames = db.getFacultyNameList();
		DepartmentFacultyCB = new JComboBox(instructorNames);
		DepartmentFacultyCB.setSelectedIndex(-1);
		DepartmentFacultyCB.addActionListener(new DepFacultyCBListener());
		DepartmentAddCancelButton = new JButton("Clear");
		DepartmentAddCancelButton.addActionListener(new CancelAddDepartmentListener());
		DepartmentAddTBPanel.add(DepartmentNameField);
		DepartmentAddTBPanel.add(DepartmentFacultyCB);
		DepartmentAddTBPanel.add(DepartmentAddCancelButton);
		DepartmentAddBorderPanel.add(DepartmentAddLabelsPanel);
		DepartmentAddBorderPanel.add(DepartmentAddTBPanel);
		DepartmentAddPanel.add(DepartmentAddBorderPanel);
		DepartmentAddPanel.setVisible(true);
		add(DepartmentAddPanel);
		
	} catch (SQLException e1){
		e1.printStackTrace();
		JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
	} catch(Exception e2) {
		JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
	}
}
	
private class AddDepartmentListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	
		try {
			if ( DepartmentFacultyCB.getSelectedIndex() == -1|| DepartmentNameField.getText().trim().isEmpty()){ //
				throw new Exception();
			} else {
				String fn = SelectedFaculty;
				String ds = DepartmentNameField.getText().trim();
	
				ResultSet faRecord = db.getFacultyRecord(fn);
				int fid  = faRecord.getInt("FacultyID");
				db.addDepartmentDB(ds, fid);
				ResultSet depIdRecord = db.getDepartmentRecord(ds);
				JOptionPane.showMessageDialog(null, "Department ID: " + depIdRecord.getInt("DepartmentID") +    
							"\nName: "  + ds + "\nDepartment head: " + fn +"\nAdded.");

			}
		} catch (SQLException e1){
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: Cannot connect to database.","Error" ,JOptionPane.ERROR_MESSAGE);
		} catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Error: Fill out all the fields.","Error" ,JOptionPane.ERROR_MESSAGE);
		}
	}	
}
	
private class CancelAddDepartmentListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		DepartmentFacultyCB.setSelectedIndex(-1);
		DepartmentNameField.setText("");
	}	
}
private class DepFacultyCBListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		SelectedFaculty = (String) DepartmentFacultyCB.getSelectedItem();
	}	
}
	private class StudentInfoSysDB {
		public final String jdbcUrl = String.format("jdbc:mysql://104.154.42.92:3306/schoolDB");
		private final String user = "victor";
		private final String password = "*********";
		private Connection myCon;
		private Object[][] rowData;
	    private Object[] columnNames;
	    private Object[] listColumns;
	    
	    //constructor
	    public StudentInfoSysDB() throws SQLException {
			myCon = DriverManager.getConnection(jdbcUrl, user, password);
		}
	    @SuppressWarnings("unused")
		public Object[][] getStudentNamesList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from StudentTable");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
			 
			 myStmt.close();
			 return rowData;
		}
		@SuppressWarnings("unused")
		public Object[] getStudentColumns() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from StudentTable");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
		
			 myStmt.close();
			 return columnNames;
		}
		public void addStudentToDB(String fn, String ln, String ad, String c, String s, int zip ) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement addStm = myCon.createStatement();
			//execute SQL Query
			String sql = "INSERT INTO StudentTable (FirstName, LastName, Address, City, State, Zip)" + "VALUES ('" + fn +"', '" + ln +"', '" + ad + "', '" + c + "', '" + s + "', " + zip + ")";
			addStm.executeUpdate(sql);
			System.out.println("Insert Complete");
		
			 addStm.close();
		}
		public ResultSet getStudentRecordDB(int id) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM StudentTable WHERE ID=" + id;  
			ResultSet studentRecord = searchStm.executeQuery(sql);
			if (studentRecord.next())
				return studentRecord;
			else 
				return null;
		}
		public ResultSet getStudentRecordDB(String fn, String ln, int z)throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM StudentTable WHERE FirstName='" + fn + "' AND LastName='" + ln + "' AND Zip = " + z ;  
			ResultSet studentRecord = searchStm.executeQuery(sql);
			if (studentRecord.next())
				return studentRecord;
			else 
				return null;
		}
		public void updateStudentToDB(int id, String fn, String ln, String ad, String c, String s, int zip ) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "UPDATE StudentTable SET FirstName = '" +fn+"', LastName = '"+ln+"', Address = '" + ad +"', City = '" + c + "', State = '" + s + "', Zip = '" + zip + "' WHERE ID = " + id ;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			
			 upStm.close();
		}
		public Object[][] getCoursesList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT * from CoursesTable");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
			
			 myStmt.close();
			 return rowData;
		}
		public Object[] getCoursesColumns() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT * from CoursesTable");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
			 
			 myStmt.close();
			 return columnNames;
		}
		public void addCourseToDB(String cn, String q, int year, int fID) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement addStm = myCon.createStatement();
			//execute SQL Query
			String sql = "INSERT INTO CoursesTable(CourseName, Quarter, Year, FacultyID) VALUES ('" + cn +"', '" + q +"', '" + year + "', " +  fID + ")";
			addStm.executeUpdate(sql);
			System.out.println("Insert Complete");
			
			addStm.close();
		}
		public ResultSet getCourseRecordDB(int id) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM CoursesTable WHERE CourseID=" + id;  
			ResultSet courseRecord = searchStm.executeQuery(sql);
			if (courseRecord.next())
				return courseRecord;
			else 
				return null;
		}
		public ResultSet getCourseRecordDB(String cn) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM CoursesTable WHERE CourseName='" + cn + "'";  
			ResultSet courseRecord = searchStm.executeQuery(sql);
			if (courseRecord.next())
				return courseRecord;
			else 
				return null;
		}
		public void updateCourseToDB(String cn, String q, int year, int fID, int cID ) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "UPDATE CoursesTable SET CourseName = '" +cn+"', Quarter = '"+q+"', Year = '" + year+ "', FacultyID='"+ fID +"' WHERE CourseID = '" + cID + "'" ;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			 
			 upStm.close();
		}
		@SuppressWarnings("unused")
		public Object[] getCourseNameList(String y, String q) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CourseName FROM CoursesTable WHERE Year='" + y +"' AND Quarter='"+ q + "'");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			//ResultSetMetaData meta = myRs.getMetaData();
	
			//create String array for the row data. 
			 listColumns = new String[numRows];
			 //Store columns in the listColumns array
			 for ( int row = 0 ; row < numRows; row++){
				 	listColumns[row] = myRs.getString("CourseName");
				 	//go to the next row in result set
				 	myRs.next();
				 }
		
			 myStmt.close();
			 return listColumns;
		}
		public Object[] getCourseNameList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CourseName FROM CoursesTable");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			//ResultSetMetaData meta = myRs.getMetaData();
	
			//create String array for the row data. 
			 listColumns = new String[numRows];
			 //Store columns in the listColumns array
			 for ( int row = 0 ; row < numRows; row++){
				 	listColumns[row] = myRs.getString("CourseName");
				 	//go to the next row in result set
				 	myRs.next();
				 }
			 
			 
			 myStmt.close();
			 return listColumns;
		}
		public Object[][] getEnrollmentList(int sid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year " +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable " +
					"ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID =" + sid );
			if (!myRs.isBeforeFirst() ) {    
			   throw new SQLException();
			} 

			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
		
			 myStmt.close();
			 return rowData;
		}
		public Object[] getEnrollmentColumns(int sid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year " +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable" +
					" ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID = " + sid );
//			if (!myRs.isBeforeFirst() ) {    
//				   throw new SQLException();
//				} 
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
			 
			 myStmt.close();
			 return columnNames;
		}
		public Object[][] getEnrollmentList(int sid, String y, String q) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year, EnrollmentTable.Grade " +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable " +
					"ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID =" + sid + " AND CoursesTable.Year= " +y +" AND CoursesTable.Quarter = '" + q + "' ");
			if (!myRs.isBeforeFirst() ) {    
				   throw new SQLException();
				} 
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
			
			 myStmt.close();
			 return rowData;
		}
		public Object[] getEnrollmentColumns(int sid, String y, String q) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year, EnrollmentTable.Grade " +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable" +
					" ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID = " + sid + " AND CoursesTable.Year= " +y +" AND CoursesTable.Quarter = '" + q + "' ");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
			
			 myStmt.close();
			 return columnNames;
		}
		public void addEnrollmentToDB(int sID, int cID) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement addStm = myCon.createStatement();
			//execute SQL Query
			String sql = "INSERT INTO EnrollmentTable(StudentID, CourseID) VALUES (" +sID + ","+cID+")";
			addStm.executeUpdate(sql);
			System.out.println("Insert Complete");
		
			addStm.close();
		}
		@SuppressWarnings("unused")
		public ResultSet getEnrollmentRecordDB(int sid, int cid) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year, EnrollmentTable.Grade" +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable" +
					"ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID =" + sid + " AND CoursesTable.CourseID =" + cid; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public void dropEnrollmentToDB(int sid, int cid ) throws SQLException{
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "DELETE FROM EnrollmentTable WHERE StudentID =" + sid + " AND CourseID =" + cid;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			 
			 upStm.close();
		}
		@SuppressWarnings("unused")
		public Object[][] getGradeList(int sid, int year, String q) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year, EnrollmentTable.Grade" +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable" +
					"ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID =" + sid + " AND CoursesTable.Year =" +
					year + "AND CoursesTable.Quarter ="+ q );
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
			 
			 myStmt.close();
			 return rowData;
		}
		@SuppressWarnings("unused")
		public Object[] getGradeColumns(int sid, int year, String q) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT CoursesTable.CourseID, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year, EnrollmentTable.Grade" +
					"FROM StudentTable JOIN EnrollmentTable ON StudentTable.ID = EnrollmentTable.StudentID JOIN CoursesTable" +
					"ON EnrollmentTable.CourseID = CoursesTable.CourseID WHERE StudentTable.ID =" + sid + " AND CoursesTable.Year =" +
					year + "AND CoursesTable.Quarter ="+ q );

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
			
			 myStmt.close();
			 return columnNames;
		}
		public void addGradeToDB(int sid, int cid, String g) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "UPDATE EnrollmentTable SET StudentID = '" +sid+"', CourseID = '"+cid+"', Grade = '" + g+ "' WHERE StudentID = "+ sid +" AND CourseID = " + cid ;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			
			 upStm.close();
		}
		public void addFacultyToDB(String n, int did) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement addStm = myCon.createStatement();
			//execute SQL Query
			String sql = "INSERT INTO FacultyTable(FacultyName, DepartmentID) VALUES ('" +n+ "' , "+did+")";
			addStm.executeUpdate(sql);
			System.out.println("Insert Complete");
			
			addStm.close();
		}
		public void updateFacultyDB(int fid, String name,int did) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "UPDATE FacultyTable SET FacultyName = '" +name+"', DepartmentID = '"+did+"' WHERE FacultyID = " + fid ;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			
			upStm.close();
		}
		public ResultSet getFacultyRecord(int fid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName, CoursesTable.CourseName, CoursesTable.Quarter, CoursesTable.Year " +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID JOIN CoursesTable " +
					"ON FacultyTable.FacultyID = CoursesTable.FacultyID WHERE FacultyTable.FacultyID = " + fid ; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public ResultSet getFacultyRecord(String fname) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM FacultyTable WHERE FacultyName = '" + fname + "'"; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public ResultSet getFacultyRecordWithDep(int fid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName " +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID WHERE FacultyTable.FacultyID = " + fid ; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public Object[] getFacultyNameList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT FacultyName FROM FacultyTable ORDER BY FacultyName");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			//ResultSetMetaData meta = myRs.getMetaData();
	
			//create String array for the row data. 
			 listColumns = new String[numRows];
			 //Store columns in the listColumns array
			 for ( int row = 0 ; row < numRows; row++){
				 	listColumns[row] = myRs.getString("FacultyName");
				 	//go to the next row in result set
				 	myRs.next();
				 }
			 
			
			 myStmt.close();
			 return listColumns;
		}
		@SuppressWarnings("unused")
		public Object[][] getFacultyList(int fid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName, CoursesTable.CourseName, CoursesTable.Quarter,CoursesTable.Year" +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID JOIN CoursesTable" +
					"ON FacultyTable.FacultyID = CoursesTable.FacultyID WHERE FacultyTable.FacultyID = " + fid );
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
		
			 myStmt.close();
			 return rowData;
		}
		@SuppressWarnings("unused")
		public Object[] getFacultyColumns(int fid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName, CoursesTable.CourseName, CoursesTable.Quarter,CoursesTable.Year" +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID JOIN CoursesTable" +
					"ON FacultyTable.FacultyID = CoursesTable.FacultyID WHERE FacultyTable.FacultyID = " + fid );

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
	
			 myStmt.close();
			 return columnNames;
		}
		public Object[][] getFacultyList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName " +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID ");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
		
			 myStmt.close();
			 return rowData;
		}
		public Object[] getFacultyColumns() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT FacultyTable.FacultyID, FacultyTable.FacultyName, DepartmentTable.DepartmentID, DepartmentTable.DeptName " +
					"FROM FacultyTable JOIN DepartmentTable ON FacultyTable.DepartmentID = DepartmentTable.DepartmentID ");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
	
			 myStmt.close();
			 return columnNames;
		}
		public Object[][] getReportList(int id, int year) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT StudentTable.ID, StudentTable.FirstName, StudentTable.LastName, CoursesTable.Quarter, EnrollmentTable.Grade FROM CoursesTable JOIN EnrollmentTable ON CoursesTable.CourseID = EnrollmentTable.CourseID JOIN StudentTable ON EnrollmentTable.StudentID = StudentTable.ID WHERE CoursesTable.CourseID ="+ id +" AND CoursesTable.Year =" + year);
			if (!myRs.isBeforeFirst() ) {    
				   throw new SQLException("There are no students enrolled in this year. Select another class or year.");
				} 
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
	
			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
			
			 myStmt.close();
			 return rowData;
		}
		public Object[] getReportColumns(int id, int year) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT StudentTable.ID, StudentTable.FirstName, StudentTable.LastName, CoursesTable.Quarter, EnrollmentTable.Grade FROM CoursesTable JOIN EnrollmentTable ON CoursesTable.CourseID = EnrollmentTable.CourseID JOIN StudentTable ON EnrollmentTable.StudentID = StudentTable.ID WHERE CoursesTable.CourseID ="+ id +" AND CoursesTable.Year =" + year);

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }
		
			 myStmt.close();
			 return columnNames;
		}
		public Object[] getDepartmentNameList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT DeptName FROM DepartmentTable ORDER BY DeptName");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			//ResultSetMetaData meta = myRs.getMetaData();
	
			//create String array for the row data. 
			 listColumns = new String[numRows];
			 //Store columns in the listColumns array
			 for ( int row = 0 ; row < numRows; row++){
				 	listColumns[row] = myRs.getString("DeptName");
				 	//go to the next row in result set
				 	myRs.next();
				 }
			 
			
			 myStmt.close();
			 return listColumns;
		}
		public ResultSet getDepartmentRecord(String dname) throws SQLException {
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM DepartmentTable WHERE DeptName = '" + dname + "'"; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public ResultSet getDepartmentRecord(int id) throws SQLException {
			Statement searchStm = myCon.createStatement();
			String sql = "SELECT * FROM DepartmentTable WHERE DepartmentID = '" + id + "'"; 
			ResultSet enrollmentRecord = searchStm.executeQuery(sql);
			if (enrollmentRecord.next())
				return enrollmentRecord;
			else 
				return null;
		}
		public Object[][] getDepartmentList() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			//create statement 
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT DepartmentTable.DepartmentID, DepartmentTable.DeptName, FacultyTable.FacultyName AS 'Department Head' FROM DepartmentTable JOIN FacultyTable ON FacultyTable.FacultyID = DepartmentTable.HeadDepID; ");
			myRs.last(); //Move to last row
			int numRows = myRs.getRow(); // get row number 
			myRs.first();
			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();

			//create 2 String array for the row data. 
			 rowData = new String[numRows][meta.getColumnCount()];
			 //Store columns in the rowData array
			 for ( int row = 0 ; row < numRows; row++){
			 	for (int col = 0 ; col < meta.getColumnCount(); col++){
			 		rowData[row][col] = myRs.getString(col+1);
			 	}
			 	//go to the next row in result set
			 	myRs.next();
			 }
		
			 myStmt.close();
			 return rowData;
		}
		public Object[] getDepartmentColumns() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT DepartmentTable.DepartmentID, DepartmentTable.DeptName, FacultyTable.FacultyName AS 'Department Head' FROM DepartmentTable JOIN FacultyTable ON FacultyTable.FacultyID = DepartmentTable.HeadDepID; ");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }

			 myStmt.close();
			 return columnNames;
		}
		@SuppressWarnings("unused")
		public Object[] getFacultyListForDep() throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement myStmt = myCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//execute SQL Query
			ResultSet myRs = myStmt.executeQuery("SELECT DepartmentTable.DepartmentID, DepartmentTable.DeptName, FacultyTable.FacultyName AS 'Department Head' FROM DepartmentTable JOIN FacultyTable ON FacultyTable.FacultyID = DepartmentTable.HeadDepID; ");

			//get meta data for the object for the result set
			ResultSetMetaData meta = myRs.getMetaData();
			//Create array of strings for the column names
			 columnNames = new String[meta.getColumnCount()];
			 //Store column names in the columnNames array
			 for (int i = 0 ; i < meta.getColumnCount(); i++){
				 //get column name
				 columnNames[i] = meta.getColumnLabel(i+1);
			 }

			 myStmt.close();
			 return columnNames;
		}
		public void updateDepartmentDB(int did, String name,int hid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "UPDATE DepartmentTable SET DeptName = '" +name+"', HeadDepId = '"+ hid+"' WHERE DepartmentID = " + did ;

			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			
			upStm.close();
		}
		public void addDepartmentDB( String name,int hid) throws SQLException {
			//myCon = DriverManager.getConnection(jdbcUrl, user, password);
			Statement upStm = myCon.createStatement();
			//execute SQL Query
			String sql = "INSERT INTO DepartmentTable(DeptName, HeadDepId) VALUES ('" +name+ "' , "+hid+")";
			upStm.executeUpdate(sql);
			System.out.println("Update Complete");
			
			upStm.close();
		}
	}
	
	
	public static void main(String[] args){
		new StudentInfoSystemFinal();
	}
}
