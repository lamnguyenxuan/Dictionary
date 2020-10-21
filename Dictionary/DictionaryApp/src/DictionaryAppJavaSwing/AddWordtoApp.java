package DictionaryAppJavaSwing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class AddWordtoApp extends JFrame implements ActionListener {
    
    
    private final int height = 204;
    private final int width = 484;
    private JLabel jLabel1; 
    private JLabel jLabel2; 
    private JTextField jtxtAddWord; 
    private JTextArea jtxtDefine; 
    private JButton jOKButton; 
    private JButton jCancelButton;
    
    
    
    Scanner sc = new Scanner(System.in);
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public AddWordtoApp() {
    addWordFrame();
}
    public void addWordFrame() {
        jLabel1 = new JLabel("Nhập vào từ cần thêm: ");
        jLabel2 = new JLabel("Nhập vào nghĩa của từ: ");
        jtxtAddWord = new JTextField();
        jtxtDefine = new JTextArea();
        jOKButton = new JButton("OK");
        jCancelButton = new JButton("Cancel");
        
        setTitle("Thêm từ");
        setSize(width, height);   
        getContentPane().setBackground(new Color(56, 113, 200));
        setLayout(null);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        jLabel1.setSize(150, 30);
        jLabel1.setLocation(7, 7);
        add(jLabel1);
        
        jLabel2.setSize(150, 30);
        jLabel2.setLocation(7, 62);
        add(jLabel2);
        
        jtxtAddWord.setSize(316, 30);
        jtxtAddWord.setLocation(146, 7);
        jtxtAddWord.setBackground(new Color(153, 153, 255));
        add(jtxtAddWord);
        
        jtxtDefine.setSize(315,55);
        jtxtDefine.setLocation(146,54);
        jtxtDefine.setBackground(new Color(153, 153, 255));
        add(jtxtDefine);
        
        jOKButton.setBounds(311, 120, 69, 31);
        jOKButton.setBackground(new Color(153, 153, 255));
        add(jOKButton);
        jOKButton.setActionCommand("okAdd");
        jOKButton.addActionListener(this);
        
        jCancelButton.setBounds(390, 120, 69, 31);
        jCancelButton.setBackground(new Color(153, 153, 255));
        add(jCancelButton);
        jCancelButton.setActionCommand("cancelAdd");
        jCancelButton.addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String newWord = jtxtAddWord.getText();
        String define = jtxtDefine.getText();
        if(("okAdd".equals(e.getActionCommand()))){
                if ( !DictionaryManagement.checkDigit(newWord) || define.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Không hợp lệ, vui lòng nhập lại!");
            } else {
                int position = DictionaryApplication.binarySearch(newWord);
                if (position != -1) {           
                JOptionPane.showMessageDialog(rootPane, "Từ cần thêm đã có trong từ điển!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn thêm từ?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        Dictionary.words.add(new Word(newWord, define));
                        dictionaryManagement.dictionaryExportToFile();           
                        JOptionPane.showMessageDialog(rootPane, "Thêm từ thành công");
                        jtxtAddWord.setText("");
                        jtxtDefine.setText("");
                    }
                }
            }
        }
        if (("cancelAdd".equals(e.getActionCommand()))) {
            
            jtxtAddWord.setText("");
            jtxtDefine.setText("");
            dispose();
        }
        
    }
}
