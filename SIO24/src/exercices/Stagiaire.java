package exercices;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;



public class Stagiaire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stagiaire frame = new Stagiaire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/*Debut de code pour la base de donnee*/
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private JTextField textId;
    private JTextField textNom;
    private JTextField textPrenom;
    private JTextField textTel;
    private JTextField textMail;
    private JTextField textEntreprise;
    private JTextField textAdresse;
    
    
    /*CREATION DE LA CLASSE POUR CONNECTER A LA BASE DE DONNEE*/
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mfc", "root","");
            /*JOptionPane.showMessageDialog(null, "Connection reussie");*/
        }catch (Exception e) {
            e.printStackTrace();
            
        }
    }

	/**
	 * 
	 * Create the frame.
	 */
	public Stagiaire() {
		initComponents();
		
      
       
		
		
		
		
		
		
		
		
		
		
		setBackground(new Color(240, 240, 240));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1157, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(10, 10, 347, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stagiaires");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 46, 302, 36);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			private AbstractButton JTable1;


			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = con.prepareStatement("insert Stagiaires(IDS,NomS,PrenomS,TelS,MailS,EntrepriseS,AdresseS) values(?,?,?,?,?,?,?)");
			          pst.setString(1, textId.getText());
			          pst.setString(2, textNom.getText());
			          pst.setString(3, textPrenom.getText());
			          pst.setString(4, textTel.getText());
			          pst.setString(5, textMail.getText());
			          pst.setString(6, textEntreprise.getText());
			          pst.setString(7, textAdresse.getText());
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Le Stagiaire a bien été Ajouter");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
			
			
			
			
		});
		btnNewButton.setBackground(new Color(0, 255, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(39, 134, 257, 49);
		panel.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = (PreparedStatement) con.prepareStatement("update stagiaires set NomS=?,PrenomS=?,TelS=?,MailS=?,EntrepriseS=?, AdresseS=? where IdS=?");
			          pst.setString(7, textId.getText());
			          pst.setString(1, textNom.getText());
			          pst.setString(2, textPrenom.getText());
			          pst.setString(3, textTel.getText());
			          pst.setString(4, textMail.getText());
			          pst.setString(5, textEntreprise.getText());
			          pst.setString(6, textAdresse.getText());
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Le Stagiaire a bien été Modifier");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
			
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnModifier.setBackground(new Color(0, 128, 255));
		btnModifier.setBounds(39, 234, 257, 49);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			           Connect();
			           pst = (PreparedStatement) con.prepareStatement("delete from Stagiaires where IdS=?");
			           pst.setString(1, textId.getText());
			           pst.executeUpdate();
			           con.close();
			           JOptionPane.showMessageDialog(null, "Le Stagiaire a bient été supprimer");
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null, "Il y'a eu une erreur au niveu de : "+e1.getMessage());
			            e1.printStackTrace();
			            
			        }
				
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setBounds(39, 327, 257, 49);
		panel.add(btnSupprimer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PASSAGE A LA PAGE SUIVANTE
				Stagiaire.super.dispose();
				Menu men = new Menu();
				men.setVisible(true);
			}
		});
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnMenu.setBackground(new Color(255, 0, 128));
		btnMenu.setBounds(39, 484, 257, 49);
		panel.add(btnMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 128));
		panel_1.setBounds(367, 10, 766, 543);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textId.setText(model.getValueAt(i, 0).toString());
				textNom.setText(model.getValueAt(i, 1).toString());
				textPrenom.setText(model.getValueAt(i, 2).toString());
				textTel.setText(model.getValueAt(i, 3).toString());
				textMail.setText(model.getValueAt(i, 4).toString());
				textEntreprise.setText(model.getValueAt(i, 5).toString());
				textAdresse.setText(model.getValueAt(i, 6).toString());
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 321, 730, 201);
		panel_1.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Id : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 10, 122, 19);
		panel_1.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textId.setBounds(10, 39, 195, 31);
		panel_1.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nom");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(275, 15, 122, 14);
		panel_1.add(lblNewLabel_2);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNom.setBounds(275, 39, 195, 31);
		panel_1.add(textNom);
		textNom.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(545, 10, 151, 18);
		panel_1.add(lblNewLabel_3);
		
		textPrenom = new JTextField();
		textPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPrenom.setBounds(545, 39, 195, 31);
		panel_1.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Telephone");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 121, 195, 19);
		panel_1.add(lblNewLabel_4);
		
		textTel = new JTextField();
		textTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTel.setBounds(10, 161, 195, 31);
		panel_1.add(textTel);
		textTel.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Email");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(275, 121, 195, 19);
		panel_1.add(lblNewLabel_4_1);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		textMail.setColumns(10);
		textMail.setBounds(275, 161, 195, 31);
		panel_1.add(textMail);
		
		JLabel lblNewLabel_4_2 = new JLabel("Entreprise");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_2.setBounds(545, 121, 195, 19);
		panel_1.add(lblNewLabel_4_2);
		
		textEntreprise = new JTextField();
		textEntreprise.setFont(new Font("Tahoma", Font.BOLD, 14));
		textEntreprise.setColumns(10);
		textEntreprise.setBounds(545, 161, 195, 31);
		panel_1.add(textEntreprise);
		
		JLabel lblNewLabel_5 = new JLabel("Adresse");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(20, 218, 195, 19);
		panel_1.add(lblNewLabel_5);
		
		textAdresse = new JTextField();
		textAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdresse.setBounds(10, 247, 450, 31);
		panel_1.add(textAdresse);
		textAdresse.setColumns(10);
		Table();
	}

	 /*CREATION DU TABLEAU*/
	public void Table() {
	    // Définition des noms de colonnes
	    String[] stagiaires = {"IDS", "NOM-STAGIAIRE", "PRENOM-STAGIAIRE", "TELEPHONE", "EMAIL","ENTREPRISE","ADRESSE"};
	    String[] afficher = new String[7];
	    DefaultTableModel model = new DefaultTableModel(null, stagiaires);
	    try {
	        Connect();
	        Statement st = con.createStatement();
	        rs = st.executeQuery("select * from stagiaires");
	        
	        while (rs.next()) {
	            afficher[0] = rs.getString("IdS");
	            afficher[1] = rs.getString("NomS");
	            afficher[2] = rs.getString("PrenomS");
	            afficher[3] = rs.getString("TelS");
	            afficher[4] = rs.getString("MailS");
	            afficher[5] = rs.getString("EntrepriseS");
	            afficher[6] = rs.getString("AdresseS");
	            model.addRow(afficher);
	        }
	        table.setModel(model);
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
