import java.util.Arrays;
import java.util.Scanner;

public class Main {
	//pepsi
		public static double[] year = {2016,2017,2018,2019,2020,2021};
		public static double[] yearadjust = {0,1,2,3,4,5};
		public static double[] COGS = {28222,28796,29381,30132,31797,37075};
		public static double[] deprec = {2368,2369,2399,2432,2548,2710};
		
	//coka-cola
		public static double[] year2 = {2016,2017,2018,2019,2020,2021};
		public static double[] COGS2 = {1940706,2782721,3069652,3156047,3238448,3608527};
		public static double[] deprec2 = {111613,150422,164502,156886,155936,157320};
	
	
	static char[] oldComp = {'A','B','C','D','E'};
	static char[] newComp = new char[5];
	
	static double[] arrayTime = {1,2,3,4,5};
	static double[] deparray1 = new double[5];
	static double[] deparray2 = new double[5];
	static double[] deparray3 = new double[5];
	static double[] deparray4 = new double[5];
	static double[] deparray5 = new double[5];
	
	static double[] arrange(double a, double b, double c, double d, double e) {
		double[] array = {a,b,c,d,e};
		double temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	
	static double slopeRegression(double[] arrayX, double[] arrayY) {
		
		double sumX = 0;
		double sumY = 0;
		double sumP = 0;
		double sumX2 = 0;
		double sumY2 = 0;
		for (int i = 0; i < arrayX.length; i++) {
			sumX += arrayX[i];
			sumY += arrayY[i];
			double product = arrayX[i] * arrayY[i];
			double squaredX = arrayX[i] * arrayX[i];
			double squaredY = arrayY[i] * arrayY[i];
			sumP += product;
			sumX2 += squaredX;
			sumY2 += squaredY;
		}	
		double slope = ((arrayX.length * sumP) - (sumX * sumY)) / ((arrayX.length * sumX2) - (sumX * sumX));	
			return slope;
		}
	static double yintercept(double[] arrayX, double[] arrayY) {
		double sumX = 0;
		double sumY = 0;
		double sumP = 0;
		double sumX2 = 0;
		double sumY2 = 0;
		for (int i = 0; i < arrayX.length; i++) {
			sumX += arrayX[i];
			sumY += arrayY[i];
			double product = arrayX[i] * arrayY[i];
			double squaredX = arrayX[i] * arrayX[i];
			double squaredY = arrayY[i] * arrayY[i];
			sumP += product;
			sumX2 += squaredX;
			sumY2 += squaredY;
		}
		double yIntercept = ((sumY * sumX2) - (sumX * sumP)) / ((arrayX.length * sumX2) - (sumX * sumX));
			return yIntercept;
	}
	public static void equation(double[] arrayx, double[] arrayy) {
		double slope = slopeRegression(arrayx, arrayy);
		double yint = yintercept(arrayx, arrayy);
		System.out.println("The linear model is: " + slope + "x" + " + " + yint);
	}
	
	static double ymean(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		double avg = sum / (array.length);
		return avg;
	}
	
	static double yhat(double[] arrayx, double[] arrayy, int x) {
		double slope = slopeRegression(arrayx, arrayy);
		double yint = yintercept(arrayx, arrayy);
		double yhat = (slope * arrayx[x]) + yint;
		return yhat;
	}

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println(" ==> Cost of Goods Sold ///////////");
	
	
	
	double ssr = 0;
	double sst = 0;
	for (int i = 0; i < deprec.length; i++) {
		ssr += ((yhat(COGS, deprec, i) - ymean(deprec)) * (yhat(COGS, deprec, i) - ymean(deprec)));
		sst += (deprec[i] - ymean(deprec)) * (deprec[i] - ymean(deprec));
	}
	double rsquared = ssr / sst;
	System.out.println(rsquared + " IS THE R-SQUARED VALUE");
	
	equation(yearadjust, COGS);
	System.out.print(" ==> Depreciation /////////// ");
	equation(yearadjust, deprec);
		System.out.println("Please enter Company A's Cash Flow Depreciation on 10K:");
		for (int i = 0; i < deparray1.length; i++) {
			deparray1[i] = s.nextDouble();
		}
		
		System.out.println("Please enter Company B's Cash Flow Depreciation on 10K:");
		for (int i = 0; i < deparray2.length; i++) {
			deparray2[i] = s.nextDouble();
		}
		System.out.println("Please enter Company C's Cash Flow Depreciation on 10K:");
		for (int i = 0; i < deparray3.length; i++) {
			deparray3[i] = s.nextDouble();
		}
		System.out.println("Please enter Company D's Cash Flow Depreciation on 10K:");
		for (int i = 0; i < deparray4.length; i++) {
			deparray4[i] = s.nextDouble();
		}
		System.out.println("Please enter Company E's Cash Flow Depreciation on 10K:");
		for (int i = 0; i < deparray5.length; i++) {
			deparray5[i] = s.nextDouble();
		}
		double slope1 = slopeRegression(arrayTime, deparray1);
		double slope2 = slopeRegression(arrayTime, deparray2);
		double slope3 = slopeRegression(arrayTime, deparray3);
		double slope4 = slopeRegression(arrayTime, deparray4);
		double slope5 = slopeRegression(arrayTime, deparray5);
		
		System.out.println("Depreciation slope for Company A is: " + slope1);
		System.out.println("Depreciation slope for Company B is: " + slope2);
		System.out.println("Depreciation slope for Company C is: " + slope3);
		System.out.println("Depreciation slope for Company D is: " + slope4);
		System.out.println("Depreciation slope for Company E is: " + slope5);
		
		double[] oldArray = {slope1,slope2,slope3,slope4,slope5};
		arrange(slope1,slope2,slope3,slope4,slope5);
		double[] newArray = arrange(slope1,slope2,slope3,slope4,slope5);
		
		System.out.println(Arrays.toString(oldArray));
		System.out.println(Arrays.toString(newArray));
		System.out.println(Arrays.toString(oldComp));
		for (int i = 0; i < oldArray.length; i++) {
			for (int j = 0; j < oldArray.length; j++) {
				if (oldArray[i] == newArray[j]) {
					newComp[j] = oldComp[i];
				}
			}
		}
		System.out.println(Arrays.toString(newComp) + " <--- is your new sales feed iff depreciation factor is 100%");
		
		
 }
}