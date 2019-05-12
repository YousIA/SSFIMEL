/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;

/**
 *
 * @author mobntic
 */
public class Rule {

	protected Itemset premise;
	protected Itemset conclusion;

	protected double confidence;
	protected int support;
	protected int relativeSupport;

	public Rule(Itemset premise, Itemset conclusion) {
		this.premise = premise;
		this.conclusion = conclusion;

		// compute confidence
		Itemset union = (Itemset) premise.clone();
		union.addAll(conclusion);
		support = union.getSupport();
		relativeSupport = union.getRelativeSupport();
		confidence = 100 * ((double) support) / premise.getSupport();
	}

	// Accessors

	public Itemset getPremise() {
		return premise;
	}

	public Itemset getConclusion() {
		return conclusion;
	}

	public double getConfidence() {
		return confidence;
	}

	public int getSupport() {
		return support;
	}

	public int getRelativeSupport() {
		return relativeSupport;
	}

	public double confidence() {
		return confidence;
	}

	// To String!
	public String toString() {
		return premise
				.toString()
				.concat(" => ")
				.concat(conclusion.toString())
				.concat(" (support: " + support + " / confidence: "
						+ confidence + ")");
	}
}
