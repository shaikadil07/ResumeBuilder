package test;

import javax.swing.*;
import java.awt.event.*;

public class ResumeForm extends JFrame implements ActionListener {

    JLabel lblName, lblEmail, lblPhone, lblGender,
           lblQualification, lblSkills, lblObjective;

    JTextField txtName, txtEmail, txtPhone;

    JRadioButton rbMale, rbFemale;
    ButtonGroup bg;

    JComboBox<String> comboQualification;

    JCheckBox cbJava, cbPython, cbSQL;

    JTextArea txtObjective;

    JButton btnSubmit;

    public ResumeForm() {

        setTitle("Resume Builder");
        setSize(700, 600);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        lblName = new JLabel("Name");
        lblName.setBounds(50, 30, 120, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 30, 200, 25);
        add(txtName);

        // Email
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 70, 120, 25);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(200, 70, 200, 25);
        add(txtEmail);

        // Phone
        lblPhone = new JLabel("Phone");
        lblPhone.setBounds(50, 110, 120, 25);
        add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(200, 110, 200, 25);
        add(txtPhone);

        // Gender
        lblGender = new JLabel("Gender");
        lblGender.setBounds(50, 150, 120, 25);
        add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 150, 80, 25);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(300, 150, 100, 25);

        bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        add(rbMale);
        add(rbFemale);

        // Qualification
        lblQualification = new JLabel("Qualification");
        lblQualification.setBounds(50, 190, 120, 25);
        add(lblQualification);

        String qualifications[] = {"B.Tech", "MCA", "MBA"};

        comboQualification = new JComboBox<>(qualifications);
        comboQualification.setBounds(200, 190, 200, 25);
        add(comboQualification);

        // Skills
        lblSkills = new JLabel("Skills");
        lblSkills.setBounds(50, 230, 120, 25);
        add(lblSkills);

        cbJava = new JCheckBox("Java");
        cbJava.setBounds(200, 230, 80, 25);

        cbPython = new JCheckBox("Python");
        cbPython.setBounds(290, 230, 80, 25);

        cbSQL = new JCheckBox("SQL");
        cbSQL.setBounds(380, 230, 80, 25);

        add(cbJava);
        add(cbPython);
        add(cbSQL);

        // Career Objective / Address
        lblObjective = new JLabel("Career Objective");
        lblObjective.setBounds(50, 280, 120, 25);
        add(lblObjective);

        txtObjective = new JTextArea();

        JScrollPane sp = new JScrollPane(txtObjective);
        sp.setBounds(200, 280, 300, 120);
        add(sp);

        // Submit Button
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(250, 430, 120, 35);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = txtName.getText();
        String email = txtEmail.getText();
        String phone = txtPhone.getText();

        String gender = "";

        if (rbMale.isSelected()) {
            gender = "Male";
        } else if (rbFemale.isSelected()) {
            gender = "Female";
        }

        String qualification =
                comboQualification.getSelectedItem().toString();

        String skills = "";

        if (cbJava.isSelected())
            skills += "Java ";

        if (cbPython.isSelected())
            skills += "Python ";

        if (cbSQL.isSelected())
            skills += "SQL ";

        String objective = txtObjective.getText();

        String result =
                "Name : " + name +
                "\nEmail : " + email +
                "\nPhone : " + phone +
                "\nGender : " + gender +
                "\nQualification : " + qualification +
                "\nSkills : " + skills +
                "\nCareer Objective : " + objective;

        JOptionPane.showMessageDialog(
                this,
                result,
                "Resume Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new ResumeForm();
    }
}