import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Gui1 extends JFrame {

	private JPanel contentPane;
	private JTextField fnameTF;
	private JTextField lnameTF;
	private JTextField dobTF;
	private JTextField textField;
	private JTextField fullnameTF;
	private JTextField dob2TF;
	private JLabel lblNblank;
	private JTextField priorityTF;
	private JLabel lblListEmpty;
	private JLabel lblfillfields;
	Node n = null; 
	int Priority=0;
	private JTextField fullname1TF;
	private JTextField dob1TF;
	private JTextField nopTF;
	private JTextField nop2TF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui1 frame = new Gui1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui1() {
		
		DLList dll = new DLList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 558, 333);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Patient Details", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(28, 41, 72, 16);
		panel.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(28, 69, 61, 16);
		panel.add(lblSurname);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(28, 97, 98, 16);
		panel.add(lblDateOfBirth);
		
		JLabel lblBriefSummary = new JLabel("Brief Summary:");
		lblBriefSummary.setBounds(28, 125, 98, 16);
		panel.add(lblBriefSummary);
		
		fnameTF = new JTextField();
		fnameTF.setBounds(155, 36, 130, 26);
		panel.add(fnameTF);
		fnameTF.setColumns(10);
		
		lnameTF = new JTextField();
		lnameTF.setBounds(155, 64, 130, 26);
		panel.add(lnameTF);
		lnameTF.setColumns(10);
		
		dobTF = new JTextField();
		dobTF.setBounds(155, 92, 130, 26);
		panel.add(dobTF);
		dobTF.setColumns(10);
		
		
		
		JTextArea briefsumTF = new JTextArea();
		briefsumTF.setLineWrap(true);
		briefsumTF.setBounds(155, 125, 209, 64);
		panel.add(briefsumTF);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fnameTF.getText().equals("") || lnameTF.getText().equals("") || dobTF.getText().equals("") || briefsumTF.getText().equals("")){
					lblfillfields.setText("Field(s) Blank");

				}else{
				Patient p = new Patient();
				p.setFname(fnameTF.getText());
				p.setLname(lnameTF.getText());
				p.setDob(dobTF.getText());
				p.setBrief_Sum(briefsumTF.getText());
				
				p.save();
				dll.add(p);
				
				fnameTF.setText("");
				lnameTF.setText("");
				dobTF.setText("");
				briefsumTF.setText("");
				lblListEmpty.setText("");
				lblfillfields.setText("");
				lblNblank.setText("");
				nopTF.setText(String.valueOf(dll.getSize()));
				nop2TF.setText(String.valueOf(dll.getSize()));

				}
				
			}
		});
		btnAdd.setBounds(155, 208, 117, 29);
		panel.add(btnAdd);
		
		lblfillfields = new JLabel("");
		lblfillfields.setForeground(new Color(255, 0, 0));
		lblfillfields.setBounds(308, 213, 105, 16);
		panel.add(lblfillfields);
		
		JLabel lblNoOfPatients = new JLabel("No. of Patients");
		lblNoOfPatients.setBounds(425, 213, 106, 16);
		panel.add(lblNoOfPatients);
		
		nopTF = new JTextField("0");
		nopTF.setEditable(false);
		nopTF.setHorizontalAlignment(SwingConstants.CENTER);
		nopTF.setBounds(445, 241, 48, 26);
		panel.add(nopTF);
		nopTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Nurse Review", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setBounds(52, 190, 61, 16);
		panel_1.add(lblPriority);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(52, 18, 51, 16);
		panel_1.add(lblName);
		
		fullnameTF = new JTextField();
		fullnameTF.setEditable(false);
		fullnameTF.setBounds(115, 13, 129, 26);
		panel_1.add(fullnameTF);
		fullnameTF.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB:");
		lblDob.setBounds(291, 18, 41, 16);
		panel_1.add(lblDob);
		
		dob2TF = new JTextField();
		dob2TF.setEditable(false);
		dob2TF.setBounds(340, 13, 117, 26);
		panel_1.add(dob2TF);
		dob2TF.setColumns(10);
		
		JLabel lblBriefSummary_1 = new JLabel("Brief Summary:");
		lblBriefSummary_1.setBounds(52, 46, 100, 16);
		panel_1.add(lblBriefSummary_1);
		
		JTextArea bf_sumTF = new JTextArea();
		bf_sumTF.setLineWrap(true);
		bf_sumTF.setEditable(false);
		bf_sumTF.setBounds(52, 63, 405, 40);
		panel_1.add(bf_sumTF);
		
		priorityTF = new JTextField();
		priorityTF.setBounds(108, 185, 44, 26);
		panel_1.add(priorityTF);
		priorityTF.setColumns(10);
		
		JLabel lblCondition = new JLabel("Vital Signs:");
		lblCondition.setBounds(52, 115, 100, 16);
		panel_1.add(lblCondition);
		
		JTextArea vsignsTF = new JTextArea();
		vsignsTF.setLineWrap(true);
		vsignsTF.setBounds(52, 132, 405, 40);
		panel_1.add(vsignsTF);
		
		JButton btnNewButton = new JButton("Update Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fullnameTF.getText().equals("") || dob2TF.getText().equals("") || priorityTF.getText().equals("") || bf_sumTF.getText().equals("") || vsignsTF.getText().equals("")){
					lblNblank.setText("Field(s) Blank");
				}else if(Integer.valueOf(priorityTF.getText())<1||Integer.valueOf(priorityTF.getText())>10){
					lblNblank.setText("Invalid Priority");
				}
				else{
				n.getPatient().setPriority(priorityTF.getText().toString());
				n.getPatient().setVitalsigns(vsignsTF.getText().toString());
				n.getPatient().save();
				
				fullnameTF.setText("");
				dob2TF.setText("");
				priorityTF.setText("");
				bf_sumTF.setText("");
				vsignsTF.setText("");
				lblNblank.setText("");
				lblListEmpty.setText("");

				}
			}
		});
		btnNewButton.setBounds(171, 185, 117, 29);
		panel_1.add(btnNewButton);
		
		JButton btnNextPatient = new JButton("Next Patient");
		btnNextPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dll.getSize()==0){
					lblNblank.setText("List Empty!");
				}else{
				if(n==null||n.getNext()==null){
					n=dll.getNode(1);
				}
				else{
					n=n.getNext();

					
				}
				String fulname=n.getPatient().Fname.toString()+ " " + n.getPatient().Lname.toString();
				fullnameTF.setText(fulname);
				dob2TF.setText(n.getPatient().dob.toString());
				bf_sumTF.setText(n.getPatient().brief_sum.toString());
				vsignsTF.setText(n.getPatient().vitalsigns.toString());
				priorityTF.setText(n.getPatient().priority.toString());
			}
			}	
		});
		btnNextPatient.setBounds(278, 239, 117, 29);
		panel_1.add(btnNextPatient);
		
		JButton btnPreviousPatient = new JButton("Previous Patient");
		btnPreviousPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dll.getSize()==0){
					lblNblank.setText("List Empty!");
				}else{
				if(n==null||n.getPrevious()==null){
					n=dll.getNode(dll.getSize());
				}
				else{
					n=n.getPrevious();

					
				}
				String fulname=n.getPatient().Fname.toString()+ " " + n.getPatient().Lname.toString();
				fullnameTF.setText(fulname);
				dob2TF.setText(n.getPatient().dob.toString());
				bf_sumTF.setText(n.getPatient().brief_sum.toString());
				vsignsTF.setText(n.getPatient().vitalsigns.toString());
				priorityTF.setText(n.getPatient().priority.toString());

				}
			}
		});
		btnPreviousPatient.setBounds(92, 239, 128, 29);
		panel_1.add(btnPreviousPatient);
		
		lblNblank = new JLabel("");
		lblNblank.setForeground(new Color(255, 0, 0));
		lblNblank.setBounds(304, 190, 91, 16);
		panel_1.add(lblNblank);
		
		JLabel label = new JLabel("No. of Patients");
		label.setBounds(425, 190, 106, 16);
		panel_1.add(label);
		
		nop2TF = new JTextField("0");
		nop2TF.setEditable(false);
		nop2TF.setHorizontalAlignment(SwingConstants.CENTER);
		nop2TF.setColumns(10);
		nop2TF.setBounds(450, 218, 48, 26);
		panel_1.add(nop2TF);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Doctor Review", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(24, 30, 61, 16);
		panel_2.add(lblName_1);
		
		fullname1TF = new JTextField();
		fullname1TF.setEditable(false);
		fullname1TF.setBounds(74, 25, 142, 26);
		panel_2.add(fullname1TF);
		fullname1TF.setColumns(10);
		
		JLabel lblDob_1 = new JLabel("D.O.B:");
		lblDob_1.setBounds(286, 30, 50, 16);
		panel_2.add(lblDob_1);
		
		dob1TF = new JTextField();
		dob1TF.setEditable(false);
		dob1TF.setBounds(333, 25, 164, 26);
		panel_2.add(dob1TF);
		dob1TF.setColumns(10);
		
		JLabel lblBriefSummary_2 = new JLabel("Brief Summary:");
		lblBriefSummary_2.setBounds(24, 68, 100, 16);
		panel_2.add(lblBriefSummary_2);
		
		JTextArea bfsumTA = new JTextArea();
		bfsumTA.setLineWrap(true);
		bfsumTA.setEditable(false);
		bfsumTA.setBounds(24, 96, 187, 60);
		panel_2.add(bfsumTA);
		
		JLabel lblVitalSummary = new JLabel("Vital Signs:");
		lblVitalSummary.setBounds(286, 68, 108, 16);
		panel_2.add(lblVitalSummary);
		
		JTextArea vitalsumTA = new JTextArea();
		vitalsumTA.setLineWrap(true);
		vitalsumTA.setEditable(false);
		vitalsumTA.setBounds(286, 96, 211, 60);
		panel_2.add(vitalsumTA);
		
		JLabel lblHighestPriorityPatient = new JLabel("Treatment Summary:");
		lblHighestPriorityPatient.setBounds(24, 168, 135, 16);
		panel_2.add(lblHighestPriorityPatient);
		
		lblListEmpty = new JLabel("");
		lblListEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		lblListEmpty.setForeground(new Color(255, 0, 0));
		lblListEmpty.setBounds(196, 156, 108, 16);
		panel_2.add(lblListEmpty);
		
		JButton btnHighestPriorityPatient = new JButton("Next Patient");
		btnHighestPriorityPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
				n = dll.getHighestPriority();
				Patient p = n.getPatient();
				String fulname=p.Fname.toString()+ " " + p.Lname.toString();
				fullname1TF.setText(fulname);
				dob1TF.setText(p.dob.toString());
				bfsumTA.setText(p.brief_sum.toString());
				vitalsumTA.setText(p.vitalsigns.toString());
				}
				catch(NullPointerException npe){
					lblListEmpty.setText("Que empty!");
				}
			}
		});
		btnHighestPriorityPatient.setBounds(51, 249, 195, 29);
		panel_2.add(btnHighestPriorityPatient);
		
		JTextArea treatmentsumTA = new JTextArea();
		treatmentsumTA.setLineWrap(true);
		treatmentsumTA.setBounds(24, 188, 474, 49);
		panel_2.add(treatmentsumTA);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fullname1TF.getText().equals("")||dob1TF.getText().equals("")||bfsumTA.getText().equals("")||vitalsumTA.getText().equals("")||treatmentsumTA.getText().equals("")){
					lblListEmpty.setText("Field(s) Blank!");

				}else{
				n.getPatient().setDoc_sum(treatmentsumTA.getText().toString());
				n.getPatient().save();
				int pos= dll.getPosition(n);
				dll.remove(pos);
				
				
				fullname1TF.setText("");
				dob1TF.setText("");
				bfsumTA.setText("");
				vitalsumTA.setText("");
				treatmentsumTA.setText("");
				nopTF.setText(String.valueOf(dll.getSize()));
				nop2TF.setText(String.valueOf(dll.getSize()));


				}
			}
		});
		btnNewButton_1.setBounds(254, 249, 164, 29);
		panel_2.add(btnNewButton_1);
		
		
		
	}
}
