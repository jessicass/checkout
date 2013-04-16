package thoughtworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckOut {
	public int total;
	Map<String, Integer> itemTotalNumber = new HashMap<String, Integer>();
	ArrayList<PricingRule> pricingRules = new ArrayList<PricingRule>(); 

	public void addNewRule(PricingRule pricingRule) {
		pricingRules.add(pricingRule);
		sortPricingRules();
	}

	public void scan(String itemName) {
		if(itemTotalNumber.containsKey(itemName)){
			itemTotalNumber.put(itemName, itemTotalNumber.get(itemName) + 1);
		}
		else{
			itemTotalNumber.put(itemName, 1);
		}
		totalPriceCalculate();
	}

	private void totalPriceCalculate() {
		total = 0;
		Map<String, Integer> currentTotalNumber = new HashMap<String, Integer>();
		currentTotalNumber.putAll(itemTotalNumber);
		for (PricingRule pricingRule : pricingRules) {
			total += pricingRule.priceCalculate(currentTotalNumber);
		}
	}

	private void sortPricingRules() {
		//Œ™πÊ‘Ú≈≈–Ú
		
	}
}
