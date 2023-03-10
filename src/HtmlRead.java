import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class HtmlRead {
    JFrame frame;
    int height = 500;
    int width = 800;
    int w = 50;
    int h = 50;
    JTextArea input;
    JTextField term;
    JTextArea output;
    JLabel topLabel;
    JLabel midLabel;
    JLabel bottomLabel;
    JButton submit;
    JScrollPane scroll;
    

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        frame = new JFrame("link_search");
        frame.setLayout(new GridLayout(7, 1));
        frame.setSize(width, height);
        frame.setVisible(true);
        topLabel = new JLabel("input URL");
        input = new JTextArea();
        input.setSize(w, h);
        midLabel = new JLabel("key term");
        term = new JTextField();
        bottomLabel = new JLabel("results");
        output = new JTextArea();
        output.setSize(w, h);
        submit = new JButton("search");
        submit.setActionCommand("search");
        submit.addActionListener(new ButtonClickListener());
        scroll =new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(topLabel);
        frame.add(input);
        frame.add(midLabel);
        frame.add(term);
        frame.add(submit);
        frame.add(bottomLabel);
        //frame.add(output);
        frame.add(scroll);

        frame.setVisible(true);



    }

    public void findlink() {
        try {
            //System.out.println();
            //System.out.print("hello \n");
            URL url = new URL(input.getText());

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;


            while ((line = reader.readLine()) != null) {
                // look into using .split commands
                //   System.out.println(term.getText());
                if (line.contains("href=") && line.contains(term.getText())) {
                    // System.out.println(line);

                    int start = line.indexOf("href=") + 6;
                    line = line.substring(start);
                    System.out.println("og "+line);
                    int end;
                    int n = -1;
                    int end1 = line.indexOf("\"");
                    int end2 = line.indexOf("\'");
                    System.out.println("end1 \": " + end1 + " end 2 \':  "+ end2);
                    if (!(end1 == n)&&!(end2 == n)) {

                        if (end1 < end2) {
                            end = end1;
                            String link = line.substring(0, end);
                            System.out.println(link);
                            output.setText(output.getText()+"\n"+link);
                        }

                     else{
                        end = end2;
                        String link = line.substring(0, end);
                        System.out.println(link);
                        output.append("\n" +link);
                    }}

                    if (end1==n){
                        end=end2;
                        String link = line.substring(0, end);
                        System.out.println(link);
                        output.append("\n"+link);
                    }
                    if (end2==n){
                        end=end1;
                        String link = line.substring(0, end);
                        System.out.println(link);
                        output.append("\n"+link);
                    }
                }


                // if (line.indexOf("x", 50) != -1) {
                // System.out.println(line);
                // }
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public void actionPerformed(ActionEvent e) {

    }

    class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("search")) {
                findlink();
            }

        }
    }
}
