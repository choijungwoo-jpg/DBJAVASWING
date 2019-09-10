import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainForm extends JFrame {
	private JTable table;
	
	public MainForm() {
		
		setLocation(400, 200);
//		setLocationRelativeTo(null);   //JFrame �߰����� ����
		
		setSize(721, 566);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 170, 705, 358);
		panel.setBackground(new Color(0, 0, 153));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSelectMember = new JButton("Select Member");
		btnSelectMember.setFont(new Font("�ü�", Font.BOLD, 20));
		btnSelectMember.setBounds(447, 244, 210, 66);
		panel.add(btnSelectMember);
		
		table = new JTable();
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setColumnCount(4);
		dtm.addColumn("�ߵǳ�");
		dtm.addColumn("�ߵǳ�");
		dtm.addColumn("�ߵǳ�");
		dtm.addColumn("�ߵǳ�");
		dtm.addRow(new Object[] {"111","222","333","444"});
//		table.setModel(new DefaultTableModel(
//				new Object[][] {
//					{"1","2","3","4"},
//				},
//				new String[] {
//						"New column","New column", "New column", "New column" 
//				}
//			));
		table.setBounds(12, 10, 404, 189);
		panel.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 705, 173);
		panel_1.setBackground(new Color(51, 52, 204));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMainForm = new JLabel("Main Form");
		lblMainForm.setForeground(Color.WHITE);
		lblMainForm.setFont(new Font("�ü�", Font.BOLD, 40));
		lblMainForm.setBounds(32, 43, 268, 84);
		panel_1.add(lblMainForm);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainForm();
	}
}
