package thoughtworks;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckOutTest {
	private CheckOut co;
	
	@Before
	public void setUp(){
		co = new CheckOut();
	}
	
	@Test
    public void should1AFor50() {
    	// given
    	co.addNewRule(new PricingRule("A",1,50));
    	co.addNewRule(new PricingRule("A",3,130));
    	
    	// when
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(50));
    }
	
	@Test
    public void should2AFor100() {
    	// given
    	co.addNewRule(new PricingRule("A",1,50));
    	co.addNewRule(new PricingRule("A",3,130));
    	
    	// when
    	co.scan("A");
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(100));
    }
	
	@Test
    public void should3AFor130() {
    	// given
    	co.addNewRule(new PricingRule("A",3,130));
    	co.addNewRule(new PricingRule("A",1,50));
    	
    	// when
    	co.scan("A");
    	co.scan("A");
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(130));
    }
    
//    @Test
	public void should3A1BFor160() {
		// given
    	co.addNewRule(new PricingRule("A",3,130));
    	co.addNewRule(new PricingRule("A",1,50));

		// then
//	    assert_equal(160, price("AAAB"));
	}
}