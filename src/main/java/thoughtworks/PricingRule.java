package thoughtworks;

import java.util.Map;

public class PricingRule {
	private String itemName;
	private int number;
	private int price;

	public PricingRule(String itemName, int number, int price) {
		this.itemName = itemName;
		this.number = number;
		this.price = price;
	}

	public int priceCalculate(Map<String, Integer> itemTotalNumber) {
		if(itemTotalNumber.containsKey(itemName)){
			int multiple = itemTotalNumber.get(itemName)/number;
			itemTotalNumber.put(itemName, itemTotalNumber.get(itemName) - multiple * number);
			return multiple * price;
		}
		return 0;
	}
}
