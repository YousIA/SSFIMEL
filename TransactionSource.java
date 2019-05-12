/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;

/**
 *
 * @author mobntic
 */
import java.util.List;

/**
 * A source of transactions.
 *
 * This is an interface to specify that the class which implements it can
 * generate transactions. This way, we can have a lot of different transactions
 * generator with the same interface, which is really convenient for the tests
 * and the use in the algorithm.
 *
 * @author Benjamin Bouvier
 *
 */
public interface TransactionSource {
	/**
	 * Returns all generated transactions.
	 *
	 * @return List of itemsets
	 */
	List<Itemset> generate();
}