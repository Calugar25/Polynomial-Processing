import java.util.Comparator;

public class Monom {

    private double  coeficient;
    private int degree;


    public static Comparator<Monom> mononDegree= new Comparator<Monom>() {
        public int compare(Monom o1, Monom o2) {

            int mondegree1=o1.getDegree();
            int mondegree2 =o2.getDegree();
            return mondegree2-mondegree1;
        }
    };


    public double getCoeficient()
    {
        return this.coeficient;
    }

    public Monom(double coeficient,int degree)
    {
        this.coeficient=coeficient;
        this.degree=degree;
    }

    public int getDegree()
    {
        return this.degree;
    }

    public static Monom div(Monom monom1,Monom monom2)
    {
        double coef= monom1.getCoeficient()/monom2.getCoeficient();
        int degree=monom1.getDegree()-monom2.getDegree();
        Monom temp= new Monom(coef,degree);
        return temp;

    }


    public double getValue(int val)
    {
        return coeficient*Math.pow(val,degree);
    }

    public Monom Derivate(Monom monom)
    {
        Monom temp=new Monom(monom.coeficient,monom.degree);
        temp.coeficient=temp.coeficient*temp.degree;
        temp.degree--;
        return temp;
    }

    public Monom Integrate(Monom monom)
    {
        Monom temp=new Monom(monom.coeficient,monom.degree);

          temp.degree++;
           temp.coeficient=temp.coeficient/temp.degree;


        return temp;
    }

    @Override
    public String toString() {
        return "Monom{" +
                "coeficient=" + coeficient +
                ", degree=" + degree +
                '}';
    }
}
