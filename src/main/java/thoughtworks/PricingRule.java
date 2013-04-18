package thoughtworks;

import java.util.Comparator;
import java.util.Map;

public abstract class PricingRule {
	public abstract int priceCalculate(Map<String, Integer> itemTotalNumber);
	public abstract Comparator<PricingRule> getComparator();
	public abstract int compareWith(PricingRule rule2);
}
