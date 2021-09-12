package com.order.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import com.order.service.model.Offer;
import com.order.service.model.Order;
import com.order.service.service.OrderService;
import com.order.service.util.OfferType;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private OrderService service;
    
    @Test
    public void test_get_id() {
    	
    	Order order = new Order();
    	order.setId(123);
    	order.setOrderName("OrderName");
    	order.setPrice(50);
    	order.setQty(2);
    	Offer offer = new Offer();
    	offer.setOfferType(OfferType.BUYONE_GETONE);
    	order.setOffer(offer);
    	
    	given(service.getOrderById("123")).willReturn(order);
    	
    	mvc.perform(get("/order/getByOrderId/"+"123")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$", hasSize(1)));
    }

}
