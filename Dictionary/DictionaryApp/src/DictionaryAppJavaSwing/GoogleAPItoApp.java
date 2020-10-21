package DictionaryAppJavaSwing;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class GoogleAPItoApp extends JFrame implements ActionListener {
    
    GoogleAPI googleAPI = new GoogleAPI();
    
    private static final String VOICENAME = "kevin16";
    private final int height = 314;
    private final int width = 662;
    private JLabel jLabel1; 
    private JLabel jLabel2; 
    JTextArea jtxtText; 
    JTextArea jtxtDefine; 
    private JButton jOKButton; 
    private JButton jClearButton;
    private JButton jbSpeak;
    private JLabel jLabel3;
    private JPanel jSpeak;
    private ImageIcon imageIcon;

    public void setJtxtText(JTextArea jtxtText) {
        this.jtxtText = jtxtText;
    }

    public JTextArea getJtxtText() {
        return jtxtText;
    }

    public void setJtxtDefine(JTextArea jtxtDefine) {
        this.jtxtDefine = jtxtDefine;
    }
    
    public JTextArea getJtxtDefine() {
        return jtxtDefine;
    }
    
    
    Scanner sc = new Scanner(System.in);
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    public GoogleAPItoApp() {
         translateWordFrame ();
}
    public void translateWordFrame (){
        jLabel1 = new JLabel("Nhập văn bản ");
        jLabel2 = new JLabel("Dịch nghĩa ");
        jtxtText = new JTextArea();
        jtxtDefine = new JTextArea();
        jOKButton = new JButton("Dịch");
        jClearButton = new JButton("Clear");
        imageIcon = new ImageIcon(getClass().getResource("/icon/speech.png"));
        jLabel3 = new JLabel(imageIcon, JLabel.CENTER);
        jSpeak = new JPanel();
        jbSpeak = new JButton();
        
        setTitle("GoogleAPI");
        setSize(width, height);   
        getContentPane().setBackground(new java.awt.Color(56, 113, 200));
        setLayout(null);
        setVisible(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        jLabel1.setSize(150, 30);
        jLabel1.setLocation(9, 11);
        jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jLabel1);
        
        jLabel2.setSize(150, 30);
        jLabel2.setLocation(326, 11);
        jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(jLabel2);
        
        jSpeak.setSize(20, 30);
        jSpeak.setLocation(118, 9);
        jSpeak.setBackground(new java.awt.Color(56, 113, 200));
        jSpeak.add(jLabel3);
        jSpeak.add(jbSpeak);
        add(jSpeak);
        
        jtxtText.setSize(316, 190);
        jtxtText.setLocation(7, 38);
        jtxtText.setBackground(new java.awt.Color(153, 153, 255));
        jtxtText.setFont(new Font("Tahoma", Font.PLAIN, 14));
        jtxtText.setLineWrap(true);
        jtxtText.setWrapStyleWord(true);
        add(jtxtText);
        
        jtxtDefine.setSize(315,190);
        jtxtDefine.setLocation(324,38);
        jtxtDefine.setBackground(new java.awt.Color(153, 153, 255));
        jtxtDefine.setFont(new Font("Tahoma", Font.PLAIN, 14));  
        jtxtDefine.setLineWrap(true);
        jtxtDefine.setWrapStyleWord(true);
        add(jtxtDefine);
        
        jOKButton.setBounds(482, 232, 76, 34);
        jOKButton.setBackground(new java.awt.Color(153, 153, 255));
        add(jOKButton);
        jOKButton.setActionCommand("translate");
        jOKButton.addActionListener(this);
        
        jClearButton.setBounds(562, 232, 76, 34);
        jClearButton.setBackground(new java.awt.Color(153, 153, 255));
        add(jClearButton);
        jClearButton.setActionCommand("clear");
        jClearButton.addActionListener(this);
        
         jbSpeak.setSize(22, 22);
         jbSpeak.setLocation(118, 9);
         jbSpeak.setBackground(new java.awt.Color(0, 0, 0));
         add(jbSpeak);
         jbSpeak.setActionCommand("speak");
         jbSpeak.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e1)  {
        String text = jtxtText.getText();
        if(("translate".equals(e1.getActionCommand()))){
            try {
                jtxtDefine.setText("");
                jtxtDefine.append(GoogleAPI.translate("en", "vi", text));
            } catch (IOException io) {
                System.out.println("Exception: " + io);
            }
        }
        if (("clear".equals(e1.getActionCommand()))) {
            jtxtText.setText("");
            jtxtDefine.setText("");
        }
        
        if (("speak".equals(e1.getActionCommand()))) {
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            try{
                voice.speak(jtxtText.getText());
            } catch(Exception e) {
                System.out.println("");
            }
         }
        
    }
    
}

