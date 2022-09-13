package com.dell;

import org.ojalgo.OjAlgoUtils;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation.Result;
import org.ojalgo.optimisation.Variable;


public class OjalgoPart  {
	static FileReader fr=new FileReader();
	public static String n[]=FileReader.name();
	public static double c[]=FileReader.capacity();
	public static double ch[]=FileReader.ChargingTime();
	public static void Optimize(int size,int Row) {
		System.out.println(OjalgoPart.class);
		System.out.println(OjAlgoUtils.getTitle());
		ExpressionsBasedModel model = new ExpressionsBasedModel();
		Expression totalNeededKwh = model.addExpression().weight(1);
		System.out.println("Car models are:");
		for (int j=0;j<Row;j++) {
			Variable  vname = model.addVariable(n[j]).lower(0).upper(1).integer(true).weight(1);
			totalNeededKwh.set(vname, c[j]);
			System.out.print((j+1)+") "+n[j]+" ,");     
		}
		System.out.println();
		totalNeededKwh.upper(size);
		Result result ;
		result = model.maximise();
		System.out.println();
		System.out.println(result);
	}



}
