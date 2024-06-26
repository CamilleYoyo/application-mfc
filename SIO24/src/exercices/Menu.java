package exercices;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1125, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 128));
		panel.setBounds(10, 10, 1091, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Utilisateur\\OneDrive\\Documents\\VisualStudioCode\\MFC\\src\\img\\logomfc.png"));
		lblNewLabel.setBounds(546, 10, 506, 461);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 10, 479, 461);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Formations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PASSAGE A LA PAGE SUIVANTE
				Menu.super.dispose();
				Formation men = new Formation();
				men.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(255, 0, 128));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(71, 29, 316, 47);
		panel_1.add(btnNewButton);
		
		JButton btnStagiaires = new JButton("Stagiaires");
		btnStagiaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PASSAGE A LA PAGE SUIVANTE
				Menu.super.dispose();
				Stagiaire men = new Stagiaire();
				men.setVisible(true);
			}
		});
		btnStagiaires.setForeground(Color.BLACK);
		btnStagiaires.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStagiaires.setBackground(new Color(255, 0, 128));
		btnStagiaires.setBounds(71, 100, 316, 47);
		panel_1.add(btnStagiaires);
		
		JButton btnFormateurs = new JButton("Formateurs");
		btnFormateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.super.dispose();
				Formateur men = new Formateur();
				men.setVisible(true);
			}
		});
		btnFormateurs.setForeground(Color.BLACK);
		btnFormateurs.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFormateurs.setBackground(new Color(255, 0, 128));
		btnFormateurs.setBounds(71, 168, 316, 47);
		panel_1.add(btnFormateurs);
		
		JButton btnSessions = new JButton("Sessions");
		btnSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.super.dispose();
				Sessions men = new 	Sessions();
				men.setVisible(true);
			}
		});
		btnSessions.setForeground(Color.BLACK);
		btnSessions.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSessions.setBackground(new Color(255, 0, 128));
		btnSessions.setBounds(71, 244, 316, 47);
		panel_1.add(btnSessions);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.super.dispose();
				Login men = new Login();
				men.setVisible(true);
			}
		});
		btnFermer.setForeground(Color.BLACK);
		btnFermer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFermer.setBackground(new Color(255, 0, 0));
		btnFermer.setBounds(71, 404, 316, 47);
		panel_1.add(btnFermer);
	}
}
