import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Processes  {

    public static  Polynom readPol( JTextField text)
    {
        Polynom pol=new Polynom();
       String s=text.getText();

        Pattern patern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = patern.matcher(s);


        while(matcher.find())
        {

            pol.addToList(Processes.convert(matcher.group(1)));

        }
        return pol;

    }

    public static  Polynom readPol2( String p)
    {
        Polynom pol=new Polynom();
        String s=p;

        Pattern patern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = patern.matcher(s);


        while(matcher.find())
        {

            pol.addToList(Processes.convert(matcher.group(1)));

        }
        return pol;

    }


    public static  Monom convert(String s )
    {
        int degree;
        int coeficient;
        s=s.replaceAll("\\^","");
        s=s.replaceAll("\\+","");

        //System.out.println(s);
        if(s.contains("x"))
        {

           if(s.contains("-"))
           {
              if(s.equals("-x"))
              {
                  coeficient=-1;
                  degree=1;
              }else
              {
                  if(s.endsWith("x"))
                  {
                      coeficient=Integer.parseInt(s.substring(0,s.length()-1));

                      degree=1;
                  }else
                  {
                      if(s.substring(0,2).equals("-x"))
                      {
                          coeficient=-1;
                          degree=Integer.parseInt(s.substring(2));
                      }else
                      {
                          String[] strings=s.split("x");
                          coeficient=Integer.parseInt(strings[0]);
                          degree=Integer.parseInt(strings[1]);
                      }
                  }
              }

           }else {
               if (s.equals("x")) {
                   degree = 1;
                   coeficient = 1;
               } else {
                   if (s.startsWith("x")) {
                       coeficient = 1;
                       degree = Integer.parseInt(s.substring(1));
                   } else {
                       if (s.endsWith("x")) {
                           coeficient = Integer.parseInt(s.substring(0, s.length() - 1));

                           degree = 1;

                       } else {
                           String[] strings = s.split("x");
                           coeficient = Integer.parseInt(strings[0]);
                           degree = Integer.parseInt(strings[1]);
                       }
                   }
               }
           }
        }else
        {
            coeficient=Integer.parseInt(s);
            degree=0;
        }
        Monom m =new Monom(coeficient,degree);
        //System.out.println("din conver coeficint"+m.getCoeficient());
        return m ;
    }


    public static Polynom addPolynomials(Polynom polynom1,Polynom polynom2)
    {

       // System.out.println(polynom1.getMonom(2).getCoeficient());
        Polynom polynom3=new Polynom();
        int cntPol1=0;
        int cntPol2=0;

        while(cntPol1<polynom1.getSize()&&cntPol2<polynom2.getSize())
        {
            if(polynom1.getMonom(cntPol1).getDegree()<polynom2.getMonom(cntPol2).getDegree())
            {
                Monom temp=new Monom(polynom2.getMonom(cntPol2).getCoeficient(),polynom2.getMonom(cntPol2).getDegree());
               if(temp.getCoeficient()!=0)
               {
                   polynom3.addToList(temp);
               }
                cntPol2++;
            }else
            {
                if(polynom1.getMonom(cntPol1).getDegree()==polynom2.getMonom(cntPol2).getDegree())
                {
                    //System.out.println("asta e la primu"+polynom1.getMonom(cntPol1).getCoeficient());
                   // System.out.println("asta e la al 2 lea"+polynom2.getMonom(cntPol2).getCoeficient());

                    double coef=(polynom1.getMonom(cntPol1).getCoeficient())+(polynom2.getMonom(cntPol2).getCoeficient());
                    int degree=polynom1.getMonom(cntPol1).getDegree();
                    Monom temp=new Monom(coef,degree);
                   if(temp.getCoeficient()!=0)
                   {
                       polynom3.addToList(temp);
                   }
                    cntPol1++;
                    cntPol2++;
                }else
                {
                    Monom temp=new Monom(polynom1.getMonom(cntPol1).getCoeficient(),polynom1.getMonom(cntPol1).getDegree());
                   if(temp.getCoeficient()!=0)
                   {
                       polynom3.addToList(temp);
                   }
                    cntPol1++;
                }
            }
        }
        while(cntPol1<polynom1.getSize()){
            Monom temp=new Monom(polynom1.getMonom(cntPol1).getCoeficient(),polynom1.getMonom(cntPol1).getDegree());
          if(temp.getCoeficient()!=0)
          {
              polynom3.addToList(temp);
          }
            cntPol1++;
            //System.out.println("Asta e cand mai suint elment in primul");
        }
        while(cntPol2<polynom2.getSize()){
            Monom temp=new Monom(polynom2.getMonom(cntPol2).getCoeficient(),polynom2.getMonom(cntPol2).getDegree());
            if(temp.getCoeficient()!=0)
            {
                polynom3.addToList(temp);
                System.out.println(temp.getCoeficient());
            }
            cntPol2++;
            //System.out.println("asta e cand mai sunt elment in al 2 lea");
        }
        return polynom3;
    }



    public static Polynom mulPol(Polynom polynom1,Polynom polynom2) {
        Polynom result = new Polynom();
        Monom temp;
        for (int i = 0; i < polynom1.getSize(); i++) {
            for (int j = 0; j < polynom2.getSize(); j++) {
                temp = new Monom(polynom1.getMonom(i).getCoeficient() * polynom2.getMonom(j).getCoeficient(), polynom1.getMonom(i).getDegree() + polynom2.getMonom(j).getDegree());
                result.addToList(temp);
            }
        }
        ArrayList<Monom> inutl = new ArrayList<Monom>();
        for (int k = 0; k < result.getSize(); k++) {
            inutl.add(result.getMonom(k));
        }
        Polynom last=new Polynom();
        Collections.sort(inutl, Monom.mononDegree);
        for (Monom m : inutl)
        {
            //System.out.println(m);
            last.addToList(m);
        }
     return last;

    }

    public static Polynom divPol(Polynom n,Polynom d)
    {
        Polynom q=new Polynom();
        Polynom r=new Polynom();
        Polynom aux=new Polynom();
        Polynom mul=new Polynom();


        Polynom t=new Polynom();


            r=n;
            while((r!=null)&&r.getMonom(0).getDegree()>=d.getMonom(0).getDegree()) {
               t.addToList0(Monom.div(r.getMonom(0),d.getMonom(0)));

               q.addToList(t.getMonom(0));
               aux=Processes.mulPol(t,d);
               r=Processes.addPolynomials(r,Polynom.mulConst(aux,-1));


            }

        return q ;
    }


}
