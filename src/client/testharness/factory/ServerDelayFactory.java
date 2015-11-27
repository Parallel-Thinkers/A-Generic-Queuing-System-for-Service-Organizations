package client.testharness.factory;

import org.apache.commons.math3.distribution.AbstractIntegerDistribution;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;


public class ServerDelayFactory {
	
	public AbstractRealDistribution getProcessDelay(String delayType){
//		System.out.println("chck"+serviceType);
		if(delayType=="GAUSSIAN"){
			return  new NormalDistribution();
		}else if(delayType=="UNIFORM"){
			return new UniformRealDistribution();
		}else if(delayType=="CONSTANT"){
			return new ConstantRealDistribution(2);
		}else{
			return  new NormalDistribution();
		}
	
	}	
	
	public AbstractIntegerDistribution getRequestDelay(String delayType){
//		System.out.println("chck"+serviceType);
		if(delayType=="BINOMIAL"){
			return new BinomialDistribution(2, 2);
		}else if(delayType=="POISSON"){
			return new PoissonDistribution(2);
		}else{
			return  new PoissonDistribution(2);
		}
	
	}	


}
