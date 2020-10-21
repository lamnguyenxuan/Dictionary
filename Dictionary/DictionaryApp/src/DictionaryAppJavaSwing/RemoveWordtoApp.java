package DictionaryAppJavaSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class RemoveWordtoApp extends JFrame implements ActionListener {
    
    
    private final int height = 204;
    private final int width = 484;
    private JLabel jLabel1;  
    private JTextField jtxtRemoveWord;  
    private JButton jOKButton; 
    private JButton jCancelButton;
    
    
    
    Scanner sc = new Scanner(System.in);
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public RemoveWordtoApp() {
        removeWordFrame();
}
    public void removeWordFrame() {
        jLabel1 = new JLabel("Nhập vào từ muốn xóa: ");
        jtxtRemoveWord = new JTextField();
        jOKButton = new JButton("OK");
        jCancelButton = new JButton("Cancel");
        
        setTitle("Xóa từ");
        setSize(width, height);   
        getContentPane().setBackground(new Color(56, 113, 200));
        setLayout(null);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        jLabel1.setSize(150, 37);
        jLabel1.setLocation(7, 45);
        add(jLabel1);
        
        
        jtxtRemoveWord.setSize(316, 37);
        jtxtRemoveWord.setLocation(146, 45);
        jtxtRemoveWord.setBackground(new Color(153, 153, 255));
        add(jtxtRemoveWord);
        
  
        jOKButton.setBounds(311, 120, 69, 31);
        jOKButton.setBackground(new Color(153, 153, 255));
        add(jOKButton);
        jOKButton.setActionCommand("okRemove");
        jOKButton.addActionListener(this);
        
        jCancelButton.setBounds(390, 120, 69, 31);
        jCancelButton.setBackground(new Color(153, 153, 255));
        add(jCancelButton);
        jCancelButton.setActionCommand("cancelRemove");
        jCancelButton.addActionListener(this);
        
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String removeWord = jtxtRemoveWord.getText();
        if(("okRemove".equals(e.getActionCommand()))){
                if ( !DictionaryManagement.checkDigit(removeWord)) {
                JOptionPane.showMessageDialog(rootPane, "Không hợp lệ, vui lòng nhập lại!");
            } else {
                int position = DictionaryApplication.binarySearch(removeWord);
                if (position == -1) {           
                JOptionPane.showMessageDialog(rootPane, "Từ cần xóa không có trong từ điển!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa từ?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        Dictionary.words.remove(position);
                        dictionaryManagement.dictionaryExportToFile();  
                        JOptionPane.showMessageDialog(rootPane, "Xóa từ thành công");
                        jtxtRemoveWord.setText("");
                    }
                }
            }
        }
        if (("cancelRemove".equals(e.getActionCommand()))) {
            jtxtRemoveWord.setText("");
            dispose();
        }
    }    
}
