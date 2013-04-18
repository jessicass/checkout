package thoughtworks;

import java.util.*;

public class CheckOut {
	public int total;
	Map<String, Integer> itemTotalNumber = new HashMap<String, Integer>();
	List<PricingRule> pricingRules = new ArrayList<PricingRule>(); 
	Comparator<PricingRule> comparator = new Comparator<PricingRule>(){
		   public int compare(PricingRule rule1, PricingRule rule2) {
			   if(rule1.getItemName().matches(rule2.getItemName())){
				   return rule2.getNumber() - rule1.getNumber(); 
			   }
			   return 0;
		   }
	};

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

	public int price(String goods) {
		for(int i = 0; i < goods.length(); i++){
			scan(String.valueOf(goods.charAt(i)));
		}
		return total;
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
		Collections.sort(pricingRules,comparator);
	}
}
