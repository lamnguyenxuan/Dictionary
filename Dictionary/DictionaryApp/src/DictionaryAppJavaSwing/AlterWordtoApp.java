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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class AlterWordtoApp extends JFrame implements ActionListener {
    
    
    private final int height = 251;
    private final int width = 484;
    private JLabel jLabel1; 
    private JLabel jLabel2; 
    private JLabel jLabel3;
    private JTextField jtxtInput, jtxtAlterWord; 
    private JTextArea jtxtDefine; 
    private JButton jOKButton; 
    private JButton jCancelButton;
    
    
    
    Scanner sc = new Scanner(System.in);
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public AlterWordtoApp() {
    addWordFrame();
}
    public void addWordFrame() {
        jLabel1 = new JLabel("Nhập vào từ cần sửa: ");
        jLabel2 = new JLabel("Nhập vào từ thay thế: ");
        jLabel3 = new JLabel("Nhâp vào nghĩa thay thế:");
        jtxtInput = new JTextField();
        jtxtAlterWord = new JTextField();
        jtxtDefine = new JTextArea();
        jOKButton = new JButton("OK");
        jCancelButton = new JButton("Cancel");
        
        setTitle("Sửa từ");
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
        jLabel2.setLocation(7, 53);
        add(jLabel2);
        
        jLabel3.setSize(150, 30);
        jLabel3.setLocation(7, 112);
        add(jLabel3);
        
        jtxtInput.setSize(316, 30);
        jtxtInput.setLocation(146, 7);
        jtxtInput.setBackground(new Color(153, 153, 255));
        add(jtxtInput);
        
        jtxtAlterWord.setSize(316, 30);
        jtxtAlterWord.setLocation(146, 54);
        jtxtAlterWord.setBackground(new Color(153, 153, 255));
        add(jtxtAlterWord);

        jtxtDefine.setSize(315,55);
        jtxtDefine.setLocation(146,101);
        jtxtDefine.setBackground(new Color(153, 153, 255));
        add(jtxtDefine);
        
        jOKButton.setBounds(311, 167, 69, 31);
        jOKButton.setBackground(new Color(153, 153, 255));
        add(jOKButton);
        jOKButton.setActionCommand("okAlter");
        jOKButton.addActionListener(this);
        
        jCancelButton.setBounds(390, 167, 69, 31);
        jCancelButton.setBackground(new Color(153, 153, 255));
        add(jCancelButton);
        jCancelButton.setActionCommand("cancelAlter");
        jCancelButton.addActionListener(this);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String inPut = jtxtInput.getText();
        String alterWord = jtxtAlterWord.getText();
        String define = jtxtDefine.getText();
        if(("okAlter".equals(e.getActionCommand()))){
               // jtxtAddWord.jPortSearchKeyType(evt);
                if (!DictionaryManagement.checkDigit(inPut) || !DictionaryManagement.checkDigit(alterWord) || define.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Không hợp lệ, vui lòng nhập lại!");
            } else {
                int position = DictionaryApplication.binarySearch(inPut);
                if (position == -1) {           
                JOptionPane.showMessageDialog(rootPane, "Từ cần sửa không có trong từ điển!");
                } else {
                    int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn sửa từ?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        Dictionary.words.set(position, new Word(alterWord, define));
                        dictionaryManagement.dictionaryExportToFile();           
                        JOptionPane.showMessageDialog(rootPane, "Sửa từ thành công");
                        jtxtInput.setText("");
                        jtxtAlterWord.setText("");
                        jtxtDefine.setText("");
                    }
                }
            }
        }
        if (("cancelAlter".equals(e.getActionCommand()))) {
            jtxtInput.setText("");
            jtxtAlterWord.setText("");
            jtxtDefine.setText("");
            dispose();
        }
        
    }
}
