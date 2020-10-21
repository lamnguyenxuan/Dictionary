package DictionaryAppJavaSwing;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JTextArea;

public class ViEngDictionary extends GoogleAPItoApp{

    private static final String VOICENAME = "kevin16";
    @Override
    public void setJtxtText(JTextArea jtxtText) {
        super.setJtxtText(jtxtText); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public JTextArea getJtxtText() {
        return super.getJtxtText(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setJtxtDefine(JTextArea jtxtDefine) {
        super.setJtxtDefine(jtxtDefine); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JTextArea getJtxtDefine() {
        return super.getJtxtDefine(); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    public void actionPerformed(ActionEvent e1) {
        String text = jtxtText.getText();
        if(("translate".equals(e1.getActionCommand()))){
            try {
                jtxtDefine.setText(GoogleAPI.translate("vi", "en", text));
            } catch (IOException io) {
                System.out.println("Exception: " + io);
            }
        }
            if (("clear".equals(e1.getActionCommand()))) {
                jtxtText.setText("");
                jtxtDefine.setText("");
            }
            if (("speak".equals(e1.getActionCommand()))) {
            Voice voice;
            VoiceManager vm = VoiceManager.getInstance();
            voice = vm.getVoice(VOICENAME);
            voice.allocate();
            try{
                voice.speak(jtxtDefine.getText());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }        
}
