import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;

    static JFrame frame =new JFrame();

    static Polynom pol1=new Polynom();
    static Polynom pol2 =new Polynom();
    static Polynom polRez=new Polynom();
    static JTextField pol1Text=new JTextField();
    static JTextField pol2Text=new JTextField();
    static JTextField polRezText= new JTextField();

    static Polynom addPol=new Polynom();
    static Polynom subPol=new Polynom();
    static Polynom mulPol=new Polynom();
    static Polynom divPol=new Polynom();
    static Polynom derPol=new Polynom();
    static Polynom intPol=new Polynom();



    public  static void initialize()throws IOException{




         frame =new JFrame("Polynomial processing");
          final JTextPane resultPol=new JTextPane();

       // frame.getContentPane().setLayout(new GridLayout(0,2,5,5));
        JPanel panel =new JPanel();
        panel.setLayout(new GridLayout(0,2,20,20));

        frame.getContentPane().add(panel);

        //The Pane for the first polynomial
        JTextPane panePol1=new JTextPane();
        panePol1.setText("POLYNOMIAL 1 ");
        panel.add(panePol1);

        //The text field for the first polynomial

        pol1Text.setPreferredSize(new Dimension(300,30) );
        panel.add(pol1Text);

        //The Pane for the second polynomial
        JTextPane panePol2= new JTextPane();
        panePol2.setText("POLYMONIAL 2 ");
        panel.add(panePol2);

        //the text field for the second polynomial

        pol2Text.setPreferredSize(new Dimension(300,30));
        panel.add(pol2Text);

       //button for adition
        final JButton addButton=new JButton("ADITION");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              pol1=Processes.readPol(pol1Text);
               pol2=Processes.readPol(pol2Text);
               addPol=Processes.addPolynomials(pol1,pol2);
               printRezInt(addPol,resultPol);

            }
        });

        panel.add(addButton);

        //button for substraction
        JButton subButton =new JButton("SUBSTRACTION ");
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pol1=Processes.readPol(pol1Text);
                pol2=Processes.readPol(pol2Text);
               // System.out.println("prima din gui "+pol2.getMonom(0).getCoeficient());

                pol2= Polynom.mulConst(pol2,-1);
               // System.out.println("AICI E IN GUI"+pol2.getMonom(0).getCoeficient());
                subPol=Processes.addPolynomials(pol1,pol2);
               // System.out.println("e aici ");
                printRezInt(subPol,resultPol);


            }
        });

        panel.add(subButton);

        // button for Multiplication

        JButton mulButton=new JButton("MULTIPLICATION");
        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pol1=Processes.readPol(pol1Text);
                pol2=Processes.readPol(pol2Text);
                mulPol=Processes.mulPol(pol1,pol2);
                mulPol=Polynom.simplfy(mulPol);
                printRezInt(mulPol,resultPol);

            }
        });
        panel.add(mulButton);

        //button for Division

        JButton divButton=new JButton("DIVISION");
       /* divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pol1=Processes.readPol(pol1Text);
                pol2=Processes.readPol(pol2Text);
                divPol=Processes.divPol(pol1,pol2);
                // System.out.println("asta e coef si degreee"+divPol.getMonom(0).getCoeficient()+divPol.getMonom(0).getDegree());
                printRezFloat(divPol,resultPol);
            }
        });*/

        panel.add(divButton);

        //button for Derivation
        JButton derButton =new JButton("DIFFERENTIATION");
        derButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pol1=Processes.readPol(pol1Text);
                derPol=Polynom.Derivate(pol1);
                printRezInt(derPol,resultPol);
            }
        });

        panel.add(derButton);

        //button for Integration

        JButton intButton =new JButton("INTEGRATION");


        panel.add(intButton);

        JTextPane result=new JTextPane();
        result.setText("THE RESULTING POLYNOMIAL->");
        panel.add(result);



        panel.add(resultPol);

        intButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pol1=Processes.readPol(pol1Text);
                intPol=Polynom.Integrate(pol1);
              printRezFloat(intPol,resultPol);
            }
        });





        frame.setSize(new Dimension(600,400));

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.getContentPane().setLayout(null);

        frame.setResizable(false);
        frame.setVisible(true);










    }

    public static void printRezInt(Polynom p,JTextPane text)
    {

        String s =Polynom.printPolInt(p);
        text.setText(s);

    }

    public static void printRezFloat(Polynom p,JTextPane text)
    {

        String s =Polynom.printPolFloat(p);
        text.setText(s);

    }


}
