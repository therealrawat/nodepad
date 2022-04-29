

package notepad;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;

public class Notepad extends JFrame implements ActionListener {
    
    LocalDateTime time;
    JTextArea area;
    JScrollPane pane;
    String text;
    JScrollPane scroll;
    Notepad()
    {
//        time = new LocalDateTime.now();
        ImageIcon img = new ImageIcon(getClass().getResource("UIM38.png"));
        setIconImage(img.getImage());
        
        setTitle("Notepad");
        
        setBounds(0, 0, 1920, 1080);
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu File = new JMenu("File");
        
        JMenuItem New = new JMenuItem("New");
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        New.addActionListener(this);
        
        
        JMenuItem Open = new JMenuItem("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        Open.addActionListener(this);
        
        JMenuItem Save = new JMenuItem("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        Save.addActionListener(this);
        
        JMenuItem Print = new JMenuItem("Print");
        Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        Print.addActionListener(this);
        
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
        Exit.addActionListener(this);
        
        
        File.add(New);
        File.add(Open);
        File.add(Save);
        File.add(Print);
        File.add(Exit);
        
        JMenu Edit = new JMenu("Edit");
        
        JMenuItem Cut = new JMenuItem("Cut");
        Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        Cut.addActionListener(this);
        
        JMenuItem Copy = new JMenuItem("Copy");
        Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        Copy.addActionListener(this);
        
        JMenuItem Paste = new JMenuItem("Paste");
        Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        Paste.addActionListener(this);
        
        JMenuItem selectall = new JMenuItem("Select All");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectall.addActionListener(this);
        
//        JMenuItem datentime = new JMenuItem("Time/Date");
//        datentime.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
//        datentime.addActionListener(this);
        
        Edit.add(Cut);
        Edit.add(Paste);
        Edit.add(Copy);
        Edit.add(selectall);
        
        JMenu Theme = new JMenu("Theme");
        JMenuItem Theme1 = new JMenuItem("Mordor");
        Theme1.addActionListener(this);
        Theme.add(Theme1);
        
        JMenuItem Theme2 = new JMenuItem("Minas Tirith");
        Theme2.addActionListener(this);
        Theme.add(Theme2);
        
        JMenuItem Theme3 = new JMenuItem("Shire");
        Theme3.addActionListener(this);
        Theme.add(Theme3);
        
        JMenu Help = new JMenu("Help");
        
        JMenuItem About = new JMenuItem("About");
        Help.add(About);
        About.addActionListener(this);
        
        JMenu format = new JMenu("Format");
        JMenuItem fonts = new JMenuItem("Font Size");
        format.add(fonts);
        fonts.addActionListener(this);
        
        menubar.add(File);
        menubar.add(Edit);
        menubar.add(format);
        menubar.add(Theme);
        menubar.add(Help);
        
        setJMenuBar(menubar);
        
        area = new JTextArea();
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        pane = new JScrollPane(area);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(pane, BorderLayout.CENTER);
           
    }
    
    public void actionPerformed(ActionEvent ae) {
            
        if (ae.getActionCommand().equals("New"))
        {
            area.setText("");
        }
        else if (ae.getActionCommand().equals("Open"))
        {
            JFileChooser choose = new JFileChooser();
            int i = choose.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION)
            {
                
            }
        }
        else if (ae.getActionCommand().equals("Save"))
        {
            JFileChooser save = new JFileChooser();
            save.setApproveButtonText("Save");
            int action = save.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            
            File filename = new File(save.getSelectedFile() + ".txt");
            BufferedWriter outFile = null;
            try
            {
                outFile = new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
            }catch(Exception e) {}
        }
        else if (ae.getActionCommand().equals("Font Size"))
        {
            String sizeOfFont = JOptionPane.showInputDialog(area,"Enter Font Size", JOptionPane.OK_CANCEL_OPTION);
                 if (sizeOfFont != null)
                 {
                     int convertSizeOfFont = Integer.parseInt(sizeOfFont);
                     Font font = new Font(Font.SANS_SERIF,Font.PLAIN,convertSizeOfFont);
                     area.setFont(font);
                 }
        }
        else if (ae.getActionCommand().equals("Print"))
        {
            try {
                area.print();
            }catch(Exception e){}
        }
        else if (ae.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }
        else if (ae.getActionCommand().equals("Copy"))
        {
            text  = area.getSelectedText();
        }
        else if (ae.getActionCommand().equals("Paste"))
        {
            area.insert(text, area.getCaretPosition());
        }
        else if (ae.getActionCommand().equals("Cut"))
        {
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
        }
        else if (ae.getActionCommand().equals("Select All"))
        {
            area.selectAll();
        }
        else if (ae.getActionCommand().equals("Date/Time"))
        {
            System.out.println(time);
        }
        else if  (ae.getActionCommand().equals("About"))
        {
            new About1().setVisible(true);
        }
        else if (ae.getActionCommand().equals("Mordor")) 
        {
            area.setBackground(new Color(25, 25, 25));
            area.setForeground(new Color(255, 255, 255));
        }
        else if (ae.getActionCommand().equals("Minas Tirith")) 
        {
            area.setBackground(new Color(107, 169, 255));
            area.setForeground(new Color(25, 25, 25));
        }
        else if (ae.getActionCommand().equals("Shire")) 
        {
            area.setBackground(new Color(30, 81, 40));
            area.setForeground(new Color(216, 233, 168));
        }
        
    }
    
    
    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }
    
}
