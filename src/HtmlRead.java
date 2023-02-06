import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        frame = new JFrame("link_search");
        frame.setLayout(new GridLayout(6, 1));
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
        frame.add(topLabel);
        frame.add(input);
        frame.add(midLabel);
        frame.add(term);
        frame.add(bottomLabel);
        frame.add(output);
        frame.setVisible(true);
        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                //lines that have the letter x will be printed from index 50
                // look into using .contains commands
                if(line.contains("href")){
                    System.out.println(line);
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

}
