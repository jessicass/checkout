package thoughtworks;

import java.util.Comparator;
import java.util.Map;

public class PricingByFixedNumber extends PricingRule {
	private String itemName;
	private int number;
	private int price;
	Comparator<PricingRule> comparator = new Comparator<PricingRule>() {
		public int compare(PricingRule rule1, PricingRule rule2) {
			return rule1.compareWith(rule2);
		}
	};

	public int compareWith(PricingRule rule) {
		if (rule instanceof PricingByFixedNumber) {
			PricingByFixedNumber newRule = (PricingByFixedNumber) rule;
			if (itemName.matches(newRule.getItemName())) {
				return newRule.getNumber() - number;
			}
		}
		return 0;
	}

	public PricingByFixedNumber(String itemName, int number, int price) {
		this.itemName = itemName;
		this.number = number;
		this.price = price;
	}

	public int priceCalculate(Map<String, Integer> itemTotalNumber) {
		if (itemTotalNumber.containsKey(itemName)) {
			int multiple = itemTotalNumber.get(itemName) / number;
			itemTotalNumber.put(itemName, itemTotalNumber.get(itemName)
					- multiple * number);
			return multiple * price;
		}
		return 0;
	}

	public String getItemName() {
		return itemName;
	}

	public int getNumber() {
		return number;
	}

	public Comparator<PricingRule> getComparator() {
		return comparator;
	}
}
