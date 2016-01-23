package bankserver.factory;

import bankserver.algorithm.Algorithm;
import bankserver.model.Model;

public class ComponentFactory {
	
	static Algorithm algo;
	static Model model;
	public void setAlgorithm(Algorithm alg){
		algo=alg;
	}
	
	public Algorithm getAlgorithm(){
		return algo;
	}

	public void setModel(Model m){
		model=m;
	}
	
	public Model getModel(){
		return model;
	}
	
}
