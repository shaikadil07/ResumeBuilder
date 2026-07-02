package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ResumeFormGUI extends JFrame {

    private JPanel contentPane;

    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;

    private JRadioButton rbMale;
    private JRadioButton rbFemale;

    private JComboBox<String> comboQualification;

    private JCheckBox cbJava;
    private JCheckBox cbPython;
    private JCheckBox cbSQL;

    private JTextArea txtObjective;

    private ButtonGroup bg;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ResumeFormGUI frame = new ResumeFormGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ResumeFormGUI() {

        setTitle("Resume Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 550);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 30, 100, 25);
        contentPane.add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 30, 200, 25);
        contentPane.add(txtName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(50, 70, 100, 25);
        contentPane.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(200, 70, 200, 25);
        contentPane.add(txtEmail);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(50, 110, 100, 25);
        contentPane.add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(200, 110, 200, 25);
        contentPane.add(txtPhone);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(50, 150, 100, 25);
        contentPane.add(lblGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 150, 80, 25);
        contentPane.add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(300, 150, 100, 25);
        contentPane.add(rbFemale);

        bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);

        JLabel lblQualification = new JLabel("Qualification");
        lblQualification.setBounds(50, 190, 100, 25);
        contentPane.add(lblQualification);

        comboQualification = new JComboBox<>();
        comboQualification.setModel(
                new DefaultComboBoxModel<>(
                        new String[] { "B.Tech", "MCA", "MBA" }));
        comboQualification.setBounds(200, 190, 150, 25);
        contentPane.add(comboQualification);

        JLabel lblSkills = new JLabel("Skills");
        lblSkills.setBounds(50, 230, 100, 25);
        contentPane.add(lblSkills);

        cbJava = new JCheckBox("Java");
        cbJava.setBounds(200, 230, 70, 25);
        contentPane.add(cbJava);

        cbPython = new JCheckBox("Python");
        cbPython.setBounds(280, 230, 80, 25);
        contentPane.add(cbPython);

        cbSQL = new JCheckBox("SQL");
        cbSQL.setBounds(370, 230, 70, 25);
        contentPane.add(cbSQL);

        JLabel lblObjective = new JLabel("Career Objective");
        lblObjective.setBounds(50, 280, 120, 25);
        contentPane.add(lblObjective);

        txtObjective = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(txtObjective);
        scrollPane.setBounds(200, 280, 300, 100);
        contentPane.add(scrollPane);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(250, 420, 120, 35);
        contentPane.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();

                String gender = "";

                if (rbMale.isSelected())
                    gender = "Male";
                else if (rbFemale.isSelected())
                    gender = "Female";

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

                JOptionPane.showMessageDialog(
                        ResumeFormGUI.this,
                        "Name : " + name +
                        "\nEmail : " + email +
                        "\nPhone : " + phone +
                        "\nGender : " + gender +
                        "\nQualification : " + qualification +
                        "\nSkills : " + skills +
                        "\nCareer Objective : " + objective,
                        "Resume Details",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}