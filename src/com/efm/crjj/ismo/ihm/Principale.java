package com.efm.crjj.ismo.ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.efm.crjj.ismo.metier.IMetier;
import com.efm.crjj.ismo.metier.MetierEmploye;
import com.efm.crjj.ismo.model.Employe;

import Hibernate_util.DoubleValidate;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principale extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	IMetier<Employe> emp=new MetierEmploye();
	private JTable table;
	private String combo[]= {"Rh","Finance","Production "};
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(combo);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setTitle("Gestion des employes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1197, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Nouvel Employe", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(10, 21, 242, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom et prenom :");
		lblNewLabel.setBounds(10, 16, 222, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 41, 222, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Departement");
		lblNewLabel_1.setBounds(10, 72, 222, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 91, 222, 22);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(combo));
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Salaire : ");
		lblNewLabel_2.setBounds(10, 129, 222, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 154, 222, 20);
		textField_1.setDocument(new DoubleValidate());
		panel.add(textField_1);
		
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enregistrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\EFMProject-main\\EFMProject-main\\immage\\download.png"));
		btnNewButton.setBounds(10, 185, 222, 28);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Liste des employes", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 251, 616, 322);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 27, 576, 241);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] { 
			},
			new String[] {
				"Cod Emp", "Nom Prenom ", "Departement", "Salaire"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\EFMProject-main\\EFMProject-main\\immage\\delete.png"));
		btnNewButton_1.setBounds(414, 279, 177, 32);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Imprimer");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\EFMProject-main\\EFMProject-main\\immage\\imprimante (2).png"));
		btnNewButton_1_1.setBounds(229, 279, 164, 32);
		panel_1.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_2.setBounds(262, 35, 364, 147);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre des employes ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_3.setBounds(10, 25, 344, 44);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("0");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_3_1.setBounds(10, 80, 344, 44);
		panel_2.add(lblNewLabel_3_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nombre Employe par departement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(646, 124, 537, 387);
		contentPane.add(panel_3);
	}
}
