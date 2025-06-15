import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class myFrame extends JFrame implements ActionListener {

    JButton btn;

    public myFrame() {
        this.setTitle("Artist Counter");//sets title of frame
        //this.setSize(400,300);//x,y dimension of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ends program when closing gui
        //do nothing on close stops the window from hiding when you press close
        this.setResizable(true);//prevents frame from being resized
        this.setVisible(true);//makes frame visible
        this.setSize(190,140); //this.setSize(120,80);


        ImageIcon image = new ImageIcon("data//space-colony-14.jpg");//creates imageIcon
        this.setIconImage(image.getImage());//change icon of frame
        this.getContentPane().setBackground(new Color(11, 57, 59));//change color of background

        JLabel label = new JLabel("Get count of artists/songs!");
        label.setSize(500,500);
        label.setForeground(new Color(0xB4AEE1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        this.add(label);

        //Button
        //this.pack();//fits size to what's in frame
        btn = new JButton("Upload file");//make button
        this.setLayout(new FlowLayout());//arrange components in a row left to right

        //btn.setHorizontalTextPosition(JLabel.TOP);
        btn.setSize(200,200);



        this.add(btn);//puts button into frame

        this.pack();

        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==btn) {

            JFileChooser file_upload = new JFileChooser();
            //file_upload.showOpenDialog(null);

            int res = file_upload.showOpenDialog(null);
            //int res_2 = file_upload.showSaveDialog(null);//button is save

            JLabel lastLabel = new JLabel("file counted!");
            lastLabel.setSize(300,300);
            lastLabel.setForeground(new Color(0xB4AEE1));
            lastLabel.setHorizontalAlignment(JLabel.CENTER);
            lastLabel.setVerticalAlignment(JLabel.CENTER);

            if(res == JFileChooser.APPROVE_OPTION){
                File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
                System.out.println(file_path);//if you select a file we need to select it's path

                try {
                    csvWriter.fileInput(file_path);
                    this.add(lastLabel);
                    this.pack();
                } catch (IOException ex) {
                    lastLabel.setText("failed to count file");
                    this.add(lastLabel);
                    //throw new RuntimeException(ex);
                }
            } else {
                lastLabel.setText("please select valid file");
                this.add(lastLabel);
                this.pack();
            }
        }
    }
}
