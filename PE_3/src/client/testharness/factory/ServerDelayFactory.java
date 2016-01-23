package client.testharness.factory;

import org.apache.commons.math3.distribution.AbstractIntegerDistribution;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;

import client.testharness.Configuration;


public class ServerDelayFactory {
	Configuration c = new Configuration();
	
	public AbstractRealDistribution getProcessDelay(String delayType){
//		System.out.println("chck"+serviceType);
		if(delayType=="GAUSSIAN"){
			return  new NormalDistribution(c.getArg1(),c.getArg2());
		}else if(delayType=="UNIFORM"){
			return new UniformRealDistribution(c.getArg1(),c.getArg2());
		}else if(delayType=="CONSTANT"){
			return new ConstantRealDistribution(c.getArg1());
		}else{
			return  new NormalDistribution(c.getArg1(),c.getArg2());
		}
	
	}	
	
	public AbstractIntegerDistribution getRequestDelay(String delayType){
//		System.out.println("chck"+serviceType);
		if(delayType=="BINOMIAL"){
			return new BinomialDistribution((int)c.getArg1(), c.getArg2());
		}else if(delayType=="POISSON"){
			return new PoissonDistribution(c.getArg1());
		}else{
			return  new PoissonDistribution(c.getArg1());
		}
	
	}	


}
