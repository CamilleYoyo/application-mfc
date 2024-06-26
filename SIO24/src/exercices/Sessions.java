package exercices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sessions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textIdSe;
	private JTextField textHoraire;
	private JTextField textDateDeb;
	private JTextField textDateFin;
	private JTextField textIdSa;

	
	
	
	
	
	
	
	/*Debut de code pour la base de donnee*/
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sessions frame = new Sessions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
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
	 * Create the frame.
	 */
	public Sessions() {
		initComponents();
		
		
		
		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1146, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 365, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session de Formation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 30, 345, 34);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = con.prepareStatement("insert sessionsdeformation(IdSE, HoraireSessions, DateDeb, DateFin, IdSalle) values(?,?,?,?,?)");
			          pst.setString(1, textIdSe.getText());
			          pst.setString(2, textHoraire.getText());
			          pst.setString(3, textDateDeb.getText());
			          pst.setString(4, textDateFin.getText());
			          pst.setString(5, textIdSa.getText());
			          
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Les Informations ont bien été Ajouter");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(23, 136, 293, 34);
		panel.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = con.prepareStatement("update sessionsdeformation set HoraireSessions=? ,DateDeb=? ,DateFin=? ,IdSalle=? where IdSE=? ");
			          pst.setString(5, textIdSe.getText());
			          pst.setString(1, textHoraire.getText());
			          pst.setString(2, textDateDeb.getText());
			          pst.setString(3, textDateFin.getText());
			          pst.setString(4, textIdSa.getText());
			          
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Les informations ont bien été Modifier");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
			
		});
		btnModifier.setBackground(new Color(128, 0, 255));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModifier.setBounds(23, 243, 293, 34);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			           Connect();
			           pst = (PreparedStatement) con.prepareStatement("delete from sessionsdeformation where IdSE=?");
			           pst.setString(1, textIdSe.getText());
			           pst.executeUpdate();
			           con.close();
			           JOptionPane.showMessageDialog(null, "Les Information on bien été supprimer");
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null, "Il y'a eu une erreur au niveu de : "+e1.getMessage());
			            e1.printStackTrace();
			            
			        }
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSupprimer.setBounds(23, 349, 293, 34);
		panel.add(btnSupprimer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PASSAGE A LA PAGE SUIVANTE
				Sessions.super.dispose();
				Menu men = new Menu();
				men.setVisible(true);
			}
		});
		btnMenu.setBackground(new Color(255, 0, 128));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMenu.setBounds(23, 584, 293, 34);
		panel.add(btnMenu);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textIdSe.setText(model.getValueAt(i, 0).toString());
				textHoraire.setText(model.getValueAt(i, 1).toString());
				textDateDeb.setText(model.getValueAt(i, 2).toString());
				textDateFin.setText(model.getValueAt(i, 3).toString());
				textIdSa.setText(model.getValueAt(i, 4).toString());
			}
		});
		table.setBounds(385, 322, 737, 331);
		contentPane.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Id-Session ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(385, 10, 159, 26);
		contentPane.add(lblNewLabel_1);
		
		textIdSe = new JTextField();
		textIdSe.setFont(new Font("Tahoma", Font.BOLD, 20));
		textIdSe.setBounds(385, 46, 197, 33);
		contentPane.add(textIdSe);
		textIdSe.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Horaire-Session");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(664, 10, 159, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textHoraire = new JTextField();
		textHoraire.setFont(new Font("Tahoma", Font.BOLD, 20));
		textHoraire.setColumns(10);
		textHoraire.setBounds(664, 46, 197, 33);
		contentPane.add(textHoraire);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date-Debut");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(450, 169, 207, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textDateDeb = new JTextField();
		textDateDeb.setHorizontalAlignment(SwingConstants.CENTER);
		textDateDeb.setFont(new Font("Tahoma", Font.BOLD, 20));
		textDateDeb.setColumns(10);
		textDateDeb.setBounds(450, 205, 263, 33);
		contentPane.add(textDateDeb);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date-Fin");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(787, 169, 227, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textDateFin = new JTextField();
		textDateFin.setHorizontalAlignment(SwingConstants.CENTER);
		textDateFin.setFont(new Font("Tahoma", Font.BOLD, 20));
		textDateFin.setColumns(10);
		textDateFin.setBounds(787, 205, 263, 33);
		contentPane.add(textDateFin);
		
		JLabel lblNewLabel_1_4 = new JLabel("Id-Salle");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(925, 10, 197, 26);
		contentPane.add(lblNewLabel_1_4);
		
		textIdSa = new JTextField();
		textIdSa.setFont(new Font("Tahoma", Font.BOLD, 20));
		textIdSa.setColumns(10);
		textIdSa.setBounds(925, 46, 197, 33);
		contentPane.add(textIdSa);
	}
	
	
	
	
	/*CREATION DU TABLEAU*/
	public void Table() {
	    // Définition des noms de colonnes
	    String[] sessionsdeformation = {"IDSE", "Horaire-Sessions", "DATE-DEBUT", "DAYE-FIN", "ID-SALLE"};
	    String[] afficher = new String[5];
	    DefaultTableModel model = new DefaultTableModel(null, sessionsdeformation);
	    try {
	        Connect();
	        Statement st = con.createStatement();
	        rs = st.executeQuery("select * from sessionsdeformation");
	        
	        while (rs.next()) {
	            afficher[0] = rs.getString("IdSE");
	            afficher[1] = rs.getString("HoraireSessions");
	            afficher[2] = rs.getString("DateDeb");
	            afficher[3] = rs.getString("DateFin");
	            afficher[4] = rs.getString("IdSalle");
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
