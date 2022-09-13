package com.dell;

import org.ojalgo.OjAlgoUtils;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;


public class OjalgoPart  {
	// create class to load data from file
	static FileReader fr=new FileReader();
	public static String n[]=FileReader.name();
	public static double c[]=FileReader.capacity();
	public static double ch[]=FileReader.ChargingTime();
	// create method to call from main 
	public static void Optimize(int size,int Row) {
		// show Ojalgo info
		System.out.println(OjalgoPart.class);
		System.out.println(OjAlgoUtils.getTitle());
		// create base model
		ExpressionsBasedModel model = new ExpressionsBasedModel();
		//create a exprission model
		Expression totalNeededKwh = model.addExpression().weight(1);
		// show car name for rows that user inputed
		System.out.println("Car models are:");
		for (int j=0;j<Row;j++) {
			/* add every row to a model it can be 0(not selected) or 1( selected))
			 weight is capacity / chargin time (a battery with highest capacity and lower charging time have 
			 more priority to select by program */
			Variable  vname = model.addVariable(n[j]).lower(0).upper(1).integer(true).weight(c[j]/ch[j]);
			// add to stack
			totalNeededKwh.set(vname, c[j]);
			// show info
			System.out.print((j+1)+") "+n[j]+" ,");     
		}
		System.out.println();
		// set top fit to user inserted size
		totalNeededKwh.upper(size);
		// make result
		Result result ;
		// get maximize result
		result = model.maximise();
		System.out.println();
		// show results
		System.out.println(result);
	}



}
