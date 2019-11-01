import java.util.ArrayList;

public class Polynom {
    private ArrayList<Monom> polynom;


    public Polynom()
    {
        this.polynom=new ArrayList<Monom>();
    }

    public void addToList(Monom monom)
    {
        this.polynom.add(monom);
        //System.out.println(monom.getCoeficient());
    }

    public void addToList0(Monom monom)
    {
        this.polynom.add(0,monom);
    }

    public Monom getMonom(int index)
    {
        return polynom.get(index);
    }


    public double calcForValue(int point)
    {
        double result=0;
       for(Monom m:polynom)
       {
           result+=m.getValue(point);
       }
       return result;
    }

    public int getSize()
    {
        return this.polynom.size();
    }

    public  static Polynom Derivate(Polynom polynom1)
    {
        Polynom aux=new Polynom();
        Monom temp;
        System.out.println();
        for(int i=0;i<polynom1.getSize();i++)
        {
            temp=polynom1.getMonom(i);
          
            aux.addToList(temp.Derivate(polynom1.getMonom(i)));
        }
        return aux;
    }
    public static  Polynom Integrate(Polynom polynom1)
    {
        Polynom aux=new Polynom();
        Monom temp;
        System.out.println();
        for(int i=0;i<polynom1.getSize();i++)
        {
            temp=polynom1.getMonom(i);
         
            aux.addToList(temp.Integrate(polynom1.getMonom(i)));
        }
        return aux;
    }


    public  static String  printPolInt(Polynom polynom)
    {
        ArrayList<String> strings=new ArrayList<String>();


        for(int i=0;i<polynom.getSize();i++) {
            if ((polynom.getMonom(i).getDegree() == -1) && (polynom.getMonom(i).getCoeficient()) == 0){}
                else
            {
                if (i != 0) {//System.out.print((int)polynom.getMonom(i).getCoeficient()+"x^"+polynom.getMonom(i).getDegree());
                    if (polynom.getMonom(i).getDegree() == 0) {
                        if (polynom.getMonom(i).getCoeficient() > 0) {
                            strings.add("+" + (int) polynom.getMonom(i).getCoeficient());
                        } else
                            strings.add(""+(int) polynom.getMonom(i).getCoeficient());
                    } else {
                        if (polynom.getMonom(i).getDegree() == 1) {
                            if (polynom.getMonom(i).getCoeficient() > 0) {
                                if (polynom.getMonom(i).getCoeficient() == 1) {
                                    strings.add("+x");
                                } else {
                                    strings.add("+" + (int) polynom.getMonom(i).getCoeficient() + "x");
                                }

                            } else

                                strings.add((int) polynom.getMonom(i).getCoeficient() + "x");
                        } else {
                            if (polynom.getMonom(i).getCoeficient() > 0) {
                                if (polynom.getMonom(i).getCoeficient() == 1) {
                                    strings.add("+x^" + polynom.getMonom(i).getDegree());
                                } else {
                                    strings.add("+" + (int) polynom.getMonom(i).getCoeficient() + "x^" + polynom.getMonom(i).getDegree());
                                }
                            } else {
                                if (polynom.getMonom(i).getCoeficient() == -1) {
                                    strings.add("-x^" + polynom.getMonom(i).getDegree());
                                } else {
                                    strings.add((int) polynom.getMonom(i).getCoeficient() + "x^" + polynom.getMonom(i).getDegree());
                                }
                            }

                        }
                    }
                } else {
                    if (polynom.getMonom(i).getCoeficient() == 1) {
                        strings.add("x^" + polynom.getMonom(i).getDegree());
                    } else {
                        strings.add((int) (polynom.getMonom(i).getCoeficient()) + "x^" + polynom.getMonom(i).getDegree());
                    }
                }
            }
        }
        String aux="";
        for(String s:strings)
        {
            aux=aux+s;
        }
        return aux;

    }

    public static String printPolFloat(Polynom polynom)
    {
        ArrayList<String> strings=new ArrayList<String>();



        for(int i=0;i<polynom.getSize();i++) {
            if ((polynom.getMonom(i).getDegree() == -1) && (polynom.getMonom(i).getCoeficient()) == 0){}
            else
            {
                if (i != 0) {//System.out.print((int)polynom.getMonom(i).getCoeficient()+"x^"+polynom.getMonom(i).getDegree());
                    if (polynom.getMonom(i).getDegree() == 0) {
                        if (polynom.getMonom(i).getCoeficient() > 0) {
                            strings.add("+" +  polynom.getMonom(i).getCoeficient());
                        } else
                            strings.add(Integer.toString((int)polynom.getMonom(i).getCoeficient()));
                    } else {
                        if (polynom.getMonom(i).getDegree() == 1) {
                            if (polynom.getMonom(i).getCoeficient() > 0) {
                                if (polynom.getMonom(i).getCoeficient() == 1) {
                                    strings.add("+x");
                                } else {
                                    strings.add("+" +  polynom.getMonom(i).getCoeficient() + "x");
                                }

                            } else

                                strings.add( polynom.getMonom(i).getCoeficient() + "x");
                        } else {
                            if (polynom.getMonom(i).getCoeficient() > 0) {
                                if (polynom.getMonom(i).getCoeficient() == 1) {
                                    strings.add("+x^" + polynom.getMonom(i).getDegree());
                                } else {
                                    strings.add("+" +  polynom.getMonom(i).getCoeficient() + "x^" + polynom.getMonom(i).getDegree());
                                }
                            } else {
                                if (polynom.getMonom(i).getCoeficient() == -1) {
                                    strings.add("-x^" + polynom.getMonom(i).getDegree());
                                } else {
                                    strings.add( polynom.getMonom(i).getCoeficient() + "x^" + polynom.getMonom(i).getDegree());
                                }
                            }

                        }
                    }
                } else {
                    if (polynom.getMonom(i).getCoeficient() == 1) {
                        strings.add("x^" + polynom.getMonom(i).getDegree());
                    } else {
                        strings.add((polynom.getMonom(i).getCoeficient()) + "x^" + polynom.getMonom(i).getDegree());
                    }
                }
            }
        }
        String aux="";
        for(String s :strings)
        {
            aux=aux+s;
        }
   
        return aux;

    }

    public static Polynom mulConst(Polynom p,int constant)
    {
        Polynom aux=new Polynom();
        Monom temp;
        for(int i=0;i<p.getSize();i++)
        {
            temp=new Monom(((int)p.getMonom(i).getCoeficient())*constant,p.getMonom(i).getDegree());
            aux.addToList(temp);
            System.out.println(temp.getCoeficient());
        }
        return aux ;
    }


    public static Polynom  simplfy(Polynom p)
    {
        Polynom aux=new Polynom();
        double  sum=0;
        int i=0;
        Monom temp;
        while(i<p.getSize())
        {
            sum=p.getMonom(i).getCoeficient();
            if(i<p.getSize()-1) {
                while (p.getMonom(i).getDegree() == p.getMonom(i + 1).getDegree()) {
                    sum += p.getMonom(i+1).getCoeficient();
                    i++;
                }
            }
            temp=new Monom(sum,p.getMonom(i).getDegree());
            aux.addToList(temp);
            i++;

        }
        return aux;
    }


}
