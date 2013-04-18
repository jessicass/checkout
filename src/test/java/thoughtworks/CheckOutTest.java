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
    	co.addNewRule(new PricingByFixedNumber("A",3,130));
    	co.addNewRule(new PricingByFixedNumber("D",1,15));
    	co.addNewRule(new PricingByFixedNumber("A",1,50));
    	co.addNewRule(new PricingByFixedNumber("B",2,45));
    	co.addNewRule(new PricingByFixedNumber("C",1,20));
    	co.addNewRule(new PricingByFixedNumber("B",1,30));
	}
	
	@Test
    public void should1AFor50() {
    	// when
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(50));
    }
	
	@Test
    public void should1A1BFor80() {    	
    	// when
    	co.scan("A");
    	co.scan("B");
    	
    	// then
    	assertThat(co.total, is(80));
    }
	
	@Test
    public void should2A1BFor130() {    	
    	// when
    	co.scan("A");
    	co.scan("B");
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(130));
    }
	
	@Test
    public void should3A1BFor160() {    	
    	// when
    	co.scan("A");
    	co.scan("B");
    	co.scan("A");
    	co.scan("A");
    	
    	// then
    	assertThat(co.total, is(160));
    }
	
	@Test
    public void should3A2BFor175() {    	
    	// when
    	co.scan("A");
    	co.scan("B");
    	co.scan("A");
    	co.scan("A");
    	co.scan("B");
    	
    	// then
    	assertThat(co.total, is(175));
    }
	
    @Test
	public void shouldPriceOf0GoodsIs0() {
		// then
    	assertThat(co.price(""),is(0));
	}
    
    @Test
	public void shouldPriceOf1AIs50() {
		// then
    	assertThat(co.price("A"),is(50));
	}
    
    @Test
	public void shouldPriceOf1A1BIs80() {
		// then
    	assertThat(co.price("AB"),is(80));
	}
    
    @Test
	public void shouldPriceOf2AIs100() {
		// then
    	assertThat(co.price("AA"),is(100));
	}
    
    @Test
	public void shouldPriceOf3AIs130() {
		// then
    	assertThat(co.price("AAA"),is(130));
	}
    
    @Test
	public void shouldPriceOf4AIs180() {
		// then
    	assertThat(co.price("AAAA"),is(180));
	}
    
    @Test
	public void shouldPriceOf5AIs230() {
		// then
    	assertThat(co.price("AAAAA"),is(230));
	}
    
    @Test
	public void shouldPriceOf6AIs260() {
		// then
    	assertThat(co.price("AAAAAA"),is(260));
	}
    
    @Test
	public void shouldPriceOf1A1B1C1DIs115() {
		// then
    	assertThat(co.price("CDBA"),is(115));
	}
    
    @Test
	public void shouldPriceOf3A1BIs160() {
		// then
    	assertThat(co.price("AAAB"),is(160));
	}
    
    @Test
	public void shouldPriceOf3A2BIs175() {
		// then
    	assertThat(co.price("AAABB"),is(175));
	}
    
    @Test
	public void shouldPriceOf3A2B1DIs190() {
		// then
    	assertThat(co.price("AAABBD"),is(190));
	}
    
    @Test
	public void shouldPriceOf3A2B1DInDisorderIs190() {
		// then
    	assertThat(co.price("DABABA"),is(190));
	}
}